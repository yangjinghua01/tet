package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.myapplication.keybroad.KeyBoardDialogUtils;

public class MainActivity extends AppCompatActivity {
    private KeyBoardDialogUtils keyBoardDialogUtils;
    private EditText et;
    private CustomNumKeyView keyView;
    private final String TAG = "test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
//        keyBoardDialogUtils = new KeyBoardDialogUtils(this);
//        et.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                keyBoardDialogUtils.show(et);
//            }
//        });
        et .setInputType(InputType.TYPE_NULL);
        keyView = findViewById(R.id.test);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyView.setVisibility(View.VISIBLE);
            }
        });
        keyView.setOnCallBack(new CustomNumKeyView.CallBack() {
            @Override
            public void clickNum(String num) {
                Log.i(TAG, "clickNum: "+num);
                if (et.getText().toString().isEmpty()){
                    et.setText(num);
                    return;
                }
                String s  = et.getText().toString()+num;
                et.setText(s);
            }

            @Override
            public void deleteNum() {
                Log.i(TAG, "deleteNum: ");
                if (et.getText().toString().isEmpty()){
                    return;
                }
                String  s = et.getText().toString().substring(0,et.getText().toString().length()-1);
                et.setText(s);
            }
        });
        keyView.setRandomKeyBoard(true);
    }
}