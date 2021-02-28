package com.example.androiddevchallenge.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PuppyDetails(model: DetailsViewModel, upPress: () -> Unit) {
    val typography = MaterialTheme.typography
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