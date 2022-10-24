package ec.com.pmyb.jetpackcomposeinstagram.login.data

import ec.com.pmyb.jetpackcomposeinstagram.login.data.network.LoginService

class LoginRepository {

    private val api = LoginService()

    suspend fun doLogin(user: String, password: String):Boolean {
        return api.doLogin(user, password)
    }
}