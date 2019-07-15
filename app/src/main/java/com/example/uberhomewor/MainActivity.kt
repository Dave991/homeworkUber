package com.example.uberhomewor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_cerca.setOnClickListener {
            var partenza:String = luogopartenzatext.text.toString()
            var arrivo:String = luogoarrivotext.text.toString()

            val intent = Intent(this,PassaggiActivity::class.java)
            intent.putExtra("partenza",partenza)
            intent.putExtra("arrivo",arrivo)
            startActivity(intent)
        }

    }
}