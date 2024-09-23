package com.example.lab06_pm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

import com.example.lab06_pm.ui.theme.Lab06PMTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab06PMTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") { CustomScaffold(navController) }
                    composable("profile") { PerfilUsuario(navController) }
                    composable("build") { BuildScreen(navController) }
                    composable("menu") { MenuScreen(navController) }
                    composable("favorite") { FavoriteScreen(navController) }
                    composable("delete") { DeleteScreen(navController) }
                }
            }
        }
    }
}

// Función Composable que crea un Scaffold personalizado
@Composable
fun CustomScaffold(navController: NavController) {
    var count by remember { mutableStateOf(0) }

    Scaffold(
        // Barra superior
        topBar = { CustomTopBar(navController) },

        // Barra inferior
        bottomBar = { CustomBottomBar(navController) },

        // Botón flotante
        floatingActionButton = { CustomFAB { count++ } },

        // Contenido principal
        content = { padding ->
            CustomContent(padding, count)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Lab 06 PEM") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun CustomBottomBar(navController: NavController) {
    BottomAppBar {
        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = {
                    println("Navegando a Build")
                    navController.navigate("build")
                },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ajustes_lab06),
                    contentDescription = "Build description"
                )
            }
            IconButton(
                onClick = {
                    println("Navegando a Menu")
                    navController.navigate("menu")
                },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.menu_lab06),
                    contentDescription = "Menu description"
                )
            }
            IconButton(
                onClick = {
                    println("Navegando a Favorite")
                    navController.navigate("favorite")
                },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.favorite_lab6),
                    contentDescription = "Favorite description"
                )
            }
            IconButton(
                onClick = {
                    println("Navegando a Delete")
                    navController.navigate("delete")
                },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.papelera_lab06),
                    contentDescription = "Delete description"
                )
            }
        }
    }
}

@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick
    ) {
        Text(
            fontSize = 24.sp, 
            text = "+"
        )
    }
}

@Composable
fun CustomContent(padding: PaddingValues, count: Int) {
    var sliderValue by remember { mutableStateOf(0f) }
    var switchChecked by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Custom Content",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        item {
            Text(
                text = "Has presionado el botón $count veces",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        item {
            Button(
                onClick = { /* Acción del botón */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Presionar Botón")
            }
        }

        item {
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text("xxxxxxxxxxx: ${sliderValue.toInt()}")
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("xxxxxxxxx")
                Switch(
                    checked = switchChecked,
                    onCheckedChange = { switchChecked = it }
                )
            }
        }

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "xxxxxxxxxxxx",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "xxxxxxxxxxxxxxxxxxx.",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SharedScaffold(
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = { CustomBottomBar(navController) },
        content = { paddingValues ->
            content(paddingValues)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Lab06PMTheme {
        val navController = rememberNavController()
        CustomScaffold(navController)
    }
}
