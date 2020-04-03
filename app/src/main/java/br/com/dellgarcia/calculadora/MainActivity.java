package br.com.dellgarcia.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton botoes[];
    private TextView visor;
    private boolean primeiro;
    private int n1, n2, res;
    private int op;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View v) {
            String valor = ((AppCompatButton)v).getText().toString();
            String value = visor.getText().toString();
            int number;
            try {
                number = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                number = 0;
            }

            try {

                switch (valor) {
                    case "+":
                        if(primeiro) {
                            n1 = Integer.parseInt(value);
                            primeiro = false;
                            visor.setText("");
                        } else {
                            n1 += valor.equals("")?0:number;
                        }
                        op = 1;
                        break;
                    case "/":
                        if(primeiro) {
                            n1 = Integer.parseInt(value);
                            primeiro = false;
                            visor.setText("");
                        } else {
                            n1 /= valor.equals("")?0:number;
                        }
                        op = 2;
                        break;
                    case "-":
                        if(primeiro) {
                            n1 = Integer.parseInt(value);
                            primeiro = false;
                            visor.setText("");
                        } else {
                            n1 -= valor.equals("")?0:number;
                        }
                        op = 3;
                        break;
                    case "*":
                        if(primeiro) {
                            n1 = Integer.parseInt(value);
                            primeiro = false;
                            visor.setText("");
                        } else {
                            n1 *= valor.equals("")?0:number;
                        }
                        op = 4;
                        break;
                    case "C":
                        n1 = 0;
                        n2 = 0;
                        res = 0;
                        primeiro = true;
                        visor.setText("");
                        break;
                    case "=":
                        if(!value.equals("")) {
                            n2 = Integer.parseInt(value);
                            res = op==1?n1+n2:op==2?n1/n2:op==3?n1-n2:n1*n2;
                            visor.setText(res+"");
                            primeiro = true;
                        }
                        break;
                    default:
                        visor.setText(visor.getText()+valor);
                }
            } catch (NumberFormatException e) {  }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = 0; n2 = 0; res = 0;
        primeiro = true;

        visor = findViewById(R.id.txvVisor);

        carregarBotoes();

        for(AppCompatButton botao: botoes) {
            botao.setOnClickListener(clickListener);
        }

    }

    private void carregarBotoes() {
        botoes = new AppCompatButton[16];
        botoes[0] = findViewById(R.id.btn0);
        botoes[1] = findViewById(R.id.btn1);
        botoes[2] = findViewById(R.id.btn2);
        botoes[3] = findViewById(R.id.btn3);
        botoes[4] = findViewById(R.id.btn4);
        botoes[5] = findViewById(R.id.btn5);
        botoes[6] = findViewById(R.id.btn6);
        botoes[7] = findViewById(R.id.btn7);
        botoes[8] = findViewById(R.id.btn8);
        botoes[9] = findViewById(R.id.btn9);
        botoes[10] = findViewById(R.id.btnMais);
        botoes[11] = findViewById(R.id.btnMenos);
        botoes[12] = findViewById(R.id.btnVezes);
        botoes[13] = findViewById(R.id.btnDivisao);
        botoes[14] = findViewById(R.id.btnLimpar);
        botoes[15] = findViewById(R.id.btnIgual);
    }
}
