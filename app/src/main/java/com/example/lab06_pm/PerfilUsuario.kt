package com.example.lab06_pm

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PerfilUsuario(navController: NavController) {
    SharedScaffold(navController) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("User Profile", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Name: Hoshi ")
            Text("Email: Hosh@gmail.com")
            Text("Phone: 952879546")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Edit profile action */ }) {
                Text("Edit Profile")
            }
        }
    }
}