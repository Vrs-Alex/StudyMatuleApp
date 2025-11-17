package vrsalex.matule.domain.port.repository

import vrsalex.matule.domain.model.CartItem

interface CartItemRepository {
    fun save(cartItem: CartItem): CartItem
    fun update(cartItem: CartItem): CartItem
}