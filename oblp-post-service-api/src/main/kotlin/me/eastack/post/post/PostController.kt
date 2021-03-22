package me.eastack.post.post

import me.eastack.post.post.representation.PostRepresentationService
import me.eastack.post.sdk.command.post.CreatePostCommand
import me.eastack.post.sdk.representation.post.PostRepresentation
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(val postRepresentationService: PostRepresentationService) {

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): PostRepresentation {
        return postRepresentationService.byId(id)
    }

    @PostMapping
    @ResponseStatus(CREATED)
    fun add(createPostCommand: CreatePostCommand): PostRepresentation {
        return postRepresentationService.save(createPostCommand)
    }

}