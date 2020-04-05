package project.book.of.cain.acts.ui

import project.book.of.cain.acts.domain.Act
import project.book.of.cain.utils.Text.EMPTY

object ActsScreen {

    data class State(
        val acts: List<Act> = listOf(),
        val loading: Boolean = false,
        val error: String = EMPTY
    )

    sealed class Event {
        object FetchActs : Event()
    }
}
