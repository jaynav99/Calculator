package com.example.jaynav.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Scientific extends ActionBarActivity {
    private Button basic,sin,cos,tan,complex,pie,naturalLog,logarithmic,exponential,percentage,factorial,squareRoot,power,clear,openBraces,closedBraces;
    private EditText result;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scientific);

        basic = (Button) findViewById(R.id.btnBasic);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        complex = (Button) findViewById(R.id.complex);
        pie = (Button) findViewById(R.id.pie);
        naturalLog = (Button) findViewById(R.id.logBase2);
        logarithmic = (Button) findViewById(R.id.logBase10);
        exponential = (Button) findViewById(R.id.exponential);
        percentage = (Button) findViewById(R.id.percentage);
        factorial = (Button) findViewById(R.id.factorial);
        squareRoot = (Button) findViewById(R.id.squareRoot);
        power = (Button) findViewById(R.id.power);
        openBraces = (Button) findViewById(R.id.openBrackets);
        closedBraces = (Button) findViewById(R.id.closeBrackets);
        result = (EditText) findViewById(R.id.result);
        clear = (Button) findViewById(R.id.btnClearText);

        Intent intent = getIntent();
        number = intent.getStringExtra("basicValue");
        result.setText(number);

        basic = (Button) findViewById(R.id.btnBasic);
        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Scientific.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double value = Math.sin( Math.toRadians(Double.parseDouble(result.getText().toString())));
                String finalS = value.toString().replace(".0","");
                result.setText(finalS);
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double value = Math.cos(Math.toRadians(Double.parseDouble(result.getText().toString())));
                String finalS = value.toString().replace(".0","");
                result.setText(finalS);
            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Double value = Math.tan(Math.toRadians(Double.parseDouble(result.getText().toString())));
                String finalS = value.toString().replace(".0","");
               result.setText(finalS);
            }
        });

        complex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().toString().length() < 1) {
                    Double value = Math.PI;
                    result.setText(value.toString());
                }
                else
                {
                    Double value = Double.parseDouble(result.getText().toString()) * Math.PI;
                    String finalS = value.toString().replace(".0","");
                    result.setText(finalS);
                }
            }
        });

        naturalLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double value = Math.log(Double.parseDouble(result.getText().toString()));
                String finalS = value.toString().replace(".0","");
                result.setText(finalS);
            }
        });

        logarithmic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double value = Math.log10(Double.parseDouble(result.getText().toString()));
                String finalS = value.toString().replace(".0","");
                result.setText(finalS);
            }
        });

        exponential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double value = Math.exp(Double.parseDouble(result.getText().toString()));
                String finalS = value.toString().replace(".0","");
                result.setText(finalS);
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double val1 = Double.parseDouble(result.getText().toString());
                Double value = val1/100;
                String finalS = value.toString().replace(".0","");
                result.setText(finalS);
            }
        });

        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double value = fact(Double.parseDouble(result.getText().toString()));
                String finalS = value.toString().replace(".0","");
                result.setText(finalS);
            }
        });

        squareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double value = Math.sqrt(Double.parseDouble(result.getText().toString()));
                String finalS = value.toString().replace(".0","");
                result.setText(finalS);
            }
        });

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.append("^");
                Intent intent = new Intent(Scientific.this,MainActivity.class);
                intent.putExtra("powerValue",result.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        openBraces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        closedBraces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
            }
        });


    }


    double fact(double input) {
        if (input == 0 || input == 1)
            return 1;
        else
            return fact(input-1)*input;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
