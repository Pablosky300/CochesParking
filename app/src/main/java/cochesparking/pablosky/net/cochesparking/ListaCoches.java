package cochesparking.pablosky.net.cochesparking;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaCoches extends RecyclerViewActivity{

    private ArrayList<String> extrasPlazas;
    private ArrayList<String> extrasModelos;
    private ArrayList<String> extrasMatriculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutManager(new LinearLayoutManager(this));

        extrasPlazas = getIntent().getStringArrayListExtra("plazas");
        extrasModelos = getIntent().getStringArrayListExtra("modelos");
        extrasMatriculas = getIntent().getStringArrayListExtra("matriculas");

        setAdapter(new AdaptadorInterno());


    }

    class AdaptadorInterno extends RecyclerView.Adapter<FilaHolder> {
        @Override
        public FilaHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
            return(new FilaHolder(getLayoutInflater()
                    .inflate(R.layout.fila, parent, false)));
        }

        @Override
        public void onBindViewHolder(FilaHolder holder, int position) {
            holder.bindModel(extrasPlazas.get(position),extrasModelos.get(position),extrasMatriculas.get(position));
        }

        @Override
        public int getItemCount() {
            return extrasPlazas.size();
        }

    }
    static class FilaHolder extends RecyclerView.ViewHolder {
        TextView numeroPlaza = null;
        TextView Modelo = null;
        TextView Matricula = null;

        FilaHolder(View fila) {
            super(fila);
            numeroPlaza = (TextView)fila.findViewById(R.id.plazaLista);
            Modelo = (TextView)fila.findViewById(R.id.marcaLista);
            Matricula = (TextView)fila.findViewById(R.id.matriculaLista);

        }
        private void bindModel(String plaza,String modelo,String matricula) {
            if(Integer.parseInt(plaza) < 10){
                plaza = "0"+plaza;
            }
            numeroPlaza.setText(plaza);
            Modelo.setText(modelo);
            Matricula.setText(matricula);
        }
    }
}
