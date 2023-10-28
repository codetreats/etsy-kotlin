package net.codetreats.etsy.types

import com.squareup.moshi.Json

data class Transaction(
    @Json(name = "transaction_id")
    val transactionId: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "seller_user_id")
    val sellerUserId: String,
    @Json(name = "buyer_user_id")
    val buyerUserId: String,
    @Json(name = "receipt_id")
    val receiptId: String,
    @Json(name = "listing_id")
    val listingId: String,
    @Json(name = "quantity")
    val quantity: Int,
    @Json(name = "price")
    val paymentAmount: PaymentAmount
)