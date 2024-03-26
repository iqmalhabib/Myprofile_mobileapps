package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//RegisterActivity is a subclass of AppCompatactivity
public class RegisterActivity extends AppCompatActivity{
    //instance variables declaration. Default access modifier
    EditText name, email, pass1, pass2;
    Button button;
    DatabaseHelper db;
    //creates the new activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //assigns the value of view's id in XML file to the references/variables in Java file
        //the references/variables can be used to access the views in XML file
        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        pass1 = findViewById(R.id.etPass1);
        pass2 = findViewById(R.id.etPass2);
        button = findViewById(R.id.btnRegister);
        //creates the DatabaseHelper object
        db = new DatabaseHelper(this);
        //registers the button as onclick listener and handles the onclick event
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //local references/variable declaration
                String nama, emel, pwd1, pwd2;
                boolean chk, ins;
                Intent intent;
                //reads and assigns the value of edit text to the reference of String
                nama = name.getText().toString().trim();
                emel = email.getText().toString().trim();
                pwd1 = pass1.getText().toString().trim();
                pwd2 = pass2.getText().toString().trim();
                //tests all values of edit texts whether they are empty or not
                if (nama.equals("") || emel.equals("") || pwd1.equals("") || pwd2.equals(""))
                    //displays a pop up message "Fields are empty" within a couple of seconds
                    //can replace Toast.LENGTH_SHORT with Toast.LENGTH_LONG
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                else {
                    //tests if the pwd1 equqls to pwd2
                    //to make sure that the user has entered the right password

                    if (pwd1.equals(pwd2)) {
                        //checks for the existing of the email in the table (database)
                        //returns a boolean value - true or false to chk
                        chk = db.chkemail(emel);
                        //tests the chk. if it is true then insert a new row/record into the table (database)
                        if (chk) {
                            //assigns true to ins if the row/record has been sucessfully inserted otherwise false
                            ins = db.insert(emel, pwd1, nama);
                            //if it is true
                            if (ins) {
                                //displays a pop-up message "Registered successfully" within a couple of seconds
                                //can replace Toast.LENGTH_SHORT with Toast.LENGTH_LONG
                                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                                //moves to the LoginActivity.class
                                //creates Intent object - RegisterActivity.this (current activity) and LoginActivity.class (new activity)
                                intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                //starts a new activity
                                startActivity(intent);
                                //finishes the current activity
                                finish();
                            }
                        } else
                            //displays a pop-up message "Email already exists" within a couple of seconds
                            //can replace Toast.LENGTH_SHORT with Toast.LENGTH_LONG
                            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                    } else
                        //displays a pop-up message "Password does not match" within a couple of seconds
                        //can replace Toast.LENGTH_SHORT with Toast.LENGTH_LONG
                        Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

