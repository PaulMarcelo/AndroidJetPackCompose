package ec.com.pmyb.twitterchallengeresolution

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun PostTwitterScreen() {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Post(Modifier.align(Alignment.TopEnd))
    }
}

@Composable
fun Post(modifier: Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            ImageUser()
            Spacer(modifier = Modifier.size(16.dp))
            BodyPost()
        }
        Divider(
            modifier =
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
        )
    }

}

@Composable
fun ImageUser() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "ImageUser",
        modifier = Modifier
            .clip(CircleShape)
            .border(1.dp, Color.Transparent, shape = CircleShape)
            .size(75.dp)
    )
}

@Composable
fun BodyPost() {
    Column(Modifier.fillMaxWidth()) {
        TitlePost()
        TextPost()
        ImagePost()
        FooterPost()
    }
}

@Composable
fun TitlePost() {
    Row(Modifier.fillMaxWidth()) {
        Text(
            text = "Aris",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 10.dp),
            color = Color.White
        )
        Text(text = "@AristiDevs 4h", color = Color.Gray)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_dots), contentDescription = "Option",
            colorFilter = ColorFilter.tint(Color.White),
            //modifier = Modifier.align(Alignment.Vertical())
        )
    }
}

@Composable
fun TextPost() {
    Text(
        text = "Descripción ld arga  sobre dwd texto Descripción larga sobre texto Descripción larga sobre texto Descripción larga sobre texto Descripción larga sobre texto",
        color = Color.White
    )
}

@Composable
fun ImagePost() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "ImageUser",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 20.dp)
            .size(200.dp)
            .clip(RoundedCornerShape(10))
    )
}

@Composable
fun FooterPost() {

    var valueComment by rememberSaveable {
        mutableStateOf(1)
    }
    var valueRt by rememberSaveable {
        mutableStateOf(1)
    }
    var valueLike by rememberSaveable {
        mutableStateOf(1)
    }

    Row(
        Modifier
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.weight(1f)) {
            Image(
                painter = if (valueComment == 1) {
                    painterResource(id = R.drawable.ic_chat)
                } else {
                    painterResource(id = R.drawable.ic_chat_filled)
                },
                contentDescription = "Chat",
                colorFilter = ColorFilter.tint(Color(0xFF9E9A9A)),
                modifier = Modifier
                    .padding(end = 3.dp)
                    .clickable {
                        if (valueComment == 1) {
                            valueComment++
                        } else {
                            valueComment--
                        }
                    }
            )
            Text(
                text = "$valueComment", color = Color(0xFF9E9A9A),
                textAlign = TextAlign.Center
            )
        }

        Row(modifier = Modifier.weight(1f)) {
            Image(
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = "RT",
                colorFilter = if (valueRt == 1) {
                    ColorFilter.tint(Color(0xFF9E9A9A))
                } else {
                    ColorFilter.tint(Color(0xFF4CAF50))
                },
                modifier = Modifier
                    .padding(end = 3.dp)
                    .clickable {
                        if (valueRt == 1) {
                            valueRt++
                        } else {
                            valueRt--
                        }
                    }
            )
            Text(
                text = "$valueRt", color = Color(0xFF9E9A9A),
                textAlign = TextAlign.Center
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            Image(
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = "Like",
                colorFilter = if (valueLike == 1) {
                    ColorFilter.tint(Color(0xFF9E9A9A))
                } else {
                    ColorFilter.tint(Color(0xFFF44336))
                },
                modifier = Modifier
                    .padding(end = 3.dp)
                    .clickable {
                        if (valueLike == 1) {
                            valueLike++
                        } else {
                            valueLike--
                        }
                    }
            )
            Text(
                text = "$valueLike", color = Color(0xFF9E9A9A),
                textAlign = TextAlign.Center
            )
        }
    }
}

