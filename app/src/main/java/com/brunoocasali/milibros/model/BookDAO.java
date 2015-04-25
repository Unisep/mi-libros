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

        ContentValues valores = new ContentValues();
        valores.put("titulo", book.getTitle());
        valores.put("descricao", book.getAuthor());
        valores.put("prazo", book.getRate().getTime());

        db.insert("tarefas", null, valores);
        db.close();
    }

    public Cursor listar(){
        // Comunicação somente leitura com o banco.
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] colunas = {"_id", "titulo", "descricao", "prazo"};

        return db.query("tarefas", colunas, null, null, null, null, null);
    }

    public void excluir(long id){

        SQLiteDatabase db = helper.getWritableDatabase();

        String[] valoresWhere = {String.valueOf(id)};

        db.delete("tarefas", "_id = ?", valoresWhere);
        db.close();
    }
}
