package me.eastack.post.post.model

import org.springframework.stereotype.Component

@Component
class PostFactory(val postIdGenerator: PostIdGenerator) {
}