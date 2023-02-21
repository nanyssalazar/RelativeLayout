package edu.iest.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Button bnRegresar = findViewById(R.id.bnRegresar);
        TextView valorCanal = findViewById(R.id.valorCanal);
        TextView valorPrograma = findViewById(R.id.valorPrograma);

        bnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DatosActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        if(getIntent() != null){
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                String canal = extras.getString("canal");
                String programa = extras.getString("programa");
                valorCanal.setText(canal);
                valorPrograma.setText(programa);
                Snackbar.make(bnRegresar,"lo obtenido es " + canal, Snackbar.LENGTH_LONG).show();
                Snackbar.make(bnRegresar,"lo obtenido es " + programa, Snackbar.LENGTH_LONG).show();
            }
        }
    }
}