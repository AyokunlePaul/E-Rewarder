package com.ayokunlepaul.erewarder.presentation.login

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.ayokunlepaul.erewarder.BR
import com.ayokunlepaul.erewarder.ERewarderApplication
import com.ayokunlepaul.erewarder.R
import com.ayokunlepaul.erewarder.base.BaseFragment
import com.ayokunlepaul.erewarder.databinding.FragmentLoginBinding
import com.ayokunlepaul.erewarder.utils.DataFactory
import com.ayokunlepaul.erewarder.utils.ERewarderNavigationCommand
import com.ayokunlepaul.erewarder.utils.resource.ERewarderState
import com.google.android.material.picker.MaterialDatePicker
import java.text.DateFormat
import java.util.*
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loginFragmentViewModel.logCustomerInState.observe(this, Observer {
            when (it.state) {
                ERewarderState.FAILED -> Toast.makeText(context!!, it.message, Toast.LENGTH_SHORT).show()
                ERewarderState.SUCCESS -> {
                    it.data?.let { customerModel ->
                        if (customerModel.isMyBirthday(
                                ERewarderApplication.getInstance(context!!).currentDate,
                                ERewarderApplication.getInstance(context!!).currentMonth
                            )
                        ) {
                            navigate(ERewarderNavigationCommand.To(LoginFragmentDirections.actionGotoRewardFragment(customerModel)))
                        } else {
                            navigate(ERewarderNavigationCommand.To(LoginFragmentDirections.actionGotoBirthdayDoesntQualifyFragment(customerModel)))
                        }
                    }
                }
            }
        })
        binding.setDate.setOnClickListener {
            val dialog = MaterialDatePicker.Builder.datePicker().build()
            dialog.addOnPositiveButtonClickListener {
                it?.let {
                    ERewarderApplication.getInstance(context!!).apply {
                        setDate(Date(it).date)
                        setMonth(Date(it).month + 1)
                    }
                    Toast.makeText(context!!, "New date set ${DateFormat.getInstance().format(Date(it))}", Toast.LENGTH_SHORT).show()
                } ?: Toast.makeText(context!!, "Using current system date", Toast.LENGTH_SHORT).show()
            }
            dialog.show(childFragmentManager, "DATE_DIALOG")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fill, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_test_fill -> {
                val customer = DataFactory.getCustomer()
                loginFragmentViewModel.apply {
                    phoneNumber.postValue(
                        customer.phoneNumber
                    )
                    password.postValue(
                        customer.password
                    )
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}