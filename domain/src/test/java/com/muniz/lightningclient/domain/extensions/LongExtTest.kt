package com.muniz.lightningclient.domain.extensions

import org.junit.Test
import kotlin.test.assertEquals

class LongExtTest {

    @Test
    fun `when convertSatToBTC is executed with a Long number the conversion should be right`() {
        val expectedBTCValue = 1.0
        val actualSatValue = 100_000_000L

        val result = actualSatValue.convertSatToBTC(default = 0.0)

        assertEquals(expectedBTCValue, result)
    }

    @Test
    fun `when convertSatToBTC with a invalid Long number the default value should be returned`() {
        val expectedBTCValue = 0.0
        val actualSatValue = -1L

        val result = actualSatValue.convertSatToBTC(default = 0.0)

        assertEquals(expectedBTCValue, result)
    }

}