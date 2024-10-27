package com.dev.uts_logbook

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // Untuk padding, fillMaxSize, dll.
import androidx.compose.foundation.lazy.LazyColumn // Untuk LazyColumn
import androidx.compose.foundation.lazy.items // Untuk items dalam LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable // Untuk @Composable
import androidx.compose.ui.unit.dp // Untuk satuan ukuran
import androidx.compose.ui.Modifier // Untuk Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.Text

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign

@Composable
fun LogbookListScreen(
    logbookViewModel: LogbookViewModel = viewModel(),
    onLogbookClick: (DataLogBook) -> Unit
) {
    val logbooks = logbookViewModel.logbookList

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopBar()

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            items(logbooks) { logbook ->
                LogbookItem(logbook = logbook, onClick = { onLogbookClick(logbook) })
            }
        }
    }
}


@Composable
fun CustomTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .shadow(1.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Logbook List",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LogbookItem(logbook: DataLogBook, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .background(Color.White)
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(
            text = logbook.title,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = logbook.date, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = if (logbook.description.length > 80) {
                logbook.description.take(80) + "..."
            } else {
                logbook.description
            },
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(12.dp))


        val status = when (logbook.status) {
            "Terverifikasi" -> LogbookStatus.VERIFIED
            "Tidak Terverifikasi" -> LogbookStatus.UNVERIFIED
            "Menunggu Verifikasi" -> LogbookStatus.PENDING
            else -> LogbookStatus.PENDING
        }
        StatusBadge(status = status)
    }
}
