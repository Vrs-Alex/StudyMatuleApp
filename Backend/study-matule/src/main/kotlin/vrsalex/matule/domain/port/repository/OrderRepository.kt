package vrsalex.matule.domain.port.repository

import vrsalex.matule.domain.model.CartItem
import vrsalex.matule.domain.model.Order

interface OrderRepository {
    fun save(order: Order): Order
}