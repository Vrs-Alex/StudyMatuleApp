package vrsalex.matule.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project_type")
data class ProjectTypeEntity(
    @PrimaryKey
    val id: Long = 0L,
    val name: String,
    val description: String?
)
