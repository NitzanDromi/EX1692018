package com.example.user.ex1692018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rbhe, rbha;
    EditText etfirst, etdm;
    int type=500;
    Double first, dom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbhe= (RadioButton) findViewById(R.id.rbhe);
        rbha= (RadioButton) findViewById(R.id.rbha);
        etfirst=(EditText) findViewById(R.id.etfirst);
        etdm=(EditText) findViewById(R.id.etdm);
    }


    public void go2 (View v){
        if ((!etfirst.getText().toString().equals(""))&&(!etfirst.getText().toString().equals(".-"))&&((!etfirst.getText().toString().equals("."))&&(!etfirst.getText().toString().equals("-"))&&(!etfirst.getText().toString().equals("-.")))||
        ((!etdm.getText().toString().equals("")) &&(!etdm.getText().toString().equals(".-"))&&((!etdm.getText().toString().equals("."))&&(!etdm.getText().toString().equals("-"))&&(!etdm.getText().toString().equals("-."))||(type==500)))){
            String st = etfirst.getText().toString();
            first=Double.parseDouble(st);
            st = etdm.getText().toString();
            dom=Double.parseDouble(st);
            Intent t = new Intent(this, SecondActivity.class);
            t.putExtra("type", type);
            t.putExtra("first", first);
            t.putExtra("dom", dom);
            startActivity (t);
            if(rbhe.isChecked())
                type=1;
            else {
                if (rbha.isChecked())
                    type = 0;
                else  Toast.makeText(this, "You need to finish in order to continue", Toast.LENGTH_LONG).show();

            }
        }
        else {

            Toast.makeText(this, "Input is unavailable", Toast.LENGTH_SHORT).show();

        }
    }

    public void gocreds(View view) {
        Intent t=new Intent(this, CredsActivity.class);
        startActivity(t);
    }
}
