package com.example.jaynav.calculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private Button advanced,one,two,three,four,five,six,seven,eight,nine,zero,subtract,add,multiply,divide,dot,equals,clear;
        private EditText result;
        String powerValue;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        advanced = (Button) findViewById(R.id.btnScientific);
        one = (Button) findViewById(R.id.num1);
        two = (Button) findViewById(R.id.num2);
        three = (Button) findViewById(R.id.num3);
        four = (Button) findViewById(R.id.num4);
        five = (Button) findViewById(R.id.num5);
        six = (Button) findViewById(R.id.num6);
        seven = (Button) findViewById(R.id.num7);
        eight = (Button) findViewById(R.id.num8);
        nine = (Button) findViewById(R.id.num9);
        zero = (Button) findViewById(R.id.num0);
        subtract = (Button) findViewById(R.id.subtract);
        add = (Button) findViewById(R.id.add);
        divide = (Button) findViewById(R.id.division);
        multiply = (Button) findViewById(R.id.multiply);
        dot = (Button) findViewById(R.id.dot);
        equals = (Button) findViewById(R.id.equals);
        result = (EditText) findViewById(R.id.result);
        clear = (Button) findViewById(R.id.btnClearText);

            Intent intent = getIntent();
            powerValue = intent.getStringExtra("powerValue");
            result.setText(powerValue);

        final Editable str =  result.getText();

        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Scientific.class);
                intent.putExtra("basicValue",str.toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    str.append("1");
                    result.setText(str);
            }
            });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    str.append("2");
                    result.setText(str);

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    str.append("3");
                    result.setText(str);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    str.append("4");
                    result.setText(str);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    str.append("5");
                    result.setText(str);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    str.append("6");
                    result.setText(str);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    str.append("7");
                    result.setText(str);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    str.append("8");
                    result.setText(str);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    str.append("9");
                    result.setText(str);

            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    str.append("0");
                    result.setText(str);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    dot.setEnabled(true);
                    str.append("+");
                    result.setText(str);
                    subtract.setEnabled(false);
                    divide.setEnabled(false);
                    multiply.setEnabled(false);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    dot.setEnabled(true);
                    str.append("-");
                    result.setText(str);
                add.setEnabled(false);
                divide.setEnabled(false);
                multiply.setEnabled(false);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    dot.setEnabled(true);
                    str.append("/");
                    result.setText(str);
                add.setEnabled(false);
                multiply.setEnabled(false);
                subtract.setEnabled(false);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    dot.setEnabled(true);
                    str.append("*");
                    result.setText(str);
                add.setEnabled(false);
                subtract.setEnabled(false);
                divide.setEnabled(false);
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        str.append(".");
                        result.setText(str);
                        dot.setEnabled(false);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot.setEnabled(true);
                result.setText("");
                str.clear();
                add.setEnabled(true);
                subtract.setEnabled(true);
                divide.setEnabled(true);
                multiply.setEnabled(true);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String operation = str.toString();

                if(operation.contains("+"))
                {
                    String[] value = operation.split("\\+");
                    Double val1 = Double.parseDouble(value[0].trim());
                    Double val2 = Double.parseDouble(value[1].trim());
                    Double finalVal =  val1 + val2;
                    str.clear();
                    str.append(finalVal.toString());
                    String finalS = finalVal.toString().replace(".0","");
                    result.setText(finalS);

                }
                else if(operation.contains("-"))
                {
                    String[] value = operation.split("\\-");
                    Double val1 = Double.parseDouble(value[0].trim());
                    Double val2 = Double.parseDouble(value[1].trim());
                    Double finalVal =  val1 - val2;
                    str.clear();
                    str.append(finalVal.toString());
                    String finalS = finalVal.toString().replace(".0","");
                    result.setText(finalS);
                }
                else if(operation.contains("*"))
                {
                    String[] value = operation.split("\\*");
                    Double val1 = Double.parseDouble(value[0].trim());
                    Double val2 = Double.parseDouble(value[1].trim());
                    Double finalVal =  val1 * val2;
                    str.clear();
                    str.append(finalVal.toString());
                    String finalS = finalVal.toString().replace(".0","");
                    result.setText(finalS);
                }
                else if(operation.contains("/"))
                {
                    String[] value = operation.split("\\/");
                    Double val1 = Double.parseDouble(value[0].trim());
                    Double val2 = Double.parseDouble(value[1].trim());
                    Double finalVal =  val1 / val2;
                    str.clear();
                    str.append(finalVal.toString());
                    String finalS = finalVal.toString().replace(".0","");
                    result.setText(finalS);
                }
                else if(operation.contains("^"))
                {
                    String[] value = operation.split("\\^");
                    Double val1 = Double.parseDouble(value[0].trim());
                    Double val2 = Double.parseDouble(value[1].trim());
                    Double finalVal = Math.pow(val1,val2);
                    str.clear();
                    str.append(finalVal.toString());
                    String finalS = finalVal.toString().replace(".0","");
                    result.setText(finalS);
                }
                add.setEnabled(true);
                subtract.setEnabled(true);
                divide.setEnabled(true);
                multiply.setEnabled(true);
            }
        });
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
