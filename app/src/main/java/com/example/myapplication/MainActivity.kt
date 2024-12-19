package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = { BottomNavigationBar() } // Garante que o NavigationBar está no Scaffold
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Header()
            Spacer(modifier = Modifier.height(16.dp))
            ActivitiesSection()
        }
    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .background(Color(0xFFD9EFFF), RoundedCornerShape(16.dp))
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "Um dia bom\né um dia\norganizado",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Icon(
                imageVector = Icons.Filled.WbSunny,
                contentDescription = "Sol",
                tint = Color(0xFFF9C74F),
                modifier = Modifier.size(64.dp)
            )
        }
    }
}

@Composable
fun ActivitiesSection() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Atividades do dia",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Button(
            onClick = { /* Ação */ },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB2E4C6))
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Adicionar")
            Text(text = "Adicionar atividade", color = Color.Black)
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        ActivityCard("Finalizar protótipo", Color(0xFFFFDDE0), Icons.Filled.Warning)
        ActivityCard("Ir ao mercado comprar leite e ovo", Color(0xFFFFDDE0), Icons.Filled.Warning)
        ActivityCard("Pintar a unha", Color(0xFFE0E0FF), Icons.Filled.Notifications)
        ActivityCard("Lavar o cabelo", Color(0xFFDFFFD8), Icons.Filled.CheckCircle)
    }

    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "Ver detalhes",
        color = Color.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(top = 8.dp)
    )
}

@Composable
fun ActivityCard(title: String, color: Color, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFFEFF3F6)
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Início") },
            label = { Text("Início") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Filled.List, contentDescription = "Atividades") },
            label = { Text("Atividades") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Filled.Help, contentDescription = "Ajuda") },
            label = { Text("Ajuda") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MyApplicationTheme { MainScreen() }
}
