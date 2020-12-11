package alexnewcomer.cs360.com;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class UpdateActivity extends AppCompatActivity {

    EditText name_input, description_input, size_input, notes_input;
    Button update_button, delete_button;

    String id, name, description, size, notes;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name_input = findViewById(R.id.name_input2);
        description_input = findViewById(R.id.description_input2);
        size_input = findViewById(R.id.size_input2);
        notes_input = findViewById(R.id.notes_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);



        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }


        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Add Validation For Item Name
        awesomeValidation.addValidation(this, R.id.name_input2,
                RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        //Validation For Item Description
        awesomeValidation.addValidation(this, R.id.description_input2,
                RegexTemplate.NOT_EMPTY, R.string.invalid_description);

        //Validation For Item Size
        awesomeValidation.addValidation(this, R.id.size_input2,
                RegexTemplate.NOT_EMPTY, R.string.invalid_size);

        //Validation For Item Notes
        awesomeValidation.addValidation(this, R.id.notes_input2,
                RegexTemplate.NOT_EMPTY, R.string.invalid_notes);

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (awesomeValidation.validate()) {
                    //On Success
                    Toast.makeText(getApplicationContext()
                            , "Form Validated Successfully...", Toast.LENGTH_SHORT).show();
                    //And only then we call this
                    MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                    name = name_input.getText().toString().trim();
                    description = description_input.getText().toString().trim();
                    size = size_input.getText().toString().trim();
                    notes = notes_input.getText().toString().trim();
                    myDB.updateData(id, name, description, size, notes);
                } else {
                    //On Failure
                    Toast.makeText(getApplicationContext()
                            , "Validation Failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData() {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("description") && getIntent().hasExtra("size") &&
                getIntent().hasExtra("notes")) {
            //Getting data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            description = getIntent().getStringExtra("description");
            size = getIntent().getStringExtra("size");
            notes = getIntent().getStringExtra("notes");

            //setting intent data
            name_input.setText(name);
            description_input.setText(description);
            size_input.setText(size);
            notes_input.setText(notes);
            Log.d("stev", name+" "+description+" "+size+" "+notes);
        } else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
