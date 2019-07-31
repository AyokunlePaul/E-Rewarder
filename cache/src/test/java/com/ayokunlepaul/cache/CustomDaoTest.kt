package com.ayokunlepaul.cache

import androidx.room.Room
import com.ayokunlepaul.cache.room.ERewarderRoomDatabase
import com.ayokunlepaul.cache.test.DataFactory
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config (manifest = Config.NONE)
class CustomDaoTest {

    private lateinit var eRewarderRoomDatabase: ERewarderRoomDatabase

    @Before
    fun initializeDatabase() {
        eRewarderRoomDatabase = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.application.baseContext,
            ERewarderRoomDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    fun closeERewarderDatabase() {
        eRewarderRoomDatabase.close()
    }

    @Test
    fun saveCustomer () {
        val customer = DataFactory.getCustomer()
        eRewarderRoomDatabase.getCustomerDao().saveCustomer(customer)

        assert(eRewarderRoomDatabase.getCustomerDao().getCustomer(customer.phoneNumber, customer.password).isNotEmpty())
    }
}