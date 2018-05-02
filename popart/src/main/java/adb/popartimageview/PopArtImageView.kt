package adb.popartimageview

import android.content.Context
import android.graphics.*
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.util.Log
import android.view.View

class PopArtImageView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    @DrawableRes var image: Int? = null
        set(value) {
            field = value
            imageBitmap = BitmapFactory.decodeResource(context.resources, value!!)
        }

    private var imageBitmap: Bitmap? = null
        set(value) {
            field = value

            bitmapWidth = value?.width?.toFloat() ?: 0F
            bitmapHeight = value?.height?.toFloat() ?: 0F

            log("Bitmap width: $bitmapWidth")
            log("Bitmap height: $bitmapHeight")
        }

    private var bitmapWidth: Float = 0F
    private var bitmapHeight: Float = 0F

    private val paint by lazy { Paint() }

    private val colors = mapOf(
            "red" to Color.parseColor("#AAd50000"),
            "yellow" to Color.parseColor("#AAffea00"),
            "blue" to Color.parseColor("#AA00FFFF"),
            "green" to Color.parseColor("#AA00c853")
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        if (imageBitmap != null) {
            val destWidth = w / 2
            val destHeight = h / 2

            imageBitmap = Bitmap.createScaledBitmap(imageBitmap, destWidth, destHeight, true)

            log("destWidth $destWidth")
            log("destHeight $destHeight")
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (imageBitmap == null) return

        log(measuredHeight)
        log(measuredWidth)

        canvas.drawBitmap(imageBitmap, 0F, 0F, paint)
        canvas.drawBitmap(imageBitmap, bitmapWidth, 0F, paint)
        canvas.drawBitmap(imageBitmap, 0f, bitmapHeight, paint)
        canvas.drawBitmap(imageBitmap, bitmapWidth, bitmapHeight, paint)

        paint.color = colors["red"]!!
        canvas.drawRect(0F, 0F, bitmapWidth, bitmapHeight, paint)

        paint.color = colors["yellow"]!!
        canvas.drawRect(0F, bitmapHeight, bitmapWidth, bitmapHeight * 2, paint)

        paint.color = colors["blue"]!!
        canvas.drawRect(bitmapWidth, 0F, bitmapWidth * 2, bitmapHeight, paint)

        paint.color = colors["green"]!!
        canvas.drawRect(bitmapWidth, bitmapHeight, bitmapWidth * 2, bitmapHeight * 2, paint)
    }

    private fun log(message: Any?) {
        Log.d("PopArt", "Log: ${message?.toString()}")
    }
}
