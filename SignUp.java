package alexnewcomer.cs360.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//allows the user to sign up for an account, and the login information is stored in Firebase
public class SignUp extends AppCompatActivity {

    //Variables
    TextInputLayout fullname_input, username_input, email_input, phone_input, password_input;
    Button create_button, return_to_log_in_button;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullname_input = findViewById(R.id.fullname_input);
        username_input = findViewById(R.id.username_input);
        email_input = findViewById(R.id.email_input);
        phone_input = findViewById(R.id.phone_input);
        password_input = findViewById(R.id.password_input);
        create_button = findViewById(R.id.create_button);
        return_to_log_in_button = findViewById(R.id.return_to_log_in_button);

        return_to_log_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
            }
        });

        //Save data in Firebase on button click
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                registerUser(view);


            }
        }); //Register button method end
    } //onCreate method end


    //Input validation
    private Boolean validateName() {
        String val = fullname_input.getEditText().getText().toString();

        if(val.isEmpty()) {
            fullname_input.setError("Field cannot be empty");
            return false;
        }
        else {
            fullname_input.setError(null);
            fullname_input.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = username_input.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if(val.isEmpty()) {
            username_input.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 15){
            username_input.setError("Username too long");
            return false;
        }
        else if (!val.matches(noWhiteSpace)) {
            username_input.setError("White spaces are not allowed");
            return false;
        }
        else {
            username_input.setError(null);
            username_input.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = email_input.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()) {
            email_input.setError("Field cannot be empty");
            return false;
        } else if(!val.matches(emailPattern)) {
            email_input.setError("Invalid email address");
            return false;
        }

        else {
            email_input.setError(null);
            email_input.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhone() {
        String val = phone_input.getEditText().getText().toString();

        if(val.isEmpty()) {
            phone_input.setError("Field cannot be empty");
            return false;
        }
        else {
            phone_input.setError(null);
            phone_input.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = password_input.getEditText().getText().toString();
        String passwordVal = "^" +
                "(?=.*[a-zA-z])" +   //any letter
                "(?=\\S+$)" +        //no white spaces
                ".{4,}" +            //at least 4 characters
                "$";

        if(val.isEmpty()) {
            password_input.setError("Field cannot be empty");
            return false;
        } else if(!val.matches(passwordVal)) {
            password_input.setError("Password too short");
            return false;
        }
        else {
            password_input.setError(null);
            password_input.setErrorEnabled(false);
            return true;
        }
    }

    //Save data in Firebase on button click
    public void registerUser(View view) {

        if(!validateName() | !validateUsername() | !validateEmail() | !validatePhone() | !validatePassword()) {
            return;
        }

        //Get all the values in String
        String name = fullname_input.getEditText().getText().toString();
        String username = username_input.getEditText().getText().toString();
        String email = email_input.getEditText().getText().toString();
        String phoneNo = phone_input.getEditText().getText().toString();
        String password = password_input.getEditText().getText().toString();
        UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);
        reference.child(username).setValue(helperClass);
    }

}
