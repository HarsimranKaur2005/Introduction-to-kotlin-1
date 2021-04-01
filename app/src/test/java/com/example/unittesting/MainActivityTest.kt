package com.example.unittesting

import android.content.Context
import org.junit.Assert
import org.junit.Test
import org.junit.runner.manipulation.Ordering
import org.mockito.Mock

class MainActivityTest {

    @Test
    fun testEmailisValid(){
        val email = "simmy@gmail.com"
        val result = MainActivity().isEmailValid(email)
        Assert.assertTrue(result)
    }
    



    @Test
    fun TestEmailContainDot() {
        val email = "simmy@gmail.com"
        val result = MainActivity().isEmailValid(email)
        Assert.assertTrue(result)
    }

    @Test
    fun TestEmailstartsWith() {
        val email = "simmy@gmail.com"
        val result = MainActivity().isEmailValid(email)
        Assert.assertTrue(result)
    }
}