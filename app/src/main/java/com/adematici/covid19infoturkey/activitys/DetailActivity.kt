package com.adematici.covid19infoturkey.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adematici.covid19infoturkey.R
import com.adematici.covid19infoturkey.adapter.RecyclerViewAdapter
import com.adematici.covid19infoturkey.model.CoronaModel
import com.adematici.covid19infoturkey.service.CoronaAPI
import com.adematici.covid19infoturkey.service.CoronaDetailAPI
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivity : AppCompatActivity() {

    private val BASE_URL = "https://covid19.saglik.gov.tr/"
    private var coronaModels: ArrayList<CoronaModel>? = null
    private var recyclerViewAdapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        loadData()
    }

    fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(CoronaDetailAPI::class.java)
        val call = service.getData()
        call.enqueue(object : Callback<List<CoronaModel>> {
            override fun onResponse(
                call: Call<List<CoronaModel>>,
                response: Response<List<CoronaModel>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        coronaModels = ArrayList(it)
                        coronaModels?.let {
                            recyclerViewAdapter = RecyclerViewAdapter(it)
                            recyclerView.adapter = recyclerViewAdapter
                        }
                    }
                }
            }
            override fun onFailure(call: Call<List<CoronaModel>>, t: Throwable) {
                Toast.makeText(this@DetailActivity,"İnternetinizin açık olduğundan emin olunuz!",Toast.LENGTH_SHORT).show()
            }
        })
    }
}