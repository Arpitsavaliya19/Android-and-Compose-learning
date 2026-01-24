package com.example.lunchtray

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.lunchtray.MainActivity
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Test
    fun navigation_test() {
        // The test rule automatically launches MainActivity, so we don't need to call setContent.

        // 1. Start on the Start Order screen and click the "Start Order" button
        composeTestRule.onNodeWithText("Start Order").performClick()

        // 2. Verify that we are on the Entree Menu screen, and select an entree
        composeTestRule.onNodeWithText("Cauliflower").performClick()

        // 3. Click the "Next" button
        composeTestRule.onNodeWithText("Next").performClick()

        // 4. Verify that we are on the Side Dish Menu screen, and select a side dish
        composeTestRule.onNodeWithText("Summer Salad").performClick()

        // 5. Click the "Next" button
        composeTestRule.onNodeWithText("Next").performClick()

        // 6. Verify that we are on the Accompaniment Menu screen, and select an accompaniment
        composeTestRule.onNodeWithText("Bread").performClick()

        // 7. Click the "Next" button
        composeTestRule.onNodeWithText("Next").performClick()

        // 8. Verify that we are on the Checkout screen.
        // We use a substring match because the full text includes the price (e.g., "Subtotal: $10.00").
        composeTestRule.onNodeWithText("Subtotal", substring = true).assertExists()
        composeTestRule.onNodeWithText("Tax", substring = true).assertExists()
        composeTestRule.onNodeWithText("Total", substring = true).assertExists()

        // 9. Click the "Submit" button
        composeTestRule.onNodeWithText("Submit").performClick()

        // 10. Verify that we are back on the Start Order screen
        composeTestRule.onNodeWithText("Start Order").assertExists()
    }
}
