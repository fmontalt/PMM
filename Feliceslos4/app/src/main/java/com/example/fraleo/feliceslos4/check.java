package com.example.fraleo.feliceslos4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


public class check extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        final CheckBox Cycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        final CheckBox Teaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        final CheckBox Blogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        final Button Hobby = (Button) findViewById(R.id.btnHobby);
        final TextView TxtHobby = (TextView) findViewById(R.id.txtHobby);

        Hobby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String strMessage = "";

                if(Cycling.isChecked()){
                    strMessage = "Cycling";
                }
                if(Teaching.isChecked()){
                    strMessage = "Teaching";
                }
                if(Blogging.isChecked()){
                    strMessage = "Blogging";
                }

                TxtHobby.setText(strMessage);
            }
        });

    }*/

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        initialUISetup();
    }

    public void initialUISetup() {
        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        TextView txtHobby = (TextView) findViewById(R.id.txtHobby);
        chkBoxCycling.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxTeaching.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxBlogging.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
    }

    class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView == chkBoxCycling) {
                    showTextNotification("Cycling");
                }
                if (buttonView == chkBoxTeaching) {
                    showTextNotification("Teaching");
                }
                if (buttonView == chkBoxBlogging) {
                    showTextNotification("BlackBlogging");
                }
            }
        }
    }

    public void showTextNotification(String msgToDisplay) {
        Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }

}


