package project.book.of.cain.acts.data

import project.book.of.cain.acts.domain.Quest

data class QuestRaw(
    val id: Int,
    val name: String,
    val slug: String
) {

    fun toQuest() = Quest(id, name)

}

