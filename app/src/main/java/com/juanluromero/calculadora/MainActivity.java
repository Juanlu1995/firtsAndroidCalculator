package com.juanluromero.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultado;

    Button suma, resta, mult, div;
    Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;
    Button point, ac, erase, negativePositive, equals;

    double nums1 = 0, nums2 = 0, numsResult = 0;

    int controladorOperacion = 0, controladorVariables = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = (TextView) findViewById(R.id.resultado);
        suma = (Button) findViewById(R.id.suma);
        resta = (Button) findViewById(R.id.resta);
        mult = (Button) findViewById(R.id.mult);
        div = (Button) findViewById(R.id.div);
        num0 = (Button) findViewById(R.id.num0);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        point = (Button) findViewById(R.id.point);
        ac = (Button) findViewById(R.id.ac);
        erase = (Button) findViewById(R.id.erase);
        negativePositive = (Button) findViewById(R.id.negativePositive);
        equals = (Button) findViewById(R.id.equals);


        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = (String) resultado.getText();
                if (!vacio()) {
                    if (!texto.contains(".")) {
                        resultado.setText(texto += ".");

                    }
                }
            }
        });

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = (String) resultado.getText();
                if (vacio()) {
                    resultado.setText("0");
                } else {
                    if (texto.length() > 1) {
                        if (texto.charAt(0) == '0' && texto.charAt(1) == '.') {
                            resultado.setText(texto += 0);
                        }
                    }
                    if (texto.charAt(0) != '0') {
                        resultado.setText(texto += 0);
                    }
                }
            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNum(1);
            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNum(2);
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNum(3);
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNum(4);
            }
        });


        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNum(5);
            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNum(6);
            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNum(7);
            }
        });

        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNum(8);
            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNum(9);
            }
        });


        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums1 = 0;
                nums2 = 0;
                numsResult = 0;
                resultado.setText("0");
            }
        });

        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = (String) resultado.getText();

                if (!vacio() && texto.charAt(0) != '0') {

                    String nuevoTexto = texto.substring(0, texto.length() - 1);

                    resultado.setText(nuevoTexto);
                }
            }
        });


        negativePositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = (String) resultado.getText();

                double num;

                if (!vacio() && texto.charAt(0) != '0') {
                    num = Double.parseDouble(texto) * -1;
                    resultado.setText(num + "");
                }
            }
        });
        // @TODO equals, suma, resta, mult, div

    }





    public void addNum(int num) {
        String texto = (String) resultado.getText();
        if (vacio()) {
            resultado.setText(Integer.toString(num));
        } else {
            if (texto.charAt(0) == '0') {
                resultado.setText(Integer.toString(num));
            }else {
                resultado.setText(texto += num);
            }
        }

    }


    public boolean vacio() {
        String texto = (String) resultado.getText();

        if (texto.equals("Resultado!") || texto.length() == 0) {
            return true;
        }
        return false;
    }

}


