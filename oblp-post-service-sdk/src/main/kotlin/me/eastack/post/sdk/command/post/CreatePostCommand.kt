package me.eastack.post.sdk.command.post

data class CreatePostCommand(
    val id: Long,
    val title: String,
    val author: String,
    val content: String,
)