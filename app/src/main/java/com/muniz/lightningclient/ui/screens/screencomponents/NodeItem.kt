package com.muniz.lightningclient.ui.screens.screencomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.muniz.lightningclient.R
import com.muniz.lightningclient.domain.model.Node
import com.muniz.lightningclient.extensions.formatDate

@Composable
fun NodeItem(node: Node) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        with(node) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "${stringResource(id = R.string.public_key_label)}: $publicKey",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${stringResource(id = R.string.alias_label)}: $alias",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${stringResource(id = R.string.channels_label)}: $channels",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "${stringResource(id = R.string.capacity_label)}: $capacity sats",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "${stringResource(id = R.string.first_seen_label)}: ${
                        firstSeen.formatDate()
                    }",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "${stringResource(id = R.string.updated_at_label)}: ${
                        updatedAt.formatDate()
                    }",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "${stringResource(id = R.string.city_label)}: ${
                        city ?: stringResource(R.string.unavailable_city)
                    }",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "${
                        stringResource(
                            id = R.string.country_label
                        )
                    }: ${
                        country?.let { if (it.ptBR.isNotEmpty()) it.ptBR else it.en } ?: stringResource(
                            R.string.unavailable_country
                        )
                    }",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}