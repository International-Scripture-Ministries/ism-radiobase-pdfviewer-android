package com.tmt.pdf.viewer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeaderData(val headers: Map<String, String> = emptyMap()) : Parcelable
