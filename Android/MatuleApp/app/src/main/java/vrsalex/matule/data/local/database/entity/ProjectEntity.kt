package vrsalex.matule.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "project")
data class ProjectEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val startDate: String,
    val endDate: String,
    val url: String,
    val typeId: Long,
    val categoryId: Long
)
