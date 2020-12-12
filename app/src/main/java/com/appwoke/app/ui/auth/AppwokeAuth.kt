package com.appwoke.app.ui.auth

import android.content.Context
import com.appwoke.app.data.model.ActionState
import com.appwoke.app.data.repository.AuthRepository
import kotlinx.coroutines.*
import javax.security.auth.callback.Callback

object AppwokeAuth {

    fun logoutAuth(context: Context, callback: ((ActionState<Boolean>) -> Unit)? = null ) {
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main) {
                if (callback != null) callback.invoke(resp)
            }
        }

    }
}