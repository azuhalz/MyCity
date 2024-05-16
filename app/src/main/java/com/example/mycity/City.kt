package com.example.mycity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val name: String?,
    val tahun: String?,
    val description: String?,
    val photo: Int
) : Parcelable
