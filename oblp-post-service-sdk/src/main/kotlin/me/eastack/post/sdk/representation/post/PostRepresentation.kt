package me.eastack.post.sdk.representation.post

data class PostRepresentation(
    val id: Long,
    val title: String,
    val author: String,
    val content: String,
)