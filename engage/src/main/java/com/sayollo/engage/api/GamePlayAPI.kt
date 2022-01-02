package com.sayollo.engage.api

interface GamePlayAPI {

    fun startGameTimeCount()
    fun stopGameTimeCount()
    fun addAchievements(arrayListOf: ArrayList<String>)
    fun addPoints(points: Int)
    fun setLevelReached(levelReached:Int)
    fun getLeaderBoard() // This is not a traditional gameplay method (Consider moving to a separate API class)
}