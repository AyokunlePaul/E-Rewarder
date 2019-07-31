package com.ayokunlepaul.cache.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayokunlepaul.cache.models.CustomerCacheModel
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCustomer(customerCacheModel: CustomerCacheModel)

    @Query("SELECT * FROM CUSTOMER WHERE phoneNumber = :phoneNumber AND password = :password")
    fun getCustomer(phoneNumber: String, password: String): List<CustomerCacheModel>
}