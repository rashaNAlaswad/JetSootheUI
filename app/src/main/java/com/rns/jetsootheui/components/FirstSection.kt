package com.rns.jetsootheui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rns.jetsootheui.R
import com.rns.jetsootheui.model.alignYourBodyData
import com.rns.jetsootheui.ui.theme.JetSootheUITheme

@Composable
fun AlignYourBodyItem(
    @DrawableRes drawable: Int,
    @StringRes text: Int, modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}


@Composable
fun AlignYourBodySection(modifier: Modifier = Modifier) {
    Column(modifier) {
        Spacer(Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.align_your_body),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(alignYourBodyData) { item ->
                AlignYourBodyItem(item.drawable, item.text)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlignYourBodyItemPreview() {
    JetSootheUITheme {
        AlignYourBodyItem(drawable = R.drawable.ab1_inversions, text = R.string.ab1_inversions)
    }
}

@Preview(showBackground = true)
@Composable
fun AlignYourBodySectionPreview() {
    JetSootheUITheme {
        AlignYourBodySection()
    }
}