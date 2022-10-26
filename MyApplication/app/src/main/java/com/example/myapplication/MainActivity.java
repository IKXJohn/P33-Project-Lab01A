package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item2:
                Toast.makeText(this, "Budget", Toast.LENGTH_SHORT).show();
                Intent myintent1 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(myintent1);
               // Toast.makeText(this, "Item 1 is selected", Toast.LENGTH_SHORT).show();
                //return true;
                return false;
            case R.id.item1:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Expenses", Toast.LENGTH_SHORT).show();
                Intent myintent2 = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(myintent2);
                return false;
            case R.id.item4:
                Toast.makeText(this, "Bank Info", Toast.LENGTH_SHORT).show();
                Intent myintent3 = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(myintent3);
                return false;
            case R.id.item5:
                Toast.makeText(this, "Calendar", Toast.LENGTH_SHORT).show();
                Intent myintent4 = new Intent(MainActivity.this, MainActivity5.class);
                startActivity(myintent4);
                return false;
            case R.id.item6:
                Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show();
                Intent myintent5 = new Intent(MainActivity.this, MainActivity6.class);
                startActivity(myintent5);
                return false;
        }
        return super.onOptionsItemSelected(item);
    }


}
