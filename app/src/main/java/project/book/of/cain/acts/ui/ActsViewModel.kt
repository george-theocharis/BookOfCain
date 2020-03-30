package project.book.of.cain.acts.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ActsViewModel : ViewModel() {

    private val _state = MutableLiveData<ActsScreen.State>()
    fun state(): LiveData<ActsScreen.State> = _state

    init {
        _state.value = ActsScreen.State()
    }

    fun onEvent(event: ActsScreen.Event) {
        when (event) {
            is ActsScreen.Event.FetchActs -> onFetchActs()
        }
    }

    private fun onFetchActs() {
        viewModelScope.launch {
            _state.value = _state.value?.copy(loading = true)
        }
    }

}


