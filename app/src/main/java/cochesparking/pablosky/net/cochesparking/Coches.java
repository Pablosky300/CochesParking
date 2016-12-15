package cochesparking.pablosky.net.cochesparking;

public class Coches {
    //Numero de plaza
    private int numeroPlaza;

    public int getNumeroPlaza() {
        return numeroPlaza;
    }

    public void setNumeroPlaza(int numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }

    //Marca modelo
    private String marcaModelo;

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    //Matricula
    private String Matricula;

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    //constructor
    public Coches(int numeroPlaza, String marcaModelo, String matricula){
        this.numeroPlaza=numeroPlaza;
        this.marcaModelo=marcaModelo;
        this.Matricula=matricula;
    }
}
