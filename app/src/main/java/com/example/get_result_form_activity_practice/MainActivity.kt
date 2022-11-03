package com.example.get_result_form_activity_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initClickListener()
    }

    private fun initClickListener() {

        val amMbSaber = findViewById<Button>(R.id.amMbSaber)
        amMbSaber.setOnClickListener {

            //建立intent，切換至SaberActivity
            val intent = Intent(this, SaberActivity::class.java)

            val name = "Arthur"
            //建立Bundle
            val info = Bundle()
            //將name帶進Bundle
            info.putString("name",name)
            //將Bundle帶進intent
            intent.putExtra("info",info)
            //啟動intent
            resultLauncher.launch(intent)
        }

        val amMbArcher = findViewById<Button>(R.id.amMbArcher)
        amMbArcher.setOnClickListener {

            //建立intent，切換至ArcherActivity
            val intent = Intent(this, ArcherActivity::class.java)

            val name = "Emiya"
            //建立Bundle
            val info = Bundle()
            //將name帶進Bundle
            info.putString("name",name)
            //將Bundle帶進intent
            intent.putExtra("info",info)
            //啟動intent
            resultLauncher.launch(intent)
        }
    }

    private val resultLauncher =

        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            if (RESULT_OK == activityResult.resultCode) {
                Log.d(
                    "maho",
                    "回傳: ${activityResult.data?.getStringExtra("BaseConstants.WEAPON")}"
                )
            }
        }
}
