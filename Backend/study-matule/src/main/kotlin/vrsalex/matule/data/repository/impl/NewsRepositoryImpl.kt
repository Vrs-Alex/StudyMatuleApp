package vrsalex.matule.data.repository.impl

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import vrsalex.matule.data.mapper.toDomain
import vrsalex.matule.data.repository.jpa.NewsJpaRepository
import vrsalex.matule.domain.model.News
import vrsalex.matule.domain.port.repository.NewsRepository


@Repository
class NewsRepositoryImpl(
    private val jpaRepository: NewsJpaRepository
) : NewsRepository {

    override fun findAll(pageable: Pageable): List<News> {
        return jpaRepository.findAll(pageable).content.map { it.toDomain() }
    }
}