package net.codetreats.etsy

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import net.codetreats.etsy.model.EtsyListResponse
import net.codetreats.etsy.model.ListingStateAdapter
import net.codetreats.etsy.util.LocalDateTimeAdapter
import net.codetreats.rest.RestClient
import org.apache.logging.log4j.Logger
import java.time.LocalDateTime

class EtsyClient(
    apiUrl: String,
    apiKey: String,
    accessToken: String,
    val shopId: String,
    val logger: Logger? = null
) {
    val restClient = RestClient(apiUrl, mapOf("x-api-key" to apiKey, "Authorization" to "Bearer $accessToken"))
    val moshi: Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .add(LocalDateTime::class.java, LocalDateTimeAdapter())
        .add(ListingStateAdapter())
        .build()

    inline fun <reified T> get(
        subUrl: String,
        params: Map<String, String?> = emptyMap(),
        headers: Map<String, String> = emptyMap()
    ): EtsyListResponse<T> {
        val subUrlReplaced = subUrl.replace("/:shopId/", "/$shopId/")
        logger?.info("GET $subUrlReplaced${params.filterNotNull().asUrl()} (${headers.asList()})")
        val message = restClient.get(subUrlReplaced, params.filterNotNull(), headers).message!!
        logger?.debug("Message: $message")
        val responseType = Types.newParameterizedType(EtsyListResponse::class.java, T::class.java)
        val adapter: JsonAdapter<EtsyListResponse<T>> = moshi.adapter(responseType)
        return adapter.fromJson(message)!!
    }
}

fun Map<String, String>.asUrl() = entries.joinToString("&", prefix = "?") { (k, v) -> "$k=$v" }

fun Map<String, String>.asList() = entries.joinToString(",") { (k, v) -> "$k=$v" }

fun Map<String, String?>.filterNotNull() : Map<String, String> =
    filter { it.value != null }.map { it.key to it.value!! }.toMap()

