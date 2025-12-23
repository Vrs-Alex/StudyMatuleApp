package vrsalex.matule.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import vrsalex.matule.data.local.database.dao.ProjectDao
import vrsalex.matule.data.local.database.entity.ProjectCategoryEntity
import vrsalex.matule.data.local.database.entity.ProjectEntity
import vrsalex.matule.data.local.database.entity.ProjectTypeEntity

@Database(
    entities = [
        ProjectEntity::class, ProjectTypeEntity::class,
        ProjectCategoryEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {


    abstract fun projectDao(): ProjectDao

}