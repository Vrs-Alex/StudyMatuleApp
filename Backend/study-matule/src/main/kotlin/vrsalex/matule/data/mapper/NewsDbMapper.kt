package vrsalex.matule.data.mapper

import vrsalex.matule.data.entity.NewsEntity
import vrsalex.matule.domain.model.News

fun NewsEntity.toDomain(): News = News(
    id = this.id,
    newsImage = this.newsImage,
    created = this.createdAt,
    updated = this.updatedAt
)
