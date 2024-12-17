package com.example.week_5_task

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week_5_task.adapter.FeedAdapter
import com.example.week_5_task.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDashboardBinding
    var imageList = ArrayList<Int>()
    var titleList = ArrayList<String>()
    var descList = ArrayList<String>()
    lateinit var feedAdapter : FeedAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name : String = intent.getStringExtra("name").toString()
        val email : String = intent.getStringExtra("email").toString()
        val gender : String = intent.getStringExtra("gender").toString()
        val country : String = intent.getStringExtra("country").toString()
        val city : String = intent.getStringExtra("city").toString()

        binding.nameTextView.text = name
        binding.emailTextView.text = email
        binding.genderTextView.text = gender
        binding.countryTextView.text = country
        binding.cityTextView.text = city

        // Feed
        imageList.add(R.drawable.apple)
        imageList.add(R.drawable.banana)
        imageList.add(R.drawable.cherry)
        imageList.add(R.drawable.android)
        imageList.add(R.drawable.location)

        titleList.add("Apple")
        titleList.add("Banana")
        titleList.add("Mango")
        titleList.add("Android")
        titleList.add("Portfolio Logo")

        descList.add("This apple is hell a good")
        descList.add("This banana is very tasty")
        descList.add("This is cherry")
        descList.add("This is andriod")
        descList.add("This is logo of profile")

        feedAdapter = FeedAdapter(
            this@DashboardActivity,
            imageList, titleList, descList
        )

        binding.feedRecyclerView.adapter = feedAdapter

        // Vertical Scroll
        binding.feedRecyclerView.layoutManager = LinearLayoutManager(this@DashboardActivity, LinearLayoutManager.VERTICAL, false)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}