package ec.com.pmyb.jetpackcomposeinstagram.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoggingEnable = MutableLiveData<Boolean>()
    val isLogginEnable: LiveData<Boolean> = _isLoggingEnable

    fun onLoginChanged(email: String,password: String) {
        _email.value = email
        _password.value = password
        _isLoggingEnable.value = this.enableLogin(email, password)
    }

    fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                password.length > 6

}