package com.adematici.covid19infoturkey.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.adematici.covid19infoturkey.R
import com.adematici.covid19infoturkey.model.CoronaModel
import com.adematici.covid19infoturkey.service.CoronaAPI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.textViewAgirHastaSayisi
import kotlinx.android.synthetic.main.activity_main.textViewGunlukIyilesen
import kotlinx.android.synthetic.main.activity_main.textViewGunlukTest
import kotlinx.android.synthetic.main.activity_main.textViewGunlukVaka
import kotlinx.android.synthetic.main.activity_main.textViewGunlukVefat
import kotlinx.android.synthetic.main.activity_main.textViewTarih
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://covid19.saglik.gov.tr/"
    private var coronaModels: ArrayList<CoronaModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        loadData()
    }

    fun digerGunler(view: View){
        val intent = Intent(this,DetailActivity::class.java)
        startActivity(intent)
    }

    fun loadData(){

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(CoronaAPI::class.java)
        val call = service.getData()
        call.enqueue(object : Callback<List<CoronaModel>> {
            override fun onResponse(
                call: Call<List<CoronaModel>>,
                response: Response<List<CoronaModel>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        coronaModels = ArrayList(it)
                        for (coronaModel: CoronaModel in coronaModels!!){
                            textViewTarih.text = coronaModel.tarih
                            textViewGunlukTest.text = coronaModel.gunluk_test
                            textViewGunlukVaka.text = coronaModel.gunluk_vaka
                            textViewGunlukVefat.text = coronaModel.gunluk_vefat
                            textViewGunlukIyilesen.text = coronaModel.gunluk_iyilesen
                            textViewAgirHastaSayisi.text = coronaModel.agir_hasta_sayisi
                        }
                    }
                }
            }
            override fun onFailure(call: Call<List<CoronaModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"İnternetinizin açık olduğundan emin olunuz!", Toast.LENGTH_SHORT).show()
            }
        })

    } // loadData

}