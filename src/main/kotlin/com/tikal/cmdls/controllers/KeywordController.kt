package com.tikal.cmdls.controllers

import com.tikal.cmdls.services.KeywordsService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/keywords")
class KeywordController (@Inject val keywordsService: KeywordsService) {



    @GET
    fun findByKeywords() = keywordsService.sayHi()
}