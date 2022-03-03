package com.kindred.model

import com.kindred.pojo.SubVendor
import com.kindred.pojo.TypeSettings
import com.kindred.pojo.Vendor

data class WishesV94mg(
    val backgroundImageUrl: String,
    val displayVendorName: String,
    val gameId: String,
    var gameName: String,
    val imageUrl: String,
    val launchLocale: String,
    val licenses: List<String>,
    val pathSegment: String,
    val playUrl: String,
    val subVendor: SubVendor,
    val tags: List<String>,
    val typeSettings: TypeSettings,
    val vendor: Vendor,
    val vendorId: String
)
