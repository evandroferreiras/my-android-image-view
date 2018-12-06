package com.example.myimageviewlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

public class MyImageViewBasic extends RelativeLayout {
    //RelativeLayout properties
    private Context context;
    private AttributeSet attrs;
    private int defStyleAttr;

    //Core
    private ImageView imageView;

    //Attributes
    private Drawable imageFile;
    private Drawable imagePlaceHolder;
    private Drawable imageError;
    private boolean isBlackAndWhite;

    public MyImageViewBasic(Context context) {
        super(context);
        this.context = context;
        InitView();
    }

    public MyImageViewBasic(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
        InitView();
    }

    public MyImageViewBasic(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.attrs = attrs;
        this.defStyleAttr = defStyleAttr;
        InitView();
    }

    private void setBlackAndWhite(){
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        this.imageView.setColorFilter(filter);
    }

    private void InitView(){
        inflate(context, R.layout.my_image_view_layout, this);
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.MyImageViewBasic, defStyleAttr, 0);

        isBlackAndWhite = arr.getBoolean(R.styleable.MyImageViewBasic_isBlackAndWhite, false);
        imageFile = arr.getDrawable(R.styleable.MyImageViewBasic_imageSrc);
        imagePlaceHolder = arr.getDrawable(R.styleable.MyImageViewBasic_imagePlaceholder);
        imageError = arr.getDrawable(R.styleable.MyImageViewBasic_imageError);

        imageView = findViewById(R.id.my_image_view);
        imageView.setScaleType (ImageView.ScaleType.FIT_CENTER);
        if (imageFile != null) {
            setDrawableImage(imageFile);
        }

        if (isBlackAndWhite){
            setBlackAndWhite();
        }

        arr.recycle();

    }

    public void setDrawableImage(Drawable imageFile) {
        imageView.setImageDrawable(imageFile);
    }

    public void setUrlImage(String url, int imageError, int imagePlaceHolder,
                            ImageView.ScaleType scaleType) {
        imageView.setScaleType(scaleType);
        Glide
                .with(context)
                .load(url)
                .placeholder(imagePlaceHolder)
                .crossFade()
                .dontAnimate()
                .error(imageError)
                .into(imageView);
    }
}