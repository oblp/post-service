package me.eastack.post.post.representation

import me.eastack.post.post.PostRepository
import me.eastack.post.post.model.Post
import me.eastack.post.sdk.command.post.CreatePostCommand
import me.eastack.post.sdk.representation.post.PostRepresentation
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class PostRepresentationService(
    val postRepository: PostRepository,
    val reactiveRedisOperations: ReactiveRedisOperations<String, Post>
) {

    @Transactional(readOnly = true)
    fun byId(id: Long): Mono<PostRepresentation> {
        return reactiveRedisOperations
            .opsForValue()
            .get("post: $id")
            .map(Post::toRepresentation)
    }

    @Transactional
    fun createPost(createPostCommand: CreatePostCommand): PostRepresentation {
        with(createPostCommand) {
            val post = postRepository.save(Post(id, title, author, content))
            reactiveRedisOperations
                .opsForValue().set("post: ${post.id}", post)
                .subscribe(System.out::println)
            return PostRepresentation(id, title, author, content)
        }
    }
}