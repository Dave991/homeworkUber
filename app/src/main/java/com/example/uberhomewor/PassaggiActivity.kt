package com.example.uberhomewor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_passaggi.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class PassaggiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passaggi)

        val bundle: Bundle? = intent.extras
        var partenza:String = bundle!!.getString("partenza").toString()
        var arrivo:String = bundle.getString("arrivo").toString()

        Toast.makeText(this,partenza,Toast.LENGTH_LONG).show()

        /* Data corrente */
        var currentDateTime = LocalDateTime.now()
        var time = currentDateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)).removeSuffix(" AM").removeSuffix(" PM")

        /* lista */
        var list = mutableListOf<Passaggio>()

        list.add(Passaggio("Napoli","Milano",10,"Mario Rossi"))
        list.add(Passaggio("Napoli","Milano",12,"Maria Bianchi"))
        list.add(Passaggio("Napoli","Milano",16,"Davide Di Marco"))
        list.add(Passaggio("Napoli","Roma",14,"Salvatore Capobianco"))
        list.add(Passaggio("Napoli","Roma",22,"Pluto Pluto"))
        list.add(Passaggio("Milano","Roma",10,"Peppe Flavio"))
        list.add(Passaggio("Milano","Firenze",18,"Mario Rossi"))

        //Conversione time in int
        var time2 = time.substring(0,2)
        var timeint = time2.toInt()


        var stringapassaggi = " "
        for (i in list) {
            if (timeint <= i.orario_partenza && partenza == i.citta_partenza && arrivo == i.citta_arrivo) {
                stringapassaggi = stringapassaggi + "Tragitto: " + i.citta_partenza +" - "+ i.citta_arrivo+ " orario:" +i.orario_partenza.toString() +":00   Utente:" +i.utente +"\n"+ "------------------------------------"+"\n "
            }
        }


        passaggi.text = stringapassaggi

    }
}
