package com.wk.oa.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

import com.wk.oa.R;


/**
 * Created by jianglei on 2016/12/13.
 */
public class TabButton extends Button {

    Bitmap mIconBitmap;
    Bitmap mSelectedBitmap;
    String iconStr;

    Paint mTextPaint;
    Paint mBitmapPaint;

    int mIconTextMargin = 10;
    int mTotalHeight = 0;
    int mTextColor;
    int mSelectedColor;

    Size textSize = null;

    boolean isSelected = false;


    public TabButton(Context context) {
        super(context);
        initAttribute(null);
    }

    public TabButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttribute(attrs);
    }

    public TabButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttribute(attrs);
    }

    public void setIconBitmap(Bitmap mBitmap) {
        this.mIconBitmap = mBitmap;
    }

    public void setIconRes(int resId) {
        Drawable mIconDrawable = getResources().getDrawable(resId);

        this.mIconBitmap = makeDrawableToBitmap(mIconDrawable);
    }

    public void setSelectedIconBitmap(Bitmap mBitmap) {
        this.mSelectedBitmap = mBitmap;
    }

    public void setSelectedIconRes(int redId) {
        Drawable mSelectedIconDrawable = getResources().getDrawable(redId);
        this.mSelectedBitmap = makeDrawableToBitmap(mSelectedIconDrawable);
    }

    public void setIconText(String iconText) {
        this.iconStr = iconText;
    }

    public void setIconTextMargin(int margin) {
        this.mIconTextMargin = margin;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
        if (isSelected) {
            mTextPaint.setColor(mSelectedColor);
        } else {
            mTextPaint.setColor(mTextColor);
        }
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        textSize = getTextWidthAndHeight(mTextPaint, iconStr);
        mTotalHeight = (mIconBitmap == null ? 0 : mIconBitmap.getHeight())
                + textSize.getHeight()
                + ((mIconBitmap != null && iconStr != null) ? mIconTextMargin : 0);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (iconStr != null) {
            int startH = (this.getHeight() + mTotalHeight) / 2;
            int startW = this.getWidth() / 2;
            canvas.drawText(iconStr, startW, startH, mTextPaint);
        }
        if (isSelected) {
            if (mSelectedBitmap != null) {
                int startH = (this.getHeight() - mTotalHeight) / 2;
                int startW = (this.getWidth() - mSelectedBitmap.getWidth()) / 2;
                canvas.drawBitmap(mSelectedBitmap, startW, startH, mBitmapPaint);
            }
        } else {
            if (mIconBitmap != null) {
                int startH = (this.getHeight() - mTotalHeight) / 2;
                int startW = (this.getWidth() - mIconBitmap.getWidth()) / 2;
                canvas.drawBitmap(mIconBitmap, startW, startH, mBitmapPaint);
            }
        }

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mIconBitmap != null && !mIconBitmap.isRecycled()) {
            mIconBitmap.recycle();
        }
    }

    private void initAttribute(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.tabbutton);
            int mIconResId = typedArray.getResourceId(R.styleable.tabbutton_icon_drawable, -1);
            if (mIconResId != -1) {
                setIconRes(mIconResId);
            }
            int mIconSelectedResId = typedArray.getResourceId(R.styleable.tabbutton_icon_drawable_selected, -1);
            if (mIconSelectedResId != -1) {
                setSelectedIconRes(mIconSelectedResId);
            }
            mIconTextMargin = typedArray.getDimensionPixelSize(R.styleable.tabbutton_icon_text_margin, mIconTextMargin);
            mTextColor = typedArray.getColor(R.styleable.tabbutton_text_color, getResources().getColor(R.color.main_tab_text_unselected_color));
            mSelectedColor = typedArray.getColor(R.styleable.tabbutton_text_selected_color, getResources().getColor(R.color.main_tab_text_selected_color));
            iconStr = typedArray.getString(R.styleable.tabbutton_icon_str);
            typedArray.recycle();
        }

        mBitmapPaint = new Paint();
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(getTextSize());
        mTextPaint.setColor(mTextColor);
    }

    public Bitmap makeDrawableToBitmap(Drawable mDrawable) {
        int width = mDrawable.getIntrinsicWidth();
        int height = mDrawable.getIntrinsicHeight();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = Bitmap.createBitmap(width, height, config);
        Canvas ca = new Canvas(bitmap);
        mDrawable.setBounds(0, 0, width, height);
        mDrawable.draw(ca);
        return bitmap;
    }

    public Size getTextWidthAndHeight(Paint mPaint, String text) {
        if (mPaint == null || text == null) {
            return new Size(0, 0);
        } else {
            Rect textBonds = new Rect();
            mPaint.getTextBounds(text, 0, text.length(), textBonds);
            return new Size(textBonds.width(), textBonds.height());
        }
    }

    public class Size {

        private int height;

        private int width;

        public Size(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public Size() {
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }
}
