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
import com.example.laban.databinding.FragmentScreen3Binding
import com.example.laban.ExternalFunctions.LunarSolar
import java.util.Calendar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Screen3Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Screen3Fragment : Fragment(R.layout.fragment_screen3), SensorEventListener {
    private var currentDegree = 0f
    private var mSensorManager: SensorManager? = null
    val today = Calendar.getInstance()
    private var _binding: FragmentScreen3Binding? = null
    private val binding get() = _binding!!
    private val lunarSolar = LunarSolar;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScreen3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        val arguments = arguments
        val selectedDay = arguments!!.getInt("selectedDay", 0)
        val selectedMonth = arguments!!.getInt("selectedMonth", 0)
        val selectedYear = arguments!!.getInt("selectedYear", 0)

        binding.txtHyThan.text = "Hỷ Thần : 0.123";
        binding.txtTaiThan.text ="Tài Thần : 0.123";
        var Year = today.get(Calendar.YEAR)
        var Month = today.get(Calendar.MONTH)
        var Day = today.get(Calendar.DAY_OF_MONTH)
        binding.textView2.text = "$Day/${Month+1}/$Year"
        addIconAtDegree(30, 1)
        addIconAtDegree(250, 0)
        addIconAtDegree(180, 2)
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

    private fun addIconAtDegree(degree: Int, type:Int) {
        if (degree > 350 || degree < 0) {
            return
        }
        val icon = ImageView(requireContext())
        if(type == 0){
            icon.setImageResource(R.mipmap.ic_launcher_round)
        }
        else if (type == 1){
            icon.setImageResource(R.drawable.baseline_self_improvement_24)
        }else{
            icon.setImageResource(R.drawable.money)
        }

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
        var x =
            x0 * Math.cos(Math.toRadians(degree.toDouble())) - y0 * Math.sin(Math.toRadians(degree.toDouble()));
        var y =
            x0 * Math.sin(Math.toRadians(degree.toDouble())) - y0 * Math.cos(Math.toRadians(degree.toDouble()));
        layoutParams.leftMargin = x.toInt() - gap / 2
        layoutParams.topMargin = -y.toInt() - gap * 2

        binding.myConstraintIconGroup.addView(icon, layoutParams)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}