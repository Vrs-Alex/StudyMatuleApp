package vrsalex.matule.uikit.component.tabbar

import vrsalex.matule.uikit.R

data class BottomTab<T>(
    val payload: T,
    val title: String,
    val iconId: Int
)