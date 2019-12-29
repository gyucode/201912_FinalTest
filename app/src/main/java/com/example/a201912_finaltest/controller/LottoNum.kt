package com.example.a201912_finaltest.controller

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

class LottoNum {

    private val winLottoNumArr = ArrayList<Int>()

    fun process():ArrayList<Int>{
        while (winLottoNumArr.size < 6){
            val randomNum = getRandomNum()
            if(findMatchNum(randomNum) == -1){
                Log.d("랜덤-중복","$randomNum,index:${winLottoNumArr.size}")
                continue
            }
            winLottoNumArr.add(randomNum)
        }
        Log.d("랜덤-추출","$winLottoNumArr")
//        [ sort방법 ]
//        bubbleSort(winLottoNumArr)
//        Collections.sort(winLottoNumArr)
        winLottoNumArr.sort()
        Log.d("랜덤-정렬","$winLottoNumArr")
        return winLottoNumArr
    }

    private fun getRandomNum():Int{
//        val randomInt = Random.nextInt(45) + 1
        return (Math.random() * 44 + 1).toInt()
    }

    private fun findMatchNum(num:Int):Int{
        for(i in winLottoNumArr){
            if(i ==  num){
                return -1
            }
        }
        return 0
    }

    private fun bubbleSort(numbers: ArrayList<Int>) {
        for (pass in 0 until (numbers.size - 1)) {
            // A single pass of bubble sort
            for (currentPosition in 0 until (numbers.size - pass - 1)) {
                // This is a single step
                if (numbers[currentPosition] > numbers[currentPosition + 1]) {
                    val tmp = numbers[currentPosition]
                    numbers[currentPosition] = numbers[currentPosition + 1]
                    numbers[currentPosition + 1] = tmp
                }
            }
        }
    }


}