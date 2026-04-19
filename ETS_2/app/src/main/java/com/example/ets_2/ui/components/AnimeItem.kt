package com.example.ets_2.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.ets_2.R

import com.example.ets_2.model.Anime

@Composable
fun AnimeItem(
    anime: Anime,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(120.dp)
            .height(340.dp)
            .clickable { onClick() }
    ) {
        Column (modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = anime.imageRes),
                contentDescription = anime.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
//                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = anime.title,
                modifier = Modifier.padding(8.dp).fillMaxWidth(),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.weight(1f))

            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(
                    painter = painterResource(R.drawable.star_svgrepo_com),
                    contentDescription = "Rating",
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    text = anime.rating,
                    fontSize = 16.sp
                )
            }
        }
    }
}