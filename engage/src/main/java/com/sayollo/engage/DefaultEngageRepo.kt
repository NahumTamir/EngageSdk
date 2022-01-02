package com.sayollo.engage

import android.content.Context
import android.content.SharedPreferences

class DefaultEngageRepo(context: Context) : EngageRepo {

    private val sp: SharedPreferences = context.getSharedPreferences("engage_repo", Context.MODE_PRIVATE)

    override fun getTimePlayed(): Int {
        TODO("Not yet implemented")
    }

    override fun addTimePlayed(timePlayed: Long) {
        TODO("Not yet implemented")
    }

    override fun addAchievements(achievementsList: ArrayList<String>) {
        TODO("Not yet implemented")
    }

    override fun getAchievement(): String {
        TODO("Not yet implemented")
    }

    override fun addPoints(points: Int) {
        TODO("Not yet implemented")
    }

    override fun getPoints(): Int {
        TODO("Not yet implemented")
    }

    override fun setLevelReached() {
        TODO("Not yet implemented")
    }

    override fun getLevelReached(levelReached: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getGamePlayData(): UserGameData {
        return UserGameData(
            sp.getLong("TIME_PLAYED_KEY", 0L),
            sp.getInt("LEVEL_REACHED_KEY", 0),
            sp.getInt("POINTS_KEY", 0),
            sp.getString("ACHIEVEMENTS_KEY", "") ?: ""
        )
    }
}