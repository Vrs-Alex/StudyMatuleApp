package vrsalex.matule.data.mapper

import vrsalex.matule.data.entity.OrderEntity
import vrsalex.matule.domain.model.CartItem
import vrsalex.matule.domain.model.Order
import java.time.LocalDateTime
import java.util.UUID

fun OrderEntity.toDomain(): Order = Order(
    id = this.id,
    userId = this.userId,
    productId = this.productId,
    count = this.count,
    created = this.createdAt,
    updated = this.updatedAt
)

fun Order.toEntity(isNew: Boolean = false): OrderEntity = OrderEntity(
    id = if (isNew) UUID.randomUUID().toString() else this.id,
    userId = this.userId,
    productId = this.productId,
    count = this.count,
    createdAt = if (isNew) LocalDateTime.now() else this.created,
    updatedAt = LocalDateTime.now()
)