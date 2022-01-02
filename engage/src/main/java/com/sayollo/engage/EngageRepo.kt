package com.sayollo.engage

interface EngageRepo {
    fun getTimePlayed(): Int
    fun addTimePlayed(timePlayed: Long)
    fun addAchievements(achievementsList: ArrayList<String>)
    fun getAchievement(): String
    fun addPoints(points: Int)
    fun getPoints(): Int
    fun setLevelReached()
    fun getLevelReached(levelReached: Int): Int
    fun getGamePlayData(): UserGameData
}
