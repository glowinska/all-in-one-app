/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.sleeptracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.example.android.sleeptracker.database.SleepDatabase
import com.example.android.sleeptracker.database.SleepDatabaseDao
import com.example.android.sleeptracker.database.SleepNight
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


/**
 * This is not meant to be a full set of tests. For simplicity, most of your samples do not
 * include tests. However, when building the Room, it is helpful to make sure it works before
 * adding the UI.
 */

@RunWith(AndroidJUnit4::class)
class SleepDatabaseTest {

    private lateinit var sleepDao: SleepDatabaseDao
    private lateinit var db: SleepDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, SleepDatabase::class.java)
                // Allowing main thread queries, just for testing.
                .allowMainThreadQueries()
                .build()
        sleepDao = db.sleepDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetNight() {
        val night = SleepNight()
        sleepDao.insertTest(night)
        val tonight = sleepDao.getTonightTest()
        assertEquals(tonight?.sleepQuality, -1)
    }

    @Test
    @Throws(Exception::class)
    fun updateAndGetNight() {
        val night = SleepNight(sleepQuality = 0)
        sleepDao.insertTest(night)
        val tonight = sleepDao.getTonightTest()
        assertEquals(tonight?.sleepQuality, 0)
    }

    @Test
    @Throws(Exception::class)
    fun clearNights() {
        sleepDao.clearTest()
        Transformations.map(sleepDao.getAllNights()) {
            assertEquals(it.isEmpty(), true)
        }
    }

    @Test
    @Throws(Exception::class)
    fun getAllNights() {
        val night = SleepNight()
        sleepDao.insertTest(night)
        sleepDao.insertTest(night)
        sleepDao.insertTest(night)
        var size = Transformations.map(sleepDao.getAllNights()) {
            assertEquals(it.size, 3)
        }
    }
}