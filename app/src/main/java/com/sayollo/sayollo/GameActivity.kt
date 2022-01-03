package com.sayollo.sayollo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sayollo.engage.Engage
import com.sayollo.engage.api.GamePlayAPI
import com.sayollo.engage.InitResult

class GameActivity : AppCompatActivity() {
    lateinit var gamePlayApi: GamePlayAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        when (val initSdkResult = Engage.initSdk(this)){
            is InitResult.InitFailure -> {return}// report error to server
            is InitResult.InitSuccess -> gamePlayApi = initSdkResult.gamePlayAPI
        }

        // Developer should use the gamePlayApi to interact with the Engage system
        gamePlayApi.addPoints(13)
        gamePlayApi.addAchievements(arrayListOf("Beginners Luck"))
        gamePlayApi.getLeaderBoard()
    }

    override fun onResume() {
        super.onResume()
        gamePlayApi.startGameTimeCount()
    }

    override fun onStop() {
        super.onStop()
        gamePlayApi.stopGameTimeCount()
    }
}