package cochesparking.pablosky.net.cochesparking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertarCoche extends AppCompatActivity implements View.OnClickListener{

    private Button GCoches,VCoches;
    private TextView NPlaza,Matricula,CochesTotales;
    private AutoCompleteTextView MarcaModelo;
    public int cochesIntroducidos=0;
    private ArrayList<String> arrayPlazas = new ArrayList<String>();
    private ArrayList<String> arrayModelos = new ArrayList<String>();
    private ArrayList<String> arrayMatriculas = new ArrayList<String>();
    public static final String[] items = {"Ford Mondeo","Ford Focus","Renault Scenic","Opel","Opel Aguila","Peugeot 307",
            "Toyota land Cruiser","Toyota Aygo","Opel Astra","Nissan Ibiza","Rover ZT","BMW","Renault Megane","Jeep Limited CRD",
            "Hyundai getz","Citrone C1","Chrysler","Opel Zafira","VolksWagen GT-R","VolksWagen Polo","Wauxhall Zafira","Renault Clio",
            "Mercedes slk 320","Opel Corsa","Renault trafic","Skoda Yeti","Fiat Punto","VolksWagen Caravelle","Seat Cordoba",
            "Opel Antara"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertar_coches);

        //TextViews
        NPlaza = (TextView) findViewById(R.id.numeroPlaza);
        MarcaModelo = (AutoCompleteTextView) findViewById(R.id.marcaModelo);
        MarcaModelo.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,
                items));
        Matricula = (TextView) findViewById(R.id.matricula);
        CochesTotales = (TextView) findViewById(R.id.numeroDeCoches);

        //Buttons
        GCoches = (Button) findViewById(R.id.botonGuardarCoches);
        GCoches.setOnClickListener(this);
        VCoches = (Button) findViewById(R.id.botonVerCoches);
        VCoches.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonGuardarCoches:
                try {
                    arrayPlazas.add(NPlaza.getText().toString());
                    arrayModelos.add(MarcaModelo.getText().toString());
                    arrayMatriculas.add(Matricula.getText().toString());

                    NPlaza.setText("");
                    MarcaModelo.setText("");
                    Matricula.setText("");
                    cochesIntroducidos++;
                    CochesTotales.setText("Numero de coches introducidos: " + cochesIntroducidos);
                    Toast.makeText(this, "Coche introducido correctamente", Toast.LENGTH_SHORT).show();
                }catch (Exception e){ Toast.makeText(this, "Tiene que rellenar todos los campos", Toast.LENGTH_SHORT).show(); }
                break;
            case R.id.botonVerCoches:
                if(cochesIntroducidos != 0){
                    Intent i = new Intent(this, ListaCoches.class);

                    i.putExtra("plazas",arrayPlazas);
                    i.putExtra("modelos",arrayModelos);
                    i.putExtra("matriculas",arrayMatriculas);
                    startActivity(i);
                }else{
                    Toast.makeText(this,"Tiene que introducir algun coche",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
