package com.example.eyesmart;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eyesmart.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class EmployeesFragment extends Fragment {

    public SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private TextView mTextView;

    public List<Employee> mList;
    public EditText mEditText;

    public EmployeesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //映射布局
        View inflate = getLayoutInflater().inflate(R.layout.fragment_employees,container,false);
        //初始化组件
        this.mEditText = (EditText)inflate.findViewById(R.id.edt_search);
        this.mSwipeRefreshLayout = (SwipeRefreshLayout)inflate.findViewById(R.id.swipeRefreshLayout);
        this.mTextView = (TextView)inflate.findViewById(R.id.tv_delete_all);
        this.mSwipeRefreshLayout.setEnabled(false);
        this.mRecyclerView = (RecyclerView)inflate.findViewById(R.id.rv_employees);
        //设置RecycleView的布局方式
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setHasFixedSize(true);
        //设置数据源
        setmList();
        //为RecycleView添加适配器
        mRecyclerView.setAdapter(new EmployeesAdapter(this));

        return inflate;
    }

    public void setmList() {
        mList = new ArrayList<Employee>();
        for (int i = 0; i < 10; i++){
            Employee employee = new Employee();
            employee.setName("刘晨");
            employee.setSex("男");
            employee.setEmpno("100010");
            employee.setIdcard("123456789123456789");
            mList.add(employee);
        }


    }
}
