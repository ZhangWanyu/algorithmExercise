package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.myapp.function.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyActivity extends Activity implements View.OnClickListener{

    private Button mButton;
    private TextView mResultView;
    private static final String ERROR = "error";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initDate();

        mButton = (Button)findViewById(R.id.button_action);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAction();
            }
        });

        mResultView = (TextView)findViewById(R.id.textview_result);
    }

    private void initDate() {
    }

    private void doAction() {
        showResult(ListUtility.cycleList());
    }


    private void showResult(StringBuffer result) {
        mResultView.setText(result);
    }

    @Override
    public void onClick(View v){
        Stack stack = new Stack();
        stack.push(new Integer(1));
        stack.push(new Integer(2));
        stack.push(new Integer(3));


    }


}
