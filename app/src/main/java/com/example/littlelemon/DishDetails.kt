package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DishDetails(id: Int) {
    val dish = requireNotNull(DishRepository.getDish(id))
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // TopAppBar
            TopAppBar(

            )

            // Dish Image
            Image(
                painter = painterResource(id = dish.imageResource),
                contentDescription = "Dish image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            // Dish Details
            Column {
                Text(text = dish.name, style = MaterialTheme.typography.h1)
                Text(text = dish.description, style = MaterialTheme.typography.body1)

                // Counter
                Counter()

                // Add to Basket Button
                Button(
                    onClick = { /* Add to basket action */ },
                    modifier = Modifier.fillMaxWidth().align(CenterHorizontally)
                ) {
                    Text(
                        text = stringResource(id = R.string.add_for) + " $${dish.price}",
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun Counter() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        var counter by remember {
            mutableStateOf(1)
        }
        TextButton(
            onClick = {
                counter--
            }
        ) {
            Text(
                text = "-",
                style = MaterialTheme.typography.h1
            )
        }
        Text(
            text = counter.toString(),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(16.dp)
        )
        TextButton(
            onClick = {
                counter++
            }
        ) {
            Text(
                text = "+",
                style = MaterialTheme.typography.h1
            )
        }
    }
}

@Preview
@Composable
fun DishDetailsPreview() {
    DishDetails(id = 1)
}
