package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.*
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*


class MainActivity : AppCompatActivity() {

    lateinit var signinButton:Button
    lateinit var username:EditText
    lateinit var password:EditText
    lateinit var statusLogin:TextView

    public fun animatedLoading(){
        lateinit var rellay1:RelativeLayout
        lateinit var rellay2:RelativeLayout

        var handler:Handler = Handler()
        var runnable: Runnable = object:Runnable {
            override fun run() {
                rellay1.visibility = View.VISIBLE
                rellay2.visibility = View.VISIBLE
            }
        }

        rellay1 = findViewById(R.id.rellay1)
        rellay2 = findViewById(R.id.rellay2)
        handler.postDelayed(runnable, 1000)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //panggil fungsi animatedLoading
        animatedLoading()

        signinButton = findViewById(R.id.signin)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        statusLogin = findViewById(R.id.status)

        signinButton.setOnClickListener {
            if(username.text.toString().equals("admin") and password.text.toString().equals("admin")){
                val kirimIntent: Intent = Intent(this, DashboardActivity::class.java)
                startActivity(kirimIntent)
            }else {

                statusLogin.visibility = View.VISIBLE
                statusLogin.text = "Gagal Login !"
            }
        }

    }

}
