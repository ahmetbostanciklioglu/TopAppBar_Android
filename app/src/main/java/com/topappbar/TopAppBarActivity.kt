package com.topappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.topappbar.ui.theme.TopAppBarTheme

class TopAppBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    //Top App Bar App calling
                    TopAppBarApp()
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = modifier.padding(horizontal = 12.dp),
                //App Title here
                title = {
                    Text(text = "My App")
                },
                navigationIcon = {
                    // navigation icons here

                    //Back button
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null, // decorative element
                        modifier = modifier.clickable {
                            /* Handle navigation icon click */
                        }
                    )
                },
                actions = {
                    // Add action icons or buttons here

                    //Search button
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = modifier
                            .clickable {
                                /* Handle search icon click */
                            }
                            .scale(1.2f)
                    )
                }
            )
        },
        content = { paddingValues ->
            // Content of the screen goes here
            LazyColumn(
                modifier = modifier
                    .padding(paddingValues = paddingValues),
                content = {
                    items(20) { index ->
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            content = {
                                Text(text = "Item $index")
                                Icon(
                                    imageVector = Icons.Default.Settings,
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
            )
        }
    )
}

@Preview
@Composable
fun TopAppBarAppPreview() {
    TopAppBarTheme {
        TopAppBarApp()
    }
}