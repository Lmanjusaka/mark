package com.example.eyesmart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ManageActivity extends AppCompatActivity implements OnClickListener{
    private DrawerLayout mdrawerLayout;
    private ImageButton mimageButton;
    private LinearLayout mlinearLayout;
    private TextView mtv_manage;
    private TextView mtv_record;
    private TextView mtv_import;
    private TextView mtv_add;
    private TextView mtv_delete;
    private TextView mtv_export;
    private FragmentManager mfragmentManager;
    private EmployeesFragment memployeesFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        /*ListView listView = (ListView)findViewById(R.id.lv_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,
                new String[]{"菜单1","菜单2","菜单3","菜单4"});
        listView.setAdapter(adapter);*/
        init();
        mfragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mfragmentManager.beginTransaction();

        memployeesFragment = new EmployeesFragment();
        fragmentTransaction.add(R.id.content_manage,memployeesFragment);
        fragmentTransaction.commit();


    }

    private void init(){
        mtv_add = findViewById(R.id.tv_add);
        mdrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mimageButton = (ImageButton)findViewById(R.id.ib_menu);
        mtv_manage = (TextView)findViewById(R.id.tv_manage);
        mtv_record = (TextView)findViewById(R.id.tv_record);
        mtv_delete = findViewById(R.id.tv_delete);
        mtv_import = findViewById(R.id.tv_import);
        mtv_add.setOnClickListener(this);
        mimageButton.setOnClickListener(this);
        mtv_manage.setOnClickListener(this);
        mtv_record.setOnClickListener(this);
        mfragmentManager = getSupportFragmentManager();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_add:
                Intent intent = new Intent(ManageActivity.this,AddActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_manage:
                mtv_manage.setSelected(true);
                mtv_record.setSelected(false);
                findViewById(R.id.ll_appbar_employee).setVisibility(View.VISIBLE);
                mtv_add.setVisibility(View.VISIBLE);
                mtv_delete.setVisibility(View.VISIBLE);
                mtv_import.setVisibility(View.VISIBLE);
                findViewById(R.id.view_interval).setVisibility(View.VISIBLE);
                findViewById(R.id.view_interval1).setVisibility(View.VISIBLE);
                findViewById(R.id.ll_appbar_record).setVisibility(View.GONE);
                if (memployeesFragment == null){
                    memployeesFragment = new EmployeesFragment();
                    mfragmentManager.beginTransaction().add(R.id.content_manage,memployeesFragment).commit();
                }
                break;
            case R.id.tv_record:
                break;

        }

    }


}
