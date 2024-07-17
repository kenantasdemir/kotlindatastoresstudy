package com.kenant42.kotlindatastorestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appref = AppRef(this)
        val job = CoroutineScope(Dispatchers.Main).launch {
            appref.saveName("Kenan")
            val nameData = appref.readName()
            Log.e("Name DATA : ",nameData)
            appref.removeName()
           val name = appref.readName()
            Log.e("NAME ",name)
        }
    }
}