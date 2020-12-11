package alexnewcomer.cs360.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ContestActivity extends AppCompatActivity {

    //code for the take a picture contest class to enter to win a $50 gift card
    //initializing variables
    private ImageView firstPicture;
    private static final int REQUEST_IMAGE_CAPTURE = 101;
    Button submitPicture;

    //on create method to map the variables and the layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make it full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_contest);

        firstPicture = findViewById(R.id.first_picture);
        submitPicture = findViewById(R.id.submit_picture);
    }

    // method to take the picture
    public void takePicture(View view) {

        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(imageTakeIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    // method to display the user's picture
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            firstPicture.setImageBitmap(imageBitmap);
        }
    }
    //submit picture button
    public void submitPicture(View view) {
        submitPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ContestActivity.this, "Your picture has been submitted.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
