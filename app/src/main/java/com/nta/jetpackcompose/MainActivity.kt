package com.nta.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nta.jetpackcompose.ui.theme.JetpackComposeTheme
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val fontFamily = FontFamily(
            Font(R.font.lexend_thin, weight = FontWeight.Thin),
            Font(R.font.lexend_light, weight = FontWeight.Light),
            Font(R.font.lexend_regular, weight = FontWeight.Normal),
            Font(R.font.lexend_medium, weight = FontWeight.Medium),
            Font(R.font.lexend_semibold, weight = FontWeight.SemiBold),
            Font(R.font.lexend_bold, weight = FontWeight.Bold),
            Font(R.font.lexend_extrabold, weight = FontWeight.ExtraBold),
        )

        //TextStyle and Box Border
        /**setContent {
        Column(
        modifier = Modifier
        .statusBarsPadding()
        .background(Color.Yellow)
        .fillMaxHeight(0.5f)
        .fillMaxWidth()
        .padding(5.dp)
        .border(5.dp, Color.Green)
        .padding(5.dp)
        .border(5.dp, Color.Red)
        .padding(5.dp),
        verticalArrangement = Arrangement.SpaceEvenly
        ) {
        Text(
        text = buildAnnotatedString {
        withStyle(
        style = SpanStyle(
        color = Color.Green,
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold
        )
        ){
        append("J")
        }
        append("etpack")
        withStyle(
        style = SpanStyle(
        color = Color.Green,
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold
        )
        ){
        append("C")
        }
        append("ompose")
        },
        modifier = Modifier.padding(20.dp),
        color = Color.White,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Aung")
        }
        }**/

        setContent {
            MyAppScreen()
        }

    }

    @Composable
    fun MyAppScreen() {

        val snackBarHostState = remember { SnackbarHostState() }
        var textFieldState by remember {
            mutableStateOf("")
        }

        val scope = rememberCoroutineScope()

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            snackbarHost = { SnackbarHost(snackBarHostState) }
        ) { contentPadding ->

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
            ) {

                TextField(
                    value = textFieldState,
                    label = {
                        Text("Enter your name")
                    },
                    onValueChange = {
                        textFieldState = it
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    scope.launch {
                        snackBarHostState.showSnackbar("Hello $textFieldState")
                    }
                }) {

                    Text(text = "Pls greet me")

                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun PreviewMyAppScreen() {
        MyAppScreen()
    }
}

