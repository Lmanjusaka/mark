package com.example.eyesmart;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class AdministratorActivity extends Activity {

    private UserDbAdapter dbHelper;
    private SimpleCursorAdapter dataAapter;
    private Button add_user;
    private Button search_user;
    private TextView textView_name;
    private static int REQ_1 = 1;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);
        textView_name = findViewById(R.id.text_search_name);
        add_user = findViewById(R.id.add_user);
        search_user = findViewById(R.id.search_user);


        dbHelper = new UserDbAdapter(this);
        dbHelper.open();
        //dbHelper.insertSomeUsers();
        //dbHelper.createUser("110","liuchen","1111");
        add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdministratorActivity.this, UserDetailActivity.class);
                startActivityForResult(intent,REQ_1);
            }
        });

        search_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(AdministratorActivity.this, UserDetailActivity.class);
                Cursor cursor = dbHelper.fetchUsersByName( textView_name.getText().toString());
                if (cursor.getCount() != 0){
                    if (cursor.getCount() == 1) {
                        //Toast.makeText(getApplicationContext(), "success find", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AdministratorActivity.this, UserDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("number",cursor.getString(1));
                        bundle.putString("name",cursor.getString(2));
                        bundle.putString("card_id",cursor.getString(3));
                        intent.putExtras(bundle);
                        startActivity(intent);
                        int a ,b;
                        Scanner s = new Scanner(System.in);
                        a = s.nextInt();
                        b = s.nextInt();
                        System.out.println(a);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"can not find this people",Toast.LENGTH_LONG).show();
                }


            }
        });

        displayListView();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if(requestCode == REQ_1){
                dbHelper = new UserDbAdapter(this);
                dbHelper.open();
                dbHelper.createUser(data.getStringExtra("number"),data.getStringExtra("name"),
                data.getStringExtra("card_id"),"");
            }
        }
        displayListView();
     }

    private void displayListView(){
        Cursor cursor = dbHelper.fetchAllUsers();
        MyCursorAdapter customAdapter = new MyCursorAdapter(AdministratorActivity.this, cursor, 0);
        ListView listView = findViewById(R.id.user_listView);
        listView.setAdapter(customAdapter);
    }


}
