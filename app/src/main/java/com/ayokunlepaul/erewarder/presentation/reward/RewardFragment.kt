package com.ayokunlepaul.erewarder.presentation.reward

import com.ayokunlepaul.erewarder.BR
import com.ayokunlepaul.erewarder.R
import com.ayokunlepaul.erewarder.base.BaseFragment
import com.ayokunlepaul.erewarder.databinding.FragmentRewardBinding
import javax.inject.Inject

class RewardFragment: BaseFragment<FragmentRewardBinding, RewardFragmentViewModel>() {

    @Inject
    lateinit var rewardFragmentViewModel: RewardFragmentViewModel

    private lateinit var binding: FragmentRewardBinding

    override fun getViewModel(): RewardFragmentViewModel = rewardFragmentViewModel

    override fun getLayoutId(): Int = R.layout.fragment_reward

    override fun getBindingVariable(): Int = BR.ViewModel

    override fun getLayoutBinding(binding: FragmentRewardBinding) {
        this.binding = binding
    }
}