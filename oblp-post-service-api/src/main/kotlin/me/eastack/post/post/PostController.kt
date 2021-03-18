package me.eastack.post.post

import me.eastack.post.post.representation.PostRepresentationService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(val postRepresentationService: PostRepresentationService) {

}