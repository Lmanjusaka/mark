package com.example.eyesmart;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.EmployeeViewHolder>{
    final EmployeesFragment employeesFragment;

    public EmployeesAdapter(EmployeesFragment employeesFragment) {
        this.employeesFragment = employeesFragment;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        EmployeeViewHolder holder = new EmployeeViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_employee,viewGroup,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder viewHolder, int i) {
        viewHolder.tv_empno.setText(employeesFragment.mList.get(i).getEmpno());
        viewHolder.tv_sex.setText(employeesFragment.mList.get(i).getSex());
        viewHolder.tv_idcard.setText(employeesFragment.mList.get(i).getIdcard());
        viewHolder.tv_name.setText(employeesFragment.mList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return employeesFragment.mList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_name,tv_sex,tv_idcard,tv_empno,tv_telephone,tv_administrator;
        public CheckBox cb_select;

        public EmployeeViewHolder(@NonNull View itemView ) {
            super(itemView);
            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.tv_sex = itemView.findViewById(R.id.tv_sex);
            this.tv_idcard = itemView.findViewById(R.id.tv_idcard);
            this.tv_empno = itemView.findViewById(R.id.tv_empno);
            this.tv_telephone = itemView.findViewById(R.id.tv_telephone);
            this.tv_administrator = itemView.findViewById(R.id.tv_administrator);
            cb_select = itemView.findViewById(R.id.cb_select);

        }
    }



}
