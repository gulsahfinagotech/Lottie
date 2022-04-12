package com.gulsahozaltun.lottiee

import android.app.ActionBar
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.Typeface
import android.provider.Telephony.Mms.Part.TEXT
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.luminance
import androidx.core.view.marginStart
import com.airbnb.lottie.animation.content.Content
import com.elyeproj.drawtext.dpToPx
import com.elyeproj.drawtext.projectResources

class CustomButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
):View(context,attrs,defStyleAttr) {

    companion object {
        private const val DEFAULT_BUTTON_COLOR = Color.YELLOW
        private const val DEFAULT_BORDER_COLOR = Color.BLACK
        private const val DEFAULT_BORDER_WIDTH = 4.0f
    }


    private var buttonColor = DEFAULT_BUTTON_COLOR
    private var borderColor = DEFAULT_BORDER_COLOR
    private var borderWidth = DEFAULT_BORDER_WIDTH
    private val paint = Paint()
    private var size = 0

    init {
        paint.isAntiAlias = true
        setupAttributes(attrs)
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.EmotionalFaceView,
            0, 0)
        buttonColor = typedArray.getColor(R.styleable.EmotionalFaceView_faceColor, DEFAULT_BUTTON_COLOR)
        // TypedArray objects are shared and must be recycled.
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        // call the super method to keep any drawing from the parent side.
        super.onDraw(canvas)
        drawButton(canvas)
    }

    private fun drawButton(canvas: Canvas) {
        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL
        //var textAlign = Paint.Align.CENTER
        val radius = size / 2f
        canvas.drawCircle(size / 2f, size / 2f, radius, paint)

        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        //canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        size = Math.min(measuredWidth, measuredHeight)

        setMeasuredDimension(size, size)
    }









/*    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        // Paint styles used for rendering are initialized here. This
        // is a performance optimization, since onDraw() is called
        // for every screen refresh.
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
        //setTextColor(Color.WHITE)
        //setText("Button")
        text="Merhaba buton"
        setBackgroundResource(R.drawable.custom_button)
    var mTextColor= Color.parseColor("#FF16A086")
    var mColor=Color.parseColor("#FFFFFF")
    var align=Paint.Align.CENTER


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPaint(paint)
    }*/


/*    fun buttonStyle(){
        setBackgroundResource(R.drawable.custom_button)
        setText("Buton")
        setPadding(15,15,15,15)
        setTypeface(typeface, Typeface.BOLD)
        setAllCaps(true) //isAllCaps = false
        setTextColor(ContextCompat.getColor(context,R.color.white))
        this.layoutParams=LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,300)
        isClickable=true
    }*/








}