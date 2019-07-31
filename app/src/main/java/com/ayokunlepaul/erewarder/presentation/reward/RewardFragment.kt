package com.ayokunlepaul.erewarder.presentation.reward

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.ayokunlepaul.erewarder.BR
import com.ayokunlepaul.erewarder.R
import com.ayokunlepaul.erewarder.base.BaseFragment
import com.ayokunlepaul.erewarder.databinding.FragmentRewardBinding
import com.ayokunlepaul.erewarder.presentation.birthday.NotBirthdayFragmentDirections
import com.ayokunlepaul.erewarder.utils.ERewarderNavigationCommand
import javax.inject.Inject

class RewardFragment: BaseFragment<FragmentRewardBinding, RewardFragmentViewModel>() {

    @Inject
    lateinit var rewardFragmentViewModel: RewardFragmentViewModel

    private val args = navArgs<RewardFragmentArgs>()

    private lateinit var binding: FragmentRewardBinding

    override fun getViewModel(): RewardFragmentViewModel = rewardFragmentViewModel

    override fun getLayoutId(): Int = R.layout.fragment_reward

    override fun getBindingVariable(): Int = BR.ViewModel

    override fun getLayoutBinding(binding: FragmentRewardBinding) {
        this.binding = binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.customer = args.value.customer
        binding.redeem.setOnClickListener {
            Toast.makeText(context!!, "You have redeemed your reward!", Toast.LENGTH_SHORT).show()
            navigate(ERewarderNavigationCommand.To(RewardFragmentDirections.actionGotoLoginFragment()))
        }
        requireActivity().onBackPressedDispatcher.addCallback(object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigate(ERewarderNavigationCommand.To(NotBirthdayFragmentDirections.actionGotoLoginFragment()))
            }
        })
    }
}