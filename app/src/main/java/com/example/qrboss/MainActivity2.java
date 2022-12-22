package com.example.qrboss;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    Button btn;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.edittext);
        btn = findViewById(R.id.btn);
        imageView = findViewById(R.id.img);

        String input = editText.getText().toString();
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = Math.min(width, height);
        smallerDimension = smallerDimension * 3 / 4;
        int finalSmallerDimension = smallerDimension;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QRGEncoder qrgEncoder = new QRGEncoder(input,null, QRGContents.Type.TEXT, finalSmallerDimension);
                qrgEncoder.setColorBlack(Color.RED);
                qrgEncoder.setColorWhite(Color.BLUE);
                try {
                    // Getting QR-Code as Bitmap
                  Bitmap bitmap = qrgEncoder.getBitmap();
                    // Setting Bitmap to ImageView
                    imageView.setImageBitmap(bitmap);
                } catch (Exception e) {
                    Log.v("TAG", e.toString());
                }
            }
        });
    }
}