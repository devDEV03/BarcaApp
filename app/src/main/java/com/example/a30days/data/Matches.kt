package com.example.a30days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30days.R

data class Matches(
    @StringRes val matchId : Int,
    @StringRes val matchName : Int,
    @DrawableRes val matchPic : Int,
    @StringRes val matchdetails : Int
)

val listOfMatches = listOf<Matches>(
    Matches(R.string.match1,R.string.match1activity,R.drawable.match1,R.string.matchdetails1),
    Matches(R.string.match2,R.string.match2activity,R.drawable.match2,R.string.matchdetails2),
    Matches(R.string.match3,R.string.match3activity,R.drawable.match3,R.string.matchdetails3),
    Matches(R.string.match4,R.string.match4activity,R.drawable.match4,R.string.matchdetails4),
    Matches(R.string.match5,R.string.match5activity,R.drawable.match5,R.string.matchdetails5),
    Matches(R.string.match6,R.string.match6activity,R.drawable.match6,R.string.matchdetails6),
    Matches(R.string.match7,R.string.match7activity,R.drawable.match7,R.string.matchdetails7),
    Matches(R.string.match8,R.string.match8activity,R.drawable.match8,R.string.matchdetails8),
    Matches(R.string.match9,R.string.match9activity,R.drawable.match9,R.string.matchdetails9),
    Matches(R.string.match10,R.string.match10activity,R.drawable.match10,R.string.matchdetails10),

    Matches(R.string.match11,R.string.match11activity,R.drawable.match11,R.string.matchdetails11),
    Matches(R.string.match12,R.string.match12activity,R.drawable.match12,R.string.matchdetails12),
    Matches(R.string.match13,R.string.match13activity,R.drawable.match13,R.string.matchdetails13),
    Matches(R.string.match14,R.string.match14activity,R.drawable.match14,R.string.matchdetails14),
    Matches(R.string.match15,R.string.match15activity,R.drawable.match15,R.string.matchdetails15),

    Matches(R.string.match16,R.string.match16activity,R.drawable.match16,R.string.matchdetails16),
    Matches(R.string.match17,R.string.match17activity,R.drawable.match17,R.string.matchdetails17),
    Matches(R.string.match18,R.string.match18activity,R.drawable.match18,R.string.matchdetails18),
    Matches(R.string.match19,R.string.match19activity,R.drawable.match19,R.string.matchdetails19),
    Matches(R.string.match20,R.string.match20activity,R.drawable.match20,R.string.matchdetails20),


    Matches(R.string.match21,R.string.match21activity,R.drawable.match21,R.string.matchdetails21),
    Matches(R.string.match22,R.string.match22activity,R.drawable.match22,R.string.matchdetails22),
    Matches(R.string.match23,R.string.match23activity,R.drawable.match23,R.string.matchdetails23),
    Matches(R.string.match24,R.string.match24activity,R.drawable.match24,R.string.matchdetails24),
    Matches(R.string.match25,R.string.match25activity,R.drawable.match25,R.string.matchdetails25),


    Matches(R.string.match26,R.string.match26activity,R.drawable.match26,R.string.matchdetails26),
    Matches(R.string.match27,R.string.match27activity,R.drawable.match27,R.string.matchdetails27),
    Matches(R.string.match28,R.string.match28activity,R.drawable.match28,R.string.matchdetails28),
    Matches(R.string.match29,R.string.match29activity,R.drawable.match29,R.string.matchdetails29),
    Matches(R.string.match30,R.string.match30activity,R.drawable.match30,R.string.matchdetails30),



)
