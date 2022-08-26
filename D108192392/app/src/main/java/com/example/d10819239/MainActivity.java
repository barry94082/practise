package com.example.d10819239;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener,View.OnClickListener,View.OnDragListener, CompoundButton.OnCheckedChangeListener{
    ImageView i1,i2,i3,ir; TextView rr;ToggleButton tg; EditText e;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1=(ImageView)findViewById(R.id.im1);i2=(ImageView)findViewById(R.id.im2);
        i3=(ImageView)findViewById(R.id.im3);rr=(TextView)findViewById(R.id.tv1);
        ir=(ImageView)findViewById(R.id.im_res);tg=(ToggleButton)findViewById(R.id.tg);
        tg.setOnCheckedChangeListener(this);e=(EditText)findViewById(R.id.ed1);
        i1.setOnLongClickListener(this);i2.setOnLongClickListener(this);i3.setOnLongClickListener(this);
        i1.setOnDragListener(this); i2.setOnDragListener(this); i3.setOnDragListener(this);
    }
    public void onClick(View view) {
        ImageView im=(ImageView)view; Drawable ww=im.getDrawable(); ir.setImageDrawable(ww);

    }

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        ImageView t=(ImageView)view;int x=(int)dragEvent.getX(),y=(int)dragEvent.getY();
        String ss="";
        switch (dragEvent.getAction()){
            case DragEvent.ACTION_DRAG_STARTED:
                ss+="開始座標("+x+","+y+")";t.setColorFilter(Color.BLUE);rr.setText(ss);break;
            case DragEvent.ACTION_DRAG_ENTERED:
                ss+="進入座標("+x+","+y+")";t.setColorFilter(Color.RED);rr.setText(ss);break;
            case DragEvent.ACTION_DRAG_EXITED:
                ss+="離開座標("+x+","+y+")";t.setColorFilter(Color.GREEN);rr.setText(ss);break;
            case DragEvent.ACTION_DRAG_ENDED:
                ss+="結束座標("+x+","+y+")";t.clearColorFilter();rr.setText(ss);break;
            case DragEvent.ACTION_DROP:
                ss+="放開座標("+x+","+y+")";rr.setText(ss);
                ImageView im=(ImageView)dragEvent.getLocalState();
                Drawable ww=im.getDrawable();
                im.setImageDrawable(t.getDrawable());
                t.setImageDrawable(ww);

                break;
        }
        setTitle(ss);
        return true;
    }

    @Override
    public boolean onLongClick(View view) {
        view.startDragAndDrop(null,new View.DragShadowBuilder(view),view,0);
        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String ss=e.getText().toString();
        if(ss.length() >0)
            rr.setText(ss+(b?"先生":"小姐"));
    }



}