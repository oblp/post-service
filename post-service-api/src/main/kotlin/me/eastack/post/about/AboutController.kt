package me.eastack.post.about

import me.eastack.post.sdk.AboutRepresentation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/about"])
class AboutController {

    @GetMapping
    fun about():AboutRepresentation {
        return AboutRepresentation(
            "post",
            "123",
            "2021-03-18 16:58",
            "2021-03-18 17:00",
            "acf671a",
            "main",
            "dev",
        )
    }
}