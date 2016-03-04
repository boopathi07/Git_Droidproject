package com.example.fssp.button;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends Activity {

    private EditText edittext;
    String value;
     Context context=this;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String price = "priceKey";
    SharedPreferences sharedpreferences;
private TextView textviw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        //edittext = (EditText) findViewById(R.id.edittext);
        textviw=(TextView)findViewById(R.id.textview);
        edittext=(EditText)findViewById(R.id.edittext);

        final LayoutInflater inflater = this.getLayoutInflater();
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        //inflater.setView(inflater.inflate(R.layout.dialog_signin, null))
       final Random numGen = new Random();
       final ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<5; i++)
        {
            list.add(new Integer(i));
        }

       // numGen.nextInt(4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedpreferences.edit();


                Collections.shuffle(list);
                editor.putString(price,list.get(0).toString());
                String temp;
                temp=sharedpreferences.getString(price,"");
                //Log.e("list","------------>"+list.get(0).toString());
                Log.e("share","------------>"+temp+list.get(0).toString());





              /*  AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView(inflater.inflate(R.layout.dialog_signin, null));
                AlertDialog alertDialog =builder.create();
                alertDialog.show();
                alertDialog.setCanceledOnTouchOutside(true);*/

            }

        });


        edittext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                // have same code as onTouchEvent() (for the Activity) above

                int action = event.getActionMasked();

                Log.d(TAG, String.valueOf(action));

                return true;
            }
        });
    }


    }



