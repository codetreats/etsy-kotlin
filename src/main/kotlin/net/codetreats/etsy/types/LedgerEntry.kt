package net.codetreats.etsy.types

import com.squareup.moshi.Json
import java.time.LocalDateTime

data class LedgerEntry(
    @Json(name = "entry_id")
    val entryId: String,
    @Json(name = "ledger_id")
    val ledgerId: String,
    @Json(name = "sequence_number")
    val sequenceNumber: String,
    @Json(name = "amount")
    val amount: Int,
    @Json(name = "currency")
    val currency: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "balance")
    val balance: Int,
    @Json(name = "create_date")
    val createDate: LocalDateTime,
    @Json(name = "created_timestamp")
    val createdTimestamp: LocalDateTime,
    @Json(name = "ledger_type")
    val ledgerType: String,
    @Json(name = "reference_type")
    val referenceType: String,
    @Json(name = "payment_adjustments")
    val paymentAdjustments : List<PaymentAdjustment>
)