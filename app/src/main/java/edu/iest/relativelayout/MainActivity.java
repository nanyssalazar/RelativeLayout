package edu.iest.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView ivMinion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bnMinion = findViewById(R.id.minionBoton);
        EditText etMinion = findViewById(R.id.editMinion);
        TextView tvMinion = findViewById(R.id.textoCentral);

        Spinner spProgramas = findViewById(R.id.spinnerMinion);
        ivMinion = findViewById(R.id.minionBob);

        spProgramas.setOnItemSelectedListener(this);


        bnMinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // aqui la logica que hacer al dar clicks
                // obtendremmos el valor del EditText y lo asignaremos al TextView inferior
                String texto = etMinion.getText().toString();
                Toast.makeText(MainActivity.this, "El valor era " + texto, Toast.LENGTH_LONG);
                tvMinion.setText(texto);
            }
        });

        ivMinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spProgramas = findViewById(R.id.spinnerMinion);
                EditText etMinion = findViewById(R.id.editMinion);

                Intent i = new Intent(MainActivity.this, DatosActivity.class);
                i.putExtra("canal",etMinion.getText().toString());
                i.putExtra("programa",spProgramas.getSelectedItem().toString());
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {
        String programa = adapterView.getItemAtPosition(posicion).toString();
        Snackbar.make(adapterView, "Programa seleccionado" + programa,
                Snackbar.LENGTH_LONG).show();

        if(posicion==0){
            ivMinion.setImageResource(R.drawable.minionbob);
        } else if(posicion==1){
            ivMinion.setImageResource(R.drawable.minionbob2);
        } else {
            ivMinion.setImageResource(R.drawable.minion_bob_3);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}