package vrsalex.matule.data.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository
import vrsalex.matule.data.entity.OrderEntity

interface OrderJpaRepository : JpaRepository<OrderEntity, String> {
    fun findAllByUserId(userId: String): List<OrderEntity>
}