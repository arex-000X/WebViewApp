package com.karaev.andrew.webviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentfragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view)

        if (currentfragment == null){
            val fragment = WebViewFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container_view,fragment).commit()
        }

    }
}