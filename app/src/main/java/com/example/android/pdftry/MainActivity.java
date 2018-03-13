package com.example.android.pdftry;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        // pdfView.fromAsset("file.pdf").load();
        ImageView resultImage = (ImageView) findViewById(R.id.resultImage);
        //Bitmap resultBmp = BlurBuilder.blur(this, BitmapFactory.decodeResource(getResources(), R.drawable.logo_ssaurel));
        //resultImage.setImageBitmap(resultBmp);
        resultImage.setAlpha(0);

        startActivityForResult(intent, 1212);



    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1212:
                if (resultCode == RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    String uriString = uri.toString();
                    File myFile = new File(uriString);
                    String path = myFile.getAbsolutePath();
                    String displayName = null;
                    PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
                    pdfView.fromUri(uri).load();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}



