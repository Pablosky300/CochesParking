package cochesparking.pablosky.net.cochesparking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button GCoches,VCoches;
    private TextView NPlaza,MarcaModelo,Matricula;
    public int cochesIntroducidos=0;
    private Coches coche;
    ArrayList<Coches> arrayCoches = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextViews
        NPlaza = (TextView) findViewById(R.id.numeroPlaza);
        MarcaModelo = (TextView) findViewById(R.id.marcaModelo);
        Matricula = (TextView) findViewById(R.id.matricula);

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
                coche = new Coches(Integer.parseInt(NPlaza.getText().toString()),MarcaModelo.getText().toString(),Matricula.getText().toString());
                Toast.makeText(this,NPlaza.getText().toString()+" "+ MarcaModelo.getText().toString()+" "+ Matricula.getText().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.botonVerCoches:
                if(cochesIntroducidos != 0){

                }else{
                    Toast.makeText(this,"Tiene que introducir algun coche",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
