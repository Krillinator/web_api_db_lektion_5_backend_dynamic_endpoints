package com.krillinator.lektion_5_dynamic_endpoints.controller

import com.krillinator.lektion_5_dynamic_endpoints.model.GreetingModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// Naming Convention - Name + Controller
// RestController = Allows, mappings (HTTP Methods, GET POST PUT DELETE)
// ResponseBody = Web Response (body, header, status codes)
@RestController
class GreetingController {

    // String = Text (will be converted to HTML document)
    @GetMapping("/hello-world")
    fun greeting(): String {

        return "Hello World"
    }

    @GetMapping("/hello-object")
    fun greetingObject(): GreetingModel {

        val greeting = GreetingModel(
            "MyGreetingObject",
            "Hello world, from object GreetingModel",
            "This is a GreetingModel object, from Kotlin"
        )

        // When returning object, spring converts it to JSON by default
        return greeting
    }

}
