package com.tikal.cmdls.controllers

import com.tikal.cmdls.model.Keywords
import com.tikal.cmdls.services.KeywordsService
import io.reactivex.Single
import org.eclipse.microprofile.openapi.annotations.Operation
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/keywords")
class KeywordController {

    @Inject
    lateinit var keywordsService: KeywordsService

    @Operation(summary = "Hi", description = "Just saying hi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun findByKeywords() = keywordsService.sayHi()

    @Operation(summary = "dump all", description = "Dump all keywords")
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll(): List<Keywords> = keywordsService.getAll().toList().blockingGet()

    @Operation(summary = "Get a keyword")
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun get(@PathParam("id") id: Long): Keywords = keywordsService.get(id)
            .switchIfEmpty(Single.error(NotFoundException()))
            .blockingGet()

    @Operation(summary = "Add a keyword")
    @PUT
    @Path("add/{keyword}")
    @Produces(MediaType.APPLICATION_JSON)
    fun add(@PathParam("keyword") keyword: String) =
            keywordsService.addNew(keyword)
                    .blockingGet()
}