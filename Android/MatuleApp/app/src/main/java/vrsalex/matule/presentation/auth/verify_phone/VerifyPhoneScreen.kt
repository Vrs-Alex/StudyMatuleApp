package vrsalex.matule.presentation.auth.verify_phone

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun VerifyPhoneScreen(
    viewModel: VerifyPhoneViewModel = hiltViewModel(),
    onNext: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when(effect){
                VerifyPhoneContract.Effect.OnNext -> onNext()
            }
        }
    }

    VerifyPhoneContent(state, viewModel::onEvent)
}


@Composable
private fun VerifyPhoneContent(
    state: VerifyPhoneContract.State,
    onEvent: (VerifyPhoneContract.Event) -> Unit
) {

    Column(

    ) {

    }

}