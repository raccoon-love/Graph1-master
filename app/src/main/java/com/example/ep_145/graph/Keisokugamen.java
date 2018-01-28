package com.example.ep_145.graph;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by ep-145 on 2017/11/16.
 */

public class Keisokugamen extends Activity {
    Calendar cale;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.keisokugamen);


        //カレンダーで今日の日付を取得
        cale = Calendar.getInstance();


        //データベースを使用、エデットテキストとボタンを関連付ける
        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();



        final EditText nameText = (EditText) findViewById(R.id.editt);
        final EditText ageText = (EditText) findViewById(R.id.editg);
        Button entryButton = (Button) findViewById(R.id.kiroku);

        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String age = ageText.getText().toString();
                ContentValues insertValues = new ContentValues();
                insertValues.put("name", name);
                insertValues.put("age", age);
                long id = db.insert("person", name, insertValues);
            }
        });


        Button detaBaseButton = (Button) findViewById(R.id.insert);
        detaBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dbIntent = new Intent(Keisokugamen.this,
                        ShowDataBase.class);
                startActivity(dbIntent);
            }
        });
    }
    //edittextを押すと日付を出す
    public void onclickcale(View view){
        // DatePickerDialogインスタンスを取得
        DatePickerDialog d_date=new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener(){
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth){
                        EditText nameText=(EditText)Keisokugamen.this.
                                findViewById(R.id.editt);
                        // Setした日付を取得する
                        nameText.setText(
                                String.format("%02d/%02d/%02d",year,monthOfYear+1,
                                        dayOfMonth));
                    }
                },
                cale.get(java.util.Calendar.YEAR),
                cale.get(java.util.Calendar.MONTH),
                cale.get(java.util.Calendar.DAY_OF_MONTH)
        );
        // ダイアログを表示する
        d_date.show();
    }

    //戻るボタンでアクティビティを終了、前アクティビティへ
    public void onBackPressed() {
        finish();
    }
}

