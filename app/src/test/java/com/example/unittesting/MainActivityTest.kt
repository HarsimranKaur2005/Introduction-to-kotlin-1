package com.example.unittesting

import android.content.Context
import org.junit.Assert
import org.junit.Test
import org.junit.runner.manipulation.Ordering
import org.mockito.Mock

class MainActivityTest {


    @Test
    fun emailIsEmpty() {
        val email = MainActivity().EmailIsEmpty("")
        Assert.assertTrue(email)
    }

    @Test
    fun TestisValidate() {
        var result = MainActivity().isValidate("abc@gmail.com")
        Assert.assertTrue(result)
    }

    @Test
    fun TestEmailContainDot() {
        var result = MainActivity().EmailContainDot("abc@gmail.com")
        Assert.assertTrue(result)
    }

    @Test
    fun TestEmailstartsWith() {
        var result = MainActivity().EmailContainDot("abc@gmail.com")
        Assert.assertTrue(result)
    }
}