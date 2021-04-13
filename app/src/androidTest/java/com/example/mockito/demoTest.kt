package com.example.mockito

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class demoTest {

    /**
     * Use this create and launch the activity under test before each test,
     * and close it after each test.
     */
    @get:Rule
    var activityTestRule = androidx.test.rule.ActivityTestRule(MainActivity::class.java)

    /**
     * Use this test to check the checkbox
     */
    @Test
    fun testAddToFavorite_CheckBoxChecked() {
        onView(withId(R.id.buttonme))
            .perform(ViewActions.click())
        onView(withId(R.id.checkboxch))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
    }

    /**
     * Use this test to uncheck the checkbox
     */
    @Test
    fun testAddToFavorite_CheckBoxNotChecked() {
        onView(withId(R.id.buttonme))
            .perform(ViewActions.click())
        onView(withId(R.id.checkboxch))
            .check(ViewAssertions.matches(ViewMatchers.isNotChecked()))
    }


}