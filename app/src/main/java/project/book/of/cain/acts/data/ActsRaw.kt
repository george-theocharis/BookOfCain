package project.book.of.cain.acts.data

import kotlinx.serialization.Serializable

@Serializable
data class ActsRaw(
    val acts: List<ActRaw>
)
