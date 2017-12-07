package com.example.startnewactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(tbMain as Toolbar?)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        startActivity(intent)
    }

}
