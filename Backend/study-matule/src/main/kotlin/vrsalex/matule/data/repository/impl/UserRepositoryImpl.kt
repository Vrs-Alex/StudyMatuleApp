package vrsalex.matule.data.repository.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import vrsalex.matule.data.mapper.toDomain
import vrsalex.matule.data.mapper.toEntity
import vrsalex.matule.data.repository.jpa.UserJpaRepository
import vrsalex.matule.domain.model.User
import vrsalex.matule.domain.port.repository.UserRepository
import java.util.UUID

@Repository
class UserRepositoryImpl(
    private val jpaRepository: UserJpaRepository // Внедряем JPA-репозиторий
) : UserRepository {

    override fun save(user: User): User {
        val newEntity = user.toEntity(isNew = true).copy(id = UUID.randomUUID().toString())
        return jpaRepository.save(newEntity).toDomain()
    }

    override fun findById(id: String): User? {
        return jpaRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun findByEmail(email: String): User? {
        return jpaRepository.findByEmail(email)?.toDomain()
    }

    override fun update(user: User): User {
        val existingEntity = jpaRepository.findByIdOrNull(user.id)
            ?: throw NoSuchElementException("User not found for update")

        val updatedEntity = existingEntity.copy(
            email = user.email,
            emailVisibility = user.emailVisibility,
            firstname = user.firstname,
            lastname = user.lastname,
            secondname = user.secondname,
            dateBirthday = user.datebirthday,
            gender = user.gender
        )
        return jpaRepository.save(updatedEntity).toDomain()
    }

    override fun delete(id: String) {
        jpaRepository.deleteById(id)
    }
}