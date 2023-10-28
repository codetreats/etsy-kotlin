package net.codetreats.etsy.util

import java.time.LocalDateTime
import java.time.ZoneOffset

fun LocalDateTime.unixTimestamp() : Long = this.toEpochSecond(ZoneOffset.UTC)

fun LocalDateTime.unixTimestampStr() : String = "${unixTimestamp()}"