package org.project.kotlinrestfullapi.service

import org.project.kotlinrestfullapi.request.CreateProductRequest
import org.project.kotlinrestfullapi.request.ListPageRequest
import org.project.kotlinrestfullapi.request.UpdateProductRequest
import org.project.kotlinrestfullapi.response.ProductResponse

interface ProductService{
    fun createProduct(createProductRequest : CreateProductRequest) : ProductResponse;

    fun getProduct(id : String) : ProductResponse;

    fun listProduct(listPageRequest: ListPageRequest) : List<ProductResponse>;

    fun updateProduct(id : String, updateProductRequest: UpdateProductRequest) :ProductResponse
}