package com.mkj.android_study_220829_1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex8GalleryActivity extends AppCompatActivity {

    Uri uri;
    ImageView imageView;
    Button btnImage;
    Animation ani1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex8_gallery);

        btnImage = findViewById(R.id.btnImage);
        imageView = findViewById(R.id.imageView);
        findViewById(R.id.btnImage).setOnClickListener(mClick);
        ani1 = AnimationUtils.loadAnimation(Ex8GalleryActivity.this, R.anim.touch);
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnImage:
                    btnImage.startAnimation(ani1);
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityResult.launch(intent);
                    break;

            }

        }
    };
    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if( result.getResultCode() == RESULT_OK && result.getData() != null){

                    uri = result.getData().getData();

                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        imageView.setImageBitmap(bitmap);

                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
}