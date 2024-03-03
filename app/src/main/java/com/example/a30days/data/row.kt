package com.example.a30days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30days.R

data class row(
    @StringRes val matchDate : Int,
    @StringRes val matchtime : Int,
    @StringRes val teamNames : Int
)

var listOfRowImages = listOf<row>(
    row(R.string.row1matchDate,R.string.time,R.string.row1match),
    row(R.string.row2matchDate,R.string.time,R.string.row2match),
    row(R.string.row3matchDate,R.string.time,R.string.row3match),
    row(R.string.row4matchDate,R.string.time,R.string.row4match),
    row(R.string.row5matchDate,R.string.time,R.string.row5match)
)