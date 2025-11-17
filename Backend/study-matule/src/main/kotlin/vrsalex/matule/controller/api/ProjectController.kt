package vrsalex.matule.controller.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import vrsalex.matule.dto.request.RequestProjectDto
import vrsalex.matule.dto.response.ProjectDto
import vrsalex.matule.dto.response.ResponsesProjectDto
import vrsalex.matule.service.ProjectService

@RestController
@RequestMapping("/collections/project")
@Tag(name = "Проекты", description = "Операции с проектами.")
class ProjectController(
    private val projectService: ProjectService
) {

    @PostMapping("/records", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    @Operation(summary = "Создание нового проекта (с изображением)")
    // Spring автоматически разбирает Multipart-запрос в RequestProjectDto
    fun createProject(request: RequestProjectDto): ResponseEntity<ProjectDto> {
        val response = projectService.createProject(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping("/records")
    @Operation(summary = "Получение списка проектов")
    fun listProjects(): ResponseEntity<ResponsesProjectDto> {
        val response = projectService.listProjects()
        return ResponseEntity.ok(response)
    }
}