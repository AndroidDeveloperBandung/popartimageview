package adb.popartimageview

import android.content.Context
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView

class PopArtImageView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    init {
        View.inflate(context, R.layout.pop_art_imageview, this)
    }

    private val imageViews by lazy {
        val findImageView = { id: Int -> findViewById<ImageView>(id) }
        listOf(
                findImageView(R.id.image_1),
                findImageView(R.id.image_2),
                findImageView(R.id.image_3),
                findImageView(R.id.image_4)
        )
    }

    fun setImage(@DrawableRes imageRes: Int) {
        imageViews.forEach {
            it.setImageResource(imageRes)
        }
    }
}
