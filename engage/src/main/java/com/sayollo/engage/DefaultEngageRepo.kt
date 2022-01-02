package com.sayollo.engage

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class DefaultEngageRepo(context: Context) : EngageRepo {

    private val sp: SharedPreferences = context.getSharedPreferences("engage_repo", Context.MODE_PRIVATE)

    override fun getTimePlayed(): Long {
        return sp.getLong("TIME_PLAYED_KEY", 0L)
    }

    override fun addTimePlayed(timePlayed: Long) {
        sp.edit().putLong("TIME_PLAYED_KEY", getTimePlayed() + timePlayed).apply()

    }

    override fun addAchievements(achievementsList: ArrayList<String>) {
        sp.edit().putString("ACHIEVEMENTS_KEY", Gson().toJson(achievementsList)).apply()
    }

    override fun getAchievements(): ArrayList<String> {

        val achievementsList = sp.getString("ACHIEVEMENTS_KEY", "")
        return Gson().fromJson(achievementsList, object : TypeToken<List<String?>?>() {}.type)
    }

    override fun addPoints(points: Int) {
        sp.edit().putInt("POINTS_KEY", points).apply()
    }

    override fun getPoints(): Int {
        return sp.getInt("POINTS_KEY", 0)
    }

    override fun setLevelReached(levelReached: Int) {
        sp.edit().putInt("LEVEL_REACHED_KEY", levelReached).apply()
    }

    override fun getLevelReached(): Int {
        return sp.getInt("LEVEL_REACHED_KEY", 0)
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