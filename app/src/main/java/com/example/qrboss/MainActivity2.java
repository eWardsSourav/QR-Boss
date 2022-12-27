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
import android.widget.TextView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    Button btn;

    private Bitmap bitmap;
    private QRGEncoder qrgEncoder;
    private EditText edtValue;
    private ImageView qrImage;
    private String inputValue;
    TextView black,beguni,purple,green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edtValue = findViewById(R.id.edittext);

        qrImage = findViewById(R.id.img);
        black = findViewById(R.id.black);
        beguni = findViewById(R.id.beguni);
        purple = findViewById(R.id.purple);
        green = findViewById(R.id.green);
        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              generateQr(R.color.purple_500);
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateQr(R.color.green);            }
        });
        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateQr(R.color.black);
            }
        });
        beguni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateQr(R.color.beguni);
            }
        });

    }

    private void generateQr(int color) {
        inputValue = edtValue.getText().toString().trim();
        if (inputValue.length() > 0) {
            WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int width = point.x;
            int height = point.y;
            int smallerDimension = Math.min(width, height);
            smallerDimension = smallerDimension * 3 / 4;




            qrgEncoder = new QRGEncoder(inputValue, null, QRGContents.Type.TEXT, smallerDimension);
            qrgEncoder.setColorBlack(color);
            qrgEncoder.setColorWhite(Color.WHITE);
            try {
                bitmap = qrgEncoder.getBitmap(0);
                qrImage.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            edtValue.setError("Error");
        }

    }
}