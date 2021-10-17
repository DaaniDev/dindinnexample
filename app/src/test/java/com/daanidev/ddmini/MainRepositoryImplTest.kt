package com.daanidev.ddmini

import com.daanidev.ddmini.network.ApiHelper
import com.daanidev.ddmini.repository.MainRepository
import com.daanidev.ddmini.ui.neworder.model.Addon
import com.daanidev.ddmini.ui.neworder.model.Data
import com.daanidev.ddmini.ui.neworder.model.NewOrderResponse
import com.daanidev.ddmini.ui.neworder.model.Status
import io.reactivex.Observable
import io.reactivex.Observer
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations.initMocks

class MainRepositoryImplTest {

    private var newOrderResponse: NewOrderResponse? = null
    private lateinit var mainRepository: MainRepository
    @Mock
    private lateinit var apiHelper: ApiHelper

    @Before
    fun setUp(){

        initMocks(this)

        val newOrderData = Data(
            listOf(Addon(12, 7, 12, "Test String")),
            1, 2, "Test Title"
        )
        val status = Status("success",200,true)
        newOrderResponse = NewOrderResponse(
            "2021-06-10T15:13+00Z", "2021-06-10T15:10+00Z",
            listOf(newOrderData), "2021-06-10T15:15+00Z",321,status,"12.30pm"
        )

    }


}