package com.sayollo.engage

import com.sayollo.engage.api.DefaultGamePlayAPI
import com.sayollo.engage.api.GamePlayAPI

sealed class InitResult {
    class InitSuccess(val gamePlayAPI: GamePlayAPI) : InitResult() {

    }

    class InitFailure(val error: InitError = InitError(303, "Wrong user name or password")) : InitResult() {
        // implement error handling logic for returning the right error code
    }
}

data class InitError(val code: Int, val desc: String) {

}