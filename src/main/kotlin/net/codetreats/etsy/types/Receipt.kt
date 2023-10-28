package net.codetreats.etsy.types

import com.squareup.moshi.Json
import java.time.LocalDateTime

data class Receipt(
    @Json(name = "receipt_id")
    val receiptId: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "is_paid")
    val isPaid: Boolean,
    @Json(name = "is_shipped")
    val isShipped: Boolean,
    @Json(name = "is_gift")
    val isGift: Boolean,
    @Json(name = "create_timestamp")
    val created: LocalDateTime,
    @Json(name = "update_timestamp")
    val updated: LocalDateTime,
    @Json(name = "transactions")
    val transactions: List<Transaction>
)