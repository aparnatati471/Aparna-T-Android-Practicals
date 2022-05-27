package dependency.injection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(private val personRepo: PersonRepo): ViewModel() {

    /** Variables */
    private val _personData = MutableLiveData<List<PersonModel>>()
    val personData: LiveData<List<PersonModel>> = _personData

    init {
        getPersonData()
    }

    /** Class Method*/
    private fun getPersonData() {
        _personData.value = personRepo.getPersonsList()
    }

}