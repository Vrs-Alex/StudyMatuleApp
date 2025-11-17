package vrsalex.matule.data.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository
import vrsalex.matule.data.entity.NewsEntity
import vrsalex.matule.data.entity.ProjectEntity
import vrsalex.matule.data.entity.UserEntity

interface ProjectJpaRepository : JpaRepository<ProjectEntity, String>