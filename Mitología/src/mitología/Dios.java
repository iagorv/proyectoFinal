/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitología;

/**
 *
 * @author a22iagorg
 */
public class Dios {
   private String nombre;
   private String dios_de;
   private String padre;
   private String madre;

    public Dios(String nombre, String dios_de, String padre, String madre) {
        this.nombre = nombre;
        this.dios_de = dios_de;
        this.padre = padre;
        this.madre = madre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDios_de() {
        return dios_de;
    }

    public void setDios_de(String dios_de) {
        this.dios_de = dios_de;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getMadre() {
        return madre;
    }

    public void setMadre(String madre) {
        this.madre = madre;
    }

    @Override
    public String toString() {
        
        return nombre+" dios de "+dios_de+"";
        
                
    }
   
    
}
