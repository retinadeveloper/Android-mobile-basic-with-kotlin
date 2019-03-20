package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Resultpage : AppCompatActivity() {
    var getData:DashboardActivity = DashboardActivity()

    ////////////////////////////////
    lateinit var namaNow:TextView
    lateinit var tglNow:TextView
    lateinit var genderNow:TextView
    lateinit var bahasaNow:TextView

    public fun init(){
        ///
        namaNow = findViewById(R.id.namaAnda)
        tglNow = findViewById(R.id.tglLahirAnda)
        genderNow = findViewById(R.id.genderAnda)
        bahasaNow = findViewById(R.id.bahasaAnda)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultpage)
        init()

        if(intent.extras != null){
            val bundle = intent.extras
                namaNow.text = bundle.getString("dataNama")
                tglNow.text = bundle.getString("dataLahir")
                genderNow.text = bundle.getString("dataGender")
                bahasaNow.text = bundle.getString("dataJawaban")
        }else{
            namaNow.text = intent.getStringExtra("dataNama")
            tglNow.text = intent.getStringExtra("dataLahir")
            genderNow.text = intent.getStringExtra("dataGender")
            bahasaNow.text = intent.getStringExtra("dataJawaban")
        }

    }
}
