package be.cbconnectit.portfolio.app.ui.main.introduction.sections

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.cbconnectit.portfolio.app.R
import be.cbconnectit.portfolio.app.domain.model.Service
import be.cbconnectit.portfolio.app.extensions.MinimumHeightState
import be.cbconnectit.portfolio.app.extensions.minimumHeightModifier
import be.cbconnectit.portfolio.app.ui.main.introduction.sections.components.ImageCard
import be.cbconnectit.portfolio.app.ui.main.introduction.sections.components.SectionTitle
import be.cbconnectit.portfolio.app.ui.theme.PortfolioTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ServiceSection(
    services: List<Service>,
    actionClicked: () -> Unit
) {
    val state = rememberLazyListState()

    Column {
        SectionTitle(
            modifier = Modifier.padding(start = 24.dp, end = 12.dp),
            title = stringResource(R.string.service),
            subtitle = stringResource(R.string.service_subtitle),
            actionText = stringResource(R.string.see_more),
            actionClicked = actionClicked
        )

        Spacer(modifier = Modifier.height(24.dp))

        val density = LocalDensity.current

        val minimumHeightState = remember { MinimumHeightState() }
        val minimumHeightStateModifier = Modifier.minimumHeightModifier(
            minimumHeightState,
            density
        )

        //TODO: add something like a snapHelper for this list! Same for all the other sections!
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            state = state,
            flingBehavior = rememberSnapFlingBehavior(lazyListState = state)
        ) {
            items(services) {
                ImageCard(
                    minimumHeightStateModifier
                        .fillParentMaxWidth()
                        .padding(horizontal = 8.dp),
                    it.image,
                    it.title,
                    it.title,
                    it.description,
                    5, 
                    RoundedCornerShape(20.dp, 20.dp, 0.dp, 20.dp)
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ServiceSectionPreview() {
    PortfolioTheme {
        Surface {
            ServiceSection(listOf(Service("", "", "", ""))) { }
        }
    }
}