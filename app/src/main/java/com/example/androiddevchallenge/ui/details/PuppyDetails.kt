package com.example.androiddevchallenge.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PuppyDetails(model: DetailsViewModel, upPress: () -> Unit) {
    val typography = MaterialTheme.typography
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Details")
                },
                navigationIcon = {
                    IconButton(onClick = { upPress() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = model.puppy.image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier.padding(PaddingValues(8.dp))) {
                    Text(text = model.puppy.name, style = typography.h4)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = model.puppy.description, style = typography.body1)
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Adopt me")
                    }
                }
            }
        }
    )
}