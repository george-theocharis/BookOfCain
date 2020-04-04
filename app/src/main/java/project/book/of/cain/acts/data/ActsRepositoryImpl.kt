package project.book.of.cain.acts.data

import project.book.of.cain.acts.domain.Act
import project.book.of.cain.acts.domain.ActsRepository
import project.book.of.cain.utils.Either
import project.book.of.cain.utils.Error

class ActsRepositoryImpl(private val api: ActsApi): ActsRepository {

    override suspend fun getActs(): Either<Error, List<Act>> {
        return try {
            val actsList = api.getActs()
            Either.Success(actsList.map { it.toAct() })
        } catch (ex: Exception) {
            Either.Failure(ex.toError())
        }
    }

    private fun Exception.toError(): Error = message?.let{ Error.SimpleError(it) } ?: Error.SimpleError()

}
