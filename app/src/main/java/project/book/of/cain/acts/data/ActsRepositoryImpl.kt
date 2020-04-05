package project.book.of.cain.acts.data

import project.book.of.cain.acts.domain.ActsRepository
import project.book.of.cain.utils.either

class ActsRepositoryImpl(private val api: ActsApi) : ActsRepository {

    override suspend fun getActs() = either {
        api.getActs().acts.map { it.toAct() }
    }
}
