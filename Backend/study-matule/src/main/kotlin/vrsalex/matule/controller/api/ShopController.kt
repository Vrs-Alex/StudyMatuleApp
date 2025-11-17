package vrsalex.matule.controller.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import vrsalex.matule.dto.response.ProductDto
import vrsalex.matule.dto.response.ResponseProductsDto
import vrsalex.matule.dto.response.ResponsesNewsDto
import vrsalex.matule.service.ShopService

@RestController
@Tag(name = "Магазин", description = "Операции с продуктами и новостями.")
class ShopController(
    private val shopService: ShopService
) {

    @GetMapping("/collections/products/records")
    @Operation(summary = "Получение списка продуктов с фильтрацией")
    fun listProducts(@RequestParam(required = false) filter: String?): ResponseEntity<ResponseProductsDto> {
        val response = shopService.listProducts(filter)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/collections/products/records/{id_product}")
    @Operation(summary = "Получение детальной информации о продукте")
    fun getProductDetails(@PathVariable("id_product") idProduct: String): ResponseEntity<ProductDto> {
        val response = shopService.getProductDetails(idProduct)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/collections/news/records")
    @Operation(summary = "Получение списка новостей и акций")
    fun listNews(): ResponseEntity<ResponsesNewsDto> {
        val response = shopService.listNews()
        return ResponseEntity.ok(response)
    }
}