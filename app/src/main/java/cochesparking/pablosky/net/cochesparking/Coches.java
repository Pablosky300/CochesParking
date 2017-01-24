package cochesparking.pablosky.net.cochesparking;

public class Coches {
    private int nPlaza;
    private String marcaModelo;
    private String matricula;

    public int getnPlaza() {
        return nPlaza;
    }

    public void setnPlaza(int nPlaza) {
        this.nPlaza = nPlaza;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    //Constructor
    public Coches(int plaza, String marca, String matric){
        this.nPlaza=plaza;
        this.marcaModelo=marca;
        this.matricula=matric;
    }
}
