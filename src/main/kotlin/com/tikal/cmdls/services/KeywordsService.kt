package com.tikal.cmdls.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class KeywordsService {
    companion object {
        private val log: Logger = LoggerFactory.getLogger(KeywordsService::class.java)
    }

    fun sayHi(): String {
        log.info("Saying hi")
        return "Hi"
    }

}