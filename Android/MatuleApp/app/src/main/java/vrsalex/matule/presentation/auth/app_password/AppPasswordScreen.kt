package vrsalex.matule.presentation.auth.app_password

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vrsalex.matule.R
import vrsalex.matule.uikit.component.header.SmallHeader
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun AppPasswordScreen(
    viewModel: AppPasswordViewModel = hiltViewModel(),
    onNext: () -> Unit = {},
    onSkip: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when(effect) {
                AppPasswordContract.Effect.OnNext -> onNext()
                AppPasswordContract.Effect.OnSkipped -> onSkip()
            }
        }
    }
    AppPasswordContent(state, viewModel::onEvent)
}


@Composable
private fun AppPasswordContent(
    state: AppPasswordContract.State,
    onEvent: (AppPasswordContract.Event) -> Unit
) {
    Column(
        Modifier.padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            Text(
                text = "Пропустить",
                style = AppTheme.typography.textRegular,
                color = AppTheme.colors.accent,
                modifier = Modifier.clickable(
                    interactionSource = null,
                    indication = ripple(),
                    onClick = { onEvent(AppPasswordContract.Event.OnSkipped) }
                ),
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Создайте пароль",
                style = AppTheme.typography.title1Heavy
            )
            Text(
                text = "Для защиты ваших персональных данных",
                style = AppTheme.typography.textRegular,
                color = AppTheme.colors.caption
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            repeat(state.pinCodeLength){ index ->
                val isFilled = state.pinCode.getOrNull(index) != null
                val color by animateColorAsState(if (isFilled) AppTheme.colors.accent else Color.Transparent)
                Box(
                    modifier = Modifier.size(16.dp)
                        .clip(CircleShape)
                        .border(1.dp, AppTheme.colors.accent, CircleShape)
                        .background(color)
                )
            }
        }
        NumberKeyboard(
            onDeleteClick = { onEvent(AppPasswordContract.Event.OnDeleteClicked) },
            onNumberClick = { onEvent(AppPasswordContract.Event.NumberClicked(it)) }
        )
    }
}

@Composable
private fun NumberKeyboard(
    onNumberClick: (String) -> Unit,
    onDeleteClick: () -> Unit
) {
    val keys = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf("", "0", "delete")
    )

    Column(
        modifier = Modifier.wrapContentSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        keys.forEach { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                row.forEach { key ->
                    KeyItem(key, onNumberClick, onDeleteClick)
                }
            }
        }
    }
}

@Composable
private fun KeyItem(
    key: String,
    onNumberClick: (String) -> Unit,
    onDeleteClick: () -> Unit
) {
    Box(modifier = Modifier.size(80.dp), contentAlignment = Alignment.Center) {
        when (key) {
            "" -> {  }
            "delete" -> IconButton(onClick = onDeleteClick) {
                Icon(painterResource(R.drawable.delete_icon), null, tint = Color.Unspecified)
            }
            else -> Surface(
                onClick = { onNumberClick(key) },
                shape = CircleShape,
                color = AppTheme.colors.inputBg,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = key, style = AppTheme.typography.title1Semibold)
                }
            }
        }
    }
}