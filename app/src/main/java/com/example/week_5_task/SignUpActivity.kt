package com.example.week_5_task

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week_5_task.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivitySignUpBinding
    private var countries = arrayOf(
        "Select", "Nepal", "India", "China", "Pakistan", "USA", "UK"
    )
    private var cities = arrayOf(
        "Kathmandu", "Pokhara", "New Delhi", "Mumbai", "Beijing", "Karachi", "New York", "London"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Spinner Adapter
        val spinnerAdapter = ArrayAdapter(
            this@SignUpActivity, android.R.layout.simple_list_item_1, countries
        )
        spinnerAdapter.setDropDownViewResource(
            android.R.layout.simple_dropdown_item_1line
        )
        binding.spinner.adapter = spinnerAdapter
        binding.spinner.onItemSelectedListener = this

        // AutoCompleteView Adapter
        val autoCompleterAdapter = ArrayAdapter(
            this@SignUpActivity, android.R.layout.simple_dropdown_item_1line, cities
        )
        binding.autoCompleteCity.setAdapter(autoCompleterAdapter)
        binding.autoCompleteCity.threshold = 2


        // Button
        binding.button.setOnClickListener {
            val name : String = binding.nameEditText.text.toString()
            val email : String = binding.emailEditText.text.toString()
            val password : String = binding.passwordEditText.text.toString()
            val gender1 : String = binding.radioButtonMale.text.toString()
            val gender2 : String = binding.radioButtonFemale.text.toString()
            val country : String = binding.spinner.selectedItem.toString()
            val city : String = binding.autoCompleteCity.text.toString()

            if(name.isEmpty()){
                binding.nameEditText.error = "Name cannot be Empty"
            }
            else if(email.isEmpty()){
                binding.emailEditText.error = "Email cannot be Empty"
            }
            else if(password.isEmpty()){
                binding.passwordEditText.error = "Password cannot be empty"
            }
//            else if(country.isEmpty() || country == "Select"){
//                binding.country.error = "Select an option"
//            }
            else if(city.isEmpty()){
                binding.autoCompleteCity.error = "City cannot be empty"
            }
            else if(!binding.checkBox.isChecked){
                Toast.makeText(
                    this@SignUpActivity,
                    "Please! click on I agree",
                    Toast.LENGTH_LONG
                ).show()
            }
            else{
                val intent = Intent(
                    this@SignUpActivity, DashboardActivity::class.java
                )
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                intent.putExtra("country", country)
                intent.putExtra("city", city)
                startActivity(intent)
                finish()
            }

        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}