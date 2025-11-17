package vrsalex.matule.data.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository
import vrsalex.matule.data.entity.CartItemEntity

interface CartItemJpaRepository : JpaRepository<CartItemEntity, String> {
    fun findAllByUserId(userId: String): List<CartItemEntity>
}