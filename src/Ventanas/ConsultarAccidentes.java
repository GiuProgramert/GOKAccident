/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Reportes;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giuliano
 */
public class ConsultarAccidentes extends javax.swing.JFrame {

    public static int id;

    public static boolean Acti = false;

    /**
     * Creates new form ConsultarAccidentes
     */
    public ConsultarAccidentes() {
        initComponents();

        //Diseño
        Inicio.ponerTemaPanel(Inicio.tema, new JPanel[]{jPanel1, jPanel2, jPanel3}, null, false);
        setTitle("Consultar accidentas");
        setLocationRelativeTo(null);
        setResizable(false);
        //Cargar icono
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconoMain.png")).getImage());
        //Cargar icono Dialogo selec rios
        jDialogReportLocalidad.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconoMain.png")).getImage());
        //Cargar icono dialogo ver localidades
        jDialogLocalidades.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconoMain.png")).getImage());
        
        //---------------Rios--------------------------
        final String TITULOS[] = new String[]{"ID ", "Nombre", "Pos V", "Pos H", "Longitud", "Pais"};
        DefaultTableModel dt = new DefaultTableModel(null, TITULOS);
        ResultSet rs = Inicio.sente.consulta("SELECT a.id_accidentes,a.nombre,a.posV,a.posH,r.longitud, p.nombre\n"
                + " FROM accidentes a, accidentes_paises ap, rios r, paises p\n"
                + " WHERE (a.id_accidentes = r.id_accidentes)\n"
                + " AND ((a.id_accidentes = ap.id_accidentes) AND (p.id_paises = ap.id_paises))");
        String columnas[] = new String[6];
        //-------------------------------------------------------------
        try {
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    columnas[i] = rs.getString(i + 1);
                }
                dt.addRow(columnas);
            }
            jTableRios.setModel(dt);
        } catch (SQLException e) {
        }

        //---------------Lagos--------------------------
        final String TITULOSL[] = new String[]{"ID ", "Nombre", "Pos V", "Pos H", "superficie", "Pais"};
        DefaultTableModel dtL = new DefaultTableModel(null, TITULOSL);
        ResultSet rsL = Inicio.sente.consulta("SELECT a.id_accidentes, a.nombre, a.posV, a.posH, L.superficie, p.nombre \n"
                + "FROM accidentes a,lagos L, accidentes_paises ap, paises p\n"
                + "WHERE a.id_accidentes = L.id_accidentes\n"
                + "and ((a.id_accidentes = ap.id_accidentes) AND (p.id_paises = ap.id_paises))");
        String columnasL[] = new String[6];
        //-------------------------------------------------------------
        try {
            while (rsL.next()) {
                for (int i = 0; i < 6; i++) {
                    columnasL[i] = rsL.getString(i + 1);
                }
                dtL.addRow(columnasL);
            }
            jTableLago.setModel(dtL);
        } catch (SQLException e) {
        }
        //---------------Montañas--------------------------
        final String TITULOSM[] = new String[]{"ID ", "Nombre", "Pos V", "Pos H", "Altura", "Pais"};
        DefaultTableModel dtM = new DefaultTableModel(null, TITULOSM);
        ResultSet rsM = Inicio.sente.consulta("SELECT a.id_accidentes, a.nombre, a.posV, a.posH, M.altura, p.nombre \n"
                + "FROM accidentes a,montañas M , accidentes_paises ap, paises p\n"
                + "WHERE a.id_accidentes = M.id_accidentes\n"
                + "AND ((a.id_accidentes = ap.id_accidentes) AND (p.id_paises = ap.id_paises))");
        String columnasM[] = new String[6];
        //-------------------------------------------------------------
        try {
            while (rsM.next()) {
                for (int i = 0; i < 6; i++) {
                    columnasM[i] = rsM.getString(i + 1);
                }
                dtM.addRow(columnasM);
            }
            jTableMont.setModel(dtM);
        } catch (SQLException e) {
        }
        
        
        //Poner tema a los dialogos
        switch (Inicio.tema) {
            case "Por defecto":
                jDialogReportLocalidad.getContentPane().setBackground(new Color(80, 163, 231));
                jLabelDiajogSelecLoc.setForeground(Color.BLACK);
                jDialogLocalidades.getContentPane().setBackground(new Color(80, 163, 231));
                break;
            case "Oscuro":
                jDialogReportLocalidad.getContentPane().setBackground(new Color(57, 67, 75));
                jDialogLocalidades.getContentPane().setBackground(new Color(57, 67, 75));
                jLabelDiajogSelecLoc.setForeground(Color.WHITE);
                break;
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

        jDialogLocalidades = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableLocalidades = new javax.swing.JTable();
        jDialogReportLocalidad = new javax.swing.JDialog();
        jLabelDiajogSelecLoc = new javax.swing.JLabel();
        jComboBoxLocalidades = new javax.swing.JComboBox<>();
        jToggleButton2 = new javax.swing.JToggleButton();
        Montaña = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRios = new javax.swing.JTable();
        jbtnModR = new javax.swing.JButton();
        jbtnElimR = new javax.swing.JButton();
        btnGenerarReportRios = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLago = new javax.swing.JTable();
        jbtnModL = new javax.swing.JButton();
        jbtnElimL = new javax.swing.JButton();
        btnGenerarReportLagos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMont = new javax.swing.JTable();
        jbtnModM = new javax.swing.JButton();
        jbtnElimM = new javax.swing.JButton();
        btnGenerarReportMonta = new javax.swing.JButton();

        jTableLocalidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTableLocalidades);

        javax.swing.GroupLayout jDialogLocalidadesLayout = new javax.swing.GroupLayout(jDialogLocalidades.getContentPane());
        jDialogLocalidades.getContentPane().setLayout(jDialogLocalidadesLayout);
        jDialogLocalidadesLayout.setHorizontalGroup(
            jDialogLocalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogLocalidadesLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jDialogLocalidadesLayout.setVerticalGroup(
            jDialogLocalidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLocalidadesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jLabelDiajogSelecLoc.setText("Seleccione una localidad:");

        jComboBoxLocalidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxLocalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLocalidadesActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Aceptar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogReportLocalidadLayout = new javax.swing.GroupLayout(jDialogReportLocalidad.getContentPane());
        jDialogReportLocalidad.getContentPane().setLayout(jDialogReportLocalidadLayout);
        jDialogReportLocalidadLayout.setHorizontalGroup(
            jDialogReportLocalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogReportLocalidadLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jDialogReportLocalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton2)
                    .addGroup(jDialogReportLocalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelDiajogSelecLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxLocalidades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jDialogReportLocalidadLayout.setVerticalGroup(
            jDialogReportLocalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogReportLocalidadLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabelDiajogSelecLoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxLocalidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jToggleButton2)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableRios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableRios);

        jbtnModR.setText("Modificar");
        jbtnModR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModRActionPerformed(evt);
            }
        });

        jbtnElimR.setText("Eliminar");
        jbtnElimR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnElimRActionPerformed(evt);
            }
        });

        btnGenerarReportRios.setText("Generar reporte");
        btnGenerarReportRios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReportRiosActionPerformed(evt);
            }
        });

        jButton1.setText("Ver localidades");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Generar reporte localidad");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jbtnModR)
                .addGap(18, 18, 18)
                .addComponent(jbtnElimR)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarReportRios)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnModR)
                    .addComponent(jbtnElimR)
                    .addComponent(btnGenerarReportRios)
                    .addComponent(jButton1)
                    .addComponent(jToggleButton1))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Montaña.addTab("Ríos", jPanel1);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(300, 64));

        jTableLago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableLago);

        jbtnModL.setText("Modificar");
        jbtnModL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModLActionPerformed(evt);
            }
        });

        jbtnElimL.setText("Eliminar");
        jbtnElimL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnElimLActionPerformed(evt);
            }
        });

        btnGenerarReportLagos.setText("Generar reporte");
        btnGenerarReportLagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReportLagosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jbtnModL)
                .addGap(18, 18, 18)
                .addComponent(jbtnElimL)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarReportLagos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnModL)
                    .addComponent(jbtnElimL)
                    .addComponent(btnGenerarReportLagos))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        Montaña.addTab("Lagos", jPanel2);

        jTableMont.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableMont);

        jbtnModM.setText("Modificar");
        jbtnModM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModMActionPerformed(evt);
            }
        });

        jbtnElimM.setText("Eliminar");
        jbtnElimM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnElimMActionPerformed(evt);
            }
        });

        btnGenerarReportMonta.setText("Generar reporte");
        btnGenerarReportMonta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReportMontaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jbtnModM)
                .addGap(18, 18, 18)
                .addComponent(jbtnElimM)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarReportMonta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnModM)
                    .addComponent(jbtnElimM)
                    .addComponent(btnGenerarReportMonta))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Montaña.addTab("Montañas", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Montaña)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Montaña)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnModRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModRActionPerformed
//rios
        NCargarAccidentes cr;
        cr = new NCargarAccidentes();
        cr.setVisible(false);
        try {
            if (!Acti) {
                NCargarAccidentes.mod = true;
                Acti = true;
                cr.setVisible(true);
                NCargarAccidentes.jTabbedPane1.setSelectedIndex(0);
                int fila = jTableRios.getSelectedRow();
                id = Integer.parseInt((String) jTableRios.getValueAt(fila, 0));
                NCargarAccidentes.RtxtNombre.setText((String) jTableRios.getValueAt(fila, 1));
                NCargarAccidentes.RtxtPosV.setText((String) jTableRios.getValueAt(fila, 2));
                NCargarAccidentes.RtxtPosiH.setText((String) jTableRios.getValueAt(fila, 3));
                NCargarAccidentes.RtxtValorTipo.setText((String) jTableRios.getValueAt(fila, 4));
                //NCargarAccidentes.ComboNom.setEnabled(false);
                NCargarAccidentes.RComboPais.setEnabled(false);
                NCargarAccidentes.RbtnMod.setEnabled(true);
                NCargarAccidentes.btnSelec.setEnabled(false);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Ya hay una ventana activa");
                cr.dispose();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Acti = false;
            cr.dispose();
            this.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento");
        }
    }//GEN-LAST:event_jbtnModRActionPerformed

    private void jbtnElimLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnElimLActionPerformed
        try {
            boolean verifica = false;
            int fila = jTableLago.getSelectedRow();
            int idfila = Integer.parseInt((String) jTableLago.getValueAt(fila, 0));
            //Borrar en lagos
            if (Inicio.sente.eliminarElemento("delete from lagos where id_accidentes=" + idfila));
            //Borrar en accidentes_paises
            if (Inicio.sente.eliminarElemento("delete from accidentes_paises where id_accidentes=" + idfila)) {
                verifica = true;
            } else {
                verifica = false;
            }
            //Borrar accidente
            if (Inicio.sente.eliminarElemento("delete from accidentes where id_accidentes=" + idfila)) {
                verifica = true;
            } else {
                verifica = false;
            }

            if (verifica) {
                JOptionPane.showMessageDialog(this, "Borrado con exito");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el accidente contacte con el técnico");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento");
        }
    }//GEN-LAST:event_jbtnElimLActionPerformed

    private void jbtnElimMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnElimMActionPerformed
        try {
            boolean verifica = false;
            int fila = jTableMont.getSelectedRow();
            int idfila = Integer.parseInt((String) jTableMont.getValueAt(fila, 0));
            //Borrar en Montañas
            if (Inicio.sente.eliminarElemento("delete from montañas where id_accidentes=" + idfila));
            //Borrar en accidentes_paises
            if (Inicio.sente.eliminarElemento("delete from accidentes_paises where id_accidentes=" + idfila)) {
                verifica = true;
            } else {
                verifica = false;
            }
            //Borrar accidente
            if (Inicio.sente.eliminarElemento("delete from accidentes where id_accidentes=" + idfila)) {
                verifica = true;
            } else {
                verifica = false;
            }

            if (verifica) {
                JOptionPane.showMessageDialog(this, "Borrado con exito");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el accidente contacte con el técnico");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento");
        }
    }//GEN-LAST:event_jbtnElimMActionPerformed

    private void jbtnModLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModLActionPerformed
        NCargarAccidentes cl;
        cl = new NCargarAccidentes();
        cl.setVisible(false);
        try {
            if (!Acti) {
                NCargarAccidentes.mod = true;
                Acti = true;
                cl.setVisible(true);
                NCargarAccidentes.jTabbedPane1.setSelectedIndex(1);
                int fila = jTableLago.getSelectedRow();
                id = Integer.parseInt((String) jTableLago.getValueAt(fila, 0));
                NCargarAccidentes.LtxtNombre.setText((String) jTableLago.getValueAt(fila, 1));
                NCargarAccidentes.LtxtPosV.setText((String) jTableLago.getValueAt(fila, 2));
                NCargarAccidentes.LtxtPosH.setText((String) jTableLago.getValueAt(fila, 3));
                NCargarAccidentes.LtxtValorTipo.setText((String) jTableLago.getValueAt(fila, 4));
                NCargarAccidentes.LbtnMod.setEnabled(false);
                NCargarAccidentes.LComboPais.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Ya hay una ventana activa");
                cl.dispose();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Acti = false;
            this.setEnabled(true);
            cl.dispose();
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento");
        }
    }//GEN-LAST:event_jbtnModLActionPerformed

    private void jbtnModMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModMActionPerformed
        //m
        NCargarAccidentes ca;
        ca = new NCargarAccidentes();
        ca.setVisible(false);
        try {

            if (!Acti) {
                NCargarAccidentes.mod = true;
                Acti = true;
                ca.setVisible(true);
                NCargarAccidentes.jTabbedPane1.setSelectedIndex(2);
                int fila = jTableMont.getSelectedRow();
                id = Integer.parseInt((String) jTableMont.getValueAt(fila, 0));
                NCargarAccidentes.MtxtNombre.setText((String) jTableMont.getValueAt(fila, 1));
                NCargarAccidentes.MtxtPosV.setText((String) jTableMont.getValueAt(fila, 2));
                NCargarAccidentes.MtxtPosH.setText((String) jTableMont.getValueAt(fila, 3));
                NCargarAccidentes.MtxtValorTipo.setText((String) jTableMont.getValueAt(fila, 4));
                NCargarAccidentes.MbtnMod.setEnabled(false);
                NCargarAccidentes.MComboPais.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Ya hay una ventana activa");
                ca.dispose();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Acti = false;
            this.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento");
        }
    }//GEN-LAST:event_jbtnModMActionPerformed

    private void jbtnElimRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnElimRActionPerformed
        try {
            boolean verifica = false;
            int fila = jTableRios.getSelectedRow();
            int idfila = Integer.parseInt((String) jTableRios.getValueAt(fila, 0));
            if (Inicio.sente.eliminarElemento(
                      "DELETE FROM \n"
                    + "     rios_localidades "
                    + "WHERE \n"
                    + "     id_accidentes = " + idfila)){
                verifica = true;
            } else {
                verifica = false;
            }
            //Borrar en rios
            if (Inicio.sente.eliminarElemento("delete from rios where id_accidentes=" + idfila)) {
                verifica = true;
            } else {
                verifica = false;
            }
            //Borrar en accidentes_paises
            if (Inicio.sente.eliminarElemento("delete from accidentes_paises where id_accidentes=" + idfila)) {
                verifica = true;
            } else {
                verifica = false;
            }
            //Borrar accidente
            if (Inicio.sente.eliminarElemento("delete from accidentes where id_accidentes=" + idfila)) {
                verifica = true;
            } else {
                verifica = false;
            }

            if (verifica) {
                JOptionPane.showMessageDialog(this, "Borrado con exito");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el accidente contacte con el técnico");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento");
        }
    }//GEN-LAST:event_jbtnElimRActionPerformed

    private void btnGenerarReportRiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReportRiosActionPerformed
        Reportes rep = new Reportes();
        String sql = "SELECT a.id_accidentes,a.nombre,a.posV,a.posH,r.longitud,rl.km,l.nombre AS nombre_lago, p.nombre AS nombre_pais"
                + " FROM accidentes a, accidentes_paises ap, rios r, rios_localidades rl, localidades l, paises p"
                + " WHERE (a.id_accidentes = r.id_accidentes)"
                + "AND ((r.id_accidentes = rl.id_accidentes) AND (l.id_localidad = rl.id_localidad))"
                + "AND (l.id_paises = p.id_paises)"
                + "AND ((a.id_accidentes = ap.id_accidentes) AND (p.id_paises = ap.id_paises))";
        String reportDir = "Reportes/reportRios.jasper";
        rep.GenerarRepor(sql, reportDir, "", "");
    }//GEN-LAST:event_btnGenerarReportRiosActionPerformed

    private void btnGenerarReportLagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReportLagosActionPerformed
        Reportes rep = new Reportes();
        String sql = "SELECT a.id_accidentes, a.nombre, a.posV, a.posH, L.superficie, p.nombre AS nombre_pais\n"
                + "FROM accidentes a,lagos L, accidentes_paises ap, paises p\n"
                + "WHERE a.id_accidentes = L.id_accidentes\n"
                + "and ((a.id_accidentes = ap.id_accidentes) AND (p.id_paises = ap.id_paises))";
        String reportDir = "Reportes/reportLagos.jasper";
        rep.GenerarRepor(sql, reportDir, "", "");
    }//GEN-LAST:event_btnGenerarReportLagosActionPerformed

    private void btnGenerarReportMontaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReportMontaActionPerformed
        Reportes rep = new Reportes();
        String sql = "SELECT a.id_accidentes, a.nombre, a.posV, a.posH, M.altura, p.nombre AS pais_nombre \n"
                + "FROM accidentes a,montañas M , accidentes_paises ap, paises p\n"
                + "WHERE a.id_accidentes = M.id_accidentes\n"
                + "AND ((a.id_accidentes = ap.id_accidentes) AND (p.id_paises = ap.id_paises))";
        String reportDir = "Reportes/reportMontana.jasper";
        rep.GenerarRepor(sql, reportDir, "", "");
    }//GEN-LAST:event_btnGenerarReportMontaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int fila = jTableRios.getSelectedRow();
            id = Integer.parseInt((String) jTableRios.getValueAt(fila, 0));
            jDialogLocalidades.setVisible(true);
            jDialogLocalidades.setLocationRelativeTo(null);
            jDialogLocalidades.setSize(483, 431);
            jDialogLocalidades.setTitle("Ver localidades del río");
            jDialogLocalidades.setLocationRelativeTo(null);
            jTableLocalidades.setSize(483, 431);
            final String TITULOS[] = new String[]{"ID ", "Localidad", "Km"};
            DefaultTableModel dt = new DefaultTableModel(null, TITULOS);
            ResultSet rs = Inicio.sente.consulta("select localidades.id_localidad, localidades.nombre, rios_localidades.km \n"
                    + " from localidades, rios_localidades\n"
                    + " WHERE rios_localidades.id_accidentes = \n" + id
                    + " AND (localidades.id_localidad = rios_localidades.id_localidad)");
            String columnas[] = new String[3];
            //-------------------------------------------------------------
            try {
                while (rs.next()) {
                    for (int i = 0; i < 3; i++) {
                        columnas[i] = rs.getString(i + 1);
                    }
                    dt.addRow(columnas);
                }
                jTableLocalidades.setModel(dt);
            } catch (SQLException e) {
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            jComboBoxLocalidades.removeAllItems();
            jDialogReportLocalidad.setVisible(true);
            jDialogReportLocalidad.setSize(239, 214);
            jDialogReportLocalidad.setLocationRelativeTo(null);
            jDialogReportLocalidad.setTitle("Selecionar río");
            
            String sql = "select accidentes.nombre "
                    + "from accidentes, rios "
                    + "where accidentes.id_accidentes = rios.id_accidentes";
            ResultSet rs = Inicio.sente.consulta(sql);
            while (rs.next()) {
                jComboBoxLocalidades.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarAccidentes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jToggleButton1ActionPerformed


    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        try {
            String sql = "select id_accidentes from accidentes "
                    + "where accidentes.nombre = '" + jComboBoxLocalidades.getSelectedItem() + "'";
            System.out.println(sql);
            ResultSet rs = Inicio.sente.consulta(sql);
            if (rs.next()) {
                String sqlReporte = "SELECT\n"
                        + "     localidades.nombre AS localidades_nombre, \n"
                        + "     rios_localidades.km AS rios_localidades_km,\n"
                        + "     accidentes.nombre AS accidentes_nombre \n"
                        + "FROM\n"
                        + "     localidades, rios_localidades, accidentes \n"
                        + "WHERE\n"
                        + "     accidentes.id_accidentes = " + rs.getString("id_accidentes") + " AND \n"
                        + "     (localidades.id_localidad = rios_localidades.id_localidad) AND \n"
                        + "     (accidentes.id_accidentes = rios_localidades.id_accidentes)";
                System.out.println(sqlReporte);
                String dirReporte = "Reportes/ReportLocalidades.jasper";
                Reportes rep = new Reportes();
                rep.GenerarRepor(sqlReporte, dirReporte, "", "");
            }
        } catch (SQLException ex) {
            System.out.println("Excepción: al momento de generar reporte de Las localidades que posee un rio"
                    + ex);
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jComboBoxLocalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLocalidadesActionPerformed

    }//GEN-LAST:event_jComboBoxLocalidadesActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarAccidentes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarAccidentes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarAccidentes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarAccidentes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarAccidentes().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTabbedPane Montaña;
    private javax.swing.JButton btnGenerarReportLagos;
    private javax.swing.JButton btnGenerarReportMonta;
    private javax.swing.JButton btnGenerarReportRios;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxLocalidades;
    private javax.swing.JDialog jDialogLocalidades;
    private javax.swing.JDialog jDialogReportLocalidad;
    private javax.swing.JLabel jLabelDiajogSelecLoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableLago;
    private javax.swing.JTable jTableLocalidades;
    private javax.swing.JTable jTableMont;
    private javax.swing.JTable jTableRios;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JButton jbtnElimL;
    private javax.swing.JButton jbtnElimM;
    private javax.swing.JButton jbtnElimR;
    private javax.swing.JButton jbtnModL;
    private javax.swing.JButton jbtnModM;
    private javax.swing.JButton jbtnModR;
    // End of variables declaration//GEN-END:variables
}
