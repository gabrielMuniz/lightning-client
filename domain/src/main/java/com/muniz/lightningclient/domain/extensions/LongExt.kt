package com.muniz.lightningclient.domain.extensions

fun Long.convertSatToBTC(default: Double) = try {
    val btcValue = this / 100_000_000.0
    if (btcValue >= 0.0) btcValue else default
} catch (exception: IllegalArgumentException) {
    default
}