package com.example.mad_pract5_085.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mad_pract5_085.R
import com.example.mad_pract5_085.screen.components.FormField
//import com.example.mad_pract5_085.showMsg

@Preview(showBackground = true)
@Composable
fun LoginScreen(context:Context?=null, modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.End,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.guni_pink_logo), // Reference to guni.png
            contentDescription = "GUNI Logo",
            modifier = Modifier
                .height(130.dp)
                .fillMaxWidth(),

            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            elevation = CardDefaults.cardElevation(20.dp),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column( modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
                FormField(Label = "Email", textState = email, onTextChange = {email=it})
                FormField(Label = "Password", isPasswordField = true, textState = password, onTextChange = {password= it})
                Text(
                    text = "ForgotPassword?",
                    fontSize = 18.sp,
                    modifier= Modifier
                        .padding(bottom = 50.dp)
                        .align(Alignment.End)
                )
                Button(onClick = { showMsg(context!!, "You have logged in.")
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),

                    ) {
                    Text(text = "LOGIN")

                }
            }
        }
    }
}

fun showMsg(context: Context, s: String) {

}
