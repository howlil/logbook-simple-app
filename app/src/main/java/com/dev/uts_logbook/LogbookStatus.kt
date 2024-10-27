package com.dev.uts_logbook

enum class LogbookStatus(val status: String) {
    VERIFIED("Terverifikasi"),
    UNVERIFIED("Tidak Terverifikasi"),
    PENDING("Menunggu Verifikasi")
}
