package org.miguelyac.reportes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.miguelyac.db.Conexion;

public class Grafico {
    public static void Graficar(String fecha){
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Conexion cn = new Conexion();
        try{
            String sql = "SELECT total FROM tbl_venta WHERE fecha = ?";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            rs = ps.executeQuery();
            DefaultPieDataset dateset = new DefaultPieDataset();
            while(rs.next()){
                dateset.setValue(rs.getString("total"),rs.getDouble("total"));
            }
            JFreeChart jf = ChartFactory.createPieChart("Reporte De Ventas",dateset);
            ChartFrame f = new ChartFrame("Total De Ventas Por Dia", jf);
            f.setSize(1000, 500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
}
