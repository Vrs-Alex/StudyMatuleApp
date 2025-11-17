package vrsalex.matule.domain.port.repository

import vrsalex.matule.domain.model.User

interface UserRepository {
    fun save(user: User): User
    fun findById(id: String): User?
    fun findByEmail(email: String): User?
    fun update(user: User): User
    fun delete(id: String)
}