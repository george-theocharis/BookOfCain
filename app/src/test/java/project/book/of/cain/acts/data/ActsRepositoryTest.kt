package project.book.of.cain.acts.data

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import project.book.of.cain.utils.Either
import project.book.of.cain.utils.Error

class ActsRepositoryTest {

    private val apiMock = mockk<ActsApi>()
    private val testedClass = ActsRepositoryImpl(apiMock)

    @Test
    fun `given api succeeds, when get acts, then result is the expected`() = runBlocking {
        val success = ActsRaw(emptyList())
        coEvery { apiMock.getActs() } returns success

        val result = testedClass.getActs()

        assertEquals(result, Either.Success(success.acts.map { it.toAct() }))
    }

    @Test
    fun `given api fails, when get acts, then result is the expected`() = runBlocking {
        val failure = Exception("No internet")
        coEvery { apiMock.getActs() } throws failure

        val result = testedClass.getActs()

        assertEquals(result, Either.Failure(Error.SimpleError("No internet")))
    }

}
