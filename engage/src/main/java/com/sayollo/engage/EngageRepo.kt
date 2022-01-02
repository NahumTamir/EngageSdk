package com.sayollo.engage

interface EngageRepo {
    fun getTimePlayed(): Long
    fun addTimePlayed(timePlayed: Long)
    fun addAchievements(achievementsList: ArrayList<String>)
    fun getAchievements(): ArrayList<String>
    fun addPoints(points: Int)
    fun getPoints(): Int
    fun setLevelReached(levelReached: Int)
    fun getLevelReached(): Int
    fun getGamePlayData(): UserGameData
}
