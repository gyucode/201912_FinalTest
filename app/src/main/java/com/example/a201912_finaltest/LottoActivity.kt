package com.example.a201912_finaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lotto.*
import java.security.KeyStore
import kotlin.random.Random

class LottoActivity : BaseActivity() {

    val winLottoNumArr = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotto)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        buyOneLottoBtn.setOnClickListener {
            makeWinLottoNum()
        }

    }

    private fun makeWinLottoNum(){
//        6개의 당첨 번호 생성. 6번 반복.
//        랜덤으로 숫자를 생성 => 아무 제약없는 랜덤이 아니라 =>1~45범위/ 중복허용 X
//        제약조건 통과한다면 =>당첨번호 목록으로 추가. (2, 10, 25) =>배열(ArrayList)을 사용.
//        (10, 2, 25,32 ,8, 16) => 작은 숫자부터 나타나도록 정렬
//        여기까지 완료 되면 6개의 테긋트 뷰에 반영.

        for(i in 0..5){
            while(true){
                val randomInt = Random.nextInt(45) + 1

                var isDuplOk = true

                for (num in winLottoNumArr){
                    if(randomInt == num){
                        isDuplOk = false
                        break
                    }
                }

                if(isDuplOk){
                    winLottoNumArr.add(randomInt)
                    break
                }
            }
        }

    }

    override fun setValues() {

    }
}
