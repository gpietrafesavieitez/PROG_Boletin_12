package boletin_12_1;
import javax.swing.JOptionPane;

public class Boletin_12_1{
    private static Garaxe garaxe = new Garaxe();

    public static void main(String[] args){
        int n = JOptionPane.showConfirmDialog(null,"¿Aparcar coche?","Garaxe",JOptionPane.YES_NO_OPTION);
        
        if(n == 0){ // Si elegimos aparcar coche
            String matricula = JOptionPane.showInputDialog(null,"Escribe a matricula:","Garaxe",3);
            if(garaxe.aparcar(matricula)){ // Si hay sitio
                long inicio = System.currentTimeMillis();
                JOptionPane.showMessageDialog(null,"PLAZAS DISPOÑIBLES","Garaxe",1);
                long fin = System.currentTimeMillis();
                long tiempo = (fin - inicio) / 1000;
                double precioTarifa = 1.50;
                double precioPagado = Double.parseDouble(JOptionPane.showInputDialog(null,"Precio estacionamiento: " + precioTarifa + " €","Garaxe",3));
                JOptionPane.showMessageDialog(null,"FACTURA:\n"
                        + "MATRICULA COCHE: " + garaxe.getMatricula() + "\n"
                                + "TEMPO: " + tiempo + " segundos.\n"
                                        + "PRECIO: " + precioTarifa + " €\n"
                                                + "CARTOS RECIBIDOS: " + precioPagado + " €\n"
                                                        + "CARTOS DEVOLTOS: " + (precioPagado - precioTarifa) + " €"
                        ,"Garaxe",1);
                JOptionPane.showMessageDialog(null,"GRAZAS POR USAR O NOSO APARCADOIRO","Garaxe",1);
            }else{ 
                JOptionPane.showMessageDialog(null,"COMPLETO","Garaxe",2);
            }
        }else{ // Si elegimos no
            System.exit(0);
        }
    }
}