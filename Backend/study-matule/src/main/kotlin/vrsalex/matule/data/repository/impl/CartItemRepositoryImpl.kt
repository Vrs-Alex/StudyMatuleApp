package vrsalex.matule.data.repository.impl

import org.springframework.stereotype.Repository
import vrsalex.matule.data.mapper.toDomain
import vrsalex.matule.data.mapper.toEntity
import vrsalex.matule.data.repository.jpa.CartItemJpaRepository
import vrsalex.matule.domain.model.CartItem
import vrsalex.matule.domain.port.repository.CartItemRepository
import java.time.LocalDateTime

@Repository
class CartItemRepositoryImpl(
    private val jpaRepository: CartItemJpaRepository
) : CartItemRepository {

    override fun save(cartItem: CartItem): CartItem {
        val entity = cartItem.toEntity(isNew = true)
        return jpaRepository.save(entity).toDomain()
    }

    override fun update(cartItem: CartItem): CartItem {
        // Логика обновления: находим существующую запись и обновляем ее поля.
        val existing = jpaRepository.findById(cartItem.id).orElseThrow {
            NoSuchElementException("CartItem with ID ${cartItem.id} not found.")
        }

        val updatedEntity = existing.copy(
            count = cartItem.count,
            updatedAt = LocalDateTime.now()
        )
        return jpaRepository.save(updatedEntity).toDomain()
    }
}