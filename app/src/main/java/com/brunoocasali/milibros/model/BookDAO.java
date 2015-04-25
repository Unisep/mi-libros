package com.brunoocasali.milibros.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.brunoocasali.milibros.vo.BookVO;

/**
 * Created by Bruno Casali on 24/04/2015.
 */
public class BookDAO {

    private BookHelper helper;

    public BookDAO(Context context){
        this.helper = new BookHelper(context, DatabaseConstraint.DATABASE_NAME, null, 1);
    }

    public void save(BookVO book){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DatabaseConstraint.COLUMN_TITLE, book.getTitle());
        values.put(DatabaseConstraint.COLUMN_AUTHOR, book.getAuthor());
        values.put(DatabaseConstraint.COLUMN_RATE, book.getRate());
        values.put(DatabaseConstraint.COLUMN_STATUS, book.getStatus());

        db.insert(DatabaseConstraint.TABLE_BOOKS, null, values);
        db.close();
    }

    public Cursor list(){
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] columns = {
                DatabaseConstraint.COLUMN_ID,
                DatabaseConstraint.COLUMN_TITLE,
                DatabaseConstraint.COLUMN_AUTHOR,
                DatabaseConstraint.COLUMN_RATE,
                DatabaseConstraint.COLUMN_STATUS };

        return db.query(DatabaseConstraint.TABLE_BOOKS, columns, null, null, null, null, null);
    }

    public void destroy(long id){
        SQLiteDatabase db = helper.getWritableDatabase();

        String[] condition = { String.valueOf(id) };

        db.delete(DatabaseConstraint.TABLE_BOOKS, "_id = ?", condition);
        db.close();
    }
}
