package org.project.kotlinrestfullapi.controller

import org.project.kotlinrestfullapi.exception.NotFoundException
import org.project.kotlinrestfullapi.response.WebResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException) : ResponseEntity<WebResponse<String>>{
        return ResponseEntity(WebResponse(
            code = 404,
            status = "BAD REQUEST",
            data= constraintViolationException.message!!
        ), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundHandler(notFoundException: NotFoundException) : ResponseEntity<WebResponse<String>>{
        return ResponseEntity(
            WebResponse(
            code = 404,
                status = "NOT FOUND",
                data="NOT FOUND"
        ),HttpStatus.BAD_REQUEST)
    }
}