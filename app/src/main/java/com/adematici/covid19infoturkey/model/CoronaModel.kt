package com.adematici.covid19infoturkey.model

data class CoronaModel(
    val tarih: String,
    val gunluk_test: String,
    val gunluk_vaka: String,
    val gunluk_vefat: String,
    val gunluk_iyilesen: String,
    val toplam_test: String,
    val toplam_vaka: String,
    val toplam_vefat: String,
    val toplam_iyilesen: String,
    val toplam_yogun_bakim: String,
    val toplam_entube: String,
    val hastalarda_zaturre_oran: String,
    val agir_hasta_sayisi: String,
    val yatak_doluluk_orani: String,
    val eriskin_yogun_bakim_doluluk_orani: String,
    val ventilator_doluluk_orani: String,
    val ortalama_filyasyon_suresi: String,
    val ortalama_temasli_tespit_suresi: String,
    val filyasyon_orani: String
)