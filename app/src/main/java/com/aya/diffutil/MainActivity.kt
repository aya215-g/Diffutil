package com.aya.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aya.diffutil.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val rvAdapter by lazy { RvAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.layoutManager = LinearLayoutManager(this)

        binding.rvList.adapter = rvAdapter

        //  new objects
        val language1= Language(1,"Java" , "Exp : 3 years")
        val language2=Language(2,"Kotlin" , "Exp : 2 years")
        val language3=Language(3,"Python" , "Exp : 4 years")

        rvAdapter.setData(listOf(language1, language2, language3))
        binding.btnNewLanguage.setOnClickListener {

            val language4= Language(4,"C++" , "Exp : 5 years")
            rvAdapter.setData(listOf(language1,language2,language3,language4))
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
