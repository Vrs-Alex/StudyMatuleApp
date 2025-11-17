package vrsalex.matule.domain.port.repository

import org.springframework.data.domain.Pageable
import vrsalex.matule.domain.model.News
import vrsalex.matule.domain.model.Product
import vrsalex.matule.domain.model.Project
import vrsalex.matule.domain.model.User

interface ProjectRepository {
    fun save(project: Project): Project
    fun findAll(pageable: Pageable): List<Project>
}