package com.brunoocasali.milibros.adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.brunoocasali.milibros.R;
import com.brunoocasali.milibros.model.DatabaseConstraint;

/**
 * Created by Bruno Casali on 24/04/2015.
 */
public class BookCursorAdapter extends CursorAdapter {

    private LayoutInflater inflater;

    public BookCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);

        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return inflater.inflate(R.layout.item_view, null);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView labelTitle = (TextView) view.findViewById(R.id.label_title);
        labelTitle.setText(cursor.getString(cursor.getColumnIndex(DatabaseConstraint.COLUMN_TITLE)));

        TextView labelRate = (TextView) view.findViewById(R.id.label_rating);

        Float value = cursor.getFloat(cursor.getColumnIndex(DatabaseConstraint.COLUMN_RATE));
        if (value > 0)
            labelRate.setText(String.valueOf(value));

        TextView labelAuthor = (TextView) view.findViewById(R.id.label_author);
        labelAuthor.setText(cursor.getString(cursor.getColumnIndex(DatabaseConstraint.COLUMN_AUTHOR)));

        int status = cursor.getInt(cursor.getColumnIndex(DatabaseConstraint.COLUMN_STATUS));

        if (status == 1){
            view.setBackgroundColor(Color.parseColor("#93C47D"));
        }else if (status == 2){
            view.setBackgroundColor(Color.parseColor("#9FC5F8"));
        }else if (status == 3){
            view.setBackgroundColor(Color.parseColor("#FFE599"));
        }else {
            view.setBackgroundColor(Color.parseColor("#EA9999"));
        }
    }
}
