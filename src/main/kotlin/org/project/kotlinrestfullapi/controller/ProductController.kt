package org.project.kotlinrestfullapi.controller

import org.project.kotlinrestfullapi.entity.Product
import org.project.kotlinrestfullapi.request.CreateProductRequest
import org.project.kotlinrestfullapi.request.ListPageRequest
import org.project.kotlinrestfullapi.request.UpdateProductRequest
import org.project.kotlinrestfullapi.response.ProductResponse
import org.project.kotlinrestfullapi.response.WebResponse
import org.project.kotlinrestfullapi.service.ProductService
import org.project.kotlinrestfullapi.util.ValidationUtil
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ProductController(
                    val productService: ProductService,
                    val validatorUtil: ValidationUtil
                            ){

    @PostMapping(
            value=["/products"],
            produces = ["application/json"],
            consumes = ["application/json"]
        )
    fun createProduct(@RequestBody body: CreateProductRequest) : WebResponse<ProductResponse> {

        validatorUtil.validate(body);

        val productResponse = productService.createProduct(body);

        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        );
    }

    @GetMapping(
        value = ["/products/{id_product}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("id_product") id: String) : WebResponse<ProductResponse>{
        val product = productService.getProduct(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = product

        );
    }

    @GetMapping(
        value = ["/products"],
        produces = ["application/json"]
    )
    fun getListProduct(@RequestParam(value = "page",defaultValue = "0") page: Int, @RequestParam(value = "size",defaultValue = "10") size: Int) : WebResponse<List<ProductResponse>>{
        var request = ListPageRequest(page,size)

        validatorUtil.validate(request)

        return WebResponse(
            code = 200,
            status = "OK",
            data =  productService.listProduct(request)
        );
    }


    @PutMapping(
        value = ["/products/{id_product}"],
        consumes = ["application/json"],
        produces = ["application/json"]

    )
    fun updateProduct( @PathVariable("id_product") id :String, @RequestBody updateProductRequest: UpdateProductRequest) : WebResponse<ProductResponse>{

        var product =  productService.updateProduct(id,updateProductRequest);

        return WebResponse(
            code = 200,
            status = "OK",
            data = product
        )
    }
}