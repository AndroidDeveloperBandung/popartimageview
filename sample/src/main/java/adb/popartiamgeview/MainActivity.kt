package adb.popartiamgeview

import adb.popartimageview.PopArtImageView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<PopArtImageView>(R.id.imageview)
        imageView.image = R.drawable.pepe
    }
}
