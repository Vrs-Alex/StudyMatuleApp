package vrsalex.matule.uikit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import vrsalex.matule.uikit.component.AppTextField
import vrsalex.matule.uikit.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme() {
                var text1 by remember { mutableStateOf("") }
                var text2 by remember { mutableStateOf("Иван") }
                var text3 by remember { mutableStateOf("") }
                var text4 by remember { mutableStateOf("") }
                var text5 by remember { mutableStateOf("") }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(AppTheme.spacing.spacing16)
                ) {
                    val spacing = AppTheme.spacing

                    // 1. Поле по умолчанию (Default)
                    AppTextField(
                        value = text1,
                        onValueChange = { text1 = it },
                        placeholder = "Введите имя",
                        modifier = Modifier.padding(bottom = spacing.spacing24)
                    )

                    // 2. Поле с введенным текстом (Filled)
                    AppTextField(
                        value = text2,
                        onValueChange = { text2 = it },
                        placeholder = "Введите имя",
                        // Без лейбла, просто введенный текст
                        modifier = Modifier.padding(bottom = spacing.spacing24)
                    )

                    // 3. Поле в фокусе (Focused)
                    // Для демонстрации фокуса нужно кликнуть на поле,
                    // но здесь я имитирую его, добавив Label над полем для соответствия изображению
                    // (хотя в реальном приложении это происходит автоматически при фокусе)
                    AppTextField(
                        value = text3,
                        onValueChange = { text3 = it },
                        placeholder = "Введите имя",
                        label = "Имя",
                        // В реальном приложении: .focusRequester(myFocusRequester).requestFocus()
                        modifier = Modifier.padding(bottom = spacing.spacing24)
                    )
                    // Примечание: В реальной жизни, чтобы показать это состояние, нужно
                    // программно установить фокус или нажать на поле.

                    // 4. Поле с ошибкой (Error)
                    AppTextField(
                        value = text4,
                        onValueChange = { text4 = it },
                        placeholder = "Введите имя",
                        label = "Имя",
                        errorMessage = "Введите ваше имя", // Отображаем текст ошибки
                    )

                    // 5. Поле по умолчанию (Default) - (Повтор первого)
                    AppTextField(
                        value = text5,
                        onValueChange = { text5 = it },
                        placeholder = "Введите имя",
                        label = "Имя",
                        modifier = Modifier.padding(bottom = spacing.spacing24)
                    )
                }
            }
        }
    }
}
