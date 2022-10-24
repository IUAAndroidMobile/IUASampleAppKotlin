package com.nicolasfanin.iuasampleappkotlin.recyclerView

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val title: String,
    val description: String,
    val imageURL: String,
    val price: Double = 0.0
): Parcelable
