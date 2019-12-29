package com.example.a201912_finaltest

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.a201912_finaltest.controller.LottoNum
import kotlinx.android.synthetic.main.activity_lotto.*

class LottoActivity : BaseActivity() {

    var totalWinMoney:Long = 0L  // 0을 Long타입으로 대입. 0은 Int로 간주되어 큰수 저장 X
    var usedMoney = 0L

    var winLottoNumArr = ArrayList<Int>()
    val winLottoTextViewList =ArrayList<TextView>()
    val myLottoTextViewList =ArrayList<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotto)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        buyOneLottoBtn.setOnClickListener {
//            6개의 숫자를 랜덤으로 생성 => 텍스트뷰에 6개 반영
            makeWinLottoNum()
//            등수 판단.
            checkLottoRank()
        }

    }

    private fun makeWinLottoNum(){
//        6개의 당첨 번호 생성. 6번 반복.
//        랜덤으로 숫자를 생성 => 아무 제약없는 랜덤이 아니라 =>1~45범위/ 중복허용 X
//        제약조건 통과한다면 =>당첨번호 목록으로 추가. (2, 10, 25) =>배열(ArrayList)을 사용.
//        (10, 2, 25,32 ,8, 16) => 작은 숫자부터 나타나도록 정렬
//        여기까지 완료 되면 6개의 테긋트 뷰에 반영.

        winLottoNumArr = LottoNum().process()

        for ( i in 0..5){
            val tempTextView = winLottoTextViewList[i]
            val winNum = winLottoNumArr[i]

            tempTextView.text = winNum.toString()
        }
    }

    fun checkLottoRank(){
//        등수판단?
//        내가 가진 숫자들과/ 당첨번호를 하나하나 비교해서, 같은 숫자가 몇개인지? 세어야함.
//        이 갯수에 따라서 등수를 판정
//        갯수 6-1등 5-3등 4-4등 3-5등

//        같은 숫자의 갯수르 ㄹ세어주는 변수
        var correctCount = 0

//        내가 가진 숫자들을 모두 꺼내보자
        for(myNumTxt in myLottoTextViewList){
            val num = myNumTxt.text.toString().toInt()

            Log.d("적혀있는 숫자들",num.toString())

//            당첨번호를 둘러보자
            for (winNum in winLottoNumArr){
//                같은 숫자를 찾았다면
                if(num == winNum){
//                    당첨번호에 들어있다! 갯수 1증가
                    correctCount++
                    break
                }
            }
            Log.d("맞춘 개수", correctCount.toString())


        }
        if(correctCount == 6){
//                1등당첨 =>당첨금액 +=50억
            totalWinMoney +=500000000
        }
        else if(correctCount == 5){
//                3등 당첨 => 당첨금액 += 150만원
            totalWinMoney += 1500000
        }
        else if(correctCount==4){
//                4등 당첨 =?> 당첨금액
            totalWinMoney +=50000
        }
        else if(correctCount==3){
            totalWinMoney += 5000
        }
        else{

        }
        totalWinMoneyTxt.text = totalWinMoney.toString()

//            사용금액 : 한장 살대마다 천원 증가
        usedMoney +=1000
        usedMoneyTxt.text=usedMoney.toString()

    }

    override fun setValues() {
//        당첨번호 텍스트 뷰를 배열로 담아둠
        winLottoTextViewList.add(lottoNumTxt01)
        winLottoTextViewList.add(lottoNumTxt02)
        winLottoTextViewList.add(lottoNumTxt03)
        winLottoTextViewList.add(lottoNumTxt04)
        winLottoTextViewList.add(lottoNumTxt05)
        winLottoTextViewList.add(lottoNumTxt06)

//        내가 뽑은 번호 텍스트뷰들을 배열로 담아둠
        myLottoTextViewList.add(myNumTxt01)
        myLottoTextViewList.add(myNumTxt02)
        myLottoTextViewList.add(myNumTxt03)
        myLottoTextViewList.add(myNumTxt04)
        myLottoTextViewList.add(myNumTxt05)
        myLottoTextViewList.add(myNumTxt06)

    }
}
