package com.krillinator.lektion_5_dynamic_endpoints.controller

import com.krillinator.lektion_5_dynamic_endpoints.model.CustomUser
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    // listOf = Immutable
    // mutableListOf = Mutable list
    val userList = mutableListOf(
        CustomUser(
            username = "Benny",
            password = "123",
            rememberMe = true,
            isEnabled = true
        ),
        CustomUser(
            username = "Frida",
            password = "321",
            rememberMe = false,
            isEnabled = false
        ),
    )

    @GetMapping("/users")
    fun getUser(): List<CustomUser> {

        return userList
    }

    // TODO - Debug for strings as well just in case
    // TODO - What if 'id' is outside of array range
    // Answer: Index Out of bounds (500 internal server error)
    // Solution: Conditional Check
    @GetMapping("/user")
    fun getUserByUserId(@RequestParam("id") id: Int): CustomUser {

        if (id >= 0 && id < userList.size) {
            return userList[id]
        } else {
            throw IndexOutOfBoundsException("Out of bounds")
        }

    }

    // Deletion of a User
    @DeleteMapping("/user")
    fun deleteUserByUserId(@RequestParam("id") id: Int): CustomUser {

        if (id >= 0 && id < userList.size) {
            return userList.removeAt(id)
        } else {
            throw IndexOutOfBoundsException("Out of bounds")
        }

    }

    // RequestParam is OK, but when something Is NOT supposed to be optional... Then use Body
    // RequestBody - Sensitive Data, do not include in URL | Endpoint
    @PostMapping("/user")
    fun createUser(@RequestBody customUser: CustomUser): Boolean {

        return userList.add(customUser) // true / false
    }

}