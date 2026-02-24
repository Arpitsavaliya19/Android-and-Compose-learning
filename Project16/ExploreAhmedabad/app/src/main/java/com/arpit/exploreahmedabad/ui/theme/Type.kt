package com.arpit.exploreahmedabad.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.arpit.exploreahmedabad.R

val centuryGothicFamily = FontFamily(
    Font(R.font.centurygothic, FontWeight.Normal),
    Font(R.font.centurygothic_bold, FontWeight.Bold)
)



// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = centuryGothicFamily, fontWeight = FontWeight.Bold),
    displayMedium = baseline.displayMedium.copy(fontFamily = centuryGothicFamily, fontWeight = FontWeight.Bold),
    displaySmall = baseline.displaySmall.copy(fontFamily = centuryGothicFamily, fontWeight = FontWeight.Bold),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = centuryGothicFamily, fontWeight = FontWeight.Bold),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = centuryGothicFamily, fontWeight = FontWeight.Bold),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = centuryGothicFamily, fontWeight = FontWeight.Bold),
    titleLarge = baseline.titleLarge.copy(fontFamily = centuryGothicFamily, fontWeight = FontWeight.Bold),
    titleMedium = baseline.titleMedium.copy(fontFamily = centuryGothicFamily, fontWeight = FontWeight.Bold),
    titleSmall = baseline.titleSmall.copy(fontFamily = centuryGothicFamily, fontWeight = FontWeight.Bold),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = centuryGothicFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = centuryGothicFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = centuryGothicFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = centuryGothicFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = centuryGothicFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = centuryGothicFamily),
)
