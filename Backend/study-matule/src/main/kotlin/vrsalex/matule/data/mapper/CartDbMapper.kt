package vrsalex.matule.data.mapper

import vrsalex.matule.data.entity.CartItemEntity
import vrsalex.matule.domain.model.CartItem
import java.time.LocalDateTime
import java.util.UUID

fun CartItemEntity.toDomain(): CartItem = CartItem(
    id = this.id,
    userId = this.userId,
    productId = this.productId,
    count = this.count,
    created = this.createdAt,
    updated = this.updatedAt
)

fun CartItem.toEntity(isNew: Boolean = false): CartItemEntity = CartItemEntity(
    id = if (isNew) UUID.randomUUID().toString() else this.id,
    userId = this.userId,
    productId = this.productId,
    count = this.count,
    createdAt = if (isNew) LocalDateTime.now() else this.created,
    updatedAt = LocalDateTime.now()
)