package com.sayollo.engage.api

import com.sayollo.engage.UserGameData

interface OnGamePlayDataChanged {
    fun onChanged(userGameData: UserGameData)
}
