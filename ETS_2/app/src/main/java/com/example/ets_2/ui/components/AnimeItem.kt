package com.example.ets_2.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    Card(colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier
//            .padding(8.dp)
            .padding(start = 15.dp)
            .width(120.dp)

            .clickable { onClick() }
    ) {
        Column (modifier = Modifier.fillMaxSize()){
            Image(
                painter = rememberAsyncImagePainter(anime.imageUri),
                contentDescription = anime.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(20.dp))
//                    .border(1.dp, Color.Gray, RoundedCornerShape(20.dp))

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

            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 8.dp)){
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