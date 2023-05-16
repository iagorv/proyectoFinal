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
import javax.swing.JOptionPane;

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
        String diosesSeleccionadosMitologias = "<html>";
        String query = "SELECT nombre FROM dioses WHERE ";
        boolean primeraCondicion = true;

        if (griegaSeleccionada) {
            query += "idMitologia = '1'";
            primeraCondicion = false;
        }
        if (egipciaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '2'";
            primeraCondicion = false;
        }
        if (nórdicaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '3'";
            primeraCondicion = false;
        }

        if (japonesaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '4'";
            primeraCondicion = false;
        }
        if (mayaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '5'";
            primeraCondicion = false;
        }
        if (hindúSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '6'";
            primeraCondicion = false;
        }
        if (chinaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '7'";
            primeraCondicion = false;
        }
        if (babilónicaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '8'";
            primeraCondicion = false;
        }
        if (yorubaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '9'";
            primeraCondicion = false;
        }
        if (eslavaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '10'";
            primeraCondicion = false;
        }
        if (polinesiaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '11'";
            primeraCondicion = false;
        }
        if (celtaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '12'";
        }

        try ( Connection conexion = DriverManager.getConnection(cadeaConexion,
                bdUser, bdPassword);  PreparedStatement ps = conexion.prepareStatement(query)) {

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                diosesSeleccionadosMitologias = diosesSeleccionadosMitologias
                        + result.getString(1) + "<br>";
            }
            diosesSeleccionadosMitologias += "</html>";
            return diosesSeleccionadosMitologias;
        } catch (SQLException d) {

            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSLQState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
            return null;

        }

    }

    public String getMitosSeleccionadosMitologia(boolean griegaSeleccionada, boolean egipciaSeleccionada, boolean nórdicaSeleccionada, boolean japonesaSeleccionada, boolean mayaSeleccionada, boolean hindúSeleccionada, boolean chinaSeleccionada, boolean babilónicaSeleccionada, boolean yorubaSeleccionada, boolean eslavaSeleccionada, boolean polinesiaSeleccionada, boolean celtaSeleccionada) {
        String mitosSeleccionadosMitologias = "<html>";
        String query = "SELECT nombre FROM mitos WHERE ";
        boolean primeraCondicion = true;

        if (griegaSeleccionada) {
            query += "idMitologia = '1'";
            primeraCondicion = false;
        }
        if (egipciaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '2'";
            primeraCondicion = false;
        }
        if (nórdicaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '3'";
            primeraCondicion = false;
        }

        if (japonesaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '4'";
            primeraCondicion = false;
        }
        if (mayaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '5'";
            primeraCondicion = false;
        }
        if (hindúSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '6'";
            primeraCondicion = false;
        }
        if (chinaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '7'";
            primeraCondicion = false;
        }
        if (babilónicaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '8'";
            primeraCondicion = false;
        }
        if (yorubaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '9'";
            primeraCondicion = false;
        }
        if (eslavaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '10'";
            primeraCondicion = false;
        }
        if (polinesiaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '11'";
            primeraCondicion = false;
        }
        if (celtaSeleccionada) {
            if (!primeraCondicion) {
                query += " OR ";
            }
            query += "idMitologia = '12'";
        }

        try ( Connection conexion = DriverManager.getConnection(cadeaConexion,
                bdUser, bdPassword);  PreparedStatement ps = conexion.prepareStatement(query)) {

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                mitosSeleccionadosMitologias = mitosSeleccionadosMitologias + result.getString(1) + "<br>";
            }
            mitosSeleccionadosMitologias += "</html>";

            return mitosSeleccionadosMitologias;
        } catch (SQLException d) {

            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSLQState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
            return null;

        }

    }

    public String getNombreDeMitologiaParaInformacionDios(String nombreDelDios) {
        String nombreMitologiaInformacion = "";
        String queryNombreMitología = "SELECT nombre FROM mitologia WHERE idMitologia = "
                + "(SELECT idMitologia FROM dioses WHERE nombre = ?)";

        try ( Connection conexion = DriverManager.getConnection(cadeaConexion, bdUser, bdPassword);  PreparedStatement ps = conexion.prepareStatement(queryNombreMitología)) {
            ps.setString(1, nombreDelDios);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                nombreMitologiaInformacion = result.getString(1);
            }
        } catch (SQLException d) {
            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSQLState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
        }

        return nombreMitologiaInformacion;
    }

    public String getDeQueEsDeidadInformacion(String nombreDelDios) {
        String deQueEsDeidadInformacion = "";
        String queryDeidadDe = "SELECT dios_de FROM dioses WHERE nombre = ?";

        try ( Connection conexion = DriverManager.getConnection(cadeaConexion, bdUser, bdPassword);  PreparedStatement ps = conexion.prepareStatement(queryDeidadDe)) {
            ps.setString(1, nombreDelDios);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                deQueEsDeidadInformacion = result.getString(1);
            }
        } catch (SQLException d) {
            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSQLState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
        }

        return deQueEsDeidadInformacion;
    }

    public String getPadreInformacion(String nombreDelDios) {
        String padre = "";
        String queryPadre = "SELECT IFNULL((SELECT nombre FROM dioses WHERE idDios"
                + " = (SELECT padre FROM dioses WHERE nombre = ?)), 'desconocido') AS padre";
        try ( Connection conexion = DriverManager.getConnection(cadeaConexion, bdUser, bdPassword);  PreparedStatement ps = conexion.prepareStatement(queryPadre)) {
            ps.setString(1, nombreDelDios);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                padre = "Su padre es " + result.getString("padre");

            }
        } catch (SQLException d) {
            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSQLState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
        }

        return padre;
    }

    public String getMadreInformacion(String nombreDelDios) {
        String madre = "";
        String queryMadre = "SELECT IFNULL((SELECT nombre FROM dioses WHERE idDios"
                + " = (SELECT madre FROM dioses WHERE nombre = ?)), 'desconocida') AS madre";
        try ( Connection conexion = DriverManager.getConnection(cadeaConexion, bdUser, bdPassword);  PreparedStatement ps = conexion.prepareStatement(queryMadre)) {
            ps.setString(1, nombreDelDios);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                madre = "su madre es " + result.getString("madre");

            }

        } catch (SQLException d) {
            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSQLState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
        }

        return madre;

    }

    public String comprobarNombre(String nombreDelDios) {
        String nombreDios = "";
        String queryNombre = "(SELECT nombre FROM dioses WHERE nombre = ?)";

        try ( Connection conexion = DriverManager.getConnection(cadeaConexion, bdUser, bdPassword);  PreparedStatement ps = conexion.prepareStatement(queryNombre)) {
            ps.setString(1, nombreDelDios);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                nombreDios = result.getString(1);
            } else {
                nombreDios = "El dios no está en la base de datos";
            }
        } catch (SQLException d) {
            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSQLState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
        }

        return nombreDios;
    }

    public String getMitossaleDiosInformacion(String nombreDelDios) {
        String mitos = "";

        String mitosSale = "select nombre from mitos where idMito=any (select idMito from aparece where idDios= (SELECT idDios FROM dioses WHERE nombre = ?))";

        try ( Connection conexion = DriverManager.getConnection(cadeaConexion,
                bdUser, bdPassword);  PreparedStatement ps = conexion.prepareStatement(mitosSale)) {
            ps.setString(1, nombreDelDios);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                mitos += result.getString(1) + "\n";
            }
        } catch (SQLException d) {
            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSQLState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
        }

        return mitos;
    }

    public String getInformacionDios(String nombreDelDios) {
        String informacionDios = "";
        String nombreMitologia = getNombreDeMitologiaParaInformacionDios(nombreDelDios);
        String deidad = getDeQueEsDeidadInformacion(nombreDelDios);
        String padre = getPadreInformacion(nombreDelDios);
        String madre = getMadreInformacion(nombreDelDios);
        String mitos = getMitossaleDiosInformacion(nombreDelDios);
        informacionDios = nombreDelDios + ", deidad de " + deidad
                + " pertenece a la mitología " + nombreMitologia + ". " + padre + " y " + madre
                + ".\nSale en los siguientes mitos:\n" + mitos;
        return informacionDios;
    }

    public String getinformacionMito(String nombreDelMito) {
        String mito = "";
        String mitosSale = "select descripcion from mitos where nombre= ?";

        try ( Connection conexion = DriverManager.getConnection(cadeaConexion,
                bdUser, bdPassword);  PreparedStatement ps = conexion.prepareStatement(mitosSale)) {
            ps.setString(1, nombreDelMito);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                mito += result.getString(1) + "\n";
            }
        } catch (SQLException d) {
            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSQLState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
        }

        return mito;
    }

    public void AñadirDios(String mitologia, String nombre, String Deidad, String nombrePadre, String nombreMadre) {

        String insertDios = "INSERT INTO dioses (nombre, dios_de, padre, madre, idMitologia) "
                + "VALUES (?, ?, "
                + "(SELECT idDios FROM dioses WHERE nombre = ?), "
                + "(SELECT idDios FROM dioses WHERE nombre = ?), "
                + "(SELECT idMitologia FROM mitologia WHERE nombre = ?))";

        try ( Connection conexion = DriverManager.getConnection(cadeaConexion, bdUser,
                bdPassword);  PreparedStatement ps = conexion.prepareStatement(insertDios)) {

            ps.setString(1, nombre);
            ps.setString(2, Deidad);
            ps.setString(3, nombrePadre);
            ps.setString(4, nombreMadre);
            ps.setString(5, mitologia);

        } catch (SQLException d) {
            System.out.println("Código de Error: " + d.getErrorCode()
                    + "\nSQLState: " + d.getSQLState()
                    + "\nMensaje: " + d.getMessage());
        }

    }

}
