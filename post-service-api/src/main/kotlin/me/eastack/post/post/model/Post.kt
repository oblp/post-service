package me.eastack.post.post.model

import me.eastack.post.sdk.representation.post.PostRepresentation
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Post(
    @Id
    @GeneratedValue
    val id: Long,
    val title: String,
    val author: String,
    val content: String,
) {
    fun toRepresentation(): PostRepresentation {
        return PostRepresentation(id, title, author, content);
    }
}
