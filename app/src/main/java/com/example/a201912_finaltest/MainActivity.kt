package com.example.a201912_finaltest

import android.content.Intent
import android.os.Bundle
import com.example.a201912_finaltest.controller.LottoNum
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        LottoNum().process()

        lottoBtn.setOnClickListener {
            val intent = Intent(mContext, LottoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun setValues() {

    }
}
