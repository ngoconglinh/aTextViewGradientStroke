package com.ngoconglinh.app
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.ngoconglinh.textviewgradientstroke.R

class TextViewGradientStroke @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var strokeWidth: Float = 10f
    private var strokeOrientation = GradientOrientation.HORIZONTAL
    private var startStrokeColor: Int = Color.GRAY
    private var endStrokeColor: Int = Color.CYAN
    private var gradientStartColor: Int = Color.GREEN
    private var gradientEndColor: Int = Color.YELLOW
    private var gradientOrientation = GradientOrientation.HORIZONTAL

    private var shadowColor: Int = Color.BLUE
    private var shadowRadius = 10f
    private var shadowDx = 6f
    private var shadowDy = 6f

    private var isShowShadow = true
    private var isShowStroke = true
    private var isShowGradient = true

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.TextViewGradientStroke)

        strokeWidth = ta.getFloat(R.styleable.TextViewGradientStroke_gsStrokeWidth, 10f)
        startStrokeColor = ta.getColor(R.styleable.TextViewGradientStroke_gsStartStrokeColor,  Color.GRAY)
        endStrokeColor = ta.getColor(R.styleable.TextViewGradientStroke_gsEndStrokeColor, Color.CYAN)
        gradientStartColor = ta.getInt(R.styleable.TextViewGradientStroke_gsGradientStartColor, Color.GREEN)
        gradientEndColor = ta.getInt(R.styleable.TextViewGradientStroke_gsGradientEndColor, Color.YELLOW)
        shadowColor = ta.getInt(R.styleable.TextViewGradientStroke_gsShadowColor, Color.BLUE)
        shadowRadius = ta.getFloat(R.styleable.TextViewGradientStroke_gsShadowRadius, 10f)
        shadowDx = ta.getFloat(R.styleable.TextViewGradientStroke_gsShadowDx, 6f)
        shadowDy = ta.getFloat(R.styleable.TextViewGradientStroke_gsShadowDy, 6f)
        isShowShadow = ta.getBoolean(R.styleable.TextViewGradientStroke_gsIsShowShadow, true)
        isShowStroke = ta.getBoolean(R.styleable.TextViewGradientStroke_gsIsShowStroke, true)
        isShowGradient = ta.getBoolean(R.styleable.TextViewGradientStroke_gsIsShowGradient, true)

        val orientationValue = ta.getInt(R.styleable.TextViewGradientStroke_gradientOrientation, 0)
        gradientOrientation = when (orientationValue) {
            1 -> GradientOrientation.VERTICAL
            2 -> GradientOrientation.DIAGONAL
            else -> GradientOrientation.HORIZONTAL
        }
        val orientationValue2 = ta.getInt(R.styleable.TextViewGradientStroke_strokeOrientation, 0)
        strokeOrientation = when (orientationValue2) {
            1 -> GradientOrientation.VERTICAL
            2 -> GradientOrientation.DIAGONAL
            else -> GradientOrientation.HORIZONTAL
        }

        ta.recycle()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        if (isShowShadow) {
            paint.setShadowLayer(shadowRadius, shadowDx, shadowDy, shadowColor)
            paint.shader = null
            super.onDraw(canvas)
        }

        if (isShowStroke) {
            paint.clearShadowLayer()
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = strokeWidth
            paint.shader = createGradient(width.toFloat(), height.toFloat(),
                startStrokeColor, endStrokeColor, strokeOrientation
            )
            super.onDraw(canvas)
        }

        if (isShowGradient) {
            paint.style = Paint.Style.FILL
            paint.shader = createGradient(width.toFloat(), height.toFloat(),
                gradientStartColor, gradientEndColor, gradientOrientation)
            super.onDraw(canvas)
        }
    }

    private fun createGradient(width: Float, height: Float, startColor: Int, endColor: Int, gradientOrientation: GradientOrientation): LinearGradient {
        return when (gradientOrientation) {
            GradientOrientation.HORIZONTAL -> LinearGradient(
                0f, 0f, width, 0f,
                startColor, endColor, Shader.TileMode.CLAMP
            )
            GradientOrientation.VERTICAL -> LinearGradient(
                0f, 0f, 0f, height,
                startColor, endColor, Shader.TileMode.CLAMP
            )
            GradientOrientation.DIAGONAL -> LinearGradient(
                0f, 0f, width, height,
                startColor, endColor, Shader.TileMode.CLAMP
            )
        }
    }

    enum class GradientOrientation {
        HORIZONTAL, VERTICAL, DIAGONAL
    }
}
