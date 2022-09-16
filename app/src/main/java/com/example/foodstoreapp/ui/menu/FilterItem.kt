package com.example.foodstoreapp.ui.menu

import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import com.example.foodstoreapp.R
import com.google.android.material.chip.Chip

data class FilterItem(
    val id: Int,
    val text: String,
    @DrawableRes val icon: Int? = null,
    val iconSize: Float = 50.0f,
) {
}

fun FilterItem.toChip(context: Context): Chip {
    val chip = LayoutInflater
            .from(context)
            .inflate(R.layout.chip_choice, null, false) as Chip

    chip.setChipStrokeColorResource(R.color.orange_500)
    chip.chipStrokeWidth = 2f

    if (icon != null) {
        chip.chipIconSize = iconSize
        chip.setChipIconResource(icon)
        chip.chipStartPadding = 20f
    } else {
        chip.chipIcon = null
    }


    chip.text = text
    chip.setTextAppearance(R.style.Widget_FoodStoreApp_Chip)

    return chip
}