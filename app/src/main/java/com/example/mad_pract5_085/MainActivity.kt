package com.example.mad_pract5_085

import android.graphics.drawable.shapes.Shape
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import android.widget.NumberPicker.OnValueChangeListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventStart
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mad_pract5_085.R
import com.example.mad_pract5_085.ui.theme.Prac5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MAD_Prac5_085Theme {
                androidx.compose.material3.Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.guni_pink_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(400.dp)
                .padding(bottom = 16.dp)
        )
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)

            ) {
                FormField(labelString = "Email")
                FormField(labelString = "Password")
                Text(
                    text = "Forgot Password",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .align(Alignment.End)
                )
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),

                    ) {
                    Text(text = "Login", fontSize = 18.sp)
                }

            }
        }


    }


}

@Preview(showBackground=true)
@Composable
fun GreetingPreview() {
    MAD_Prac5_085Theme {
        com.example.mad_pract5_085.LoginScreen("Android")
    }
}


@Composable
fun FormField(labelString:String,isNumber: Boolean=false,isPassWordField: Boolean=false)
{
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically )
    {
        Text(text = labelString, fontSize = 18.sp)
        if(isNumber) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = labelString) },
                placeholder = { Text(text = labelString) } ,
                modifier=Modifier.padding(start=16.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
                keyboardOptions= KeyboardOptions(keyboardType = KeyboardType.Number)
            )}
        else{
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = labelString)},
                placeholder = { Text(text = labelString)},
                modifier=Modifier.padding(start=16.dp),
                textStyle = LocalTextStyle.current.copy(fontSize =16.sp),
                visualTransformation = VisualTransformation.None


            )
        }

    }
}