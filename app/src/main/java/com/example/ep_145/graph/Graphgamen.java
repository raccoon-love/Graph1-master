package com.example.ep_145.graph;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class Graphgamen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphgamen);




        //データベースを読み込むため
        MyOpenHelper helper = new MyOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
//
//        // queryメソッドの実行例
//        Cursor c = db.query("person", new String[] { "name", "age" }, null,
//                null, null, null, null);
//        boolean mov = c.moveToFirst();
        int b=1;

//_idとQuestionNoを比べる
        String sql = "SELECT name,age FROM person WHERE_age"+b;
        Cursor c = db.rawQuery(sql,null);
        //DBのカーソルを最初に持ってくる。(必須)
        c.moveToFirst();
        //データベースの変数をセット　　　　本当ならループ文で記載
        int age= c.getInt(c.getColumnIndex("age"));
        c.moveToNext();

        int age2= c.getInt(c.getColumnIndex("age"));
        c.moveToNext();

        int age3= c.getInt(c.getColumnIndex("age"));
        c.moveToNext();

        int age4= c.getInt(c.getColumnIndex("age"));
        c.moveToNext();

        int age5= c.getInt(c.getColumnIndex("age"));
        c.moveToNext();

        int age6= c.getInt(c.getColumnIndex("age"));
        c.moveToNext();

        int age7= c.getInt(c.getColumnIndex("age"));
        c.moveToNext();

        LineChart lineChart = (LineChart)findViewById(R.id.chart1);

        //グラフ用データ
        ArrayList<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(age,0));
        entries.add(new Entry(age2,1));
        entries.add(new Entry(age3,2));
        entries.add(new Entry(age4,3));
        entries.add(new Entry(age5,4));
        entries.add(new Entry(age6,5));
        entries.add(new Entry(age7,6));

        //データをセット
        LineDataSet dataSet = new LineDataSet(entries,"weight");





        //ラベル
        String[] labels = {"2005","2006","2007","2008","2009","2010,","2011"};

        //LineDataインスタンス生成
        LineData data = new LineData(labels,dataSet);

        //LineDataをLineChartにセット
        lineChart.setData(data);

        //説明分
        lineChart.setDescription("体重の遷移");

        //背景色
        lineChart.setBackgroundColor(Color.WHITE);

        //アニメーション
        lineChart.animateX(1200);


  //      c.close();
    //    db.close();
    }
}