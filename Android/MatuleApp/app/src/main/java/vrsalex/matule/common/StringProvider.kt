package vrsalex.matule.common

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StringProvider @Inject constructor(
    @param:ApplicationContext private val context: Context
) {
    fun getString(@StringRes stringRes: Int): String {
        return context.getString(stringRes)
    }

    fun getString(@StringRes stringRes: Int, vararg formatArgs: Any): String {
        return context.getString(stringRes, *formatArgs)
    }
}