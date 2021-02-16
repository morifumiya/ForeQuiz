package com.test.forequiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] QUIZ = {"アリ", "ネズミ", "人間", "ゴリラ", "クジラ"}; // 問題
    int tap = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        出題
        List<String> list = Arrays.asList(QUIZ.clone());
        Collections.shuffle(list);

        ((Button)findViewById(R.id.b0)).setText(list.get(0));
        ((Button)findViewById(R.id.b1)).setText(list.get(1));
        ((Button)findViewById(R.id.b2)).setText(list.get(2));
        ((Button)findViewById(R.id.b3)).setText(list.get(3));
        ((Button)findViewById(R.id.b4)).setText(list.get(4));
    }

    public void onButton (View v) {
        String text = ((Button)v).getText().toString();
        if(text.equals(QUIZ[tap])) {
            v.setEnabled(false); // ボタン押したらクリック不可
            tap++;
            ((TextView)findViewById(R. id. tv)).setText(tap + "正解!!"); // 正解表示
            if (tap>=5) {
                ((TextView)findViewById(R. id. tv)).setText("ゲームクリア"); // 正解表示
            }
        } else {
            ((TextView)findViewById(R. id. tv)).setText("ゲームオーバー"); // 正解表示
            ((Button)findViewById(R. id. b0)).setEnabled(false);
            ((Button)findViewById(R. id. b1)).setEnabled(false);
            ((Button)findViewById(R. id. b2)).setEnabled(false);
            ((Button)findViewById(R. id. b3)).setEnabled(false);
            ((Button)findViewById(R. id. b4)).setEnabled(false);
        }
    }
}