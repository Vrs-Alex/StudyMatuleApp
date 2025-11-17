package vrsalex.matule.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.multipart.MultipartFile

data class RequestProjectDto(
    val title: String,
    val typeProject: String?,
    @field:JsonProperty("user_id")
    val userId: String,
    val dateStart: String?,
    val dateEnd: String?,
    val gender: String?,
    @field:JsonProperty("description_source")
    val descriptionSource: String?,
    val category: String?,
    // В YAML указано format: binary, что соответствует MultipartFile в Spring
    val image: MultipartFile?
)