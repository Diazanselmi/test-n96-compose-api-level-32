package com.example.testn96.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun AutoCompleteDropDownList(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    searchText: String = "",
    itemsList: List<String> = emptyList(),
    onItemSelected: (onSelected: Boolean, item: String) -> Unit
) {
    val density = LocalDensity.current
    AnimatedVisibility(
        modifier = modifier
            .zIndex(1f),
        visible = expanded,
        enter = slideInVertically {
            with(density) { 0.dp.roundToPx() }
        } + expandVertically(),
        exit = slideOutVertically { with(density) { 0.dp.roundToPx() } } + shrinkVertically()
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth(),
            elevation = 4.dp,
            shape = RoundedCornerShape(4.dp)
        ) {
            LazyColumn(
                modifier = Modifier.heightIn(max = 200.dp),
            ) {
                items(
                    if (searchText.isEmpty()) {
                        itemsList
                    } else {
                        itemsList.filter { it.lowercase().contains(searchText.lowercase()) }.sorted()
                    }
                ) {
                    ItemsList(itemText = it) { itemText ->
                        onItemSelected(false, itemText)
                    }
                }
            }
        }
    }
}

@Composable
fun ItemsList(
    itemText: String,
    onSelect: (String) -> Unit
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = remember {
                    MutableInteractionSource()
                }
            ) {
                onSelect(itemText)
            }
            .padding(10.dp),
        text = itemText, fontSize = 16.sp
    )
}