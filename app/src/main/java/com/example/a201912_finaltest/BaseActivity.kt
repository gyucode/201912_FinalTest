package com.example.a201912_finaltest

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    val mContext = this


    abstract fun setupEvents()
    abstract fun setValues()
}