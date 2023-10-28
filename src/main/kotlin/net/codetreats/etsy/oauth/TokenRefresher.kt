package net.codetreats.etsy.oauth

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.ktor.http.*
import net.codetreats.etsy.asUrl
import net.codetreats.rest.RestClient
import java.util.logging.Logger
import java.time.LocalDateTime

class TokenRefresher(
    refreshUrl: String,
    private val apiKey: String,
    private val logger: Logger? = null
) {
    private val restClient = RestClient(refreshUrl, mapOf("x-api-key" to apiKey))

    fun refresh(refreshToken: String) : Token {
        val body = mutableMapOf<String, String>()
        body["grant_type"] = "refresh_token"
        body["client_id"] = apiKey
        body["refresh_token"] = refreshToken
        val bodyString = body.entries.joinToString("&") { (k, v) -> "$k=$v" }
        logger?.info("[OAUTH] Body string: $bodyString")
        val result = restClient.post("/token", emptyMap(), emptyMap(), bodyString, ContentType.Application.FormUrlEncoded)
        logger?.info("[OAUTH] Refreshed tokens: ${result.message}")
        val moshi: Moshi = Moshi.Builder().add(LocalDateTime::class.java, TtlAdapter()).addLast(KotlinJsonAdapterFactory()).build()
        val adapter: JsonAdapter<Token> = moshi.adapter(Token::class.java)
        return adapter.fromJson(result.message!!)!!
    }
}
