package com.tikal.cmdls.model

data class Keywords (val id: Long?, val keyword: String)

data class Arg (val id: Long?, val description: String, val type: ArgType, val isRequired: Boolean)

data class Flag (val id: Long?, val description: String, val type: ArgType, val isRequired: Boolean, val short: String?,
                 val long: String, val default: String? = null)

data class Resolution (val id: Long?, val bin: String, val npm: String, val github: String)




enum class ArgType {
    STRING,
    NUMBER,
    BOOLEAN;

    fun resolve(type: String): ArgType =
            ArgType.valueOf(type.toUpperCase())

}