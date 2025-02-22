package net.codetreats.etsy.model

import com.squareup.moshi.Json

data class PaymentAdjustment(
    @Json(name = "payment_adjustment_id")
    val paymentAdjustmentId: String,
    @Json(name = "payment_id")
    val paymentId: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "is_success")
    val isSuccess: Boolean,
    @Json(name = "user_id")
    val userId: String,
    @Json(name = "reason_code")
    val reasonCode: String,
)