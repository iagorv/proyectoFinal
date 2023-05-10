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
public class DAO {

    private String server;
    private int port;
    private String bdName;
    private String bdUser;
    private String bdPassword;
    private String cadeaConexion;

    public DAO(String server, int port, String bdName, String bdUser, String bdPassword) {
        this.server = server;
        this.port = port;
        this.bdName = bdName;
        this.bdUser = bdUser;
        this.bdPassword = bdPassword;
        cadeaConexion = String.format("jdbc:mysql://%s:%d/%s", server, port, bdName);
    }

    
    
    
    

    public String getDiosesSeleccionadosMitologias(boolean griegaSeleccionada, boolean egipciaSeleccionada, boolean nórdicaSeleccionada, boolean japonesaSeleccionada, boolean mayaSeleccionada, boolean hindúSeleccionada, boolean chinaSeleccionada, boolean babilónicaSeleccionada, boolean yorubaSeleccionada, boolean eslavaSeleccionada, boolean polinesiaSeleccionada, boolean celtaSeleccionada) {
        String diosesSeleccionadosMitologias = "";
        String query = "SELECT nombre FROM dioses WHERE ";
        boolean primeraCondicion = true;

        if (griegaSeleccionada) {
            query += "idMitologia = 'Griega'";
            primeraCondicion = false;
        }
        if (egipciaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = 'Egipcia'";
            primeraCondicion = false;
        }
        if (nórdicaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = 'Nórdica'";
            primeraCondicion = false;
        }

        if (japonesaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = 'Japonesa'";
            primeraCondicion = false;
        }
        if (mayaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = 'Maya'";
            primeraCondicion = false;
        }
        if (hindúSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = 'Hindú'";
            primeraCondicion = false;
        }
        if (chinaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = 'China'";
            primeraCondicion = false;
        }
        if (babilónicaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = 'Babilónica'";
            primeraCondicion = false;
        }
        if (yorubaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = 'Yoruba'";
            primeraCondicion = false;
        }
        if (eslavaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = 'Eslava'";
            primeraCondicion = false;
        }
        if (polinesiaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = 'Polinesia'";
            primeraCondicion = false;
        }
        if (celtaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = 'Celta'";
        }

        try ( Connection conexion = DriverManager.getConnection(cadeaConexion, bdUser, bdPassword);  PreparedStatement ps = conexion.prepareStatement(query)) {

            ResultSet result = ps.executeQuery(query);
            while (result.next()) {
                diosesSeleccionadosMitologias = diosesSeleccionadosMitologias + System.lineSeparator() + result.getString(1);
            }

            return diosesSeleccionadosMitologias;
        } catch (SQLException d) {

            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSLQState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
            return null;

        }

    }

    }
