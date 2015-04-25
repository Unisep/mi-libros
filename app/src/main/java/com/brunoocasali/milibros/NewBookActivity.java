package com.brunoocasali.milibros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.brunoocasali.milibros.model.BookDAO;
import com.brunoocasali.milibros.vo.BookVO;

/**
 * Created by Bruno Casali on 24/04/2015.
 */
public class NewBookActivity extends Activity {

    private EditText textTitle;
    private EditText textRate;
    private EditText textAuthor;
    private RadioGroup radioGroupStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);

        Intent intent = getIntent();

        textTitle = (EditText) findViewById(R.id.text_title);
        textRate = (EditText) findViewById(R.id.text_rate);
        textAuthor = (EditText) findViewById(R.id.text_author);
        radioGroupStatus = (RadioGroup) findViewById(R.id.radio_group);
    }

    public void save(View v) {
        BookVO book = new BookVO();

        int selectedId = radioGroupStatus.getCheckedRadioButtonId();
        int status = 1;

        if (selectedId == R.id.radio_want){
            status = 2;
        }else if (selectedId == R.id.radio_already){
            status = 3;
        }else if (selectedId == R.id.radio_quit){
            status = 4;
        }

        book.setStatus(status);
        book.setTitle(textTitle.getText().toString());
        book.setAuthor(textAuthor.getText().toString());
        book.setRate(Float.valueOf(textRate.getText().toString()));
        BookDAO dao = new BookDAO(this);
        dao.save(book);

        Intent result = new Intent();

        setResult(RESULT_OK, result);
        finish();
    }
}
