package com.sayollo.engage.api

import com.sayollo.engage.data.EngageRepo

internal class DefaultGamePlayAPI(
    private val repository: EngageRepo,
    private val onGamePlayDataChanged: OnGamePlayDataChanged
) : GamePlayAPI {
    var tempStartPlayHolder = 0L

    override fun startGameTimeCount() {
        tempStartPlayHolder = System.currentTimeMillis()
    }

    override fun stopGameTimeCount() {
        // Safety check so the game developer won't use this method the wrong way
        if (tempStartPlayHolder > 0) {
            repository.addTimePlayed(System.currentTimeMillis() - tempStartPlayHolder)
            tempStartPlayHolder = 0
            update()
        }
    }

    override fun addAchievements(achievementsList: ArrayList<String>) {
        repository.addAchievements(achievementsList)
        update()
    }

    override fun addPoints(points: Int) {
        repository.addPoints(points)
        update()
    }

    override fun getLeaderBoard() {
        // This is not a traditional gameplay method (Consider moving to a separate API class)
    }

    override fun setLevelReached(levelReached: Int) {
        repository.setLevelReached(levelReached)
        update()
    }

    private fun update() {
        onGamePlayDataChanged.onChanged(repository.getGamePlayData())
    }
}

