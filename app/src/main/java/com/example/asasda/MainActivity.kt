package com.example.asasda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.asasda.ui.theme.AsasdaTheme
import com.google.rpc.Help

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AsasdaTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar()
                    }
                ) { innerPadding ->
                    AtividadesScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFFDFF5E1), // Cor de fundo verde claro
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Início") },
            label = { Text("Início") },
            selected = false,
            onClick = {  }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "Atividades") },
            label = { Text("Atividades") },
            selected = false,
            onClick = {  }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Ajuda") },
            label = { Text("Ajuda") },
            selected = false,
            onClick = {  }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            selected = false,
            onClick = {  }
        )
    }
}

@Composable
fun AtividadesScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Atividades",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        AtividadeCard(
            title = "Pintar a unha",
            description = "Preciso pintar a unha porque esse final de semana tenho um evento importante, e não posso esquecer de ir a manicure. Estou adicionando pois provavelmente vou esquecer de fazer isso.",
            backgroundColor = Color(0xFFE7EDFF),
            icon = R.drawable.unhas
        )

        Spacer(modifier = Modifier.height(16.dp))

        AtividadeCard(
            title = "Lavar o cabelo",
            description = "Marquei de ir no salão sexta-feira, mas caso eu não consiga ir, sem problemas.",
            backgroundColor = Color(0xFFD4F7E4),
            icon = R.drawable.cabelo
        )
    }
}

@Composable
fun AtividadeCard(title: String, description: String, backgroundColor: Color, icon: Int) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 8.dp),
                contentScale = ContentScale.Fit
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }


            IconButton(onClick = { /* Lógica para deletar */ }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    tint = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AtividadesPreview() {
    AsasdaTheme {
        Scaffold(bottomBar = { BottomNavigationBar() }) {
            AtividadesScreen(modifier = Modifier.padding(it))
        }
    }
}
