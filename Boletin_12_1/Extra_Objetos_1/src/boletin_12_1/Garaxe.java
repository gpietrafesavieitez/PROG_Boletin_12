package boletin_12_1;

public class Garaxe {
    private int numeroCoches;
    private String matricula;
    
    public Garaxe(){
    }
    
    public Garaxe(int numeroCoches){
        this.numeroCoches = numeroCoches;
    }
    
    public Garaxe(int numeroCoches,String matricula){
        this.numeroCoches = numeroCoches;
        this.matricula = matricula;
    }
    
    public int getNumeroCoches(){
        return numeroCoches;
    }
    
    public String getMatricula(){
        return matricula;
    }

    public void setNumeroCoches(int numeroCoches){
        this.numeroCoches = numeroCoches;
    }
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public boolean aparcar(String matricula){
        this.matricula = matricula;
        if(this.numeroCoches < 5){
            this.numeroCoches++;
            return true;
        }else{
            return false;
        }
    }
        
}
