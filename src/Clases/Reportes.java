/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.net.URL;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public class Reportes {
    // comandos puede ser tambien

    Sentencias sen = new Sentencias();

    public Reportes() {
    }

    // definimos un metodo con dos variables de entrada sql=contendra la 
    //consulta de mysql y dir=la direccion del reporte
    public void GenerarRepor(String sql, String dir, String nomParametro, String parametro) {
        ResultSet rs = sen.consulta(sql);
        //jrRS, contiene la consulta sql,JRResultSetDataSource tipo de resultset para 
        //ireport
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
        // HashMap, un mapa de entrada de datos para el reporte , esto esta vacio
        HashMap parametros = new HashMap();
        parametros.put(nomParametro, parametro);
        try {
            //   direccion donde se encuetra nuestro reporte.jasper(dir)
            URL urlDireccion = getClass().getClassLoader().getResource(dir);
            // Cargamos el reporte, especificando la direccion
            //donde se encuentra el reporte
            JasperReport reporte = (JasperReport) JRLoader.loadObject(urlDireccion);
            //cargamos una variable reporteImprimir con el reporte, los parametros, y 
            //el resultado de la consulta
            JasperPrint reporteImprimir = JasperFillManager.fillReport(reporte, parametros, jrRS);
            //mostramos la ventana, con un titulo y los hacemos visible
            JasperViewer verVentana = new JasperViewer(reporteImprimir, false);
            verVentana.setTitle("Reporte de paises");
            verVentana.setVisible(true);
            verVentana.setLocationRelativeTo(null);

            //Cargar icono
            verVentana.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/iconoMain.png")).getImage());
        } catch (JRException e) {//mostramos el error con e
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e, "ATENCION ",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
