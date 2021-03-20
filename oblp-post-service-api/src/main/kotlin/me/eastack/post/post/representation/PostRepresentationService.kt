package me.eastack.post.post.representation

import me.eastack.post.post.PostRepository
import me.eastack.post.post.model.Post
import me.eastack.post.sdk.command.post.CreatePostCommand
import me.eastack.post.sdk.representation.post.PostRepresentation
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostRepresentationService(var postRepository: PostRepository) {

    @Transactional(readOnly = true)
    fun byId(id: Long): PostRepresentation {
        return postRepository.findById(id)
            .map(Post::toRepresentation)
            .orElseThrow()
    }

    @Transactional
    fun save(createPostCommand: CreatePostCommand): PostRepresentation {

    }
}