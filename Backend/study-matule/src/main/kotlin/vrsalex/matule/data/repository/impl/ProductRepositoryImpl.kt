package vrsalex.matule.data.repository.impl

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import vrsalex.matule.data.mapper.toDomain
import vrsalex.matule.data.mapper.toItemDomain
import vrsalex.matule.data.repository.jpa.ProductJpaRepository
import vrsalex.matule.domain.model.Product
import vrsalex.matule.domain.model.ProductItem
import vrsalex.matule.domain.port.repository.ProductRepository

@Repository
class ProductRepositoryImpl(
    private val jpaRepository: ProductJpaRepository
) : ProductRepository {

    override fun findById(id: String): Product? {
        return jpaRepository.findById(id).orElse(null)?.toDomain()
    }

    override fun findAll(pageable: Pageable): List<ProductItem> {
        return jpaRepository.findAll(pageable).content.map { it.toItemDomain() }
    }

    override fun findByTitle(filter: String): List<ProductItem> {
        return jpaRepository.findByTitleContainingIgnoreCase(filter).map { it.toItemDomain() }
    }
}