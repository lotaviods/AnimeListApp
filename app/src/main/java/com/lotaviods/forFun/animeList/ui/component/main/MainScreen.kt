package com.lotaviods.forFun.animeList.ui.component

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.lotaviods.forFun.animeList.R
import com.lotaviods.forFun.animeList.model.Anime
import com.lotaviods.forFun.animeList.ui.component.main.DismissableAnimeList
import com.lotaviods.forFun.animeList.ui.main.viewModel.ListAnimeAppState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    getAnimes: () -> Unit,
    state: ListAnimeAppState,
    onDelete: (anime: Anime) -> String,
    toAddPage: () -> Unit
) {
    Scaffold(Modifier.fillMaxSize(), floatingActionButton = {
        FloatingActionButton(onClick = { toAddPage.invoke() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_add_24),
                contentDescription = null,
                tint = Color.Black
            )

        }
    }) { paddingValues ->
        val refreshState =
            rememberSwipeRefreshState(isRefreshing = state == ListAnimeAppState.Loading)

        SwipeRefresh(
            state = refreshState,
            onRefresh = { getAnimes.invoke() },
            modifier = Modifier.padding(paddingValues.calculateBottomPadding()).fillMaxSize(),
        ) {
            val context = LocalContext.current

            DismissableAnimeList(
                items = (state as? ListAnimeAppState.Success)?.data
                    ?: SnapshotStateList(),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                onDismissed = { anime ->
                    Toast.makeText(
                        context,
                        onDelete(anime),
                        Toast.LENGTH_SHORT
                    ).show()
                },
                onClickItem = { anime ->
                    Toast.makeText(
                        context,
                        anime.name,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        }
    }
}