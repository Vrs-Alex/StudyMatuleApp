package vrsalex.matule.data.local.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class FullProjectInfo(
    @Embedded val project: ProjectEntity,
    @Relation(
        parentColumn = "typeId",
        entityColumn = "id"
    )
    val projectType: ProjectTypeEntity,

    @Relation(
        parentColumn = "categoryId",
        entityColumn = "id"
    )
    val projectCategory: ProjectCategoryEntity
)