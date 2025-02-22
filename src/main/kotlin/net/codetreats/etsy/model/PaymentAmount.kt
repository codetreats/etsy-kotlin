package net.codetreats.etsy.model

import com.squareup.moshi.Json

data class PaymentAmount(
    val amount : Int,
    val divisor : Int,
    @Json(name = "currency_code")
    val currencyCode: String
) {
    val value: Double = (amount.toDouble() / divisor.toDouble()).round()
    private fun Double.round() = String.format("%.2f", this).toDouble()
}
