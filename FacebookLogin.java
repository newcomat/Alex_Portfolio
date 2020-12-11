/* Disabling Facebook Login for now due to potential security vulnerabilities if users chose to log
in with Facebook on the demo application


package alexnewcomer.cs360.com;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;
Facebook login functionality.  When the user logs in with via the Facebook site, they will get a prompt
* that asks them is they are okay with sharing their name, email address and profile picture.  If the user
* does not accept the prompt they will not be able to log in with the app.  The name, email address, and
* profile picture are only stored on the user's local device and not shared with Firebase or any other class
* for security purposes.
public class FacebookLogin extends AppCompatActivity {

    private LoginButton continueButton;
    private CircleImageView circleImageView;

    private CallbackManager callbackManager;

    private TextView txtName, txtEmail;

    private Button welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_facebook_login);

        continueButton = findViewById(R.id.facebook_login_button);
        txtName = findViewById(R.id.profile_name);
        txtEmail = findViewById(R.id.profile_email);
        circleImageView = findViewById(R.id.profile_pic);
        txtName = findViewById(R.id.profile_name);
        welcome = findViewById(R.id.go_to_welcome);

        callbackManager = CallbackManager.Factory.create();
        continueButton.setReadPermissions(Arrays.asList("email","public_profile"));

        checkLoginStatus();


        continueButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    AccessTokenTracker tokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            if(currentAccessToken == null) {

                circleImageView.setImageResource(0);
                Toast.makeText(FacebookLogin.this, "User logged out", Toast.LENGTH_LONG).show();
            }
            else
                loadUserProfile(currentAccessToken);

        }
    };

    private void loadUserProfile(AccessToken newAccessToken) {

        GraphRequest request = GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {

                try {
                    String first_name = object.getString("first_name");
                    String last_name = object.getString("last_name");
                    String email = object.getString("email");
                    String id = object.getString("id");

                    //URL for the profile picture
                    String image_url = "https://graph.facebook.com/"+id+ "/picture?type=normal";

                    //only the email, name and profile picture are used from Facebook, and stored only locally
                    txtEmail.setText(email);
                    txtName.setText(first_name + " " + last_name);
                    welcome.setText("Continue as " + first_name);
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.dontAnimate();

                    Glide.with(FacebookLogin.this).load(image_url).into(circleImageView);

                    welcome.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(FacebookLogin.this, Home.class);
                            startActivity(intent);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields","first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void checkLoginStatus() {
        if(AccessToken.getCurrentAccessToken() != null) {
            loadUserProfile(AccessToken.getCurrentAccessToken());
        }
    }


}*/

