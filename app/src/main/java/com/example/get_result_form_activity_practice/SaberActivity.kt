package com.example.get_result_form_activity_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.util.ResourceBundle.getBundle

class SaberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saber)

        //從intent取出Bundle
        val bundle = intent.getBundleExtra("info")
        //從Bundle取出value
        val info = bundle?.getString("name")
        Log.d("maho","姓名: $info")

        initClickListener()
    }

    private fun initClickListener() {

        val asMbMain = findViewById<Button>(R.id.asMbMain)
        asMbMain.setOnClickListener {

            //建立intent
            val intent = Intent()

            val weapon = "Excalibur"
            //將weapon帶進intent
            intent.putExtra("BaseConstants.WEAPON", weapon)

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}