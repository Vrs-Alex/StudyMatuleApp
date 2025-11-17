package vrsalex.matule.data.repository.impl

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import vrsalex.matule.data.mapper.toDomain
import vrsalex.matule.data.mapper.toEntity
import vrsalex.matule.data.repository.jpa.ProjectJpaRepository
import vrsalex.matule.domain.model.Product
import vrsalex.matule.domain.model.Project
import vrsalex.matule.domain.model.User
import vrsalex.matule.domain.port.repository.ProductRepository
import vrsalex.matule.domain.port.repository.ProjectRepository

@Repository
class ProjectRepositoryImpl(
    private val jpaRepository: ProjectJpaRepository
) : ProjectRepository {

    override fun save(project: Project): Project {
        val isNew = jpaRepository.findById(project.id).isEmpty
        val entity = project.toEntity(isNew)
        return jpaRepository.save(entity).toDomain()
    }

    override fun findAll(pageable: Pageable): List<Project> {
        return jpaRepository.findAll(pageable).content.map { it.toDomain() }
    }
}