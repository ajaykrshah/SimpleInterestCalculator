package com.example.aksh.simpleinterestcalculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText p,n,r;
    TextView i;
    Button cal;
    String [] font = {"","1.TTF","2.TTF","3.TTF","4.TTF","5.TTF","6.TTF","7.TTF","8.TTF" }; //TypeFace fonts
    String [] bg ={"@drawable\\screen.png"};
    Typeface typeface;
    SharedPreferences preferences ;
    int j;
    RelativeLayout back;

    public void initilizer() {

        p = (EditText)findViewById(R.id.etP);
        n = (EditText)findViewById(R.id.etN);
        r = (EditText)findViewById(R.id.etR);
        i= (TextView)findViewById(R.id.tv);
        cal = (Button)findViewById(R.id.calBtn);
        back = (RelativeLayout)findViewById(R.id.back);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initilizer();
        setFont();
        setBackground();
    }




    @Override
    public void onClick(View v) {

      try {
          Double P = Double.valueOf(p.getText().toString());
          Double N = Double.valueOf(n.getText().toString());
          Double R = Double.valueOf(r.getText().toString());

          String Ans = String.valueOf((P*N*R)/100);
          i.setText("Interest = "+Ans);
      }
        catch (Exception e)
                {
                    e.printStackTrace();
                }


        // hiding Keyboard after click..
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(n.getWindowToken(), 0);

    }



    public void setBackground() {


        preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        j = Integer.parseInt(preferences.getString("backgroundList", "1"));

        //typeface = Typeface.createFromAsset(getAssets(), bg[j]);

       // back.setBackground();


    }


    // TypeFace settings

    public void setFont() {


        preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        j = Integer.parseInt(preferences.getString("fontList", "4"));

        typeface = Typeface.createFromAsset(getAssets(), font[j]);


        i.setTypeface(typeface);
        p.setTypeface(typeface);
        n.setTypeface(typeface);
        r.setTypeface(typeface);
        cal.setTypeface(typeface);


    }


    //////  For Menu ...


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_sic_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;
        switch (item.getItemId())
                {
                    case R.id.about :
                                            intent = new Intent("About");
                                            startActivity(intent);
                        break;


                    case R.id.settings :
                                            intent = new Intent("Settings");
                                           startActivity(intent);
                        break;


                    case R.id.contact :

                                            intent = new Intent("Contact");
                                            startActivity(intent);
                        break;


                    case R.id.exit :
                                            finish();
                        break;
                 }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setFont();
    }


///On Pause

    @Override
    protected void onPause() {
        super.onPause();


    }
}
