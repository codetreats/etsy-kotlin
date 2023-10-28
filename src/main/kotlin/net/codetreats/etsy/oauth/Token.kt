package net.codetreats.etsy.oauth

import com.squareup.moshi.*
import net.codetreats.etsy.util.unixTimestamp
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

data class Token(
    @Json(name = "refresh_token")
    val refreshToken: String,
    @Json(name = "access_token")
    val accessToken: String,
    @Json(name = "expires_in")
    val expires: LocalDateTime
)

class TtlAdapter : JsonAdapter<LocalDateTime>() {
    @FromJson
    override fun fromJson(reader: JsonReader): LocalDateTime? = if (reader.peek() != JsonReader.Token.NULL) {
        LocalDateTime.now().plusSeconds(reader.nextLong())
    } else {
        reader.nextNull()
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: LocalDateTime?) {
        writer.value(value?.unixTimestamp())
    }
}

