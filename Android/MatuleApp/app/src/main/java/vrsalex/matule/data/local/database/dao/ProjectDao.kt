package vrsalex.matule.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import vrsalex.matule.data.local.database.entity.FullProjectInfo
import vrsalex.matule.data.local.database.entity.ProjectCategoryEntity
import vrsalex.matule.data.local.database.entity.ProjectEntity
import vrsalex.matule.data.local.database.entity.ProjectTypeEntity

@Dao
interface ProjectDao {

    @Transaction
    @Query("SELECT * FROM project")
    fun getAllFullProjects(): Flow<List<FullProjectInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProject(project: ProjectEntity): Long

    @Update
    suspend fun updateProject(project: ProjectEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(projects: List<ProjectEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTypes(types: List<ProjectTypeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategories(categories: List<ProjectCategoryEntity>)

}