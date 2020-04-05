package project.book.of.cain.acts.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.coEvery
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
import project.book.of.cain.acts.domain.ActsRepository
import project.book.of.cain.utils.Either
import project.book.of.cain.utils.Error

@ExperimentalCoroutinesApi
class ActsViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val observerMock = mockk<Observer<ActsScreen.State>>()
    private val repositoryMock = mockk<ActsRepository>()
    private lateinit var testedClass: ActsViewModel

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        testedClass = ActsViewModel(repositoryMock)

        every { observerMock.onChanged(any()) } returns Unit
        coEvery { repositoryMock.getActs() } returns Either.Success(listOf())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `given an idle state, when fetching acts, then state is loading`() = runBlockingTest {
        val loading = ActsScreen.State(loading = true)
        testedClass.state().observeForever(observerMock)

        testedClass.onEvent(ActsScreen.Event.FetchActs)

        verifyOrder {
            observerMock.onChanged(loading)
        }
    }

    @Test
    fun `given a loading state, when fetching acts is successful, then state is the expected`() = runBlockingTest {
        val loading = ActsScreen.State(loading = true)
        val success = loading.copy(loading = false, acts = listOf())
        testedClass.state().observeForever(observerMock)

        testedClass.onEvent(ActsScreen.Event.FetchActs)

        verifyOrder {
            observerMock.onChanged(loading)
            observerMock.onChanged(success)
        }
    }

    @Test
    fun `given a loading state, when fetching acts fails, then state is the expected`() = runBlockingTest {
        val loading = ActsScreen.State(loading = true)
        val simpleError = Error.SimpleError()
        val failure = loading.copy(loading = false, error = simpleError.reason)
        testedClass.state().observeForever(observerMock)
        coEvery { repositoryMock.getActs() } returns Either.Failure(simpleError)

        testedClass.onEvent(ActsScreen.Event.FetchActs)

        verifyOrder {
            observerMock.onChanged(loading)
            observerMock.onChanged(failure)
        }
    }
}
