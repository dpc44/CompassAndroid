package com.example.laban

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.laban.databinding.ActivityScreen2Binding
import java.lang.Math.cos
import java.lang.Math.sin


class screen2 : AppCompatActivity() {
    lateinit var binding: ActivityScreen2Binding;
    var selectedDay: Int = 0;
    var selectedMonth: Int = 0;
    var selectedYear: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val i = intent
        val bundle = i.extras;
        if(bundle!= null){
            this.selectedDay = bundle?.getInt("selectedDay", 0) ?: 0
            this.selectedMonth = bundle?.getInt("selectedMonth", 0) ?: 0
            this.selectedYear = bundle?.getInt("selectedYear", 0) ?: 0
        }

        val args = Bundle()
        args.putInt("selectedDay", this.selectedDay)
        args.putInt("selectedMonth",  this.selectedMonth)
        args.putInt("selectedYear",  this.selectedYear)

        // Create Screen2Fragment and pass the arguments
        val screen2Fragment = Screen2Fragment()
        screen2Fragment.arguments = args

        // Create Screen3Fragment and pass the arguments
        val screen3Fragment = Screen3Fragment()
        screen3Fragment.arguments = args
        val toolbar : Toolbar = binding.toolbar
        setSupportActionBar(toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        replaceFragment(screen2Fragment)
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuTuoi -> {
                    replaceFragment(screen2Fragment)
                    true
                }
                R.id.menuNgay -> {
                    replaceFragment(screen3Fragment)
                    true
                }
                R.id.menuSettings -> {
                    replaceFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.FrameLayout.id, fragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.topmenusetting ->{
                Toast.makeText(this, "settings selected", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}