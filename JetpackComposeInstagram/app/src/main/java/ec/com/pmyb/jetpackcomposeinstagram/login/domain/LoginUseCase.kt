package ec.com.pmyb.jetpackcomposeinstagram.login.domain

import ec.com.pmyb.jetpackcomposeinstagram.login.data.LoginRepository

class LoginUseCase {
    val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }

}