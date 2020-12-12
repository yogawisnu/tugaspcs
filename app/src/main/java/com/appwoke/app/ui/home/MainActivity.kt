package com.appwoke.app.ui.home

import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.appwoke.app.R
import com.appwoke.app.databinding.ActivityMainBinding
import com.appwoke.app.ui.auth.AppwokeAuth
import com.appwoke.app.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
        binding.buttonLogout.setOnClickListener {
            AppwokeAuth.logoutAuth(this) {
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
}