package net.codetreats.etsy.util

import com.squareup.moshi.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.TimeZone

class LocalDateTimeAdapter : JsonAdapter<LocalDateTime>() {
    @FromJson
    override fun fromJson(reader: JsonReader): LocalDateTime? = if (reader.peek() != JsonReader.Token.NULL) {
        val timeZone = System.getenv("TZ") ?: "Europe/Berlin"
        LocalDateTime.ofInstant(Instant.ofEpochSecond(reader.nextLong()), TimeZone.getTimeZone(timeZone).toZoneId())
    } else {
        reader.nextNull()
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: LocalDateTime?) {
        writer.value(value?.unixTimestamp())
    }
}
