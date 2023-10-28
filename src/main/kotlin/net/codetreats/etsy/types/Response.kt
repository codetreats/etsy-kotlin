package net.codetreats.etsy.types

data class EtsyListResponse<T>(val count: Int, val results: List<T>)