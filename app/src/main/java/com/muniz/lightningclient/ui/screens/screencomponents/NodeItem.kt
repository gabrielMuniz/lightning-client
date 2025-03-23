package com.muniz.lightningclient.ui.screens.screencomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.muniz.lightningclient.R
import com.muniz.lightningclient.domain.model.Node
import com.muniz.lightningclient.extensions.formatDate
import com.muniz.lightningclient.ui.components.TextInfoComponent
import kotlinx.coroutines.launch

@Composable
fun NodeItem(node: Node, snackBarHostState: SnackbarHostState) {
    val clipboardManager = LocalClipboardManager.current
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                clipboardManager.setText(AnnotatedString(node.publicKey))

                coroutineScope.launch {
                    snackBarHostState.showSnackbar(
                        message = "${
                            context.getString(R.string.public_key_copied)
                        }: ${node.publicKey}",
                        duration = SnackbarDuration.Short
                    )
                }
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        with(node) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                TextInfoComponent(label = R.string.public_key_label, value = publicKey)
                TextInfoComponent(label = R.string.alias_label, value = alias)
                TextInfoComponent(label = R.string.channels_label, value = channels.toString())
                TextInfoComponent(label = R.string.capacity_label, value = capacity.toString())
                TextInfoComponent(label = R.string.first_seen_label, value = firstSeen.formatDate())
                TextInfoComponent(label = R.string.updated_at_label, value = updatedAt.formatDate())
                TextInfoComponent(
                    label = R.string.city_label,
                    value = city?.let { if (it.ptBR.isNotEmpty()) it.ptBR else it.en }
                        ?: stringResource(
                            R.string.unavailable_city
                        ))
                TextInfoComponent(
                    label = R.string.country_label,
                    value = city?.let { if (it.ptBR.isNotEmpty()) it.ptBR else it.en }
                        ?: stringResource(
                            R.string.unavailable_country
                        ))
            }
        }
    }
}