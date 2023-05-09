/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitología;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

/**
 *
 * @author a22iagorg
 */
public class BaseDatos {

    private String server;
    private int port;
    private String bdName;
    private String bdUser;
    private String bdPassword;
    private String cadeaConexion;

    public BaseDatos(String server, int port, String bdname, String bdUser, String bsPassword) {
        this.server = server;
        this.port = port;
        this.bdName = bdname;
        this.bdUser = bdUser;
        this.bdPassword = bsPassword;
        cadeaConexion = String.format("jdbc:mysql://%s:%d/%s", server, port, bdName);
    }

    public ArrayList<Dios> getDioses() {
        ArrayList<Dios> dioses = new ArrayList<>();
        String query = "select nombre, dios_de  from dioses";
        try ( Connection conexion = DriverManager.getConnection(
                cadeaConexion, bdUser, bdPassword);  PreparedStatement ps = conexion.prepareStatement(query)) {

            ResultSet result = ps.executeQuery(query);
            while (result.next()) {
                String name = result.getString(1);
                String deidad = result.getString(2);
                Dios d = new Dios(name, deidad, null, null);
                dioses.add(d);
            }
            return dioses;
        } catch (SQLException d) {

            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSLQState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
            return null;

        }

    }
}
