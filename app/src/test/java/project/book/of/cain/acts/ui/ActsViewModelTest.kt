package project.book.of.cain.acts.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ActsViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var testedClass: ActsViewModel

    @Before
    fun setup() {
        testedClass = ActsViewModel()
    }

    @Test
    fun `given an initial state, when fetching acts, then state is loading`() {
        val expected = ActsScreen.State(loading = true)

        testedClass.onEvent(ActsScreen.Event.FetchActs)
        val actual = testedClass.state().value

        assertEquals(expected, actual)
    }

}
