package net.codetreats.etsy.model

data class EtsyListResponse<T>(val count: Int, val results: List<T>)