package com.example.a201912_finaltest.controller

import kotlin.random.Random

class NumProcess {

    val winLottoNumArr = ArrayList<Int>()

    fun process(){
        while (true){
            val randomNum = getRandomNum()
            if(findMatchNum(randomNum) == -1){

            }
        }

    }

    private fun getRandomNum():Int{
        val randomInt = Random.nextInt(45) + 1
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


}