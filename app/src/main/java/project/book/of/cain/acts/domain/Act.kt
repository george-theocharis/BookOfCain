package project.book.of.cain.acts.domain

data class Act(
    val number: Int,
    val name: String,
    val quests: List<Quest>
)
