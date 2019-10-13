package com.example.eyesmart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    public static void addActivity(Context context) {
        context.startActivity(new Intent(context,AddActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportFragmentManager().beginTransaction().add(R.id.content_add,new EMFragment()).commit();
    }

}
