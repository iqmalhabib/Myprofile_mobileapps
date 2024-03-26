package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//MainActivity class is a subclass of AppCompatActivity class
public class MainActivity extends AppCompatActivity {
    //instance variables declaration
    Button button;
    //creates the new activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String msg;
        //assigns the value of view's id in XML file to the references/variables in Java file
        //the references/variables can be used to access the views in XML file
        button = findViewById(R.id.btnLogout);
        //registers the button as onclick listener and handles the onclick event
        button.setOnClickListener(new View.OnClickListener() {
            //onClick() has one parameter - v and returns no value
            @Override
            public void onClick(View v) {
                Intent intent;
                //moves to the LoginActivity.class
                //creates Intent object - MainActivity.this (current activity) and LoginActivity.class (new activity)
                intent = new Intent(MainActivity.this, LoginActivity.class);
                //starts a new activity
                startActivity(intent);
                //finishes the current activity
                finish();

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "about me selected", Toast.LENGTH_SHORT).show();
                // Start Activity1
                Intent intent1 = new Intent(this, AboutmeActivity.class);
                startActivity(intent1);
                return true;
            case R.id.item2:
                Toast.makeText(this, "hobbies selected", Toast.LENGTH_SHORT).show();
                // Start Activity2
                Intent intent2 = new Intent(this, HobbiesActivity.class);
                startActivity(intent2);
                return true;
            case R.id.item3:
                Toast.makeText(this, "skill selected", Toast.LENGTH_SHORT).show();
                // Start Activity3
                Intent intent3 = new Intent(this, SkillsActivity.class);
                startActivity(intent3);
                return true;
            case R.id.item4:
                Toast.makeText(this, "resume selected", Toast.LENGTH_SHORT).show();
                // Start Activity3
                Intent intent4 = new Intent(this, ResumeActivity.class);
                startActivity(intent4);
                return true;
            // Add more cases for other menu items if needed
            case R.id.sub_item1:
                Toast.makeText(this, "UiTM website selected", Toast.LENGTH_SHORT).show();
                // Start SubActivity1
                Intent subIntent1 = new Intent(this, WebviewActivity.class);
                startActivity(subIntent1);
                return true;
            case R.id.sub_item2:
                Toast.makeText(this, "Student portal selected", Toast.LENGTH_SHORT).show();
                // Start SubActivity2
                Intent subIntent2 = new Intent(this, Webview2Activity.class);
                startActivity(subIntent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
