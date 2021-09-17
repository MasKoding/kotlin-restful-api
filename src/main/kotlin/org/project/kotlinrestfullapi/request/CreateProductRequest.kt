package org.project.kotlinrestfullapi.request

import java.util.*
import javax.persistence.Column
import javax.persistence.Id
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateProductRequest (
//        ?  means can null
        @field:NotBlank
        val id: String?,

        @field:NotBlank
        val name: String?,

        @field:NotNull
        @field:Min(1)
        val price: Long?,

        @field:NotNull
        @field:Min(0)
        val quantity:Int?
);