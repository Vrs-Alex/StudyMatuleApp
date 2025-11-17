package vrsalex.matule.data.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository
import vrsalex.matule.data.entity.ProductEntity
import vrsalex.matule.data.entity.UserEntity

interface ProductJpaRepository : JpaRepository<ProductEntity, String> {
    fun findByTitleContainingIgnoreCase(filter: String): List<ProductEntity>
}