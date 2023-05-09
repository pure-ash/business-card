package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

// Full view of the app
@Composable
fun BusinessCard() {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        // Picture, name, and title
        ContactInfo(Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.weight(1f))
        // 3 list of contact information
        AboutMe()
    }
}

// Composable function that shows 3 UI item, which is picture, name, and title
@Composable
fun ContactInfo(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {  //arrange center
        Image(painterResource(id = R.drawable.android_logo), contentDescription = null, Modifier.size(120.dp).background(
            Color(0xFF276125)
        ) )
        Text(text = stringResource(R.string.name), fontSize = 56.sp, fontWeight = FontWeight.ExtraLight) // Bold, Size big
        Text(text = stringResource(R.string.title), fontWeight = FontWeight.SemiBold, color = Color(0xFF276125))
    }
}

// A composable function that contain 3 AboutMeList in column container
@Composable
fun AboutMe(modifier: Modifier = Modifier) {
    val myAppIcons = Icons.Outlined
    Column(modifier.padding(24.dp)) {
        AboutMeList(icon = myAppIcons.Phone, iconDescription = stringResource(R.string.phone_desc) , text = stringResource(R.string.phone_number))
        AboutMeList(icon = myAppIcons.Person, iconDescription = stringResource(R.string.social_media_desc), text = stringResource(R.string.social_media))
        AboutMeList(icon = myAppIcons.Email, iconDescription = stringResource(R.string.email_desc), text = stringResource(R.string.email))
    }
}

// A composable function that provide a template for an icon and a list
@Composable
private fun AboutMeList(icon: ImageVector, iconDescription: String, text: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .padding(10.dp)) {
        Icon(icon, iconDescription,
            Modifier
                .padding(end = 24.dp)
                .size(24.dp, 24.dp),
            Color(0xFF276125))
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}