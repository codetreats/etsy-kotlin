package net.codetreats.etsy.types

import com.squareup.moshi.*
import java.lang.IllegalArgumentException
import java.time.LocalDateTime

data class Listing(
    @Json(name = "listing_id")
    val listing_id: String,
    @Json(name = "user_id")
    val user_id: String,
    @Json(name = "shop_id")
    val shop_id: String,
    @Json(name = "title")
    val title: String,
//    @Json(name = "description")
//    val description: String,
    @Json(name = "state")
    val state: ListingState,
    @Json(name = "created_timestamp")
    val created: LocalDateTime,
    @Json(name = "updated_timestamp")
    val updated: LocalDateTime,
    @Json(name = "quantity")
    val quantity: Int,
    @Json(name = "price")
    val price: PaymentAmount,
    @Json(name = "url")
    val url: String,
    @Json(name = "images")
    val images: List<ListingImage>,
    @Json(name = "videos")
    val videos: List<ListingVideo>,
)

data class ListingImage(
    @Json(name = "listing_id")
    val listingId: String,
    @Json(name = "listing_image_id")
    val imageId: String,
    @Json(name = "url_fullxfull")
    val url: String,
    @Json(name = "full_height")
    val height: String,
    @Json(name = "full_width")
    val width: String,
    @Json(name = "created_timestamp")
    val created: LocalDateTime
)

data class ListingVideo(
    @Json(name = "video_id")
    val videoId: String,
    @Json(name = "video_url")
    val videoUrl: String,
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String,
    @Json(name = "height")
    val height: String,
    @Json(name = "width")
    val width: String,
    @Json(name = "video_state")
    val videoState: String
)

enum class ListingState(val value: String) {
    ACTIVE("active"),
    INACTIVE("inactive"),
    SOLD_OUT("sold_out"),
    DRAFT("draft"),
    EXPIRED("expired");

    companion object {
        fun from(value: String) : ListingState =
            entries.firstOrNull { it.value == value} ?: throw IllegalArgumentException("Invalid ListingState '$value")
    }
}

enum class ListingInclude(val value: String) {
    SHIPPING("Shipping"),
    IMAGES("Images"),
    SHOP("Shop"),
    USER("User"),
    TRANSLATIONS("Translations"),
    INVENTORY("Inventory"),
    VIDEOS("Videos");
}

class ListingStateAdapter: JsonAdapter<ListingState>() {
    @FromJson
    override fun fromJson(reader: JsonReader): ListingState? =  if (reader.peek() != JsonReader.Token.NULL) {
        ListingState.from(reader.nextString())
    } else {
        reader.nextNull()
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: ListingState?) {
        writer.value(value?.value)
    }
}

