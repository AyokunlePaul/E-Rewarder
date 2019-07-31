package com.ayokunlepaul.erewarder.presentation.login

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.ayokunlepaul.erewarder.BR
import com.ayokunlepaul.erewarder.R
import com.ayokunlepaul.erewarder.base.BaseFragment
import com.ayokunlepaul.erewarder.databinding.FragmentLoginBinding
import com.ayokunlepaul.erewarder.utils.resource.ERewarderState
import javax.inject.Inject

class LoginFragment: BaseFragment<FragmentLoginBinding, LoginFragmentViewModel>() {

    @Inject
    lateinit var loginFragmentViewModel: LoginFragmentViewModel

    private lateinit var binding: FragmentLoginBinding

    override fun getViewModel(): LoginFragmentViewModel = loginFragmentViewModel

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun getBindingVariable(): Int  = BR.ViewModel

    override fun getLayoutBinding(binding: FragmentLoginBinding) {
        this.binding = binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.phoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher())

        loginFragmentViewModel.logCustomerInState.observe(this, Observer {
            when (it.state) {
                ERewarderState.FAILED -> Toast.makeText(context!!, it.message, Toast.LENGTH_SHORT).show()
                ERewarderState.SUCCESS -> Toast.makeText(context!!, it.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}