package uiwidgetsc.recyclerviewandadapters

import android.content.Context
import android.content.res.Resources
import com.example.javakotlinpracticals.R
import com.google.gson.Gson
import uiwidgetse.otherimportantviews.Student

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

        fun getStudentData(): ArrayList<Student> {
            val studentList: ArrayList<Student> = ArrayList()
            studentList.add(Student(R.drawable.a, "Sonu"))
            studentList.add(Student(R.drawable.b, "Jyoti"))
            studentList.add(Student(R.drawable.c, "Nandini"))
            studentList.add(Student(R.drawable.d, "Guddi"))
            studentList.add(Student(R.drawable.e, "Aniket"))
            studentList.add(Student(R.drawable.f, "Abhishek"))
            studentList.add(Student(R.drawable.g, "Vishal"))
            return studentList
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

        fun getLanguageData(): ArrayList<Student> {
            val languageList: ArrayList<Student> = ArrayList()
            val data = "While creating apps we may need to face the different Design Architectural Patterns depends upon the project type and behavior.We always need to figure out the best architecture depends upon the project requirements and it’s behavior before initiating the project. Being an app developer, we need to know different design pattern and architectures. Some of the patterns that most of the app developers are used to are Model-View-Controller(MVC), Model-View-Presenter(MVP), Model-View-ViewModel(MVVM), and the one which we are going to learn VIPER(View-Interactor-Presenter-Entity-Router) etc."
            languageList.add(Student(R.drawable.a, data))
            languageList.add(Student(R.drawable.b, data))
            languageList.add(Student(R.drawable.c, data))
            languageList.add(Student(R.drawable.d, data))
            languageList.add(Student(R.drawable.e, data))
            languageList.add(Student(R.drawable.f, data))
            return languageList
        }

    }

}

