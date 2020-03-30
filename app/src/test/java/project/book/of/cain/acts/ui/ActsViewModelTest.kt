package project.book.of.cain.acts.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyOrder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class ActsViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val observerMock = mockk<Observer<ActsScreen.State>>()
    private lateinit var testedClass: ActsViewModel

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        testedClass = ActsViewModel()

        every { observerMock.onChanged(any()) } returns Unit
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `given an initial state, when fetching acts, then state is loading`() = runBlockingTest {
        val loading = ActsScreen.State(loading = true)
        testedClass.state().observeForever(observerMock)

        testedClass.onEvent(ActsScreen.Event.FetchActs)

        verifyOrder {
            observerMock.onChanged(loading)
        }
    }

}
