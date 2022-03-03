package com.kindred.ui

import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.kindred.R
import com.kindred.repository.AppRepositoryImpl
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import retrofit2.http.GET
import java.util.regex.Pattern.matches

@LargeTest
@RunWith(AndroidJUnit4::class)
class GamesListActivityTest/*(java: Class<GamesListActivityTest>)*/ {

    private lateinit var scenario : ActivityScenario<GamesListActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(GamesListActivity::class.java)
        scenario.moveToState(Lifecycle.State.STARTED)

    }



    @Test
    fun recyclerViewItemClick() {
        Espresso.onView(withId(R.id.recyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2,
                ViewActions.click()
            ))
    }

}