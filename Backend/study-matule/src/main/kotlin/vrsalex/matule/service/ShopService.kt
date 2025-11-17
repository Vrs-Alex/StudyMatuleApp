package vrsalex.matule.service

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import vrsalex.matule.domain.model.News
import vrsalex.matule.domain.model.Product
import vrsalex.matule.domain.model.ProductItem
import vrsalex.matule.domain.port.repository.NewsRepository
import vrsalex.matule.domain.port.repository.ProductRepository
import vrsalex.matule.dto.response.NewsDto
import vrsalex.matule.dto.response.ProductDto
import vrsalex.matule.dto.response.ProductItemDto
import vrsalex.matule.dto.response.ResponseProductsDto
import vrsalex.matule.dto.response.ResponsesNewsDto


// Маппинг DTO для примера (для продакшена выносится в мапперы)
fun ProductItem.toDto() = ProductItemDto(id, title, price, typeCloses, type)
fun Product.toDto() = ProductDto(
    id, "product", "products", created.toString(), updated.toString(),
    title, description, price, typeCloses, type, approximateCost
)
fun News.toDto() = NewsDto(
    id, "news", "news", created.toString(), updated.toString(), newsImage
)

@Service
class ShopService(
    private val productRepository: ProductRepository,
    private val newsRepository: NewsRepository
) {
    private val defaultPageSize = 20

    /**
     * GET /collections/products/records: Список продуктов с поиском
     */
    fun listProducts(filter: String?): ResponseProductsDto {
        val items = if (!filter.isNullOrBlank()) {
            productRepository.findByTitle(filter) // Используем поиск по названию
        } else {
            // Для упрощения, пока без пагинации, если нет фильтра
            productRepository.findAll(PageRequest.of(0, defaultPageSize))
        }

        val dtoList = items.map { it.toDto() }

        // Заглушка для пагинации
        return ResponseProductsDto(
            page = 1,
            perPage = defaultPageSize,
            totalPages = 1,
            totalItems = dtoList.size,
            items = dtoList
        )
    }

    /**
     * GET /collections/products/records/{id_product}: Описание продукта
     */
    fun getProductDetails(idProduct: String): ProductDto {
        val product = productRepository.findById(idProduct)
            ?: throw NoSuchElementException("Product not found.")
        return product.toDto()
    }

    /**
     * GET /collections/news/records: Акции и новости
     */
    fun listNews(): ResponsesNewsDto {
        // Для упрощения, используем фиксированную пагинацию
        val pageable = PageRequest.of(0, defaultPageSize)
        val items = newsRepository.findAll(pageable)

        val dtoList = items.map { it.toDto() }

        // Заглушка для пагинации
        return ResponsesNewsDto(
            page = 1,
            perPage = defaultPageSize,
            totalPages = 1,
            totalItems = dtoList.size,
            items = dtoList
        )
    }
}