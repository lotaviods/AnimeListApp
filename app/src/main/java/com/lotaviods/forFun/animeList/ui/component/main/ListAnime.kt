package com.lotaviods.forFun.animeList.ui.component.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.lotaviods.forFun.animeList.model.Anime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun DismissableAnimeList(
    modifier: Modifier = Modifier,
    items: List<Anime>,
    onDismissed: (anime: Anime) -> Unit = {},
    onClickItem: (anime: Anime) -> Unit = {},
) {
    LazyColumn(modifier, content = {
        items(items = items, key = {
            it.hashCode()
        }) { item ->
            val dismissState = rememberDismissState {
                if (it == DismissValue.DismissedToStart) {
                    onDismissed(item)
                    true
                } else {
                    false
                }

            }

            SwipeToDismiss(state = dismissState,
                directions = setOf(DismissDirection.EndToStart),
                background = {
                    val color by animateColorAsState(
                        when (dismissState.targetValue) {
                            DismissValue.Default -> Color.White
                            else -> Color.Red
                        }
                    )
                    val alignment = Alignment.CenterEnd
                    val icon = Icons.Default.Delete

                    val scale by animateFloatAsState(
                        if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f
                    )

                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(color)
                            .padding(horizontal = Dp(20f)),
                        contentAlignment = alignment
                    ) {
                        Icon(
                            icon,
                            contentDescription = "Delete Icon",
                            modifier = Modifier.scale(scale)
                        )
                    }
                }) {
                AnimeCard(
                    item = item, onClickItem = {
                        onClickItem(item)
                    }, modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                )
            }
        }
    })


}