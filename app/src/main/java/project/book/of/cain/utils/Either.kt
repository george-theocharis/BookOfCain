package project.book.of.cain.utils

sealed class Either<out E, out T> {

    data class Failure<out E>(val error: E) : Either<E, Nothing>()
    data class Success<out T>(val data: T) : Either<Nothing, T>()

}

sealed class Error {
    data class SimpleError(val reason: String = "An error occurred!") : Error()
}
