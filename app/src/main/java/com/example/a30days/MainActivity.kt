package com.example.a30days

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30days.data.Matches
import com.example.a30days.data.listOfMatches
import com.example.a30days.data.listOfRowImages
import com.example.a30days.ui.theme.Purple40
import com.example.a30days.ui.theme.Purple80
import com.example.a30days.ui.theme.PurpleGrey40
import com.example.a30days.ui.theme._30DaysTheme
import com.example.a30days.ui.theme.blue60
import com.example.a30days.ui.theme.red60

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                   modifier =  Modifier.background(Color.Blue)
                ) {
                    BarcaApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BarcaApp(){
    Scaffold(
        topBar = {
            BarcaTopBar()
        }
    ) {
        Column {
            Spacer(modifier = Modifier.height(70.dp))
            LazyRow{
                items(listOfRowImages){
                    Card(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = red60,
                            contentColor = Color.Black
                        )
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text(text = stringResource(id = it.matchDate))
                            Text(text = stringResource(id = it.matchtime))
                            Text(text = stringResource(id = it.teamNames))
                        }
                    }
                }
            }
            LazyColumn(contentPadding = it){
                items(listOfMatches){
                    BarcaCards(match = it)
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarcaTopBar(){
    CenterAlignedTopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box{
                Image(painter = painterResource(R.drawable.brand), contentDescription = null
                    , modifier = Modifier.size(40.dp))
            }

            Text(text = "FC BARCELONA")
        }
        Spacer(modifier = Modifier.height(12.dp))


    }
//    , colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//        MaterialTheme.colorScheme.primaryContainer
//    )
    )

}

@Composable
fun BarcaCards(
    match : Matches,
    modifier: Modifier = Modifier
){
   var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(16.dp, 6.dp)
            .clip(MaterialTheme.shapes.small),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = blue60
        )
    ) {
        Column (
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ){
            Column {
                Column (
                    modifier = Modifier.padding(8.dp,10.dp)
                ){

                    Row {
                        Text(text = stringResource(id = match.matchId),
                            style = MaterialTheme.typography.titleLarge)
                        Spacer(modifier = Modifier.weight(1f))
                        iconButton(expanded = expanded, onClick = { expanded = !expanded })
                    }
                    Text(text = stringResource(id = match.matchName), style = MaterialTheme.typography.titleLarge)
                }
                Box {
                    Image(painter = painterResource(id = match.matchPic),contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()

//                    fillMaxHeight()
                    )
                }
            }
            if(expanded){
                Column(
                    modifier = Modifier.background(Purple80)
                ) {
                    matchDetails(details = match.matchdetails)
                }

            }

        }

    }

}

@Composable
fun matchDetails(
    @StringRes details : Int,
    modifier : Modifier = Modifier
){
    Column (
        modifier = Modifier
            .padding(16.dp),
    ){
        Text(text = stringResource(id = details)
        , style = MaterialTheme.typography.labelLarge)
    }

}

@Composable
fun iconButton(
    expanded : Boolean,
    onClick : () -> Unit,
    modifier : Modifier = Modifier
){
    IconButton(onClick = onClick) {
        Icon(imageVector = if(!expanded){Icons.Filled.KeyboardArrowDown}
        else{Icons.Filled.KeyboardArrowUp},
            contentDescription = null
        )

    }
}


//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    _30DaysTheme {
//        Greeting("Android")
//    }
//}