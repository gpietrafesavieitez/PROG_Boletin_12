package boletin_12_1;
import javax.swing.JOptionPane;

public class Boletin_12_1{
    private static Garaxe garaxe = new Garaxe(4);

    public static void main(String[] args){
        boolean esc = false; // Booleano util para salir de bucles
        double precioTarifa = 1.50, precioPagado = 0;
        if(JOptionPane.showConfirmDialog(null,"¿Aparcar coche?","Garaxe",JOptionPane.YES_NO_OPTION) == 0){ // Si elegimos aparcar coche
            do{ // Input matricula + validacion
                garaxe.setMatricula(JOptionPane.showInputDialog(null,"Escribe a matricula:","Garaxe",3));
                if(garaxe.getMatricula().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Este campo non pode quedar vacio.","Garaxe",0);
                }else{
                    esc = true;
                }
            }while(esc != true);
            if(garaxe.aparcar()){ // Si hay sitio
                long inicio = System.currentTimeMillis(); // Empezamos a contar tiempo en miliseg
                JOptionPane.showMessageDialog(null,"PRAZAS DISPOÑIBLES","Garaxe",1);
                long fin = System.currentTimeMillis(); // Paramos de contar
                long tiempo = (fin - inicio) / 1000; // Obtenemos el tiempo transcurrido en miliseg y lo convertimos a seg
                for(int i = 3; i < tiempo; i ++){ // Por cada seg se suma +0,20€ al precio base (1,50€)
                    precioTarifa += 0.20;
                }
                do{ // Input precioPagado + validacion
                    try{
                        precioPagado = Double.parseDouble(JOptionPane.showInputDialog(null,"Prezo estacionamento: " + String.format("%.2f",precioTarifa) + " €","Garaxe",3));
                        esc = true;
                    }catch(NumberFormatException e){
                    }
                    if(precioPagado < precioTarifa){
                        JOptionPane.showMessageDialog(null,"Porfavor, abone a cantidade solicitada.","Garaxe",0);
                        esc = false;
                    }
                }while(esc != true); // Si todo fue correcto imprimimos factura
                JOptionPane.showMessageDialog(null,"FACTURA:\n\n"
                                + "- MATRICULA COCHE: " + garaxe.getMatricula() + "\n"
                                        + "- TEMPO: " + tiempo + " hora (s)\n"
                                                + "- PREZO: " + String.format("%.2f",precioTarifa) + " €\n"
                                                        + "- CARTOS RECIBIDOS: " + String.format("%.2f",precioPagado) + " €\n"
                                                                + "- CARTOS DEVOLTOS: " + String.format("%.2f",(precioPagado - precioTarifa)) + " €\n\n"
                                                                        + "GRAZAS POR USAR O NOSO APARCADOIRO","Garaxe",1);
            }else{ // Si no hay sitio
                JOptionPane.showMessageDialog(null,"COMPLETO","Garaxe",2);
            }
        }
        System.exit(0);
    }
}