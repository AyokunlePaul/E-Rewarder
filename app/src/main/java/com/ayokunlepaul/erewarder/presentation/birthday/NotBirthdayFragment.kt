package com.ayokunlepaul.erewarder.presentation.birthday

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.ayokunlepaul.erewarder.BR
import com.ayokunlepaul.erewarder.R
import com.ayokunlepaul.erewarder.base.BaseFragment
import com.ayokunlepaul.erewarder.databinding.FragmentNotBirthdayBinding
import com.ayokunlepaul.erewarder.utils.ERewarderNavigationCommand
import javax.inject.Inject

class NotBirthdayFragment: BaseFragment<FragmentNotBirthdayBinding, NotBirthdayFragmentViewModel>() {

    @Inject
    lateinit var notBirthdayFragmentViewModel: NotBirthdayFragmentViewModel

    private val args by navArgs<NotBirthdayFragmentArgs>()

    private lateinit var binding: FragmentNotBirthdayBinding

    override fun getViewModel(): NotBirthdayFragmentViewModel = notBirthdayFragmentViewModel

    override fun getLayoutId(): Int = R.layout.fragment_not_birthday

    override fun getBindingVariable(): Int = BR.ViewModel

    override fun getLayoutBinding(binding: FragmentNotBirthdayBinding) {
        this.binding = binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.customer = args.customer
        requireActivity().onBackPressedDispatcher.addCallback(object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigate(ERewarderNavigationCommand.To(NotBirthdayFragmentDirections.actionGotoLoginFragment()))
            }
        })
    }
}