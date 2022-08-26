package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,View.OnClickListener {
    ArrayList<CompoundButton> ss=new  ArrayList<CompoundButton>();
    TextView rr; int ch[]={R.id.cb1,R.id.cb2,R.id.cb3,R.id.cb4}; Button b1,b2;
    RadioButton hb,hm,hs,cb,cm,cs,fb,fm,fs,cob,com,cos;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rr=(TextView)findViewById(R.id.tv1);
        b1=(Button)findViewById(R.id.bt1);b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.bt2);b2.setOnClickListener(this);
        hb=(RadioButton)findViewById(R.id.rbc1);hm=(RadioButton)findViewById(R.id.rbc2);hs=(RadioButton)findViewById(R.id.rbc3);
        fb=(RadioButton)findViewById(R.id.rbh1);fm=(RadioButton)findViewById(R.id.rbh2);fs=(RadioButton)findViewById(R.id.rbh3);
        cb=(RadioButton)findViewById(R.id.rbs1);cm=(RadioButton)findViewById(R.id.rbs2);cs=(RadioButton)findViewById(R.id.rbs3);
        cob=(RadioButton)findViewById(R.id.rbb1);com=(RadioButton)findViewById(R.id.rbb2);cos=(RadioButton)findViewById(R.id.rbb3);
        for (int i=0; i<ch.length; i++){
            CheckBox c =(CheckBox)findViewById(ch[i]);
            c.setOnCheckedChangeListener(this);

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
       /* for(int i=0 ; i<ch.length; i++){
            if(compoundButton.getId()==ch[i]){
                if(b)
                    Toast.makeText(this, "第"+i+"個被點選",Toast.LENGTH_SHORT).show();

            }
        }*/
       if (b) ss.add(compoundButton); else ss.remove (compoundButton);
    }
    public void onClick(View view){
        if(view==b2){
            for(int i=0; i<ch.length; i++){CheckBox c= (CheckBox )findViewById(ch[i]);c.setChecked(false);}
            rr.setText("請點餐!!!");
        }
        if(view==b1){
            String m = getString(R.string.order);
            if(ss.size()>0){
                for(CompoundButton cp:ss){
                    m=m+"\n"+cp.getText().toString();
                }
                rr.setText(m);
            }
            else rr.setText(getString(R.string.noorder));
        }
        if(view == b1){
            String  m=getString(R.string.noorder); int k= 0, money =0,hi,ci,coi,fi;
            int hh[] = {100,90,80},ff[]={60,50,40},cc[]={50,40,30},co[]={45,35,30};
            if(ss.size() >0) {
                for (CompoundButton cp:ss) {
                    if(k ==0){m=m+cp.getText().toString(); k=1;}
                    m += "、" + cp.getText().toString();
                    if(cp.getId() == ch[0]) {
                        if(hb.isChecked()){m+="大號";hi = 0;}else if (hm.isChecked()){m+="中號";hi = 1;} else{m+="小號"; hi=2;}money += hh[hi];
                    }
                    else if(cp.getId() == ch[1]) {
                        if(fb.isChecked()){m+="大號";fi = 0;}else if (fm.isChecked()){m+="中號";fi = 1;} else{m+="小號";fi=2;} money += ff[fi];
                    }
                    else if(cp.getId() == ch[2]) {
                        if(cb.isChecked()){m+="大號";ci = 0;}else if (cm.isChecked()){m+="中號";ci = 1;} else{m+="小號";ci=2;} money += cc[ci];
                    }
                    else if(cp.getId() == ch[3]) {
                        if(cob.isChecked()){m+="大號";coi = 0;}else if (com.isChecked()){m+="中號";coi = 1;} else{m+="小號";coi=2;} money += co[coi];
                    }
                }
            }
            rr.setText(m+".應付"+money+"元");
        }
        else rr.setText(getString(R.string.noorder));
    }
}