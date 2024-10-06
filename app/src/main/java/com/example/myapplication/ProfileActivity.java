package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void setTeamIcon(View view) {
        Intent returnIntent = new Intent();
        ImageView selectedImage = (ImageView) view;
        returnIntent.putExtra("ImageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.logo1);
        // Figuring out the correct image
        String drawableName = "avatar1";
        int selectedImageId = data.getIntExtra("selectedImageId", R.id.image1);
        if (selectedImageId == R.id.image1) {
            drawableName = "avatar1";
        } else if (selectedImageId == R.id.image2) {
            drawableName = "avatar2";
        } else if (selectedImageId == R.id.image3) {
            drawableName = "avatar3";
        } else if (selectedImageId == R.id.image4) {
            drawableName = "avatar4";
        } else if (selectedImageId == R.id.image5) {
            drawableName = "avatar5";
        } else if (selectedImageId == R.id.image6) {
            drawableName = "avatar6";
        } else {
            drawableName = "avatar1";
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
}