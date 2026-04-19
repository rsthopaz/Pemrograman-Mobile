package com.example.ets_2.ui.screen
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Arrangement
import androidx.navigation.NavController
import androidx.navigation.compose.*
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import com.example.ets_2.data.DummyData
import com.example.ets_2.ui.components.AnimeItem
import com.example.ets_2.ui.components.GenreChip
import com.example.ets_2.R


@Composable
fun DetailScreen(animeId: Int) {
    val anime = DummyData.animeList.find { it.id == animeId }

    anime?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ){

                Image(
                    painter = painterResource(id = anime.imageRes),
                    contentDescription = it.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(150.dp)
                        .height(190.dp)
//                        .aspectRatio(0.8f)
                        .clip(RoundedCornerShape(12.dp))
                )
                Spacer(modifier = Modifier.width(20.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = it.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                        )

                    Row(verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            painter = painterResource(id = R.drawable.movie_svgrepo_com),
                            contentDescription = "Release",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = it.releaseDate,
                            fontSize = 16.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            painter = painterResource(id = R.drawable.wifi_1021_svgrepo_com),
                            contentDescription = "Season",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = it.season,
                            fontSize = 16.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            painter = painterResource(id = R.drawable.timer_svgrepo_com),
                            contentDescription = "Release",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = it.eps,
                            fontSize = 16.sp
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.star_svgrepo_com),
                            contentDescription = "Release",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = it.rating,
                            fontSize = 16.sp
                        )
                    }

                }


            }
                Spacer(modifier = Modifier.height(16.dp))


            Row{
                it.genre.forEach { g -> GenreChip(g) }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = it.synopsis)


        }
    }
}