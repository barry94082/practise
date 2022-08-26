package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , CompoundButton.OnCheckedChangeListener,RadioGroup.OnCheckedChangeListener{
    Button b1,b2,b3; TextView res; ImageView i_h,i_f,i_c,i_s; CheckBox c1,c2,c3,c4;String ss="",s1="點餐結果:";
    String siz1[]={"大號","忠昊","小號"}; int hi=0, fi=0 ,coli=0,corni=0;
    int hh[]={90,80,70},fren[]={55,45,35},cola[]={60,50,40},corn[]={70,60,50};
    RadioGroup r1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);b2=(Button)findViewById(R.id.button2);b3=(Button)findViewById(R.id.button3);
        b1.setOnClickListener(this);b2.setOnClickListener(this);b3.setOnClickListener(this);
        res=(TextView)findViewById(R.id.tv2); i_h=(ImageView)findViewById(R.id.imhh);
        i_f=(ImageView)findViewById(R.id.imff);i_c=(ImageView)findViewById(R.id.imcc);
        i_s=(ImageView)findViewById(R.id.imuu);
        c1=(CheckBox)findViewById(R.id.chh);c2=(CheckBox)findViewById(R.id.chf);
        c3=(CheckBox)findViewById(R.id.chu);c4=(CheckBox)findViewById(R.id.chc);
        c1.setOnCheckedChangeListener(this);c2.setOnCheckedChangeListener(this);
        c3.setOnCheckedChangeListener(this);c4.setOnCheckedChangeListener(this);
        r1=(RadioGroup)findViewById(R.id.rg);
        r1.setOnCheckedChangeListener(this);
    }

    ArrayList<CompoundButton> sel=new ArrayList<CompoundButton>();
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b)sel.add(compoundButton);else sel.remove(compoundButton);
    }
    public void onClick(View view) {
        if(view==b1){
            if(c1.isChecked())i_h.setVisibility(View.VISIBLE);
            else i_h.setVisibility(View.GONE);
            if(c2.isChecked())i_f.setVisibility(View.VISIBLE);
            else i_f.setVisibility(View.GONE);
            if(c3.isChecked())i_s.setVisibility(View.VISIBLE);
            else i_s.setVisibility(View.GONE);
            if(c4.isChecked())i_c.setVisibility(View.VISIBLE);
            else i_c.setVisibility(View.GONE);

            int i=0 ,money=0; ss="";
            for(CompoundButton s: sel){
                if(i==0){i=1; ss+=s.getText().toString();}else{ss+="`"+s.getText().toString();}
                if(s==c1){ss+= siz1[hi];money+=hh[hi];}
                if(s==c2){ss+= siz1[fi];money+=fren[fi];}
                if(s==c3){ss+= siz1[coli];money+=cola[coli];}
                if(s==c4){ss+= siz1[corni];money+=corn[corni];}
                }

            Toast.makeText(this,""+sel.size(),Toast.LENGTH_LONG).show();res.setText(s1+ss);
    }


        if(view==b2){
            c1.setChecked(false);  c2.setChecked(false);  c3.setChecked(false);  c4.setChecked(false);
            res.setText(s1+ss);sel.clear();
            Toast.makeText(this,""+sel.size(),Toast.LENGTH_LONG).show();
            ((RadioButton)findViewById(R.id.radioButton)).setChecked(true);
            i_c.setVisibility(View.GONE);i_h.setVisibility(View.GONE);
            i_f.setVisibility(View.GONE);
            i_s.setVisibility(View.GONE);

        }
        if(view==b3){
            finish();

        }


}

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i==R.id.rg)hi=fi=coli=corni=0; if(i==R.id.radioButton2)hi=fi=coli=corni=1;if(i==R.id.radioButton3)hi=fi=coli=corni=2;
    }
}


