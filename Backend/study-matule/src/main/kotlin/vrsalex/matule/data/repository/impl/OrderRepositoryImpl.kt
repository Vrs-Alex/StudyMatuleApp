package vrsalex.matule.data.repository.impl

import org.springframework.stereotype.Repository
import vrsalex.matule.data.mapper.toDomain
import vrsalex.matule.data.mapper.toEntity
import vrsalex.matule.data.repository.jpa.OrderJpaRepository
import vrsalex.matule.domain.model.CartItem
import vrsalex.matule.domain.model.Order
import vrsalex.matule.domain.port.repository.OrderRepository

@Repository
class OrderRepositoryImpl(
    private val jpaRepository: OrderJpaRepository
) : OrderRepository {

    override fun save(order: Order): Order {
        val entity = order.toEntity(isNew = true)
        return jpaRepository.save(entity).toDomain()
    }
}