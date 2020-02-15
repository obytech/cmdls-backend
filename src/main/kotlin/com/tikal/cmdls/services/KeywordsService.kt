package com.tikal.cmdls.services

import com.tikal.cmdls.model.KeywordDao
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class KeywordsService {

    @Inject
    lateinit var keywordsDao: KeywordDao

    companion object {
        val log: Logger = LoggerFactory.getLogger(KeywordsService::class.java)
    }

    fun sayHi(): String {
        log.info("Saying hi")
        return "Hi"
    }

    fun getAll() = keywordsDao.findAll()

    fun get(id: Long) = keywordsDao.find(id)

    fun addNew(keyword: String) =
            keywordsDao.add(keyword)

}