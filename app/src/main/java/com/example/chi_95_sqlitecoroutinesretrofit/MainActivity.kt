package com.example.chi_95_sqlitecoroutinesretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chi_95_sqlitecoroutinesretrofit.databinding.ActivityMainBinding
import com.example.chi_95_sqlitecoroutinesretrofit.network.Common
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val adapter = AnimalAdapter()
    private val TAG = "ttt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MainScope().launch(Dispatchers.Main) {
            val internetRequestList = internetRequest()
            val dbManager = DBManager(this@MainActivity)
            dbManager.insertAnimals(internetRequestList)
            val sqlList = dbManager.fetchAnimals()
            setupRecyclerview(sqlList as MutableList<Animal>)
        }
    }

    private suspend fun internetRequest() :MutableList<Animal>{
        var retrofitList = mutableListOf<Animal>()
        withContext(Dispatchers.IO) {
            try {
                val service = Common.retrofitService
                 retrofitList=
                    service.getResponseItem().execute().body() as MutableList<Animal>

            } catch (err: Error) {
                Log.e(TAG, "Request error ${err.localizedMessage}")
            }
        }
        return retrofitList
    }

    private fun setupRecyclerview(list : MutableList<Animal>) {
        adapter.setItems(list)
        binding.animalsList.adapter = adapter
        binding.animalsList.run {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager(context).orientation
                )
            )
        }
    }
}