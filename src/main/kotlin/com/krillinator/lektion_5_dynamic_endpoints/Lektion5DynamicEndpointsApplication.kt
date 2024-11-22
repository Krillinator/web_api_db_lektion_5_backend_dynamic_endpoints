package com.krillinator.lektion_5_dynamic_endpoints

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// Sub-annotations
// Component-Scanning (Activation)
/* IMPORTANT - THIS FILE MUST BE AT THE TOP - ROOT LEVEL */
@SpringBootApplication
class Lektion5DynamicEndpointsApplication

fun main(args: Array<String>) {
	runApplication<Lektion5DynamicEndpointsApplication>(*args)
}
