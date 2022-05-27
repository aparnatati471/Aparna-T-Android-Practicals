package dependency.injection

import android.util.Log
import com.example.javakotlinpracticals.R

/** Interface for getting data */
interface PersonRepo {
    fun getPersonsList(): List<PersonModel>
}

class PersonRepository : PersonRepo {

    init {
        Log.d("Hilt", this.toString())
    }

    /** Overridden Method */
    override fun getPersonsList() = listOf(
        PersonModel(R.drawable.a, "a"),
        PersonModel(R.drawable.b, "b"),
        PersonModel(R.drawable.c, "c"),
        PersonModel(R.drawable.d, "d"),
        PersonModel(R.drawable.e, "e"),
        PersonModel(R.drawable.f, "f"),
    )

}