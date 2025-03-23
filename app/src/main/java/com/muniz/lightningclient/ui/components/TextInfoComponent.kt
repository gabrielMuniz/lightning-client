package com.muniz.lightningclient.ui.components

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.muniz.lightningclient.R
import com.muniz.lightningclient.ui.theme.LightningClientTheme

@Composable
fun TextInfoComponent(@StringRes label: Int, value: String) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("${stringResource(label)}: ")
            }
            append(value)
        },
        style = MaterialTheme.typography.bodyMedium,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
@Preview(showBackground = true)
fun TextInfoComponentPreview() {
    LightningClientTheme {
        TextInfoComponent(R.string.country_label, stringResource(R.string.country_label))
    }
}