package com.febrian.vehiclesales.di

import android.app.Application
import androidx.room.Room
import com.febrian.vehiclesales.data.VehicleRepository
import com.febrian.vehiclesales.data.database.VehicleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideVehicleDatabase(app: Application): VehicleDatabase {
        return Room.databaseBuilder(
            app,
            VehicleDatabase::class.java,
            "Vehicle"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideVehicleRepository(db: VehicleDatabase): VehicleRepository {
        return VehicleRepository(db.vehicleDao)
    }
}