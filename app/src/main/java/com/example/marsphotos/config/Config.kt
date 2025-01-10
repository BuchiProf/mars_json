package com.example.marsphotos.config

import java.util.Properties
import java.io.InputStream

object Config {
    val BASE_URL: String by lazy {
        println("Loading BASE_URL from config.properties")
        val inputStream: InputStream? = javaClass.classLoader?.getResourceAsStream("config.properties")
        val url = inputStream?.bufferedReader()?.use {
            val properties = Properties()
            properties.load(it)
            properties.getProperty("BASE_URL")
        } ?: "default_base_url"
        println("Loaded BASE_URL: $url")
        url
    }
}