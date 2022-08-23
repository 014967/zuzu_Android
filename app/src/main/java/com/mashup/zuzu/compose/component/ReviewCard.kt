package com.mashup.zuzu.compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mashup.zuzu.R
import com.mashup.zuzu.compose.theme.ProofTheme
import com.mashup.zuzu.data.model.ReviewShareCard
import com.mashup.zuzu.ui.review.getDrinkCategoryColor

/**
 * @Created by 김현국 2022/08/20
 */

@Composable
fun ReviewCard(
    reviewShareCard: ReviewShareCard,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(396.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            ProofTheme.color.gray500,
                            ProofTheme.color.gray500
                        )
                    ),
                    alpha = 0.6f,
                    shape = RoundedCornerShape(12.dp)
                )
                .align(Alignment.BottomCenter)
        )

        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(Alignment.TopCenter)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                BlurWithOuterHeightImage(blurOuterHeight = 740.dp.value) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(reviewShareCard.wine.imageUrl).build(),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.ic_share_logo), contentDescription = "",
                modifier = Modifier
                    .padding(12.dp)
                    .size(70.dp, 24.dp)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp),
                horizontalAlignment = Alignment.End
            ) {
                val categoryColor = getDrinkCategoryColor(reviewShareCard.wine.category)

                Text(
                    text = "NO.002",
                    style = ProofTheme.typography.headingXS,
                    color = ProofTheme.color.gray500,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 14.dp)
                        .background(
                            color = Color(categoryColor),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(6.dp)
                )

                Text(
                    text = reviewShareCard.userReview.createdAt.split("T")[0],
                    style = ProofTheme.typography.headingXS,
                    color = Color(categoryColor),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .background(
                            color = ProofTheme.color.gray500,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(6.dp)
                )
            }

            Column(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                ProofTheme.color.gray500,
                                ProofTheme.color.gray500
                            )
                        ),
                        alpha = 0.6f,
                        shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)
                    ),
//                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                /**
                 * Drink Description
                 */
                /**
                 * Drink Description
                 */

                /**
                 * Drink Description
                 */
                /**
                 * Drink Description
                 */
                /**
                 * Drink Description
                 */
                /**
                 * Drink Description
                 */
                /**
                 * Drink Description
                 */

                /**
                 * Drink Description
                 */
                Text(
                    text = reviewShareCard.wine.name,
                    color = ProofTheme.color.white,
                    style = ProofTheme.typography.headingS,
                    maxLines = 2,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 12.dp)
                )

                Spacer(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = ProofTheme.color.black)
                )

                /**
                 * Drink Info
                 */

                /**
                 * Drink Info
                 */

                /**
                 * Drink Info
                 */

                /**
                 * Drink Info
                 */

                /**
                 * Drink Info
                 */

                /**
                 * Drink Info
                 */

                /**
                 * Drink Info
                 */

                /**
                 * Drink Info
                 */
                Text(
                    text = reviewShareCard.wine.category,
                    color = ProofTheme.color.white,
                    style = ProofTheme.typography.headingXS,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Text(
                    text = "ALC ${reviewShareCard.wine.alc}% . FROM reviewShareCard.wine.origin",
                    color = ProofTheme.color.white,
                    style = ProofTheme.typography.buttonM,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Spacer(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = ProofTheme.color.black)
                )

                /**
                 * Review Info
                 */

                /**
                 * Review Info
                 */

                /**
                 * Review Info
                 */

                /**
                 * Review Info
                 */

                /**
                 * Review Info
                 */

                /**
                 * Review Info
                 */

                /**
                 * Review Info
                 */

                /**
                 * Review Info
                 */
                Text(
                    text = "${reviewShareCard.userReview.mood} ${reviewShareCard.userReview.weather},${reviewShareCard.userReview.time}" +
                            "\n${reviewShareCard.userReview.isHeavy}|${reviewShareCard.userReview.isBitter}|${reviewShareCard.userReview.isBurning}|${reviewShareCard.userReview.isStrong}",
                    color = ProofTheme.color.white,
                    style = ProofTheme.typography.bodyS,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }
        }
    }
}