package project.book.of.cain.acts.domain

import project.book.of.cain.utils.Either
import project.book.of.cain.utils.Error

interface ActsRepository {

    suspend fun getActs(): Either<Error, List<Act>>

}
