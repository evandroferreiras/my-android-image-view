package com.example.evandrodesouza.myimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.myimageviewlibrary.MyImageViewBasic;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyImageViewBasic myImageViewBasic = findViewById(R.id.blackAndWhiteImage);

        myImageViewBasic.setUrlImage("https://user-images.githubusercontent.com/3903012/49407038-72272080-f73e-11e8-807f-50fdc4f2d157.jpg" , R.drawable.error,
                R.drawable.placeholder, ImageView.ScaleType.CENTER_CROP);
    }
}
