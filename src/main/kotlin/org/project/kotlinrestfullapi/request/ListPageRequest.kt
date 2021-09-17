package org.project.kotlinrestfullapi.request

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class ListPageRequest (

        @field:NotNull
        val page : Int,

        @field:NotNull
        val size :Int



        );