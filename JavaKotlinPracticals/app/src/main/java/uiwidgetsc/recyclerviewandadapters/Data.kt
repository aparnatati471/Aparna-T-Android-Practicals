package uiwidgetsc.recyclerviewandadapters

import android.content.Context
import com.example.javakotlinpracticals.R
import com.google.gson.Gson

class Data {
    companion object getData {
        fun getPersonData(): ArrayList<Person> {
            val arrayPersonList: ArrayList<Person> = ArrayList()
            arrayPersonList.add(Person("sonu", "Hi", R.drawable.a))
            arrayPersonList.add(Person("Jyoti", "Hello", R.drawable.b))
            arrayPersonList.add(Person("Nanding", "How R u", R.drawable.c))
            arrayPersonList.add(Person("Guddi", "Fine", R.drawable.d))
            arrayPersonList.add(Person("Aniket", "Had Dinner?", R.drawable.e))
            arrayPersonList.add(Person("Vishal", "Hello", R.drawable.f))
            arrayPersonList.add(Person("Abhishek", "Hi", R.drawable.g))
            return arrayPersonList
        }

        fun getMoviesData(context: Context): ArrayList<DataClass> {
            val movieDetails = ArrayList<DataClass>()
            val gson = Gson()
            val fileurl = context.assets.open("MovieDetailsJSON.json").bufferedReader().use { it.readText() }

            val data: Movies = gson.fromJson(fileurl, Movies::class.java)
            data.forEach {
                movieDetails.add(DataClass(it.name, listOf(it.realname, it.team, it.publisher, it.firstappearance, it.createdby, it.bio)))
            }
            return movieDetails
        }

        fun getMoviesDataForRecyelrView(context: Context): ArrayList<MoviesItem> {
            val gson = Gson()
            val fileurl = context.assets.open("MovieDetailsJSON.json").bufferedReader().use { it.readText() }
            val data: Movies = gson.fromJson(fileurl, Movies::class.java)
            val modelList = ArrayList<MoviesItem>()
            data.forEach {
                modelList.add(MoviesItem(it.name, it.realname, it.team, it.publisher, it.firstappearance, it.createdby, it.bio))
            }
            return modelList
        }

        fun getImages(): ArrayList<StraggeredPhotosModel> {
            val imageList: ArrayList<StraggeredPhotosModel> = ArrayList()
            val images = intArrayOf(
                R.drawable.sone,
                R.drawable.a,
                R.drawable.stwo,
                R.drawable.sthree,
                R.drawable.sfour,
                R.drawable.sone,
                R.drawable.ssix,
                R.drawable.sfive,
                R.drawable.ssix,
                R.drawable.stwo,
                R.drawable.sfive,
                R.drawable.c
            )
            for (img in images.indices) {
                imageList.add(StraggeredPhotosModel(images[img]))
            }
            return imageList
        }
    }

}

