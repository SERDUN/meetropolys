package com.meetropolys.meetropolys.ui.base.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.AttrRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class ImageView extends android.support.v7.widget.AppCompatImageView{

    private static final float DEFAULT_HORIZONTAL_OFFSET = 0.5f;
    private static final float DEFAULT_VERTICAL_OFFSET = 0.9f;

    private float mHorizontalOffsetPercent = DEFAULT_HORIZONTAL_OFFSET;
    private float mVerticalOffsetPercent = DEFAULT_VERTICAL_OFFSET;

    public ImageView(Context context) {
        this(context, null);
    }

    public ImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageView(Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setScaleType(ScaleType.MATRIX);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        applyCropOffset();
    }



    private void applyCropOffset() {
        Matrix matrix = getImageMatrix();

        float scale;
        int viewWidth = getWidth() - getPaddingLeft() - getPaddingRight();
        int viewHeight = getHeight() - getPaddingTop() - getPaddingBottom();
        int drawableWidth = 0, drawableHeight = 0;
        if (getDrawable() != null) {
            drawableWidth = getDrawable().getIntrinsicWidth();
            drawableHeight = getDrawable().getIntrinsicHeight();
        }

        // Get the scale.
        if (drawableWidth * viewHeight > drawableHeight * viewWidth) {
            // Drawable is flatter than view. Scale it to fill the view height.
            // A Top/Bottom crop here should be identical in this case.
            scale = (float) viewHeight / (float) drawableHeight;
        } else {
            // Drawable is taller than view. Scale it to fill the view width.
            // Left/Right crop here should be identical in this case.
            scale = (float) viewWidth / (float) drawableWidth;
        }

        float viewToDrawableWidth = viewWidth / scale;
        float viewToDrawableHeight = viewHeight / scale;
        float xOffset = mHorizontalOffsetPercent * (drawableWidth - viewToDrawableWidth);
        float yOffset = mVerticalOffsetPercent * (drawableHeight - viewToDrawableHeight);

        // Define the rect from which to take the image portion.
        RectF drawableRect =
                new RectF(
                        xOffset,
                        yOffset,
                        xOffset + viewToDrawableWidth,
                        yOffset + viewToDrawableHeight);
        RectF viewRect = new RectF(0, 0, viewWidth, viewHeight);
        matrix.setRectToRect(drawableRect, viewRect, Matrix.ScaleToFit.FILL);

        setImageMatrix(matrix);
    }
    }
