package me.eastack.post.post.model

import me.eastack.shared.utils.UuidGenerator
import org.springframework.stereotype.Component

@Component
class PostIdGenerator {
    fun generate(): String {
        return UuidGenerator.newUuid()
    }
}