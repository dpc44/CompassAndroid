package com.example.laban

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.laban.ExternalFunctions.LunarSolar
import com.example.laban.databinding.FragmentScreen2Binding
import java.lang.Math.cos
import java.lang.Math.sin

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Screen2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Screen2Fragment : Fragment(R.layout.fragment_screen2), SensorEventListener {
    private var currentDegree = 0f
    private var mSensorManager: SensorManager? = null
    private var _binding: FragmentScreen2Binding? = null
    private val binding get() = _binding!!
    private val lunarSolar = LunarSolar;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScreen2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()

        val arguments = arguments

        val selectedDay = arguments!!.getInt("selectedDay", 0)
        val selectedMonth = arguments!!.getInt("selectedMonth", 0)
        val selectedYear = arguments!!.getInt("selectedYear", 0)


        val chiCanName =  lunarSolar.getLunarYearName(selectedYear);
        binding.textView2.text = "$chiCanName - $selectedYear"


        for (currentDegree in 0..350 step 10) {
            addIconAtDegree(currentDegree)
        }
    }

    private fun initData() {
        mSensorManager = requireActivity().getSystemService(Context.SENSOR_SERVICE) as SensorManager?
    }

    override fun onResume() {
        super.onResume()

        mSensorManager?.registerListener(
            this,
            mSensorManager?.getDefaultSensor(Sensor.TYPE_ORIENTATION),
            SensorManager.SENSOR_DELAY_UI
        )
    }

    override fun onPause() {
        super.onPause()
        mSensorManager?.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val degree = Math.round(event?.values?.get(0)!!)
        binding.txtDegree.text = "Degree: $degree"
        val rotateAnimation = RotateAnimation(
            currentDegree, (-degree).toFloat(),
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation.duration = 120
        rotateAnimation.fillAfter = true

        binding.imgCompass.startAnimation(rotateAnimation)
        binding.myConstraintIconGroup.startAnimation(rotateAnimation)
        currentDegree = (-degree).toFloat()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}

    private fun addIconAtDegree(degree: Int) {
        if (degree > 350 || degree < 0) {
            return
        }
        val icon = ImageView(requireContext())
        icon.setImageResource(R.mipmap.ic_launcher_round)

        val layoutParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.leftToLeft = binding.myConstraintIconGroup.id
        layoutParams.rightToRight = binding.myConstraintIconGroup.id
        layoutParams.topToTop = binding.myConstraintIconGroup.id
        layoutParams.bottomToBottom = binding.myConstraintIconGroup.id
        layoutParams.height = 30
        layoutParams.width = 30

        var gap = -10
        var x0 = -15
        var y0 = 600
        var x =x0 * cos(Math.toRadians(degree.toDouble())) - y0 * sin(Math.toRadians(degree.toDouble()));
        var y =x0 * sin(Math.toRadians(degree.toDouble())) - y0 * cos(Math.toRadians(degree.toDouble()));

        layoutParams.leftMargin = x.toInt() - gap / 2
        layoutParams.topMargin = -y.toInt() - gap * 2
        binding.myConstraintIconGroup.addView(icon, layoutParams)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}