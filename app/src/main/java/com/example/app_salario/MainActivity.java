package com.example.app_salario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgGrupo;
    Button btCalc;
    EditText edSal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edSal = (EditText) findViewById(R.id.edSal);
        rgGrupo = (RadioGroup) findViewById(R.id.grupo);
        btCalc = (Button) findViewById(R.id.btCalc);

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double salario = Double.parseDouble(edSal.getText().toString());
                int op = rgGrupo.getCheckedRadioButtonId();
                double novo_salario = 0;

            if (op == R.id.rd40)
                novo_salario = salario + (salario * 0.4);

               else if (op == R.id.rd45)
                    novo_salario = salario + (salario * 0.45);

            else if (op == R.id.rd50)
                novo_salario = salario + (salario * 0.5);
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Novo salário");
                dialogo.setMessage("Seu novo salário é :R$"
                +String.valueOf(novo_salario));
                dialogo.setNeutralButton("OK",null);
                dialogo.show();
            }
        });
    }
}