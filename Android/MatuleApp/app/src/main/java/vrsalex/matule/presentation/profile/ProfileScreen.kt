package vrsalex.matule.presentation.profile

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vrsalex.matule.R
import vrsalex.matule.uikit.component.control.Toggle
import vrsalex.matule.uikit.theme.AppTheme

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val state by profileViewModel.state.collectAsStateWithLifecycle()

    ProfileContent(
        state,
        profileViewModel::onEvent
    )
}


@Composable
private fun ProfileContent(
    state: ProfileContract.State,
    event: (event: ProfileContract.Event) -> Unit
) {
    val uriHandler = LocalUriHandler.current

    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = state.name,
                style = AppTheme.typography.title1Heavy
            )
            Text(
                text = state.phone,
                style = AppTheme.typography.headLineRegular,
                color = AppTheme.colors.caption
            )
        }
        Spacer(Modifier.height(24.dp))
        Column() {
            Row(Modifier.fillMaxWidth().height(64.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(R.drawable.order),
                    contentDescription = null
                )
                Spacer(Modifier.width(20.dp))
                Text(
                    text = "Мои заказы",
                    style = AppTheme.typography.title3Semibold
                )
            }
            Row(Modifier.fillMaxWidth().height(64.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(R.drawable.setting),
                    contentDescription = null
                )
                Spacer(Modifier.width(20.dp))
                Text(
                    text = "Уведомления",
                    style = AppTheme.typography.title3Semibold
                )
                Spacer(Modifier.weight(1f))
                Toggle(
                    checked = state.showNotification,
                    onCheckedChange = { event(ProfileContract.Event.OnShowNotification(it)) }
                )
            }
            Spacer(Modifier.weight(1f))
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Column(Modifier.height(108.dp).width(219.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Политика конфиденциальности",
                        style = AppTheme.typography.textMedium,
                        color = AppTheme.colors.caption,
                        modifier = Modifier.clickable{
                            uriHandler.openUri("https://google.com")
                        }
                    )
                    Text(
                        text = "Пользовательское соглашение",
                        style = AppTheme.typography.textMedium,
                        color = AppTheme.colors.caption,
                        modifier = Modifier.clickable{
                            uriHandler.openUri("https://google.com")
                        }
                    )
                    Text(
                        text = "Выход",
                        style = AppTheme.typography.textMedium,
                        color = AppTheme.colors.error,
                        modifier = Modifier.clickable{
                            event(ProfileContract.Event.OnLogout)
                        }
                    )
                }
            }
            Spacer(Modifier.weight(1f))
        }
    }

}