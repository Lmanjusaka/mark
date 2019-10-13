package com.example.eyesmart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arclibrary.RegisterAndRecognizeActivity;

public class UserDetailActivity extends AppCompatActivity {

    private TextView name;
    private TextView card_id;
    private TextView number;
    private ImageView imageView;
    private static int REQ_1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail_info);
        Intent intent = getIntent();
        number = findViewById(R.id.detail_num);
        name = findViewById(R.id.detail_name);
        card_id = findViewById(R.id.detail_card_id);
        imageView = findViewById(R.id.img_detail);
        if(intent.getExtras() != null){
            number.setText(intent.getExtras().get("number").toString());
            name.setText(intent.getExtras().get("name").toString());
            card_id.setText(intent.getExtras().get("card_id").toString());
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDetailActivity.this, RegisterAndRecognizeActivity.class);
                startActivityForResult(intent, REQ_1);
            }
        });



    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
            Intent data = new Intent();
            data.putExtra("number",number.getText().toString());
            data.putExtra("name",name.getText().toString());
            data.putExtra("card_id",card_id.getText().toString());
            this.setResult(RESULT_OK,data);
        this.finish();
    }
}
