package com.example.a30daysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30daysapp.R

data class Days(
    @DrawableRes val imageResourceId: Int,
    @StringRes val stringResourceId: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val smalldescriptionId : Int
)

val days = listOf(
    Days(R.drawable.day_1, R.string.day_1_desc, R.string.day_1_title, R.string.day1brief),
    Days(R.drawable.day_2, R.string.day_2_desc, R.string.day_2_title, R.string.day2brief),
    Days(R.drawable.day_3, R.string.day_3_desc, R.string.day_3_title, R.string.day3brief),
    Days(R.drawable.day_4, R.string.day_4_desc, R.string.day_4_title, R.string.day4brief),
    Days(R.drawable.day_5, R.string.day_5_desc, R.string.day_5_title, R.string.day5brief),
    Days(R.drawable.day_6, R.string.day_6_desc, R.string.day_6_title, R.string.day6brief),
    Days(R.drawable.day_7, R.string.day_7_desc, R.string.day_7_title, R.string.day7brief),
    Days(R.drawable.day_8, R.string.day_8_desc, R.string.day_8_title, R.string.day8brief),
    Days(R.drawable.day_9, R.string.day_9_desc, R.string.day_9_title, R.string.day9brief),
    Days(R.drawable.day_10, R.string.day_10_desc, R.string.day_10_title, R.string.day10brief),
    Days(R.drawable.day_11, R.string.day_11_desc, R.string.day_11_title, R.string.day11brief),
    Days(R.drawable.day_12, R.string.day_12_desc, R.string.day_12_title, R.string.day12brief),
    Days(R.drawable.day_13, R.string.day_13_desc, R.string.day_13_title, R.string.day13brief),
    Days(R.drawable.day_14, R.string.day_14_desc, R.string.day_14_title, R.string.day14brief),
    Days(R.drawable.day_15, R.string.day_15_desc, R.string.day_15_title, R.string.day15brief),
    Days(R.drawable.day_16, R.string.day_16_desc, R.string.day_16_title, R.string.day16brief),
    Days(R.drawable.day_17, R.string.day_17_desc, R.string.day_17_title, R.string.day17brief),
    Days(R.drawable.day_18, R.string.day_18_desc, R.string.day_18_title, R.string.day18brief),
    Days(R.drawable.day_19, R.string.day_19_desc, R.string.day_19_title, R.string.day19brief),
    Days(R.drawable.day_20, R.string.day_20_desc, R.string.day_20_title, R.string.day20brief),
    Days(R.drawable.day_21, R.string.day_21_desc, R.string.day_21_title, R.string.day21brief),
    Days(R.drawable.day_22, R.string.day_22_desc, R.string.day_22_title, R.string.day22brief),
    Days(R.drawable.day_23, R.string.day_23_desc, R.string.day_23_title, R.string.day23brief),
    Days(R.drawable.day_24, R.string.day_24_desc, R.string.day_24_title, R.string.day24brief),
    Days(R.drawable.day_25, R.string.day_25_desc, R.string.day_25_title, R.string.day25brief),
    Days(R.drawable.day_26, R.string.day_26_desc, R.string.day_26_title, R.string.day26brief),
    Days(R.drawable.day_27, R.string.day_27_desc, R.string.day_27_title, R.string.day27brief),
    Days(R.drawable.day_28, R.string.day_28_desc, R.string.day_28_title, R.string.day28brief),
    Days(R.drawable.day_29, R.string.day_29_desc, R.string.day_29_title, R.string.day29brief),
    Days(R.drawable.day_30, R.string.day_30_desc, R.string.day_30_title, R.string.day30brief)
)
