package alexnewcomer.cs360.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class AddActivity extends AppCompatActivity {

    //Initialize Variables
    EditText name_input, description_input, size_input, notes_input;
    Button add_button;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //Assign variables
        name_input = findViewById(R.id.name_input);
        description_input = findViewById(R.id.description_input);
        size_input = findViewById(R.id.size_input);
        notes_input = findViewById(R.id.notes_input);
        add_button = findViewById(R.id.add_button);

        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Add Validation For Item Name
        awesomeValidation.addValidation(this, R.id.name_input,
                RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        //Validation For Item Description
        awesomeValidation.addValidation(this, R.id.description_input,
                RegexTemplate.NOT_EMPTY, R.string.invalid_description);

        //Validation For Item Size
        awesomeValidation.addValidation(this, R.id.size_input,
                RegexTemplate.NOT_EMPTY, R.string.invalid_size);

        //Validation For Item Notes
        awesomeValidation.addValidation(this, R.id.notes_input,
                RegexTemplate.NOT_EMPTY, R.string.invalid_notes);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check Validation
                if (awesomeValidation.validate()) {
                    //On Success
                    Toast.makeText(getApplicationContext()
                            , "Form Validated Successfully...", Toast.LENGTH_SHORT).show();
                    //Adds the item to the Database
                    MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                    myDB.addItem(name_input.getText().toString().trim(),
                            description_input.getText().toString().trim(),
                            size_input.getText().toString().trim(),
                            notes_input.getText().toString().trim());
                } else {
                    //On Failure
                    Toast.makeText(getApplicationContext()
                            , "Validation Failed.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}