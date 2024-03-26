package com.example.myprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResumeActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        webView = (WebView) findViewById(R.id.html_resume);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/resume.html");

        // Enable the home button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the home button icon
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);

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
