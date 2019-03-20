package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class DashboardActivity : AppCompatActivity() {
    lateinit var namaLengkap:EditText
    lateinit var tglLahir:EditText
    lateinit var gender:RadioGroup
    lateinit var jawaban:EditText
    lateinit var tesButton:Button

    var jenisKelamin:String = ""

    public fun init(){
        namaLengkap = findViewById(R.id.namaLengkap)
        tglLahir = findViewById(R.id.tglLahir)
        gender = findViewById(R.id.gender)
        jawaban = findViewById(R.id.jawaban)
        tesButton = findViewById(R.id.testbtn)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        init()
        gender.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == 1) {
                jenisKelamin = "Laki-laki"
                Log.e("String", jenisKelamin)
            }else if(checkedId == 2){
                jenisKelamin = "perempuan"
                Log.e("String", jenisKelamin)
            }
        }

        tesButton.setOnClickListener {
            var jawab:String = jawaban.text.toString()
            if (jawab.equals("html")){
                var kirimIntent: Intent = Intent(this,Resultpage::class.java)
                kirimIntent.putExtra("dataNama", namaLengkap.text.toString())
                kirimIntent.putExtra("dataLahir", tglLahir.text.toString())
                kirimIntent.putExtra("dataJawaban", jawaban.text.toString())
                kirimIntent.putExtra("dataGender", jenisKelamin)
                startActivity(kirimIntent)
            }
        }

    }

}
