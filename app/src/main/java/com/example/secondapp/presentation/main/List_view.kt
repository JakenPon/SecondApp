package com.example.secondapp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondapp.R
import com.example.secondapp.data.repository.Adapter
import com.example.secondapp.data.repository.RetroInstance
import com.example.secondapp.data.repository.RetroService
import com.example.secondapp.data.repository.response.CountriesItem
import com.example.secondapp.data.repository.response.CountriesList
import kotlinx.android.synthetic.main.activity_list_view.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class List_view : AppCompatActivity() {

    lateinit var recyclerViewAdapter: Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        initRecyclerView()

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getCountries()
        println("call. " + retroInstance.getCountries())
        call.enqueue(object : Callback<List<CountriesItem>> {

            override fun onResponse(call: Call<List<CountriesItem>>, response: Response<List<CountriesItem>>) {
                if (response.isSuccessful) {
                    println(response.body())
                    response.body()?.let { recyclerViewAdapter.setListData(it) }
                    recyclerViewAdapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<List<CountriesItem>>, t: Throwable) {
                println("stacktrace : " +t.stackTrace)
                println("message : " +t.localizedMessage)
                println("message² : " +t.message)
                println("cause : " +t.cause)
                Toast.makeText(this@List_view, "ERROR API", Toast.LENGTH_LONG).show()

            }
        })

    }
    private fun initRecyclerView(){
        recycler_view.apply{
            layoutManager = LinearLayoutManager(this@List_view)
            recyclerViewAdapter = Adapter()
            adapter = recyclerViewAdapter
        }
    }
    }

/*
        val item = ArrayList<ResultData>()

        item.add(ResultData("Homme", "Philibert"))
        item.add(ResultData("Alien", "Philibert"))
        item.add(ResultData("Woman", "Philibert"))

        recyclerViewAdapter.setListData(item)
        recyclerViewAdapter.notifyDataSetChanged()
*/
