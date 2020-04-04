package project.book.of.cain.acts.data

import kotlinx.serialization.Serializable
import project.book.of.cain.acts.domain.Act

@Serializable
data class ActRaw(
    val slug: String,
    val number: Int,
    val name: String,
    val quests: List<QuestRaw>
) {

    fun toAct() = Act(number, name, quests.map { it.toQuest() })

}
