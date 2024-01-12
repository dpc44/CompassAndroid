package com.example.laban

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.laban.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class MainActivity<NumberPicker> : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val today = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(today.time)
        binding.datePickerButton.text = dateFormat
        var selectedYear = today.get(Calendar.YEAR)
        var selectedMonth = today.get(Calendar.MONTH)
        var selectedDay = today.get(Calendar.DAY_OF_MONTH)
        binding.datePickerButton.setOnClickListener {
            DatePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog ,DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                binding.datePickerButton.setText("$i3/${i2+1}/$i")
                selectedYear = i;
                selectedMonth = i2;
                selectedDay = i3;
            }, selectedYear, selectedMonth, selectedDay).show()
        }
        binding.btnCommit.setOnClickListener {
            commitDateOfBirth(selectedYear, selectedMonth, selectedDay);
        }
    }

    fun commitDateOfBirth(selectedYear: Int, selectedMonth: Int, selectedDay: Int) {

        val bundle = Bundle()
        bundle.putInt("selectedDay", selectedDay)
        bundle.putInt("selectedMonth", selectedMonth)
        bundle.putInt("selectedYear", selectedYear)
        val intent = Intent(this, screen2::class.java)
        intent.putExtras(bundle);
        startActivity(intent)
    }


}