package com.dev.uts_logbook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun StatusBadge(status: LogbookStatus) {
    val backgroundColor = when (status) {
        LogbookStatus.VERIFIED -> Color(0xFFB2DFDB) // Warna hijau terang untuk Terverifikasi
        LogbookStatus.UNVERIFIED -> Color(0xFFFFCDD2) // Warna merah terang untuk Tidak Terverifikasi
        LogbookStatus.PENDING -> Color(0xFFFFF9C4) // Warna kuning terang untuk Menunggu Verifikasi
    }

    val textColor = when (status) {
        LogbookStatus.VERIFIED -> Color(0xFF388E3C) // Hijau gelap
        LogbookStatus.UNVERIFIED -> Color(0xFFD32F2F) // Merah gelap
        LogbookStatus.PENDING -> Color(0xFFF57C00) // Oranye gelap
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(backgroundColor)
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = status.status,
            color = textColor,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}
