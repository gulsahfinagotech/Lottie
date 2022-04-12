package com.gulsahozaltun.lottiee

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import android.graphics.RectF


class LoginCustomButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    private var bgColor: Int = Color.YELLOW
    private var textColor: Int = Color.RED
    private var rippleColor: Int = Color.WHITE
    private var StateNormal = 1
    private var mState = StateNormal
    protected var isClickEnable = true

    init {
        isClickable = true

        val attr = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.LoadingButton,
            0,
            0
        )
        try {

            // button back-ground color
            bgColor = attr.getColor(
                R.styleable.LoadingButton_bgColor,
                ContextCompat.getColor(context, R.color.white)
            )

            // button text color
            textColor = attr.getColor(
                R.styleable.LoadingButton_textColor,
                ContextCompat.getColor(context, R.color.black)
            )
        } finally {
            // clearing all the data associated with attribute
            attr.recycle()
        }
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER // button text alignment
        textSize = 55.0f //button text size
        typeface = Typeface.create("", Typeface.BOLD) // button text's font style
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.strokeWidth = 0f
        paint.color = Color.RED
        setPadding(10,10,10,10)
        var corner = 25f
        var offset = 50f
        val rectF = RectF(
            offset,  // left
            offset,  // top
            canvas!!.width - offset,  // right
            canvas!!.height - offset // bottom
        )



        if (canvas != null) {
            //canvas.clipRect(20, 20, 40, 40)
            // canvas.drawRoundRect(rectF,corner,corner,paint)
            canvas.drawRoundRect(rectF, corner, corner, paint)
            //canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)

        }
        // write the text on custom button
        paint.color = textColor
        var buttonText = "Login Button"
        if (canvas != null) {
            canvas.drawText(buttonText, (width / 2).toFloat(), ((height + 30) / 2).toFloat(), paint)
        }

    }


}

