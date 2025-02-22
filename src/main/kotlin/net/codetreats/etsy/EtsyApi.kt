package net.codetreats.etsy

import net.codetreats.etsy.model.*
import net.codetreats.etsy.util.unixTimestampStr
import java.time.LocalDateTime

class EtsyApi(private val etsyClient: EtsyClient) {
    /**
     * returns the orders of the shop
     */
    fun receipts(
        minCreated: LocalDateTime? = null,
        maxCreated: LocalDateTime? = null,
        minLastModified: LocalDateTime? = null,
        maxLastModified: LocalDateTime? = null,
        limit: Int = 25,
        offset: Int = 0,
        sortOn: SortOn = SortOn.CREATED,
        sortOrder: SortOrder = SortOrder.DESCENDING,
        wasPaid: Boolean? = null,
        wasShipped: Boolean? = null,
        wasDelivered: Boolean? = null,
        wasCancelled: Boolean? = null,
        language: String? = null
    ): EtsyListResponse<Receipt> {
        val params = mutableMapOf<String, String?>()
        params["min_created"] = minCreated?.unixTimestampStr()
        params["max_created"] = maxCreated?.unixTimestampStr()
        params["min_last_modified"] = minLastModified?.unixTimestampStr()
        params["max_last_modified"] = maxLastModified?.unixTimestampStr()
        params["limit"] = limit.toString()
        params["offset"] = offset.toString()
        params["sort_on"] = sortOn.value
        params["sort_order"] = sortOrder.value
        params["was_paid"] = wasPaid?.toString()
        params["was_shipped"] = wasShipped?.toString()
        params["was_delivered"] = wasDelivered?.toString()
        params["was_canceled"] = wasCancelled?.toString()
        params["language"] = language
        return etsyClient.get<Receipt>("/shops/:shopId/receipts", params)
    }

    fun ledgerEntries(
        minCreated: LocalDateTime,
        maxCreated: LocalDateTime,
        limit: Int = 25,
        offset: Int = 0
    ): EtsyListResponse<LedgerEntry> {
        val params = mutableMapOf<String, String?>()
        params["min_created"] = minCreated.unixTimestampStr()
        params["max_created"] = maxCreated.unixTimestampStr()
        params["limit"] = limit.toString()
        params["offset"] = offset.toString()
        return etsyClient.get<LedgerEntry>("/shops/:shopId/payment-account/ledger-entries", params)

    }

    fun payments(ledgerEntry: LedgerEntry) = payments(ledgerEntry.entryId)

    fun payments(entryId: String): EtsyListResponse<Payment> {
        val params = mutableMapOf<String, String?>()
        params["ledger_entry_ids"] = entryId
        return etsyClient.get<Payment>("/shops/:shopId/payment-account/ledger-entries/payments", params)
    }

    /**
     * returns the items of the shop
     */
    fun listings(
        state: ListingState = ListingState.ACTIVE,
        limit: Int = 25,
        offset: Int = 0,
        sortOn: SortOn = SortOn.CREATED,
        sortOrder: SortOrder = SortOrder.DESCENDING,
        includes: List<ListingInclude> = listOf(ListingInclude.IMAGES, ListingInclude.VIDEOS),
        language: String? = null
    ): EtsyListResponse<Listing> {
        val params = mutableMapOf<String, String?>()
        params["limit"] = limit.toString()
        params["offset"] = offset.toString()
        params["sort_on"] = sortOn.value
        params["sort_order"] = sortOrder.value
        params["state"] = state.value
        params["includes"] = includes.joinToString(",") { it.value }
        params["language"] = language
        return etsyClient.get<Listing>("/shops/:shopId/listings", params)
    }

}