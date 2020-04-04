package project.book.of.cain.acts.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import project.book.of.cain.acts.domain.ActsRepository
import project.book.of.cain.utils.Either
import project.book.of.cain.utils.Error

class ActsViewModel(private val repository: ActsRepository) : ViewModel() {

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
            when (val result = repository.getActs()) {
                is Either.Success -> _state.value = _state.value?.copy(loading = false, acts = result.data)
                is Either.Failure -> _state.value = _state.value?.copy(loading = false, error = resolveError(result.error))
            }
        }
    }

    private fun resolveError(error: Error) = when (error) {
        is Error.SimpleError -> error.reason
    }

}


