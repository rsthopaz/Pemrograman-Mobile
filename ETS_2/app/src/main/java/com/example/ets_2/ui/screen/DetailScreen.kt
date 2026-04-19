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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
                    // icon: Int, label: string, value
                    maininformation(icon = R.drawable.movie_svgrepo_com, label = "Release", value = it.releaseDate)
                    maininformation(icon = R.drawable.wifi_1021_svgrepo_com, label = "Season", value = it.season)
                    maininformation(icon = R.drawable.timer_svgrepo_com, label = "Total Episodes", value = it.eps)
                    maininformation(icon = R.drawable.star_svgrepo_com, label = "Rating", value = it.rating)

                }
            }
                Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ){
                items(it.genre) {
                    g -> GenreChip(g)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Column() {
            Text(
                text = "Synopsis",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
                Spacer(modifier = Modifier.height(10.dp))
            Text(text = it.synopsis)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column() {
                Text(
                    text = "More Information",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))

                additionalinformation("Type", it.type)
                
                Text(text = "Type: ${it.type}")
            }


        }
    }
}

@Composable
fun maininformation(icon: Int, label: String, value: String){
    // icon: Int, label: string, value
    Row(verticalAlignment = Alignment.CenterVertically){
        Icon(
            painter = painterResource(icon),
            contentDescription = label,
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.size(6.dp))
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = value,
            fontSize = 16.sp
        )
    }
}

@Composable
fun additionalinformation(label: String, value: String){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.SemiBold
        )
        Text(text = value)
    }
}