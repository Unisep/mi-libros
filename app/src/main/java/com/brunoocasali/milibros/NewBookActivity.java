package com.brunoocasali.milibros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.brunoocasali.milibros.model.TarefaDAO;
import com.brunoocasali.milibros.vo.BookVO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        BookVO tarefa = new BookVO();

        tarefa.setTitle(textTitle.getText().toString());
        tarefa.setAuthor(textRate.getText().toString());

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String data = txtData.getText().toString();

        try {
            tarefa.setRate(df.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        /*
        int selectedId = radioSexGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

            Toast.makeText(MyAndroidAppActivity.this,
                radioSexButton.getText(), Toast.LENGTH_SHORT).show();
         */



        TarefaDAO dao = new TarefaDAO(this);
        dao.salvar(tarefa);

        Intent retorno = new Intent();

        setResult(RESULT_OK, retorno);
        finish();
    }
}
