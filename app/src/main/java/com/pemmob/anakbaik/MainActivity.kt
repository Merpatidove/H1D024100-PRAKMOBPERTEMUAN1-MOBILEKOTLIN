package com.pemmob.anakbaik

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pemmob.anakbaik.ui.theme.JualanTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LayoutTentangJualan(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LayoutTentangJualan(modifier: Modifier = Modifier) {
    var tampilHalamanUtama by remember { mutableStateOf(false) }

    if (!tampilHalamanUtama) {
        LaunchedEffect(Unit) {
            delay(2000)
            tampilHalamanUtama = true
        }

        SplashScreen(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
        )
    } else {
        HalamanUtama(modifier = modifier.fillMaxSize())
    }
}

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_jualan),
            contentDescription = "Logo Jualan",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun HalamanUtama(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(Color(0xFF121016)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.umkm),
            contentDescription = "Ilustrasi UMKM Lokal",
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Jualan - Platform UMKM Lokal",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Jualan adalah aplikasi yang membantu para pelaku UMKM " +
                "lokal memasarkan dan menjual produknya secara digital. " +
                "Dengan platform ini, para pelaku usaha kecil dari berbagai " +
                "daerah dapat menjangkau lebih banyak pelanggan, mengelola " +
                "penjualan, dan mengembangkan bisnisnya tanpa batasan geografis.",
            color = Color.White,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1E1E1E))
                .padding(16.dp)
        ) {
            Text(
                text = "Misi Kami:",
                modifier = Modifier.weight(1f),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Memajukan UMKM Lokal",
                modifier = Modifier.weight(2f),
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {},
                modifier = Modifier.size(
                    width = 80.dp,
                    height = 42.dp
                ),
                shape = RoundedCornerShape(20.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "NEXT",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LayoutTentangJualanPreview() {
    JualanTheme {
        LayoutTentangJualan()
    }
}
