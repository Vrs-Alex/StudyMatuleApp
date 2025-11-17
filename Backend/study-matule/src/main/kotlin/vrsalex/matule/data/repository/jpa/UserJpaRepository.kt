package vrsalex.matule.data.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository
import vrsalex.matule.data.entity.UserEntity

interface UserJpaRepository : JpaRepository<UserEntity, String> {
    fun findByEmail(email: String): UserEntity?
}