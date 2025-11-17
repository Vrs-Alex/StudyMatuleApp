package vrsalex.matule.data.mapper

import vrsalex.matule.data.entity.ProductEntity
import vrsalex.matule.domain.model.Product
import vrsalex.matule.domain.model.ProductItem

fun ProductEntity.toDomain(): Product = Product(
    id = this.id,
    title = this.title,
    description = this.description,
    price = this.price,
    typeCloses = this.typeCloses,
    type = this.type,
    approximateCost = this.approximateCost,
    created = this.createdAt,
    updated = this.updatedAt
)

// Маппинг для ProductItem
fun ProductEntity.toItemDomain(): ProductItem = ProductItem(
    id = this.id,
    title = this.title,
    price = this.price,
    typeCloses = this.typeCloses,
    type = this.type
)