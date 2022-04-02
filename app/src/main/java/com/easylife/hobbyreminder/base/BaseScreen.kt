package com.easylife.hobbyreminder.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavController
import org.koin.core.component.KoinComponent

abstract class BaseScreen<VM: BaseViewModel>: KoinComponent {

    //protected val analyticsManager: AnalyticsManager by inject()
    protected lateinit var viewModel: VM
    protected lateinit var navController: NavController
    protected lateinit var focusManager: FocusManager

    @Composable
    fun Create(viewModel: VM, navController: NavController) {
        this.viewModel = viewModel
        this.navController = navController
        this.focusManager = LocalFocusManager.current

        val error by viewModel.error.observeAsState()
        if (error != null) {
            /* TODO: Handle on error */
        }

        val showProgress by viewModel.showProgress.observeAsState()
        if (showProgress == true) {
            /* TODO: Show progress indicator over screen */
        }

        Content()
    }

    @Composable
    abstract fun Content()
}