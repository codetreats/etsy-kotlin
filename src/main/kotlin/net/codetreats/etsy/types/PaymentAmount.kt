package net.codetreats.etsy.types

import com.squareup.moshi.Json

data class PaymentAmount(
    val amount : Int,
    val divisor : Int,
    @Json(name = "currency_code")
    val currencyCode: String
) {
    fun amount() = amount / divisor
}
