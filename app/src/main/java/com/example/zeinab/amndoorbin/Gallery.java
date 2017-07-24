package com.example.zeinab.amndoorbin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import info.guardianproject.iocipher.File;
import info.guardianproject.iocipher.FileInputStream;
import info.guardianproject.iocipher.FileOutputStream;
import info.guardianproject.iocipher.FileReader;
import info.guardianproject.iocipher.IOCipherFileChannel;
import info.guardianproject.iocipher.VirtualFileSystem;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Gallery extends AppCompatActivity {

    ImageView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        show = (ImageView) findViewById(R.id.show);

        File file = new File(Environment.getExternalStorageDirectory()+"/MyCamAppCipher"+"/zeinab.jpg");
        //File file = new File("/text.jpg");
        Bitmap bmp = null;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            Toast.makeText(Gallery.this, "Show! :D", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(Gallery.this, "not111! :D", Toast.LENGTH_SHORT).show();
        }
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;

        options.inJustDecodeBounds = false;
        options.inSampleSize = 2;
        try {
            bmp = BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            Toast.makeText(Gallery.this, "Show:D", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(Gallery.this, "not22! :D", Toast.LENGTH_SHORT).show();
        }

        show.setImageBitmap(bmp);
    }
}
