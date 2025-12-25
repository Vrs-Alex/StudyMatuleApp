package vrsalex.matule.presentation.project.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vrsalex.matule.common.TimeUtils
import vrsalex.matule.uikit.component.button.AppButton
import vrsalex.matule.uikit.component.button.ButtonSize
import vrsalex.matule.uikit.component.button.ButtonType
import vrsalex.matule.uikit.component.card.PrimaryCard
import vrsalex.matule.uikit.component.header.SmallHeader
import vrsalex.matule.uikit.component.icon.SystemIcon
import vrsalex.matule.uikit.theme.AppTheme
import vrsalex.matule.uikit.theme.White

@Composable
fun ProjectScreen(
    viewmodel: ProjectViewModel = hiltViewModel()
) {

    val state by viewmodel.state.collectAsStateWithLifecycle()


    ProjectContent(state, viewmodel::onEvent)

}


@Composable
private fun ProjectContent(
    state: ProjectContract.State,
    onEvent: (event: ProjectContract.Event) -> Unit
) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .padding(top = 28.dp)
    ) {
        SmallHeader(
            title = "Проекты",
            endContent = {
                SystemIcon(
                    icon = SystemIcon.PLUS,
                    tint = AppTheme.colors.inputIcon,
                    onClick = { onEvent(ProjectContract.Event.OnAddProjectClicked) }
                )
            }
        )
        Spacer(Modifier.height(18.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(
                items = state.projects,
                key = { it.id }
            ){ project ->
                PrimaryCard(
                    title = project.name,
                    bottomContent = {
                        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
                            Text(
                                text = TimeUtils.getDaysAgoText(project.startDate)
                            )
                        }
                    },
                    actionContent = {
                        AppButton(
                            buttonSize = ButtonSize.SMALL,
                            buttonType = ButtonType.PRIMARY,
                            onClick = { onEvent(ProjectContract.Event.OnProjectClicked) },
                            text = "Открыть"
                        )
                    },
                    onActionClick = {

                    }
                )
            }

            if (state.projects.isEmpty() && !state.isLoading) {
                item {
                    Text(
                        text = "Проектов пока нет",
                        modifier = Modifier.fillParentMaxSize(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

}