package com.example.user.ex1692018;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public abstract class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    int x; double y;
    Intent r;
    TextView tvX, tvN, tvD, tvS;
    ListView lv;
    int type1;
    double first1;
    double dom1;
    String [] series = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sacond);
        tvX= (TextView)findViewById(R.id.tvx);
        tvN=(TextView)findViewById(R.id.tvn);
        tvD=(TextView)findViewById(R.id.tvd);
        tvS=(TextView)findViewById(R.id.tvSn);
        lv=(ListView) findViewById(R.id.lv);
        if (getIntent()!=null) {
            r = getIntent();
            type1 = r.getIntExtra("type", x);
            first1=r.getDoubleExtra("first",y);
            dom1=r.getDoubleExtra("dom",y);
            tvX.setText(Double.toString(first1));
            tvD.setText(Double.toString(dom1));
            series[0] = Double.toString(first1);
            if (type1 == 1) {
                for (int i = 1; i < 20; i++) {
                    series[i] = Double.toString(Double.parseDouble(series[i - 1]) + dom1);
                }
            } else {
                for (int i = 1; i < 20; i++) {
                    series[i] = Double.toString(Double.parseDouble(series[i - 1]) * dom1);
                }
            }
            lv.setOnItemClickListener(this);
            lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, series);
            lv.setAdapter(adp);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int n=i+1;
        tvN.setText(Double.toString(n)); double sum;
        if (type1==1)
            sum=((n*((2*first1)+dom1*(n-1)))/2);
        else{ if (dom1!=1)
            sum=((first1*(Math.pow(dom1,n))-1))/(dom1-1);
            else sum=first1*n;
        }
        tvS.setText(Double.toString(sum));
    }

    public void go1(View view) {
        Intent t=new Intent(this, MainActivity.class);
        startActivity(t);
    }

}

