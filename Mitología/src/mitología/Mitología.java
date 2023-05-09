package mitología;

import java.util.ArrayList;

/**
 *
 * @author a22iagorg
 */
public class Mitología {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseDatos mitologia = new BaseDatos("localhost", 3306, "mitologiabd", "root", "root");
      
        ArrayList<Dios> dioses=mitologia.getDioses();
                
        mitologia.getDioses();
        
        for (Dios dios : dioses) {
            System.out.println(dios);
        }

    }
}
