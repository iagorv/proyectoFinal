/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mitología;

import java.awt.CardLayout;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author a22iagorg
 */
public class InterfazF extends javax.swing.JFrame {

    /**
     * Creates new form prueba
     */
    public InterfazF() {
        initComponents();

    }
    DAO mitologia = new DAO("localhost", 3306, "mitologiabd", "root", "root");

    private void cambiarCard(String card) {
        CardLayout cardL = (CardLayout) panelPrincipal.getLayout();
        cardL.show(panelPrincipal, card);
    }

    public void mostrarDiosesSeleccionados() {
        String diosesSeleccionados = "";
        boolean griegaSeleccionada = Griega.isSelected();
        boolean egipciaSeleccionada = Egipcia.isSelected();
        boolean nórdicaSeleccionada = Nórdica.isSelected();
        boolean japonesaSeleccionada = Japonesa.isSelected();
        boolean mayaSeleccionada = Maya.isSelected();
        boolean hindúSeleccionada = Hindú.isSelected();
        boolean chinaSeleccionada = China.isSelected();
        boolean babilónicaSeleccionada = Babilónica.isSelected();
        boolean yorubaSeleccionada = Yoruba.isSelected();
        boolean eslavaSeleccionada = Eslava.isSelected();
        boolean polinesiaSeleccionada = Polinesia.isSelected();
        boolean celtaSeleccionada = Celta.isSelected();

        diosesSeleccionados = mitologia.getDiosesSeleccionadosMitologias(griegaSeleccionada,
                egipciaSeleccionada, nórdicaSeleccionada, japonesaSeleccionada, mayaSeleccionada,
                hindúSeleccionada, chinaSeleccionada, babilónicaSeleccionada,
                yorubaSeleccionada, eslavaSeleccionada, polinesiaSeleccionada, celtaSeleccionada);

        textoDioses.setText(diosesSeleccionados);

    }

    public void mostrarMitosSeleccionados() {
        String mitosSeleccionados = "";
        boolean griegaSeleccionada = Griega.isSelected();
        boolean egipciaSeleccionada = Egipcia.isSelected();
        boolean nórdicaSeleccionada = Nórdica.isSelected();
        boolean japonesaSeleccionada = Japonesa.isSelected();
        boolean mayaSeleccionada = Maya.isSelected();
        boolean hindúSeleccionada = Hindú.isSelected();
        boolean chinaSeleccionada = China.isSelected();
        boolean babilónicaSeleccionada = Babilónica.isSelected();
        boolean yorubaSeleccionada = Yoruba.isSelected();
        boolean eslavaSeleccionada = Eslava.isSelected();
        boolean polinesiaSeleccionada = Polinesia.isSelected();
        boolean celtaSeleccionada = Celta.isSelected();

        mitosSeleccionados = mitologia.getMitosSeleccionadosMitologia(griegaSeleccionada,
                egipciaSeleccionada, nórdicaSeleccionada, japonesaSeleccionada, mayaSeleccionada,
                hindúSeleccionada, chinaSeleccionada, babilónicaSeleccionada,
                yorubaSeleccionada, eslavaSeleccionada, polinesiaSeleccionada, celtaSeleccionada);

        textoMitos.setText(mitosSeleccionados);
    }

    public void mostrarDatosDios() {

        String nombreDios = meterNombreDiosInformación.getText();
        if (mitologia.comprobarNombre(nombreDios) == "El dios no está en la base de datos") {
            String datos = mitologia.comprobarNombre(nombreDios);
            textoInformacionDios.setText("Introduzca un nombre correcto");
            JOptionPane.showMessageDialog(null, "Error: El dios no está en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String datos = mitologia.getInformacionDios(nombreDios);
            textoInformacionDios.setText("<html>" + datos.replaceAll("\n", "<br>") + "</html>");
        }//cambiar TextArea textoInformacionDios por un jLabel

    }

    public void MostrarMito() {
        String nombreMito = meterNombreMito.getText();
        //El mito no está en la base de datos
        if (mitologia.comprobarNombreMito(nombreMito) == "El mito no está en la base de datos") {
            String datos = mitologia.comprobarNombre(nombreMito);
            labelMitosDescripcion.setText("Introduzca un nombre correcto");
            JOptionPane.showMessageDialog(null, "Error: El mito no está en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String informacionMito = mitologia.getinformacionMito(nombreMito);

            labelMitosDescripcion.setText("<html>" + informacionMito.replaceAll("\n", "<br>") + "</html>");
        }
    }

    public void conseguirAñadirDios() {
        String nombreDiosAñadir = nombreMeterDios.getText();
        String deidadAñadir = deidadMeterDios.getText();
        String nombrePadreAñadir = nombreMeterPadre.getText();
        String nombreMadreAñadir = nombreMeterMadre.getText();
        String mitologiaDiosAñadir = seleccionarMitologíaMeterDios.getSelectedItem().toString();

        boolean seMetioDiosCorrectamente = mitologia.AñadirDios(mitologiaDiosAñadir, nombreDiosAñadir,
                deidadAñadir, nombrePadreAñadir, nombreMadreAñadir);
        if (!mitologia.ComprobarNombreMeter(nombreDiosAñadir)) {
            JOptionPane.showMessageDialog(null, "Dios repetido:Ya hay un dios con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);

        }
        if (!mitologia.ComprobarNombreMadreMeter(nombreMadreAñadir)) {
            JOptionPane.showMessageDialog(null, "Madre incorrecto:No hay ninguna diosa con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);

        }
        if(!mitologia.ComprobarNombrePadre(nombrePadreAñadir)){
        JOptionPane.showMessageDialog(null, "Padre Incorrecto:No hay ningun dios con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);

        }

        if (seMetioDiosCorrectamente) {
            JOptionPane.showMessageDialog(null, "EL dios se añadió correctamente");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        PanelInicio = new javax.swing.JPanel();
        inicioAMitologias = new javax.swing.JButton();
        inicioAMeter = new javax.swing.JButton();
        inicioADios = new javax.swing.JButton();
        inicioAMitos = new javax.swing.JButton();
        ExplicarBotonMitologia = new javax.swing.JLabel();
        ExplicarbotonInformacionMito = new javax.swing.JLabel();
        ExplicarBotonMeterDios = new javax.swing.JLabel();
        ExplicarBotonInformacionDioses = new javax.swing.JLabel();
        PanelMitologia = new javax.swing.JPanel();
        tituloMitos = new javax.swing.JLabel();
        Nórdica = new javax.swing.JCheckBox();
        textoDioses = new javax.swing.JLabel();
        Japonesa = new javax.swing.JCheckBox();
        textoMitos = new javax.swing.JLabel();
        Maya = new javax.swing.JCheckBox();
        Hindú = new javax.swing.JCheckBox();
        botonParaQueAparezcan = new javax.swing.JButton();
        China = new javax.swing.JCheckBox();
        Babilónica = new javax.swing.JCheckBox();
        Eslava = new javax.swing.JCheckBox();
        Griega = new javax.swing.JCheckBox();
        Polinesia = new javax.swing.JCheckBox();
        Yoruba = new javax.swing.JCheckBox();
        Celta = new javax.swing.JCheckBox();
        tituloDioses = new javax.swing.JLabel();
        Egipcia = new javax.swing.JCheckBox();
        MitologiaAInicio = new javax.swing.JButton();
        MitologiaADioses = new javax.swing.JToggleButton();
        MitologiaAMitos = new javax.swing.JToggleButton();
        MitologiaAMeter = new javax.swing.JToggleButton();
        PanelAñadirDios = new javax.swing.JPanel();
        seleccionarMitologíaMeterDios = new javax.swing.JComboBox<>();
        nombreMeterDios = new javax.swing.JTextField();
        deidadMeterDios = new javax.swing.JTextField();
        botonIrPanelPrincipal = new javax.swing.JButton();
        nombreMeterPadre = new javax.swing.JTextField();
        nombreMeterMadre = new javax.swing.JTextField();
        añadirDios = new javax.swing.JButton();
        MeterADios = new javax.swing.JToggleButton();
        meterAMitos = new javax.swing.JToggleButton();
        meterAMitologias = new javax.swing.JToggleButton();
        verInformacionDios = new javax.swing.JPanel();
        meterNombreDiosInformación = new javax.swing.JTextField();
        enseñarInformacionDios = new javax.swing.JButton();
        DiosAInicio = new javax.swing.JButton();
        textoInformacionDios = new javax.swing.JLabel();
        DiosAMito = new javax.swing.JToggleButton();
        diosAMeter = new javax.swing.JToggleButton();
        diosAMitologias = new javax.swing.JToggleButton();
        verInformacionMitos = new javax.swing.JPanel();
        mitoAInicio = new javax.swing.JButton();
        meterNombreMito = new javax.swing.JTextField();
        botonVerMito = new javax.swing.JButton();
        labelMitosDescripcion = new javax.swing.JLabel();
        mitoADios = new javax.swing.JToggleButton();
        mitoAMeter = new javax.swing.JToggleButton();
        mitoAMitologia = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setLayout(new java.awt.CardLayout());

        PanelInicio.setBackground(new java.awt.Color(128, 206, 215));
        PanelInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelInicio.setForeground(new java.awt.Color(99, 199, 178));

        inicioAMitologias.setBackground(new java.awt.Color(99, 199, 178));
        inicioAMitologias.setText("Ir panel Mitologia");
        inicioAMitologias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioAMitologiasActionPerformed(evt);
            }
        });

        inicioAMeter.setBackground(new java.awt.Color(99, 199, 178));
        inicioAMeter.setText("Ir a panel meter dios");
        inicioAMeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioAMeterActionPerformed(evt);
            }
        });

        inicioADios.setBackground(new java.awt.Color(99, 199, 178));
        inicioADios.setText("Ir a panel infromacion dioses");
        inicioADios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioADiosActionPerformed(evt);
            }
        });

        inicioAMitos.setBackground(new java.awt.Color(99, 199, 178));
        inicioAMitos.setText("Ir a panel informacion mito");
        inicioAMitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioAMitosActionPerformed(evt);
            }
        });

        ExplicarBotonMitologia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExplicarBotonMitologia.setText("<html>\n Dale a este boton e irás a una pantalla para ver dioses y mitos de diferentes mitologías.\n\n</html>     ");

        ExplicarbotonInformacionMito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExplicarbotonInformacionMito.setText("<html>\n Dale a este boton e irás a una pantalla donde pordrás leer diferentes mitos una vez sepas su nombre\n\n</html>     ");

        ExplicarBotonMeterDios.setText("<html>  Dale a este boton e irás a una pantalla donde pordrás meter dioses en la base de datos  </html>     ");

        ExplicarBotonInformacionDioses.setText("<html>  Dale a este boton e irás a una pantalla donde pordrás ver información sobre los dioses  </html>     ");

        javax.swing.GroupLayout PanelInicioLayout = new javax.swing.GroupLayout(PanelInicio);
        PanelInicio.setLayout(PanelInicioLayout);
        PanelInicioLayout.setHorizontalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInicioLayout.createSequentialGroup()
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ExplicarBotonMitologia, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelInicioLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(inicioAMitologias)))
                .addGap(18, 18, 18)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inicioAMitos)
                    .addGroup(PanelInicioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(ExplicarbotonInformacionMito, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inicioAMeter, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ExplicarBotonMeterDios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inicioADios)
                    .addComponent(ExplicarBotonInformacionDioses, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        PanelInicioLayout.setVerticalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicioAMitologias)
                    .addComponent(inicioAMeter)
                    .addComponent(inicioAMitos)
                    .addComponent(inicioADios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExplicarBotonMitologia, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ExplicarbotonInformacionMito, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ExplicarBotonMeterDios, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ExplicarBotonInformacionDioses, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(693, Short.MAX_VALUE))
        );

        panelPrincipal.add(PanelInicio, "card2");

        PanelMitologia.setBackground(new java.awt.Color(128, 206, 215));

        tituloMitos.setText("Mitos");

        Nórdica.setText("Japonesa");
        Nórdica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NórdicaActionPerformed(evt);
            }
        });

        textoDioses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDioses.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Japonesa.setText("Nórdica");
        Japonesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JaponesaActionPerformed(evt);
            }
        });

        textoMitos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoMitos.setToolTipText("");
        textoMitos.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Maya.setText("Hindú");

        Hindú.setText("Maya");

        botonParaQueAparezcan.setBackground(new java.awt.Color(142, 108, 136));
        botonParaQueAparezcan.setText("Buscar");
        botonParaQueAparezcan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonParaQueAparezcanActionPerformed(evt);
            }
        });

        China.setText("Babilónica");

        Babilónica.setText("Eslava");
        Babilónica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BabilónicaActionPerformed(evt);
            }
        });

        Eslava.setText("Celta");

        Griega.setText("Griega");
        Griega.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 255), new java.awt.Color(204, 255, 51), new java.awt.Color(255, 0, 102), new java.awt.Color(255, 51, 51)));
        Griega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GriegaActionPerformed(evt);
            }
        });

        Polinesia.setText("Polinesia");

        Yoruba.setText("Yoruba");

        Celta.setText("China");

        tituloDioses.setText("Dioses");

        Egipcia.setText("Egipcia");

        MitologiaAInicio.setBackground(new java.awt.Color(99, 199, 178));
        MitologiaAInicio.setText("Volver a panel inicial");
        MitologiaAInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitologiaAInicioActionPerformed(evt);
            }
        });

        MitologiaADioses.setBackground(new java.awt.Color(99, 199, 178));
        MitologiaADioses.setText("Ir a información de dioses");
        MitologiaADioses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitologiaADiosesActionPerformed(evt);
            }
        });

        MitologiaAMitos.setBackground(new java.awt.Color(99, 199, 178));
        MitologiaAMitos.setText("Ir a informacion de mitos");
        MitologiaAMitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitologiaAMitosActionPerformed(evt);
            }
        });

        MitologiaAMeter.setBackground(new java.awt.Color(99, 199, 178));
        MitologiaAMeter.setText("Ir a meter Dios");
        MitologiaAMeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MitologiaAMeterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMitologiaLayout = new javax.swing.GroupLayout(PanelMitologia);
        PanelMitologia.setLayout(PanelMitologiaLayout);
        PanelMitologiaLayout.setHorizontalGroup(
            PanelMitologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMitologiaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PanelMitologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMitologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(China)
                        .addGroup(PanelMitologiaLayout.createSequentialGroup()
                            .addGroup(PanelMitologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Hindú)
                                .addComponent(Nórdica)
                                .addComponent(Maya))
                            .addGap(6, 6, 6))
                        .addComponent(Celta, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Yoruba, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Babilónica, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Polinesia, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Eslava, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(PanelMitologiaLayout.createSequentialGroup()
                        .addGroup(PanelMitologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Japonesa)
                            .addComponent(Egipcia)
                            .addComponent(Griega)
                            .addComponent(botonParaQueAparezcan))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(PanelMitologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMitologiaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(textoDioses, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(textoMitos, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(PanelMitologiaLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(tituloDioses)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                        .addComponent(tituloMitos)
                        .addGap(174, 174, 174))))
            .addGroup(PanelMitologiaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(MitologiaAInicio)
                .addGap(28, 28, 28)
                .addComponent(MitologiaADioses)
                .addGap(32, 32, 32)
                .addComponent(MitologiaAMitos)
                .addGap(18, 18, 18)
                .addComponent(MitologiaAMeter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelMitologiaLayout.setVerticalGroup(
            PanelMitologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMitologiaLayout.createSequentialGroup()
                .addGroup(PanelMitologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMitologiaLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(PanelMitologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tituloDioses)
                            .addComponent(tituloMitos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelMitologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoDioses, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                            .addComponent(textoMitos, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)))
                    .addGroup(PanelMitologiaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(PanelMitologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MitologiaAInicio)
                            .addComponent(MitologiaADioses)
                            .addComponent(MitologiaAMitos)
                            .addComponent(MitologiaAMeter))
                        .addGap(26, 26, 26)
                        .addComponent(Griega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Egipcia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Japonesa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nórdica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Hindú)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Maya)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Celta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(China)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Yoruba)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Babilónica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Polinesia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eslava)
                        .addGap(47, 47, 47)
                        .addComponent(botonParaQueAparezcan)))
                .addContainerGap())
        );

        panelPrincipal.add(PanelMitologia, "card3");

        PanelAñadirDios.setBackground(new java.awt.Color(128, 206, 215));

        seleccionarMitologíaMeterDios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Griega", "Egipcia", "Nórdica", "Japonesa", "Maya", "Hindú", "China", "Babilónica", "Yoruba", "Eslava", "Polinesia", "Celta" }));

        nombreMeterDios.setText("Nombre del dios");
        nombreMeterDios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreMeterDiosActionPerformed(evt);
            }
        });

        deidadMeterDios.setText("Deidad...");
        deidadMeterDios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deidadMeterDiosActionPerformed(evt);
            }
        });

        botonIrPanelPrincipal.setBackground(new java.awt.Color(99, 199, 178));
        botonIrPanelPrincipal.setText("Volver al panel inicial");
        botonIrPanelPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIrPanelPrincipalActionPerformed(evt);
            }
        });

        nombreMeterPadre.setText("Padre");

        nombreMeterMadre.setText("Madre");

        añadirDios.setBackground(new java.awt.Color(142, 108, 136));
        añadirDios.setText("Añadir");
        añadirDios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirDiosActionPerformed(evt);
            }
        });

        MeterADios.setBackground(new java.awt.Color(99, 199, 178));
        MeterADios.setText("Ir a información dioses");
        MeterADios.setActionCommand("Ir a información de dioses");
        MeterADios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeterADiosActionPerformed(evt);
            }
        });

        meterAMitos.setBackground(new java.awt.Color(99, 199, 178));
        meterAMitos.setText("Ir a información de mitos");
        meterAMitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meterAMitosActionPerformed(evt);
            }
        });

        meterAMitologias.setBackground(new java.awt.Color(99, 199, 178));
        meterAMitologias.setText("Ir a Mitologías");
        meterAMitologias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meterAMitologiasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAñadirDiosLayout = new javax.swing.GroupLayout(PanelAñadirDios);
        PanelAñadirDios.setLayout(PanelAñadirDiosLayout);
        PanelAñadirDiosLayout.setHorizontalGroup(
            PanelAñadirDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAñadirDiosLayout.createSequentialGroup()
                .addGroup(PanelAñadirDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAñadirDiosLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(PanelAñadirDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAñadirDiosLayout.createSequentialGroup()
                                .addGroup(PanelAñadirDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seleccionarMitologíaMeterDios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreMeterPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(88, 88, 88)
                                .addGroup(PanelAñadirDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelAñadirDiosLayout.createSequentialGroup()
                                        .addComponent(nombreMeterDios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addComponent(deidadMeterDios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelAñadirDiosLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(nombreMeterMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(añadirDios)))
                    .addGroup(PanelAñadirDiosLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(botonIrPanelPrincipal)
                        .addGap(38, 38, 38)
                        .addComponent(MeterADios)
                        .addGap(43, 43, 43)
                        .addComponent(meterAMitos)
                        .addGap(39, 39, 39)
                        .addComponent(meterAMitologias)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        PanelAñadirDiosLayout.setVerticalGroup(
            PanelAñadirDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAñadirDiosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAñadirDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonIrPanelPrincipal)
                    .addComponent(MeterADios)
                    .addComponent(meterAMitos)
                    .addComponent(meterAMitologias))
                .addGap(60, 60, 60)
                .addGroup(PanelAñadirDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionarMitologíaMeterDios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreMeterDios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deidadMeterDios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(PanelAñadirDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreMeterPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreMeterMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addComponent(añadirDios)
                .addContainerGap(569, Short.MAX_VALUE))
        );

        panelPrincipal.add(PanelAñadirDios, "card4");

        verInformacionDios.setBackground(new java.awt.Color(128, 206, 215));

        meterNombreDiosInformación.setText("nombre del dios");
        meterNombreDiosInformación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meterNombreDiosInformaciónActionPerformed(evt);
            }
        });

        enseñarInformacionDios.setBackground(new java.awt.Color(142, 108, 136));
        enseñarInformacionDios.setText("EnseñarInformacion");
        enseñarInformacionDios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enseñarInformacionDiosActionPerformed(evt);
            }
        });

        DiosAInicio.setBackground(new java.awt.Color(99, 199, 178));
        DiosAInicio.setText("volver a panel inicio");
        DiosAInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiosAInicioActionPerformed(evt);
            }
        });

        DiosAMito.setBackground(new java.awt.Color(99, 199, 178));
        DiosAMito.setText("Ir a panel informacion mito");
        DiosAMito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiosAMitoActionPerformed(evt);
            }
        });

        diosAMeter.setBackground(new java.awt.Color(99, 199, 178));
        diosAMeter.setText("Ir a meter dioses");
        diosAMeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diosAMeterActionPerformed(evt);
            }
        });

        diosAMitologias.setBackground(new java.awt.Color(99, 199, 178));
        diosAMitologias.setText("Ir a Mitologías");
        diosAMitologias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diosAMitologiasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout verInformacionDiosLayout = new javax.swing.GroupLayout(verInformacionDios);
        verInformacionDios.setLayout(verInformacionDiosLayout);
        verInformacionDiosLayout.setHorizontalGroup(
            verInformacionDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verInformacionDiosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(verInformacionDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DiosAInicio)
                    .addComponent(meterNombreDiosInformación, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(verInformacionDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(verInformacionDiosLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(enseñarInformacionDios))
                    .addGroup(verInformacionDiosLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(DiosAMito)
                        .addGap(80, 80, 80)
                        .addComponent(diosAMeter)
                        .addGap(63, 63, 63)
                        .addComponent(diosAMitologias)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(verInformacionDiosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(textoInformacionDios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        verInformacionDiosLayout.setVerticalGroup(
            verInformacionDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verInformacionDiosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(verInformacionDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiosAInicio)
                    .addComponent(DiosAMito)
                    .addComponent(diosAMeter)
                    .addComponent(diosAMitologias))
                .addGap(42, 42, 42)
                .addGroup(verInformacionDiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(meterNombreDiosInformación, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enseñarInformacionDios))
                .addGap(48, 48, 48)
                .addComponent(textoInformacionDios, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(312, Short.MAX_VALUE))
        );

        panelPrincipal.add(verInformacionDios, "card5");

        verInformacionMitos.setBackground(new java.awt.Color(128, 206, 215));

        mitoAInicio.setBackground(new java.awt.Color(99, 199, 178));
        mitoAInicio.setText("Ir panel principal");
        mitoAInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitoAInicioActionPerformed(evt);
            }
        });

        meterNombreMito.setText("Nombre del mito");

        botonVerMito.setBackground(new java.awt.Color(142, 108, 136));
        botonVerMito.setText("Mostrar Mito");
        botonVerMito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerMitoActionPerformed(evt);
            }
        });

        labelMitosDescripcion.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        mitoADios.setBackground(new java.awt.Color(99, 199, 178));
        mitoADios.setText("Ir a información dioses");
        mitoADios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitoADiosActionPerformed(evt);
            }
        });

        mitoAMeter.setBackground(new java.awt.Color(99, 199, 178));
        mitoAMeter.setText("Ir a meter dioses");
        mitoAMeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitoAMeterActionPerformed(evt);
            }
        });

        mitoAMitologia.setBackground(new java.awt.Color(99, 199, 178));
        mitoAMitologia.setText("Ir a Mitologías");
        mitoAMitologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitoAMitologiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout verInformacionMitosLayout = new javax.swing.GroupLayout(verInformacionMitos);
        verInformacionMitos.setLayout(verInformacionMitosLayout);
        verInformacionMitosLayout.setHorizontalGroup(
            verInformacionMitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verInformacionMitosLayout.createSequentialGroup()
                .addGroup(verInformacionMitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(verInformacionMitosLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(meterNombreMito, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(botonVerMito))
                    .addGroup(verInformacionMitosLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(verInformacionMitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelMitosDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(verInformacionMitosLayout.createSequentialGroup()
                                .addComponent(mitoAInicio)
                                .addGap(55, 55, 55)
                                .addComponent(mitoADios)
                                .addGap(54, 54, 54)
                                .addComponent(mitoAMeter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mitoAMitologia)))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        verInformacionMitosLayout.setVerticalGroup(
            verInformacionMitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verInformacionMitosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(verInformacionMitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mitoAInicio)
                    .addComponent(mitoADios)
                    .addComponent(mitoAMeter)
                    .addComponent(mitoAMitologia))
                .addGap(51, 51, 51)
                .addGroup(verInformacionMitosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(meterNombreMito, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVerMito))
                .addGap(50, 50, 50)
                .addComponent(labelMitosDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(315, Short.MAX_VALUE))
        );

        panelPrincipal.add(verInformacionMitos, "card6");

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioAMitologiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioAMitologiasActionPerformed
        cambiarCard("card3");
    }//GEN-LAST:event_inicioAMitologiasActionPerformed

    private void NórdicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NórdicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NórdicaActionPerformed

    private void JaponesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JaponesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JaponesaActionPerformed

    private void botonParaQueAparezcanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonParaQueAparezcanActionPerformed
        mostrarDiosesSeleccionados();
        mostrarMitosSeleccionados();
        // TODO add your handling code here:
    }//GEN-LAST:event_botonParaQueAparezcanActionPerformed

    private void BabilónicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BabilónicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BabilónicaActionPerformed

    private void GriegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GriegaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GriegaActionPerformed

    private void MitologiaAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitologiaAInicioActionPerformed
        cambiarCard("card2");        // TODO add your handling code here:
    }//GEN-LAST:event_MitologiaAInicioActionPerformed

    private void nombreMeterDiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreMeterDiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreMeterDiosActionPerformed

    private void deidadMeterDiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deidadMeterDiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deidadMeterDiosActionPerformed

    private void inicioAMeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioAMeterActionPerformed
        cambiarCard("card4");        // TODO add your handling code here:
    }//GEN-LAST:event_inicioAMeterActionPerformed

    private void botonIrPanelPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIrPanelPrincipalActionPerformed
        cambiarCard("card2");        // TODO add your handling code here:
    }//GEN-LAST:event_botonIrPanelPrincipalActionPerformed

    private void meterNombreDiosInformaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meterNombreDiosInformaciónActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meterNombreDiosInformaciónActionPerformed

    private void enseñarInformacionDiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enseñarInformacionDiosActionPerformed
        mostrarDatosDios();        // TODO add your handling code here:
    }//GEN-LAST:event_enseñarInformacionDiosActionPerformed

    private void inicioADiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioADiosActionPerformed
        cambiarCard("card5");        // TODO add your handling code here:
    }//GEN-LAST:event_inicioADiosActionPerformed

    private void DiosAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiosAInicioActionPerformed
        cambiarCard("card2");        // TODO add your handling code here:
    }//GEN-LAST:event_DiosAInicioActionPerformed

    private void inicioAMitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioAMitosActionPerformed
        cambiarCard("card6");        // TODO add your handling code here:
    }//GEN-LAST:event_inicioAMitosActionPerformed

    private void mitoAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitoAInicioActionPerformed
        cambiarCard("card2");        // TODO add your handling code here:
    }//GEN-LAST:event_mitoAInicioActionPerformed

    private void añadirDiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirDiosActionPerformed
        conseguirAñadirDios();        // TODO add your handling code here:
    }//GEN-LAST:event_añadirDiosActionPerformed

    private void botonVerMitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerMitoActionPerformed
        MostrarMito();        // TODO add your handling code here:
    }//GEN-LAST:event_botonVerMitoActionPerformed

    private void MitologiaADiosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitologiaADiosesActionPerformed
        cambiarCard("card5");        // TODO add your handling code here:
    }//GEN-LAST:event_MitologiaADiosesActionPerformed

    private void MitologiaAMitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitologiaAMitosActionPerformed
        cambiarCard("card6");
    }//GEN-LAST:event_MitologiaAMitosActionPerformed

    private void MitologiaAMeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MitologiaAMeterActionPerformed
        cambiarCard("card4");        // TODO add your handling code here:
    }//GEN-LAST:event_MitologiaAMeterActionPerformed

    private void MeterADiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeterADiosActionPerformed
        cambiarCard("card5"); // TODO add your handling code here:
    }//GEN-LAST:event_MeterADiosActionPerformed

    private void meterAMitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meterAMitosActionPerformed
        cambiarCard("card6");        // TODO add your handling code here:
    }//GEN-LAST:event_meterAMitosActionPerformed

    private void meterAMitologiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meterAMitologiasActionPerformed
        cambiarCard("card3");        // TODO add your handling code here:
    }//GEN-LAST:event_meterAMitologiasActionPerformed

    private void DiosAMitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiosAMitoActionPerformed
        cambiarCard("card6");        // TODO add your handling code here:
    }//GEN-LAST:event_DiosAMitoActionPerformed

    private void diosAMeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diosAMeterActionPerformed
        cambiarCard("card4");        // TODO add your handling code here:
    }//GEN-LAST:event_diosAMeterActionPerformed

    private void diosAMitologiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diosAMitologiasActionPerformed
        cambiarCard("card3");        // TODO add your handling code here:
    }//GEN-LAST:event_diosAMitologiasActionPerformed

    private void mitoADiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitoADiosActionPerformed
        cambiarCard("card5");        // TODO add your handling code here:
    }//GEN-LAST:event_mitoADiosActionPerformed

    private void mitoAMeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitoAMeterActionPerformed
        cambiarCard("card4");        // TODO add your handling code here:
    }//GEN-LAST:event_mitoAMeterActionPerformed

    private void mitoAMitologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitoAMitologiaActionPerformed
        cambiarCard("card3");        // TODO add your handling code here:
    }//GEN-LAST:event_mitoAMitologiaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Babilónica;
    private javax.swing.JCheckBox Celta;
    private javax.swing.JCheckBox China;
    private javax.swing.JButton DiosAInicio;
    private javax.swing.JToggleButton DiosAMito;
    private javax.swing.JCheckBox Egipcia;
    private javax.swing.JCheckBox Eslava;
    private javax.swing.JLabel ExplicarBotonInformacionDioses;
    private javax.swing.JLabel ExplicarBotonMeterDios;
    private javax.swing.JLabel ExplicarBotonMitologia;
    private javax.swing.JLabel ExplicarbotonInformacionMito;
    private javax.swing.JCheckBox Griega;
    private javax.swing.JCheckBox Hindú;
    private javax.swing.JCheckBox Japonesa;
    private javax.swing.JCheckBox Maya;
    private javax.swing.JToggleButton MeterADios;
    private javax.swing.JToggleButton MitologiaADioses;
    private javax.swing.JButton MitologiaAInicio;
    private javax.swing.JToggleButton MitologiaAMeter;
    private javax.swing.JToggleButton MitologiaAMitos;
    private javax.swing.JCheckBox Nórdica;
    private javax.swing.JPanel PanelAñadirDios;
    private javax.swing.JPanel PanelInicio;
    private javax.swing.JPanel PanelMitologia;
    private javax.swing.JCheckBox Polinesia;
    private javax.swing.JCheckBox Yoruba;
    private javax.swing.JButton añadirDios;
    private javax.swing.JButton botonIrPanelPrincipal;
    private javax.swing.JButton botonParaQueAparezcan;
    private javax.swing.JButton botonVerMito;
    private javax.swing.JTextField deidadMeterDios;
    private javax.swing.JToggleButton diosAMeter;
    private javax.swing.JToggleButton diosAMitologias;
    private javax.swing.JButton enseñarInformacionDios;
    private javax.swing.JButton inicioADios;
    private javax.swing.JButton inicioAMeter;
    private javax.swing.JButton inicioAMitologias;
    private javax.swing.JButton inicioAMitos;
    private javax.swing.JLabel labelMitosDescripcion;
    private javax.swing.JToggleButton meterAMitologias;
    private javax.swing.JToggleButton meterAMitos;
    private javax.swing.JTextField meterNombreDiosInformación;
    private javax.swing.JTextField meterNombreMito;
    private javax.swing.JToggleButton mitoADios;
    private javax.swing.JButton mitoAInicio;
    private javax.swing.JToggleButton mitoAMeter;
    private javax.swing.JToggleButton mitoAMitologia;
    private javax.swing.JTextField nombreMeterDios;
    private javax.swing.JTextField nombreMeterMadre;
    private javax.swing.JTextField nombreMeterPadre;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JComboBox<String> seleccionarMitologíaMeterDios;
    private javax.swing.JLabel textoDioses;
    private javax.swing.JLabel textoInformacionDios;
    private javax.swing.JLabel textoMitos;
    private javax.swing.JLabel tituloDioses;
    private javax.swing.JLabel tituloMitos;
    private javax.swing.JPanel verInformacionDios;
    private javax.swing.JPanel verInformacionMitos;
    // End of variables declaration//GEN-END:variables
}
