package net.codetreats.etsy.types

import com.squareup.moshi.Json
import java.time.LocalDateTime

class Payment(
    @Json(name = "payment_id")
    val paymentId: String,
    @Json(name = "buyer_user_id")
    val buyerUserId: String,
    @Json(name = "shop_id")
    val shopId: String,
    @Json(name = "receipt_id")
    val receiptId: String,
    @Json(name = "amount_gross")
    val amountGross: PaymentAmount,
    @Json(name = "amount_fees")
    val amountFees: PaymentAmount,
    @Json(name = "amount_net")
    val amountNet: PaymentAmount,
    @Json(name = "posted_gross")
    val postedGross: PaymentAmount,
    @Json(name = "posted_fees")
    val postedFees: PaymentAmount,
    @Json(name = "posted_net")
    val postedNet: PaymentAmount,
    @Json(name = "adjusted_gross")
    val adjustedGross: PaymentAmount?,
    @Json(name = "adjusted_fees")
    val adjustedFees: PaymentAmount?,
    @Json(name = "adjusted_net")
    val adjustedNet: PaymentAmount?,
    @Json(name = "currency")
    val currency: String,
    @Json(name = "shipping_user_id")
    val shippingUserId: String,
    @Json(name = "shipping_address_id")
    val shippingAddressId: String,
    @Json(name = "billing_address_id")
    val billingAddressId: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "created_timestamp")
    val created: LocalDateTime,
    @Json(name = "updated_timestamp")
    val updated: LocalDateTime,
    @Json(name = "shipped_timestamp")
    val shipped: LocalDateTime?,
    @Json(name = "payment_adjustments")
    val paymentAdjustments: List<PaymentAdjustment>

)