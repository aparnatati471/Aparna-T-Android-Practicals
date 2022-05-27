package dependency.injection

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PersonModule {

    init {
        Log.d("Hilt", this.toString())
    }

    /** Interface Object Through Module */
    @Provides
    @Singleton
    fun providePersonDetails(): PersonRepo = PersonRepository()

}