package com.example.eyesmart;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

public class MyCursorAdapter extends CursorAdapter {
    private LayoutInflater cursorInflater;
    private TextView number;
    private TextView name;
    private TextView card_id;
    public MyCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        cursorInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup group) {
        return cursorInflater.inflate(R.layout.user_info, group, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        number = view.findViewById(R.id.number);
        name = view.findViewById(R.id.name);
        card_id = view.findViewById(R.id.card_id);
        number.setText(cursor.getString(cursor.getColumnIndex(UserDbAdapter.KEY_NUMBER)));
        name.setText(cursor.getString(cursor.getColumnIndex(UserDbAdapter.KEY_NAME)));
        card_id.setText(cursor.getString(cursor.getColumnIndex(UserDbAdapter.KEY_CARDID)));

    }
}
