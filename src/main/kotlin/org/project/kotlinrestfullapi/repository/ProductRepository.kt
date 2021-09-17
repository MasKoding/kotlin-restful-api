package org.project.kotlinrestfullapi.repository

import org.project.kotlinrestfullapi.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product,String>{

}