package vrsalex.matule.domain.port.repository

import org.springframework.data.domain.Pageable
import vrsalex.matule.domain.model.News
import vrsalex.matule.domain.model.Product
import vrsalex.matule.domain.model.User

interface NewsRepository {
    fun findAll(pageable: Pageable): List<News>
}