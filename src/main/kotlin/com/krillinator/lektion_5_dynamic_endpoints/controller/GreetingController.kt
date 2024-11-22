package com.krillinator.lektion_5_dynamic_endpoints.controller

import com.krillinator.lektion_5_dynamic_endpoints.model.GreetingModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
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

        // Instantiation (Creation of New Object)
        val greeting = GreetingModel(
            "MyGreetingObject",
            "Hello world, from object GreetingModel",
            "This is a GreetingModel object, from Kotlin"
        )

        // When returning object, spring converts it to JSON by default
        return greeting
    }


    // RequestParam = Takes in dynamic values
    // RequestParam = NOT OPTIONAL (by default)
    // IF we exclude, RequestParam = BAD REQUEST - 400

    // /search?q=bananas
    // q = query (search param)
    // http://localhost:8081/hello-dynamic?q=bananas = BAD REQUEST
    // http://localhost:8081/hello-dynamic?title=bananas = SUCCESS

    // Multiple Params... How do we concatenate?
    // /hello-dynamic?title=bananas?message=TBD?description=TBD = 404 Not Found
    // /hello-dynamic?title=bananas&message=hej&description=inSwedish = SUCCESS 200

    // Required (default param - sets required to false automatically)
    // /hello-dynamic?title=bananas = 500 Internal Server Error
    // /hello-dynamic = 500 Internal Server Error

    // defaultValue = ""
    // required becomes 'false' implicitly
    // /hello-dynamic = 200 OK

    @GetMapping("/hello-dynamic")
    fun dynamicGreeting(
        @RequestParam("title", defaultValue = "") title: String,
        @RequestParam("message", defaultValue = "") message: String,
        @RequestParam("description", defaultValue = "") description: String,
    ): GreetingModel {

        val greeting = GreetingModel(title, message, description)

        return greeting
    }

}
