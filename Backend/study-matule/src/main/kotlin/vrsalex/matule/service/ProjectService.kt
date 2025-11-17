package vrsalex.matule.service


import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import vrsalex.matule.domain.model.Project
import vrsalex.matule.domain.port.repository.ProjectRepository
import vrsalex.matule.dto.request.RequestProjectDto
import vrsalex.matule.dto.response.ProjectDto
import vrsalex.matule.dto.response.ResponsesProjectDto
import java.io.File
import java.time.LocalDateTime
import java.util.UUID

// Маппинг DTO для примера
fun Project.toDto() = ProjectDto(
    id, "project", "projects", created.toString(), updated.toString(),
    title, dateStart, dateEnd, gender, descriptionSource, category, image, userId
)

@Service
class ProjectService(
    private val projectRepository: ProjectRepository
) {
    private val defaultPageSize = 20

    /**
     * POST /collections/project/records: Создание проекта
     */
    fun createProject(request: RequestProjectDto): ProjectDto {
        // 1. Обработка файла (заглушка)
        val imagePath = request.image?.let { file ->
            // В реальном проекте: сохранение файла на S3/диске и возврат URL
            // val uniqueFileName = UUID.randomUUID().toString() + "_" + file.originalFilename
            // file.transferTo(File("/path/to/uploads/$uniqueFileName"))
            "uploads/${file.originalFilename}"
        }

        // 2. Создание доменной модели
        val newProject = Project(
            id = UUID.randomUUID().toString(),
            userId = request.userId,
            title = request.title,
            dateStart = request.dateStart,
            dateEnd = request.dateEnd,
            gender = request.gender,
            descriptionSource = request.descriptionSource,
            category = request.category,
            image = imagePath,
            created = LocalDateTime.now(),
            updated = LocalDateTime.now()
        )

        val savedProject = projectRepository.save(newProject)
        return savedProject.toDto()
    }

    /**
     * GET /collections/project/records: Список проектов
     */
    fun listProjects(): ResponsesProjectDto {
        val pageable = PageRequest.of(0, defaultPageSize)
        val items = projectRepository.findAll(pageable)
        val dtoList = items.map { it.toDto() }

        // Заглушка для пагинации
        return ResponsesProjectDto(
            page = 1,
            perPage = defaultPageSize,
            totalPages = 1,
            totalItems = dtoList.size,
            items = dtoList
        )
    }
}