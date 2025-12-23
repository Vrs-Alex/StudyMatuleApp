package vrsalex.matule.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import vrsalex.matule.data.local.database.entity.FullProjectInfo
import vrsalex.matule.data.local.database.entity.ProjectEntity

@Dao
interface ProjectDao {

    @Transaction
    @Query("SELECT * FROM project")
    fun getAllFullProjects(): Flow<List<FullProjectInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProject(project: ProjectEntity)

    @Update
    suspend fun updateProject(project: ProjectEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(projects: List<ProjectEntity>)

}