package com.example.f1infokotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.lifecycle.SavedStateHandle
import com.example.f1infokotlin.apiWork.Api
import com.example.f1infokotlin.apiWork.Repository
import com.example.f1infokotlin.objects.DisplayData
import com.example.f1infokotlin.objects.DriverStanding
import com.example.f1infokotlin.objects.DriverStandings
import com.example.f1infokotlin.ui.theme.*
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            F1InfoKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = mclaren_blue
                ) {
                    TabLayout()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
//    Text(text = "Hello $name!")
    Box(
        modifier = Modifier
            .size(500.dp)
            .background(Color.Gray),
    ) {
        Button(
            {},
            Modifier
                .size(30.dp)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red
            ),
        ) {
            Text(text = "this is my te")
        }
    }
}

// on below line we are creating a
// composable function for our tab layout
@OptIn(ExperimentalUnitApi::class)
@ExperimentalPagerApi
@Composable
fun TabLayout() {

    val coroutineScope = rememberCoroutineScope()
    val viewModel = remember { MyViewModel(coroutineScope, Repository(), SavedStateHandle()) }

    // on below line we are creating variable for pager state.
    val pagerState = rememberPagerState(pageCount = 3)

    // on below line we are creating a column for our widgets.
    Column(
        // for column we are specifying modifier on below line.
        modifier = Modifier.background(mclaren_blue)
    ) {
        // on the below line we are specifying the top app bar
        // and specifying background color for it.
        TopAppBar(backgroundColor = mclaren_orange) {
            // on below line we are specifying a column
            // for our text view to display a text
            // in our top app bar.
            Column(
                modifier = Modifier.fillMaxSize(),
                // on below line we are providing alignment for our
                // column to center of our top app bar.
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // on below line we are specifying a text and
                // specifying a text as "Tab Layout Example"
                Text(
                    text = "F1 Info",
                    style = TextStyle(color = mclaren_ltblue),
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(
                        18F,
                        TextUnitType.Sp
                    ),
                    // on below line we are specifying a modifier
                    // to our text and adding passing from all sides.
                    modifier = Modifier.padding(all = Dp(5F)),
                    // on below line we are aligning
                    // our text to center.
                    textAlign = TextAlign.Center
                )
            }
        }
        // on below line we are calling tabs
        Tabs(pagerState = pagerState)
        // on below line we are calling tabs content
        // for displaying our page for each tab layout
        TabsContent(pagerState = pagerState, viewModel)
    }
}

// on below line we are
// creating a function for tabs
@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    // in this function we are creating a list
    // in this list we are specifying data as
    // name of the tab and the icon for it.
    val list: List<Pair<String, @Composable (() -> Unit)>> = listOf(
        "Drivers" to run {
            {
                Icon(
                    painter = painterResource(id = R.drawable.helmet),
                    contentDescription = null,
                    Modifier.size(30.dp)
                )
            }
        },
        "Teams" to run {
            {
                Icon(
                    painter = painterResource(id = R.drawable.racecar_opt2),
                    contentDescription = null,
                    Modifier.size(30.dp)
                )
            }
        },
        "Schedule" to run {
            {
                Icon(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = null, // decorative element
                    Modifier.size(30.dp)
                )
            }
        },
    )
    // on below line we are creating
    // a variable for the scope.
    val scope = rememberCoroutineScope()
    // on below line we are creating a
    // individual row for our tab layout.
    TabRow(
        // on below line we are specifying
        // the selected index.
        selectedTabIndex = pagerState.currentPage,

        // on below line we are
        // specifying background color.
//        backgroundColor = Color(R.color.mclaren_orange),
        backgroundColor = mclaren_ltorange,


        // on below line we are specifying content color.
//        contentColor = Color.White,

        // on below line we are specifying
        // the indicator for the tab
        indicator = { tabPositions ->
            // on below line we are specifying the styling
            // for tab indicator by specifying height
            // and color for the tab indicator.
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = mclaren_ltblue
            )
        }
    ) {
        // on below line we are specifying icon
        // and text for the individual tab item
        list.forEachIndexed { index, _ ->
            // on below line we are creating a tab.
            Tab(
                // on below line we are specifying icon
                // for each tab item and we are calling
                // image from the list which we have created.
                icon = {
                    list[index].second()
//                    Icon(imageVector = list[index].second, contentDescription = null)
                },
                // on below line we are specifying the text for
                // the each tab item and we are calling data
                // from the list which we have created.
                text = {
                    Text(
                        list[index].first,
                        // on below line we are specifying the text color
                        // for the text in that tab
                        color = if (pagerState.currentPage == index) mclaren_ltblue else mclaren_ltgrey
                    )
                },
                // on below line we are specifying
                // the tab which is selected.
                selected = pagerState.currentPage == index,
                // on below line we are specifying the
                // on click for the tab which is selected.
                onClick = {
                    // on below line we are specifying the scope.
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@Composable
fun tester() {

}

// on below line we are creating a tab content method
// in which we will be displaying the individual page of our tab .
@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState, viewModel: MyViewModel) {
    // on below line we are creating
    // horizontal pager for our tab layout.
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> driverDisplay(listODriverStanding = viewModel.uiState.driverDataToDisplayOnScreen)
            1 -> constructorDisplay(listOConstructorStanding = viewModel.uiState.constructorDataToDisplayOnScreen)
            2 -> scheduleDisplay(listOSchedule = viewModel.uiState.scheduleDataToDisplayOnScreen)
            else -> null
        }?.let {
//            CollapsableLazyColumn(listOf(CollapsableSection("title", listOf("a","b","c")),
//                CollapsableSection("title2", listOf("a2","b2","c2"))))
            CollapsableLazyColumn(it)
        }
    }
}

// on below line we are creating a Tab Content
// Screen for displaying a simple text message.
@Composable
fun TabContentScreen(data: String) {
    // on below line we are creating a column
    Column(
        // in this column we are specifying modifier
        // and aligning it center of the screen on below lines.
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // in this column we are specifying the text
        Text(
            // on below line we are specifying the text message
            text = data,

            // on below line we are specifying the text style.
            style = MaterialTheme.typography.h5,

            // on below line we are specifying the text color
            color = mclaren_orange,

            // on below line we are specifying the font weight
            fontWeight = FontWeight.Bold,

            //on below line we are specifying the text alignment.
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DisplayListOfThree(list: List<String>) {
    Log.d("My Tag toDisplay", list[1])

    Row(
        Modifier
            .padding(horizontal = 25.dp, vertical = 20.dp)
    ) {
        Text(text = list[0])
        Spacer(Modifier.weight(1f))
        Text(text = list[1])
        Spacer(Modifier.weight(1f))
        Text(text = list[2])
    }
}

@Composable
fun CollapsableLazyColumn(
    sections: List<DisplayData>,
    modifier: Modifier = Modifier,
) {
    val collapsedState = remember(sections) { sections.map { true }.toMutableStateList() }
    LazyColumn(modifier) {
        sections.forEachIndexed { i, dataItem ->
            Log.d("My Tag dataItem", dataItem.toString())
            val collapsable: Boolean = dataItem.rows.isNotEmpty()
            val collapsed = collapsedState[i]
            item(key = "header_$i") {
                if (!collapsable) {
                    DisplayListOfThree(list = dataItem.stats)
                } else {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable {
                                collapsedState[i] = !collapsed
                            }
                    ) {
                        Icon(
                            Icons.Default.run {
                                if (collapsed)
                                    KeyboardArrowDown
                                else
                                    KeyboardArrowUp
                            },
                            contentDescription = "",
//                            tint = Color.LightGray,
                        )
//                        Text(
//                            dataItem.stats[0],
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier
//                                .padding(vertical = 10.dp)
//                                .weight(1f)
//                        )
                        DisplayListOfThree(list = dataItem.stats)
                    }
                }
                Divider()
            }
            if (collapsable && !collapsed) {
                items(dataItem.rows) { row ->
                    Row {
                        Spacer(modifier = Modifier.size(MaterialIconDimension.dp))
//                        Text(
//                            row.name,
//                            modifier = Modifier
//                                .padding(vertical = 10.dp)
//                        )
                     val local = row.dateTime
                            .withZoneSameInstant(ZoneId.of("America/New_York"))
                        DisplayListOfThree(
                            list = listOf(
                                local.format(DateTimeFormatter.ofPattern("MM/dd")),
                                row.name,
                                local.format(DateTimeFormatter.ofPattern("HH:mm"))
                            )
                        )
                    }
                    Divider()
                }
            }
        }
    }
}



const val MaterialIconDimension = 24f


@Composable
fun TestData(api: Api) {
    val cScope = rememberCoroutineScope()
    var obj: List<DriverStanding> by remember {
        mutableStateOf(emptyList())
    }
    LaunchedEffect(key1 = true) {
        cScope.launch {
            val myVariable = api.getDriverStandings()
            obj =
                Json.decodeFromString<DriverStandings>(myVariable).MRData.StandingsTable.StandingsLists[0].DriverStandings
//            Log.d("myTage", obj.StandingsTable.toString())
        }
    }

    Column(
        Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        obj.forEach {
            Row(
                Modifier
                    .padding(horizontal = 25.dp, vertical = 20.dp)
            ) {
                Text(text = it.driver.familyName)
                Spacer(Modifier.weight(1f))
                Text(text = it.points)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    F1InfoKotlinTheme {
        Greeting("Android")
    }
}

