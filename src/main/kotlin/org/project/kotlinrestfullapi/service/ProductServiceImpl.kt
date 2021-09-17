package org.project.kotlinrestfullapi.service

import org.project.kotlinrestfullapi.entity.Product
import org.project.kotlinrestfullapi.exception.NotFoundException
import org.project.kotlinrestfullapi.repository.ProductRepository
import org.project.kotlinrestfullapi.request.CreateProductRequest
import org.project.kotlinrestfullapi.request.ListPageRequest
import org.project.kotlinrestfullapi.request.UpdateProductRequest
import org.project.kotlinrestfullapi.response.ProductResponse
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService{
    override fun createProduct(createProductRequest: CreateProductRequest): ProductResponse {
        val product = Product(
                id=createProductRequest.id!!,
                name = createProductRequest.name!!,
                price= createProductRequest.price!!,
                quantity = createProductRequest.quantity!!,
                createdAt = Date(),
                updatedAt = null
        );

             productRepository.save(product);

        return convertProductToProductResponse(product)
    }

    override fun getProduct(id: String): ProductResponse {
        val product = productFindByIdOrNullException(id);

        return  convertProductToProductResponse(product)


    }

    override fun listProduct(listPageRequest: ListPageRequest): List<ProductResponse> {
        val data = productRepository.findAll(PageRequest.of(listPageRequest.page, listPageRequest.size));

        var products : List<Product> = data.get().collect(Collectors.toList());

        return products.map { convertProductToProductResponse(it) };

    }

    override fun updateProduct(id: String,updateProductRequest: UpdateProductRequest) : ProductResponse {
        val product = productFindByIdOrNullException(id);

        product.apply {
            name =updateProductRequest.name
            price = updateProductRequest.price
            quantity = updateProductRequest.quantity
            updatedAt = Date()

        };

        productRepository.save(product);
        return convertProductToProductResponse(product);
    }

    private fun convertProductToProductResponse(product: Product) : ProductResponse{
        return ProductResponse(
            id=product.id,
            name = product.name,
            price= product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        );
    }
    private fun productFindByIdOrNullException(id: String) : Product {
        val product = productRepository.findByIdOrNull(id);

        if (product == null) {
            throw NotFoundException();
        } else {
            return product;
        }
    }

}