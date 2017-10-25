package com.juanluromero.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView cuentas, resultado;

    Button suma, resta, mult, div;
    Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;
    Button point, ac, erase, negativePositive, equals;

    double nums1 = 0, nums2 = 0, numsResult = 0;

    int controladorOperacion = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cuentas = (TextView) findViewById(R.id.cuentas);
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
                String texto = (String) cuentas.getText();
                if (!vacio()) {
                    if (!texto.contains(".")) {
                        cuentas.setText(texto += ".");

                    }
                }
            }
        });

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = (String) cuentas.getText();
                if (vacio()) {
                    cuentas.setText("0");
                } else {
                    if (texto.length() > 1) {
                        if (texto.charAt(0) == '0' && texto.charAt(1) == '.') {
                            cuentas.setText(texto += 0);
                        }
                    }
                    if (texto.charAt(0) != '0') {
                        cuentas.setText(texto += 0);
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
                controladorOperacion = -1;
                resultado.setText("Resultado!");
                cuentas.setText("Cuentas");
            }
        });

        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = (String) cuentas.getText();

                if (!vacio() && texto.charAt(0) != '0') {

                    String nuevoTexto = texto.substring(0, texto.length() - 1);

                    cuentas.setText(nuevoTexto);
                }
            }
        });


        negativePositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = (String) cuentas.getText();

                double num;

                if (!vacio() && texto.charAt(0) != '0') {
                    num = Double.parseDouble(texto) * -1;
                    cuentas.setText(num + "");
                }
            }
        });
        // @TODO equals, suma, resta, mult, div


        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operar(1);
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operar(2);
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operar(3);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operar(4);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


    public void operar(int numOperacion) {
        try {
            nums2 = Double.parseDouble((String) cuentas.getText());
            if (controladorOperacion != -1) {
                switch (controladorOperacion) {
                    case 1:
                        numsResult = nums1 + nums2;
                        resultado.setText(Double.toString(numsResult));
                        nums1 = numsResult;
                        controladorOperacion = numOperacion;
                        cuentas.setText("");

                        break;

                    case 2:
                        numsResult = nums1 - nums2;
                        resultado.setText(Double.toString(numsResult));
                        nums1 = numsResult;
                        controladorOperacion = numOperacion;
                        cuentas.setText("");

                        break;

                    case 3:
                        numsResult = nums1 * nums2;
                        resultado.setText(Double.toString(numsResult));
                        nums1 = numsResult;
                        controladorOperacion = numOperacion;
                        cuentas.setText("");

                        break;

                    case 4:
                        try {
                            numsResult = nums1 / nums2;
                            if (Double.isInfinite(numsResult)) {
                                throw new IllegalArgumentException();
                            } else {
                                resultado.setText(Double.toString(numsResult));
                                nums1 = numsResult;
                                controladorOperacion = numOperacion;
                                cuentas.setText("");

                                break;

                            }
                        } catch (IllegalArgumentException e) {
                            Toast.makeText(MainActivity.this, "No se puede dividir por 0", Toast.LENGTH_LONG).show();
                        }

                    case 0:
                        if (controladorOperacion != 0) {
                            operar(numOperacion);
                            controladorOperacion = -1;
                            cuentas.setText("Cuentas");
                        } else {
                            Toast.makeText(MainActivity.this, "La operación ya está ejecutada", Toast.LENGTH_LONG).show();
                        }

                        break;
                }

            } else {
                controladorOperacion = numOperacion;
                nums1 = Double.parseDouble((String) cuentas.getText());
                cuentas.setText("");
            }
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "No hay numero al cual sumar", Toast.LENGTH_LONG).show();

        }
    }


    public void addNum(int num) {
        String texto = (String) cuentas.getText();
        if (vacio()) {
            cuentas.setText(Integer.toString(num));
        } else {
            if (texto.charAt(0) == '0') {
                cuentas.setText(Integer.toString(num));
            } else {
                cuentas.setText(texto += num);
            }
        }

    }


    public boolean vacio() {
        String texto = (String) cuentas.getText();

        if (texto.equals("Cuentas") || texto.length() == 0) {
            return true;
        }
        return false;
    }

}


