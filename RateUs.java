package alexnewcomer.cs360.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
//class for user to rate LCS by half star increments
public class RateUs extends AppCompatActivity {

    Button ratingButton;
    RatingBar ratingStars;

    float myRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Make this page full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_rate_us);

        ratingButton = findViewById(R.id.my_rating_btn);
        ratingStars = findViewById(R.id.ratingBar);

        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                int userRating = (int) rating;
                String message = null;

                myRating = ratingBar.getRating();


                switch (userRating) {
                    case 1:
                        message = "Sorry to hear that.";
                        break;
                    case 2:
                        message = "We always accept suggestions to improve.";
                        break;
                    case 3:
                        message = "Thank you";
                        break;
                    case 4:
                        message = "Great, thank you!";
                        break;
                    case 5:
                        message = "Awesome, thanks for your feedback!";
                        break;
                }

                Toast.makeText(RateUs.this, message, Toast.LENGTH_SHORT).show();

            }
        });

        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RateUs.this, "Your rating is: "+String.valueOf(myRating), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
