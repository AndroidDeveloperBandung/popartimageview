package adb.popartiamgeview

import adb.popartimageview.PopArtImageView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val popArt = findViewById<PopArtImageView>(R.id.popart)
        popArt. = R.color.colorPrimary
    }
}
