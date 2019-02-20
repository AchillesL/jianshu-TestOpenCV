package com.example.testopencv;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.osgi.OpenCVNativeLoader;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OpenCVNativeLoader loader = new OpenCVNativeLoader();
        loader.init();

        mImageView = findViewById(R.id.imageView);
        mImageView.setImageResource(R.drawable.girl);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(),R.drawable.girl);
                Mat mat = new Mat();
                Mat grayMat = new Mat();
                Utils.bitmapToMat(bitmap,mat);
                Imgproc.cvtColor(mat, grayMat, Imgproc.COLOR_RGB2GRAY);
                Utils.matToBitmap(grayMat,bitmap);
                mImageView.setImageBitmap(bitmap);
            }
        });
    }
}
