package com.example.laban

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.laban.databinding.ActivityScreen2Binding
import java.lang.Math.cos
import java.lang.Math.sin


class screen2 : AppCompatActivity(),SensorEventListener {
    lateinit var binding: ActivityScreen2Binding
    private var currentDegree = 0f;
    private var mSensorManager : SensorManager? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        for (currentDegree in 0..350 step 10) {
            addIconAtDegree(currentDegree)
        }
    }
    private fun initData(){
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager?
    }

    override fun onResume(){
        super.onResume()

        mSensorManager?.registerListener(this,
            mSensorManager?.getDefaultSensor(Sensor.TYPE_ORIENTATION),
            SensorManager.SENSOR_DELAY_UI)
    }
    override fun onPause(){
        super.onPause()
        mSensorManager?.unregisterListener(this)
    }
    override fun onSensorChanged(event: SensorEvent?) {
        val degree = Math.round(event?.values?.get(0)!!)
        binding.txtDegree.setText("Degree: "+ degree)
        val rotateAnimation = RotateAnimation(
            currentDegree,(-degree).toFloat(),
            Animation.RELATIVE_TO_SELF,0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation.duration= 120
        rotateAnimation.fillAfter=true

        binding.imgCompass.startAnimation(rotateAnimation)
        binding.myConstraintIconGroup.startAnimation(rotateAnimation)
        currentDegree = (-degree).toFloat()

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
    private fun addIconAtDegree(degree: Int) {
        if(degree >350 || degree < 0){
            return;
        }
        val icon = ImageView(this)
        icon.setImageResource(R.mipmap.ic_launcher_round)

        val layoutParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.leftToLeft = binding.myConstraintIconGroup.id
        layoutParams.rightToRight = binding.myConstraintIconGroup.id
        layoutParams.topToTop = binding.myConstraintIconGroup.id
        layoutParams.bottomToBottom = binding.myConstraintIconGroup.id
        layoutParams.height = 30;
        layoutParams.width = 30;
        var gap = 20

        var x0 = 15
        var y0= -580
        var x = x0 * cos(Math.toRadians(degree.toDouble())) - y0 * sin(Math.toRadians(degree.toDouble()));
        var y = x0 * sin(Math.toRadians(degree.toDouble())) - y0 * cos(Math.toRadians(degree.toDouble()));
        layoutParams.leftMargin = x.toInt() - gap
        layoutParams.topMargin = -y.toInt() - gap

        binding.myConstraintIconGroup.addView(icon, layoutParams)
    }

}