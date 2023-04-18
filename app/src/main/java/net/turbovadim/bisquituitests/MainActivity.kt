package net.turbovadim.bisquituitests

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.turbovadim.bisquituitests.ui.theme.jost

enum class Screen{
    FIRST,
    SECOND,
    THIRD
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val currentScreen = remember { mutableStateOf(Screen.FIRST) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        when (currentScreen.value) {
            Screen.FIRST -> {
                FirstScreen()
            }

            Screen.SECOND -> {
                SecondScreen()
            }
            Screen.THIRD -> {
                ThirdScreen()
            }
        }
        Column {
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(12.dp)
                        .height(12.dp)
                        .clip(CircleShape)
                        .background(
                            if (currentScreen.value == Screen.FIRST) Color(
                                0xFFFFC100
                            ) else Color.Transparent
                        )
                        .border(2.dp, Color(0xFFFFC100), CircleShape)
                )
                Box(
                    modifier = Modifier
                        .width(12.dp)
                        .height(12.dp)
                        .clip(CircleShape)
                        .background(
                            if (currentScreen.value == Screen.SECOND) Color(
                                0xFFFFC100
                            ) else Color.Transparent
                        )
                        .border(2.dp, Color(0xFFFFC100), CircleShape)
                )
                Box(
                    modifier = Modifier
                        .width(12.dp)
                        .height(12.dp)
                        .clip(CircleShape)
                        .background(
                            if (currentScreen.value == Screen.THIRD) Color(
                                0xFFFFC100
                            ) else Color.Transparent
                        )
                        .border(2.dp, Color(0xFFFFC100), CircleShape)
                )
            }
            Column(
                Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 16.dp)
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        when (currentScreen.value) {
                            Screen.FIRST -> currentScreen.value = Screen.SECOND
                            Screen.SECOND -> currentScreen.value = Screen.THIRD
                            Screen.THIRD -> TODO() //MOVE TO SIGNIN
                        }
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC100))
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = if (currentScreen.value != Screen.THIRD) "Дальше" else {"Начать"},
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = jost
                    )
                }
            }
        }

    }
}

@Composable
fun FirstScreen() {
    Image(
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth(),
        painter = painterResource(id = R.drawable.post1),
        contentDescription = "post1"
    )
    Text(
        modifier = Modifier.padding(top = 12.dp, start = 20.dp, end = 20.dp),
        text = "Без теории, только практика\n" +
                "Вы не платите за лекции и теоретический материал, ведь все это можно найти в интернете бесплатно",
        fontFamily = jost,
        fontSize = 21.sp,
        lineHeight = 24.sp
    )
}

@Composable
fun SecondScreen() {
    Image(
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth(),
        painter = painterResource(id = R.drawable.post2),
        contentDescription = "post2"
    )
    Text(
        modifier = Modifier.padding(top = 4.dp, start = 20.dp, end = 20.dp),
        text = "Без теории, только практика\n" +
                "Вы не платите за лекции и теоретический материал, ведь все это можно найти в интернете бесплатно",
        fontFamily = jost,
        fontSize = 21.sp,
        lineHeight = 24.sp
    )
}

@Composable
fun ThirdScreen() {
    Image(
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth(),
        painter = painterResource(id = R.drawable.post3),
        contentDescription = "post3"
    )
    Text(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
        text = "Обучение онлайн из любой точки мира\n" +
                "Наше обучение изначально создавалось как дистанционное",
        fontFamily = jost,
        fontSize = 21.sp,
        lineHeight = 24.sp
    )
}