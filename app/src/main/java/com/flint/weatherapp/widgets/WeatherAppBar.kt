package com.flint.weatherapp.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar


import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherAppBar(
    title: String = "title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 0.dp,
    navController: NavController,
    onAddActionClick: () -> Unit = {},
    onButtonClicked: () -> Unit = {}

) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.secondary,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            )
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                if(icon != null) {
                    Icon(imageVector = icon, contentDescription = "", tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.clickable { onButtonClicked.invoke() }
                        )
                }

            }
        },
        modifier = Modifier.shadow(elevation = elevation),
        actions = {
            if (isMainScreen) {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector =  Icons.Rounded.MoreVert , contentDescription = "")

                }
            }else Box(){}



        }
    )
}