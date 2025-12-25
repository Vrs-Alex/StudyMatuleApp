package vrsalex.matule.data.local.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "project",
    foreignKeys = [
        ForeignKey(
            entity = ProjectTypeEntity::class,
            parentColumns = ["id"],
            childColumns = ["typeId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ProjectCategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
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
