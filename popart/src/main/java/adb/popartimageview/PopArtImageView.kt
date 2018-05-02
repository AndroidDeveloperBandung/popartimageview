package adb.popartimageview

import adb.popart.R
import android.content.Context
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout



class PopArtImageView @JvmOverloads constructor(
        context: Context,
        val attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val imageViews by lazy {
        listOf<ImageView>(
                findViewById(R.id.image1),
                findViewById(R.id.image2),
                findViewById(R.id.image3),
                findViewById(R.id.image4)
        )
    }

    private val overlays by lazy {
        listOf<View>(
                findViewById(R.id.overlay1),
                findViewById(R.id.overlay2),
                findViewById(R.id.overlay3),
                findViewById(R.id.overlay4)
        )
    }

    @DrawableRes var image: Int? = null
        set(value) {
            field = value
            imageViews.forEach {
                it.setImageResource(value!!)
            }
        }

    @ColorRes var overlay: Int? = null
        set(value) {
            field = value
            overlays.forEach {
                it.setBackgroundColor(ContextCompat.getColor(context, value!!))
            }
        }

    init {
        View.inflate(context, R.layout.popartimageview, this)
        orientation = LinearLayout.VERTICAL

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.PopArtImageView)
        attributes.apply {
            image = getResourceId(R.styleable.PopArtImageView_image, 0)
        }.also { it.recycle() }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }
}
