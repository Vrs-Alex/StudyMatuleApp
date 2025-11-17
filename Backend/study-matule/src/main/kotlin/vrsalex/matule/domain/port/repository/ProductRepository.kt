package vrsalex.matule.domain.port.repository

import org.springframework.data.domain.Pageable
import vrsalex.matule.domain.model.Product
import vrsalex.matule.domain.model.ProductItem
import vrsalex.matule.domain.model.User


interface ProductRepository {
    fun findById(id: String): Product?
    fun findAll(pageable: Pageable): List<ProductItem> // Для списка продуктов с пагинацией
    fun findByTitle(filter: String): List<ProductItem> // Для поиска
}