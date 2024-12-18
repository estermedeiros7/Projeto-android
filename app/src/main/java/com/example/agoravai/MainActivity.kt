import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddActivityScreen() {
    val selectedIndex = remember { mutableStateOf(0) } // Controle da BottomNavigation

    // Scaffold organiza tela com barra de navegação e conteúdo principal
    Scaffold(
        bottomBar = { BottomNavigationBar(selectedIndex) } // Adiciona a barra na parte inferior
    ) { paddingValues ->
        // Conteúdo principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F9FA))
                .padding(paddingValues) // Adiciona espaço para não sobrepor a BottomNavigation
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Text(
                text = "Adicionar atividade",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Icon Row
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconBox("\uD83D\uDEE1") // Shield emoji
                IconBox("\uD83D\uDD14") // Bell emoji
                IconBox("⚠️")
                IconBox("\uD83D\uDED1") // Stop emoji
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Buttons for Activity Levels
            ActivityButton("Adicionar atividade com baixo nível de prioridade.", Color(0xFFDFF5E1))
            ActivityButton("Adicionar atividade com nível médio de prioridade.", Color(0xFFE7EAFB))
            ActivityButton("Adicionar atividade com nível alerta de prioridade.", Color(0xFFFCEAC5))
            ActivityButton("Adicionar atividade nível urgente de prioridade.", Color(0xFFFAD7D7))

            Spacer(modifier = Modifier.height(24.dp))

            // Footer Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Agende suas atividades de forma simples.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Ao criar uma atividade, você pode visualizá-la na página de atividades, ou na tela inicial.",
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(selectedIndex: MutableState<Int>) {
    NavigationBar(
        containerColor = Color(0xFFDFF5E1), // Cor de fundo verde claro
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Início") },
            label = { Text("Início") },
            selected = selectedIndex.value == 0,
            onClick = { selectedIndex.value = 0 }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "Atividades") },
            label = { Text("Atividades") },
            selected = selectedIndex.value == 1,
            onClick = { selectedIndex.value = 1 }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Ajuda") },
            label = { Text("Ajuda") },
            selected = selectedIndex.value == 2,
            onClick = { selectedIndex.value = 2 }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            selected = selectedIndex.value == 3,
            onClick = { selectedIndex.value = 3 }
        )
    }
}

@Composable
fun IconBox(icon: String) {
    Text(
        text = icon,
        fontSize = 24.sp,
        modifier = Modifier
            .size(48.dp)
            .background(Color(0xFFE9ECEF), shape = RoundedCornerShape(8.dp))
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ActivityButton(text: String, backgroundColor: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier.padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = text, fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddActivityScreenPreview() {
    AddActivityScreen()
}
