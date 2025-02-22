package net.codetreats.etsy.model

import com.squareup.moshi.Json
import java.time.LocalDateTime

data class Receipt(
    /**
     * the visible order number
     */
    @Json(name = "receipt_id")
    val receiptId: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "formatted_address")
    val address: String,
    @Json(name = "first_line")
    val firstLine: String,
    @Json(name = "second_line")
    val secondLine: String?,
    @Json(name = "country_iso")
    val country: String,
    @Json(name = "city")
    val city: String,
    @Json(name = "zip")
    val zip: String,
    @Json(name = "buyer_email")
    val buyerEmail: String?,
    @Json(name = "payment_email")
    val paymentEmail: String?,
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
    @Json(name = "message_from_seller")
    val messageFromSeller: String?,
    @Json(name = "message_from_buyer")
    val messageFromBuyer: String?,
    @Json(name = "gift_message")
    val giftMessage: String?,
    @Json(name = "grandtotal")
    val grandTotal: PaymentAmount,
    @Json(name = "subtotal")
    val subTotal: PaymentAmount,
    @Json(name = "total_price")
    val totalPrice: PaymentAmount,
    @Json(name = "total_shipping_cost")
    val totalShippingCost: PaymentAmount,
    @Json(name = "total_tax_cost")
    val totalTaxCost: PaymentAmount,
    @Json(name = "total_vat_cost")
    val totalVatCost: PaymentAmount,
    @Json(name = "discount_amt")
    val discountAmount: PaymentAmount,
    @Json(name = "gift_wrap_price")
    val giftWrapPrice: PaymentAmount,
    @Json(name = "transactions")
    val transactions: List<Transaction>
)