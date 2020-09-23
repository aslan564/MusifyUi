package com.aslanovaslan.inlinechats.model

import android.graphics.drawable.Drawable
import com.aslanovaslan.inlinechats.R

data class PlayerModel(
    val instrumentName:String="Guitar",
    val instrumentImage:Int= R.drawable.ic_guitar,
    val instrumentBackgroundImage:Int= R.drawable.ic_guitar_background
)