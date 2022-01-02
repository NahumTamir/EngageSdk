package com.sayollo.engage.data

internal data class UserGameData(
    var timePlayed: Long,
    var levelReached: Int,
    var points: Int,
    var achievements: String
)
