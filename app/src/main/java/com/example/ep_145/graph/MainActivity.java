package com.example.ep_145.graph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Image viewのボタンを押すと遷移、idを入れて変数を入れる
        ImageView ivlist2 = (ImageView) findViewById(R.id.btn2);
        ivlist2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// インテントのインスタンス生成 ↓List1に遷移指定
                Intent intent = new Intent(MainActivity.this, Keisokugamen.class);
// 次画面のアクティビティ起動
                startActivity(intent);
            }
        });



        //Image viewのボタンを押すと遷移、idを入れて変数を入れる
        ImageView ivlist1 = (ImageView) findViewById(R.id.btn1);
        ivlist1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// インテントのインスタンス生成 ↓List1に遷移指定
                Intent intent = new Intent(MainActivity.this, Graphgamen.class);
// 次画面のアクティビティ起動
                startActivity(intent);
            }
        });
    }
}

