package com.daanidev.ddmini

import com.daanidev.ddmini.ui.neworder.model.Addon
import com.daanidev.ddmini.ui.neworder.model.Data
import com.daanidev.ddmini.ui.neworder.model.NewOrderResponse
import com.daanidev.ddmini.ui.neworder.model.Status
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertNotNull
import org.junit.Test

import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NewOrderResponseTest {

    private var newOrderResponse: NewOrderResponse? = null

    @Before
    fun setUp() {
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

    @Test
    fun testVerifyNewOrderResponseNotNull(){
        assertNotNull(newOrderResponse)
    }
    @Test
    fun testVerifyNewOrderResponse(){
        assertThat(newOrderResponse?.expired_at, `is`("2021-06-10T15:15+00Z"))
        assertThat(newOrderResponse?.alerted_at, `is`("2021-06-10T15:13+00Z"))
        assertThat(newOrderResponse?.created_at, `is`("2021-06-10T15:10+00Z"))
        assertThat(newOrderResponse?.data?.get(0)?.title,`is`("Test Title"))
    }

}