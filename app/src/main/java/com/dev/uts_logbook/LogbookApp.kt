package com.dev.uts_logbook

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LogbookApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "logbookList") {
        composable("logbookList") {
            LogbookListScreen(onLogbookClick = { logbook ->
                navController.navigate("logbookDetail/${logbook.id}")
            })
        }

        composable("logbookDetail/{logbookId}") { backStackEntry ->
            val logbookId = backStackEntry.arguments?.getString("logbookId")?.toIntOrNull()
            val viewModel: LogbookViewModel = viewModel()
            val logbook = viewModel.logbookList.find { it.id == logbookId }

            LogbookDetailScreen(logbook = logbook, onBack = {
                navController.popBackStack()
            })
        }
    }
}
