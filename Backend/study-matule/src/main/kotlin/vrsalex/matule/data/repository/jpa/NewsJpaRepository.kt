package vrsalex.matule.data.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository
import vrsalex.matule.data.entity.NewsEntity
import vrsalex.matule.data.entity.UserEntity

interface NewsJpaRepository : JpaRepository<NewsEntity, String>