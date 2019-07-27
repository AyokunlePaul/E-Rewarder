package com.ayokunlepaul.erewarder.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ayokunlepaul.erewarder.utils.ERewarderNavigationCommand
import dagger.android.support.DaggerFragment

abstract class BaseFragment<in D: ViewDataBinding, out V: BaseViewModel>: DaggerFragment() {

    abstract fun getViewModel(): V

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getBindingVariable(): Int

    abstract fun getLayoutBinding(binding: D)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: D = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.apply {
            setVariable(getBindingVariable(), getViewModel())
            executePendingBindings()
        }
        getLayoutBinding(binding)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getViewModel().navigationCommand.observe(this, Observer { navCommand ->
            when (navCommand) {
                is ERewarderNavigationCommand.Back -> findNavController().navigateUp()
                is ERewarderNavigationCommand.To -> findNavController().navigate(navCommand.direction)
            }
        })
    }
}