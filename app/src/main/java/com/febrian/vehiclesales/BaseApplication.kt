package com.febrian.vehiclesales

import android.app.Application
import com.febrian.vehiclesales.utils.PreferenceManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BaseApplication : Application()