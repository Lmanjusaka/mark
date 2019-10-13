package com.example.eyesmart.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.arclibrary.RegisterAndRecognizeActivity;
import com.example.eyesmart.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;




public class CameraActivity extends AppCompatActivity {
    private static int REQ_1 = 1;
    private static int REQ_2 = 2;
    //private String mFilePath;
    private Uri uri;
    File outputImg;
    private ImageView imageView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imageView = findViewById(R.id.save_image);
        button = findViewById(R.id.button_jni);
        //mFilePath = Environment.getExternalStorageDirectory().getPath();
        //mFilePath = mFilePath + "/" + "temp.png";
        outputImg = new File(getExternalCacheDir(),"temp.png");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //button.setText(JNIUtils.sayHelloFromJni());
                Intent intent = new Intent(CameraActivity.this, RegisterAndRecognizeActivity.class);
                startActivity(intent);
            }
        });
    }
    public void startCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Uri uri = Uri.fromFile(new File(mFilePath));
        //Uri uri = FileProvider.getUriForFile(this,"com.example.eyesmart.fileprovider",new File(mFilePath));
        uri = FileProvider.getUriForFile(this,"com.example.eyesmart.fileprovider",outputImg);
        //intent.addFlags( Intent.FLAG_GRANT_READ_URI_PERMISSION|Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        //intent.putExtra("return-data",true);
        startActivityForResult(intent,REQ_1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == REQ_1) {
                FileInputStream fis = null;
                try {
                    //fis = new FileInputStream(mFilePath);
                    //Bitmap bitmap = BitmapFactory.decodeStream(fis);
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                    imageView.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                }

            }
            else if (requestCode == REQ_2) {
                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");
                imageView.setImageBitmap(bitmap);

           }


        }


}
