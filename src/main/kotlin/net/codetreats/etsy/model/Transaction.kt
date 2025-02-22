package net.codetreats.etsy.model

import com.squareup.moshi.Json
import java.time.LocalDateTime

data class Transaction(
    @Json(name = "transaction_id")
    val transactionId: String,
    @Json(name = "seller_user_id")
    val sellerUserId: String,
    @Json(name = "buyer_user_id")
    val buyerUserId: String,
    @Json(name = "receipt_id")
    val receiptId: String,
    @Json(name = "listing_id")
    val listingId: String,
    @Json(name = "title")
    val title: String?,
    @Json(name = "product_id")
    val productId: String,
    @Json(name = "quantity")
    val quantity: Int,
    @Json(name = "create_timestamp")
    val created: LocalDateTime,
    @Json(name = "price")
    val price: PaymentAmount,
    @Json(name = "shipping_cost")
    val shippingCost: PaymentAmount,
    @Json(name = "variations")
    val variations: List<TransactionVariation>
)

data class TransactionVariation(
    @Json(name = "formatted_name")
    val name: String,
    @Json(name = "formatted_value")
    val value: String
)