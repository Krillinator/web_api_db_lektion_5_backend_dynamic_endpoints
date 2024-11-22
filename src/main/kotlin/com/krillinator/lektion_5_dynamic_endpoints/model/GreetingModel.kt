package com.krillinator.lektion_5_dynamic_endpoints.model

// Model = data (objects)
// Primary Constructor
class GreetingModel(
    val title: String,
    val message: String,
    val description: String,
    testInit: String = ""
) {

    // After Instantiation
    init {
        println("Inside INIT block")
        println(testInit)
    }


}
