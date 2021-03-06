package c.bmartinez.yelpclone.presentation.search_list_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Room
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import c.bmartinez.yelpclone.R
import c.bmartinez.yelpclone.domain.model.business_search.Businesses
import c.bmartinez.yelpclone.presentation.utils.DisplayStarRating
import c.bmartinez.yelpclone.utils.*

@Composable
fun SearchListItem(searchItem: Businesses, onClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(width = 0.dp, color = Color.Transparent, shape = RectangleShape)
            .clickable(onClick = onClick)
        ,
        elevation = 0.dp
    ) {
        Column {
            searchItem.imageUrl.let { url ->
                val image = LoadPicture(url = url, defaultImage = DEFAULT_BUSINESS_IMAGE).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    )
                }
            }

//            Image(
//                painter = painterResource(id = DEFAULT_BUSINESS_IMAGE),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(LOCATION_DETAILS_IMAGE_HEIGHT.dp),
//                contentScale = ContentScale.Crop
//            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = searchItem.name,
                    modifier = Modifier
                        .fillMaxWidth(.7f)
                        .wrapContentWidth(Alignment.Start),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${
                        String.format(
                            "%.2f",
                            (searchItem.distance / YelpConstants.METERS_IN_MILE)
                        )
                    } mi",
                    modifier = Modifier
                        .padding(start = 40.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
                        .wrapContentWidth(align = Alignment.End)
                )
            }

            searchItem.rating.let { rate ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DisplayStarRating(rating = rate, height = 40, width = 80)
                    Text(
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center,
                        text = "${searchItem.reviewCount} Reviews",
                        color = Color.Gray
                    )
                }
            }

            val locCategories: String = concatSearchListOfStrings(searchItem.categories)
            Text(
                modifier = Modifier
                    .align(Alignment.Start),
                textAlign = TextAlign.Center,
                text = locCategories,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Filled.Room, contentDescription = null)
                Text(
                    text = searchItem.location.city,
                    color = Color.Gray,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }

            Divider(color = Color.LightGray, thickness = 1.dp)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_check_24),
                    contentDescription = null
                )
                //Text(
                //text = searchItem.transactions.joinToString(", ")
                //)
            }

            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}