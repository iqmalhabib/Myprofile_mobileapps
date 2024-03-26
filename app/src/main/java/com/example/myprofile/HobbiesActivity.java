package com.example.myprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class HobbiesActivity extends AppCompatActivity {
    TextSwitcher textSwitcher;
    Button buttonPrevious,buttonNext;

    String[] lists={
            "Play FootBall",
            "Play Fut-sal",
            "Play Video game",
            "Study"};
    int position =-1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);

        textSwitcher = findViewById(R.id.text_switcher);
        buttonNext = findViewById(R.id.button_next);
        buttonPrevious = findViewById(R.id.button_previous);

        // Enable the home button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the home button icon
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);


        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(18);
                textView.setTextColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary));
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(position<lists.length-1){
                    position = position + 1;
                    textSwitcher.setText(lists[position]);
                }
            }
        });
        buttonPrevious.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(position>0){
                    position = position - 1;
                    textSwitcher.setText(lists[position]);
                }
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

            case android.R.id.home:
                // Handle the home button click
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the back stack
                startActivity(intent);
                return true;
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
