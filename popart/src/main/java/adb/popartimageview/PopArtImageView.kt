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
            bitmapWidth = imageBitmap?.width?.toFloat() ?: 0F
            bitmapHeight = imageBitmap?.height?.toFloat() ?: 0F
        }

    private var imageBitmap: Bitmap? = null
    private var bitmapWidth: Float = 0F
    private var bitmapHeight: Float = 0F

    private val paint by lazy { Paint() }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        if (imageBitmap != null) {
            log("W $w")
            log("H $h")
            val destWidth = w / 4
            val destHeight = h / 4
            imageBitmap = Bitmap.createScaledBitmap(imageBitmap, destWidth, destHeight, true)

            log("Bitmap width: $bitmapWidth")
            log("Bitmap height: $bitmapHeight")
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (image == null) return

        log(measuredHeight)
        log(measuredWidth)

        canvas.drawBitmap(imageBitmap, 0F, 0F, paint)
        canvas.drawBitmap(imageBitmap, bitmapWidth, 0F, paint)

        paint.color = Color.RED
//        canvas.drawRect(0F, 0F, bitmapWidth, bitmapHeight, paint)
    }

    private fun log(message: Any?) {
        Log.d("PopArt", "Log: ${message?.toString()}")
    }
}
