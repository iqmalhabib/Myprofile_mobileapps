package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.graphics.Color;
//LoginActivity is a subclass of AppCompatActivity and implements the View.OnClickListener interface
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    //instance variables declaration
    //uses default access modifier. may use private access modifier as well
    DatabaseHelper db;
    EditText email, pass;
    Button button1, button2,button3;
    //creates the new activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //creates the DatabaseHelper object
        db = new DatabaseHelper(this);
        //assigns the value of view's id in XML file to the references/variables in Java file
        //the references/variables can be used to access the views in XML file
        email = findViewById(R.id.etEmail);
        pass = findViewById(R.id.etPass);
        button1 = findViewById(R.id.btnLogin);
        button2 = findViewById(R.id.btnSignup);
        button3 = findViewById(R.id.display_dialog);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyDialogFragment().show(getSupportFragmentManager(),"MyDialogFragment");
            }
        });
        //registers the buttons as onclick listener
        //The buttons can listen to the onclick event
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        // Get references to the EditText and the Login button
        EditText emailEditText = findViewById(R.id.etEmail);
        Button loginButton = findViewById(R.id.btnLogin);

        // Add a TextWatcher to the email EditText
        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Check if the entered email matches the desired format
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.com";
                boolean isValidEmail = s.toString().matches(emailPattern);

                // Update the background color of the Login button
                if (isValidEmail) {
                    loginButton.setBackgroundColor(Color.GREEN);
                } else {
                    loginButton.setBackgroundColor(Color.RED);
                }
            }
        });
    }
    //handles the onclick event
    //necessary action will be taken when the login and sign-up buttons are clicked on
    @Override
    public void onClick(View v) {
        //local references/variables declaration
        boolean chk;
        String emel, pwd;
        Intent intent;
        int id;

        //gets the id of buttons that is clicked on by the user and assigns it to id
        id = v.getId();

//tests if the user clicks on the login button
        if(id==R.id.btnLogin) {
            //reads and assigns the value of edit text to the reference of String
            emel = email.getText().toString().trim();
            pwd = pass.getText().toString().trim();
            //tests the values of emel and pwd whether they are empty or not
            if (emel.equals("") || pwd.equals(""))
                //displays a pop up message "Fields are empty" within a couple of seconds
                //can replace Toast.LENGTH_SHORT with Toast.LENGTH_LONG
                Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
            else {
                //find the row/record with the emel and pwd in the table (database)
                chk = db.chklogin(emel, pwd);
                //tests chk whether it is true or false
                //if chk is true
                if (chk) {
                    //moves to the MainActivity.class
                    //creates Intent object - LoginActivity.this (current activity) and MainActivity.class (new activity)
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    //starts the new activity
                    startActivity(intent);
                    //finishes the current activity
                    finish();
                } else
                    //displays a pop-up message "Error: Username or Password" within a couple of seconds
                    //can replace Toast.LENGTH_SHORT with Toast.LENGTH_LONG
                    Toast.makeText(getApplicationContext(), "Error: Username or Password", Toast.LENGTH_SHORT).show();
            }
            //tests if the user clicks on the sign up button
            //may remove the if(id==R.id.btnSignup) because there are only two options - login and sign-up
        }else if(id==R.id.btnSignup) {
            //displays a pop up message "Signup" within a couple of seconds
            //can replace Toast.LENGTH_SHORT with Toast.LENGTH_LONG
            Toast.makeText(getApplicationContext(), "Signup", Toast.LENGTH_SHORT).show();
            //moves to the RegisterActivity.class
            //creates Intent object - LoginActivity.this (current activity) and RegistryActivity.class (new activity)
            intent = new Intent(LoginActivity.this, RegisterActivity.class);
            //starts the new activity
            startActivity(intent);
            //finishes the current activity
            finish();
        }
    }
}
