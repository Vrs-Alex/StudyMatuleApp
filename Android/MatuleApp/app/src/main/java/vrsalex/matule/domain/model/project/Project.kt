package vrsalex.matule.domain.model.project

data class Project(
    val id: Long = 0,
    val name: String = "",
    val startDate: String = "",
    val endDate: String = "",
    val url: String = "",
    val type: ProjectType = ProjectType(),
    val category: ProjectCategory = ProjectCategory()
)
