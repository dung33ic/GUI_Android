package com.sct.dung.gui_android;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button btn1,btn2;
    CheckBox cb1, cb2, cb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.idBtn1);
        btn2 = (Button)findViewById(R.id.idBtn2);
        cb1 = (CheckBox)findViewById(R.id.checkBox1);
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        cb3 = (CheckBox)findViewById(R.id.checkBox3);

        /*Bắt sự kiện click vào textview hiển thị thông điệp chào mừng trong 1s */
        textView = (TextView)findViewById(R.id.idtxt1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myvar = textView.getText().toString();
                Toast.makeText(getApplicationContext(),myvar,Toast.LENGTH_SHORT).show();
            }
        });
        /* Event của EditText */
        editText = (EditText)findViewById(R.id.idtxt2);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = editText.getText().toString();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        /*Su kien cua RadioGroup*/
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioBtn1:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                    case R.id.radioBtn2:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFFF00"));
                        break;
                    case R.id.radioBtn3:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF00FF"));
                        break;
                    case R.id.radioBtn4:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
                        break;
                }
            }
        });

    }
    /*Event cua Button */
    public void btnClick(View v){
        Toast.makeText(this,"Button was click",Toast.LENGTH_SHORT).show();
    }

    public void btnClickMe(View v){
        if(cb1.isChecked()==true && cb2.isChecked()==true && cb3.isChecked()==true){
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFFFFF"));
        }else if(cb1.isChecked()==true && cb2.isChecked()==true){
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFFF00"));
        }else if(cb1.isChecked()==true && cb3.isChecked()==true){
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF00FF"));
        }else if(cb2.isChecked()==true && cb3.isChecked()==true){
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FFFF"));
        }else if(cb1.isChecked()==true){
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
        }else if(cb2.isChecked()==true){
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00FF00"));
        }else if(cb3.isChecked()==true){
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#0000FF"));
        }else{
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#000000"));
        }
    }
}
