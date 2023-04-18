package net.turbovadim.bisquituitests

import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class TDDTests {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun pressNextBtn() {
        rule.setContent { MyApp() }

        //Post 1

        rule.onNode(
            hasText("Без теории, только практика\n" +
                    "Вы не платите за лекции и теоретический материал, ведь все это можно найти в интернете бесплатно")
        ).assertExists()

        rule.onNode(
            hasContentDescription("post1")
        ).assertExists()

        rule.onNodeWithText("Дальше").performClick()

        //Post 2

        rule.onNode(
            hasText("Без теории, только практика\n" +
                    "Вы не платите за лекции и теоретический материал, ведь все это можно найти в интернете бесплатно")
        ).assertExists()

        rule.onNode(
            hasContentDescription("post2")

        ).assertExists()

        rule.onNodeWithText("Дальше").assertExists()

        rule.onNodeWithText("Дальше").performClick()

        //Post 3

        rule.onNode(
            hasText("Обучение онлайн из любой точки мира\n" +
                    "Наше обучение изначально создавалось как дистанционное")
        ).assertExists()

        rule.onNode(
            hasContentDescription("post3")
        ).assertExists()

        rule.onNodeWithText("Начать").assertExists()

    }
}