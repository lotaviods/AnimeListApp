@file:OptIn(ExperimentalMaterialApi::class)

package com.lotaviods.forFun.animeList.ui.component.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.lotaviods.forFun.animeList.model.Anime

@Composable
@Preview
fun AnimeCard(
    @PreviewParameter(AnimePreviewParameter::class) item: Anime,
    modifier: Modifier = Modifier,
    onClickItem: () -> Unit = {},
) {
    Card(modifier = modifier, onClick = onClickItem) {
        val context = LocalContext.current
        Row(horizontalArrangement = Arrangement.SpaceEvenly){
            SubcomposeAsyncImage(
                modifier = Modifier.size(128.dp),
                model = ImageRequest.Builder(context)
                    .data(item.imageUrl)
                    .build(),
                contentDescription = null,
                loading = {
                    CircularProgressIndicator(context)
                }
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.size(128.dp)
            ) {
                Text(text = item.name)
            }
        }
    }
}

class AnimePreviewParameter : PreviewParameterProvider<Anime> {
    override val values = sequenceOf(
        Anime("", "Noragami"),
    )
}