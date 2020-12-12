package com.appwoke.app.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.appwoke.app.data.repository.AuthRepository
import com.appwoke.app.databinding.FragmentSplashBinding
import kotlinx.coroutines.*


class SplashFragment : Fragment() {
    val parent: AuthActivity by lazy { activity as AuthActivity }
    val viewModel: AuthViewModel by lazy { AuthViewModel(AuthRepository(parent)) }
    lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
       CoroutineScope(Dispatchers.IO).launch {
           delay(2000)
           withContext(Dispatchers.Main) {
               if (viewModel.isLogin.value == true) {
                   parent.onSucess(viewModel.authUser.value)
               } else {
                   findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
               }
           }
       }
    }


}