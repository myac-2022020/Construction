/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.miguelyac.vista;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.miguelyac.controlador.ProductosDAO;
import org.miguelyac.controlador.VentaDAO;
import org.miguelyac.modelo.Productos;
import org.miguelyac.modelo.Venta;
import org.miguelyac.modelo.Cliente;
import org.miguelyac.controlador.ClienteDAO;
import org.miguelyac.modelo.Detalle;
import org.miguelyac.modelo.Login;
import org.miguelyac.controlador.LoginDAO;
import org.miguelyac.modelo.DatosDeEmpresa;
import org.miguelyac.vista.Principal;
/**
 *
 * @author santiago
 */
public class PrincipalClientes extends javax.swing.JFrame {
    Productos pd = new Productos();
    ProductosDAO  products = new ProductosDAO();
    Venta vt = new Venta();
    VentaDAO venta = new VentaDAO();
    Detalle Dv = new Detalle();
    DefaultTableModel modelo = new DefaultTableModel();
    Cliente cl = new Cliente();
    ClienteDAO client = new ClienteDAO();
    Login lg = new Login();
    LoginDAO login = new LoginDAO();
    DatosDeEmpresa config = new DatosDeEmpresa();
    Principal ps = new Principal();
    int item;
    double TotalPagar = 0.00;
    public PrincipalClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
        public void ListarProductos(){
        List<Productos> ListarPD = products.ListarProductos();
        modelo = (DefaultTableModel) TableProductos.getModel();
        Object[] ob = new Object[6];
        for(int i=0; i< ListarPD.size(); i++){
            ob[0] = ListarPD.get(i).getCodigo();
            ob[1] = ListarPD.get(i).getDescripcion();
            ob[2] = ListarPD.get(i).getNombre();
            ob[3] = ListarPD.get(i).getPrecio();
            modelo.addRow(ob);
        }
        TableProductos.setModel(modelo);
    }
    public void LimpiarTabla(){
        for(int i=0; i<modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelDePortada = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblVendedor = new javax.swing.JLabel();
        PanelDeClientes = new javax.swing.JPanel();
        TabedPane = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtExistencias = new javax.swing.JTextField();
        txtIDProd = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCompra = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNIT = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDPI = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btnGenerarVenta = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableProductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        PanelDeConfig = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtNombreUsuario = new javax.swing.JTextField();
        txtCorreoUsuario = new javax.swing.JTextField();
        txtPassUsuario = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnAyuda = new javax.swing.JButton();
        txtIDUSUARIO = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelDePortada.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Logo.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Nventa.png"))); // NOI18N
        jButton1.setText("ᴄᴏᴍᴘʀᴀs");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/producto.png"))); // NOI18N
        jButton2.setText("ᴘʀᴏᴅᴜᴄᴛᴏs");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/config.png"))); // NOI18N
        jButton3.setText("ᴄᴏɴFɪɢ");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lblVendedor.setForeground(new java.awt.Color(255, 255, 255));
        lblVendedor.setText("Constructora OMEG4");

        javax.swing.GroupLayout PanelDePortadaLayout = new javax.swing.GroupLayout(PanelDePortada);
        PanelDePortada.setLayout(PanelDePortadaLayout);
        PanelDePortadaLayout.setHorizontalGroup(
            PanelDePortadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDePortadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDePortadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDePortadaLayout.createSequentialGroup()
                        .addGroup(PanelDePortadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelDePortadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelDePortadaLayout.setVerticalGroup(
            PanelDePortadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDePortadaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVendedor)
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );

        getContentPane().add(PanelDePortada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        PanelDeClientes.setBackground(new java.awt.Color(0, 0, 0));
        PanelDeClientes.setPreferredSize(new java.awt.Dimension(1148, 600));

        jLabel11.setText("Codigo");

        jLabel12.setText("Descripcion");

        jLabel13.setText("Cantidad");

        jLabel14.setText("Precio");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        txtDescripcion.setEditable(false);

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });

        txtPrecio.setEditable(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        txtExistencias.setEditable(false);

        txtIDProd.setEditable(false);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/eliminar.png"))); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        TableCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableCompra);
        if (TableCompra.getColumnModel().getColumnCount() > 0) {
            TableCompra.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableCompra.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableCompra.getColumnModel().getColumn(2).setPreferredWidth(50);
            TableCompra.getColumnModel().getColumn(3).setPreferredWidth(50);
            TableCompra.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Nventa.png"))); // NOI18N
        jLabel2.setText("Area De Compras");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel4.setText("NIT");

        txtNIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNITKeyPressed(evt);
            }
        });

        jLabel21.setText("Nombre");

        txtNombre.setEditable(false);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/money.png"))); // NOI18N
        jLabel22.setText("Total A Pagar");

        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/print.png"))); // NOI18N
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        lblTotal.setText("---");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescripcion)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(txtExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtIDProd, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(14, 14, 14))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(77, 77, 77)
                        .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)
                        .addGap(0, 178, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIDProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel21))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(lblTotal))
                                .addGap(40, 40, 40))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );

        TabedPane.addTab("Ventas", jPanel4);

        TableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Marca", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TableProductos);
        if (TableProductos.getColumnModel().getColumnCount() > 0) {
            TableProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
            TableProductos.getColumnModel().getColumn(1).setPreferredWidth(150);
            TableProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableProductos.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/producto.png"))); // NOI18N
        jLabel3.setText("Catalogo De Productos");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel3)
                .addContainerGap(394, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        TabedPane.addTab("Productos", jPanel3);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Clientes.png"))); // NOI18N
        jLabel6.setText("Usuario");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/config.png"))); // NOI18N
        jLabel16.setText("Configuracion");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel5.setText("Nombre");

        jLabel18.setText("Contraseña");

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        txtCorreoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoUsuarioKeyPressed(evt);
            }
        });

        jLabel20.setText("Correo");

        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/ayuda.png"))); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        txtIDUSUARIO.setEditable(false);

        javax.swing.GroupLayout PanelDeConfigLayout = new javax.swing.GroupLayout(PanelDeConfig);
        PanelDeConfig.setLayout(PanelDeConfigLayout);
        PanelDeConfigLayout.setHorizontalGroup(
            PanelDeConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDeConfigLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(404, 404, 404))
            .addGroup(PanelDeConfigLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addGroup(PanelDeConfigLayout.createSequentialGroup()
                .addGroup(PanelDeConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDeConfigLayout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jLabel6))
                    .addGroup(PanelDeConfigLayout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addGroup(PanelDeConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(txtPassUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelDeConfigLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(PanelDeConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelDeConfigLayout.createSequentialGroup()
                                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(243, 243, 243)
                                .addGroup(PanelDeConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))))))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(PanelDeConfigLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnAyuda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIDUSUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(374, 374, 374))
        );
        PanelDeConfigLayout.setVerticalGroup(
            PanelDeConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeConfigLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelDeConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDeConfigLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnAyuda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(PanelDeConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelDeConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(PanelDeConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar))
                        .addGap(27, 27, 27))
                    .addGroup(PanelDeConfigLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(txtIDUSUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        TabedPane.addTab("Config", PanelDeConfig);

        javax.swing.GroupLayout PanelDeClientesLayout = new javax.swing.GroupLayout(PanelDeClientes);
        PanelDeClientes.setLayout(PanelDeClientesLayout);
        PanelDeClientesLayout.setHorizontalGroup(
            PanelDeClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDeClientesLayout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addComponent(TabedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelDeClientesLayout.setVerticalGroup(
            PanelDeClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDeClientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TabedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(PanelDeClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 580));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/config.png"))); // NOI18N
        jMenu1.setText("Opciones");
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Clientes.png"))); // NOI18N
        jMenuItem2.setText("Crear Cliente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       CrearCliente cl = new CrearCliente();
       cl.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LimpiarTabla();
        ListarProductos();
        TabedPane.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TabedPane.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TabedPane.setSelectedIndex(2);
        txtCorreoUsuario.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtCodigo.getText())){
                String cod = txtCodigo.getText();
                pd = products.buscarProductos(cod);
                if(pd.getDescripcion() != null){
                    txtDescripcion.setText(""+pd.getDescripcion());
                    txtPrecio.setText(""+pd.getPrecio());
                    txtExistencias.setText(""+pd.getStock());
                    txtCantidad.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "Codigo De Producto Inexistente");
                    LimpiarCompra();
                    txtCodigo.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese el Codigo de un producto");
                txtCodigo.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCantidad.getText())) {
                String cod = txtCodigo.getText();
                String descripcion = txtDescripcion.getText();
                int cant = Integer.parseInt(txtCantidad.getText());
                double precio = Double.parseDouble(txtPrecio.getText());
                double total = cant * precio;
                int stock = Integer.parseInt(txtExistencias.getText());
                if (stock >= cant) {
                    item = item + 1;
                    DefaultTableModel tmp = new DefaultTableModel();
                    tmp = (DefaultTableModel) TableCompra.getModel();
                    for (int i = 0; i < TableCompra.getRowCount(); i++) {
                        if (TableCompra.getValueAt(i, 1).equals(txtDescripcion.getText())) {
                            LimpiarCompra();
                            txtCodigo.requestFocus();
                            JOptionPane.showMessageDialog(null, "El producto ya esta registrado");
                            return;
                        }
                    }
                    ArrayList lista = new ArrayList();
                    lista.add(item);
                    lista.add(cod);
                    lista.add(descripcion);
                    lista.add(cant);
                    lista.add(precio);
                    lista.add(total);
                    Object[] O = new Object[6];
                    O[0] = lista.get(1);
                    O[1] = lista.get(2);
                    O[2] = lista.get(3);
                    O[3] = lista.get(4);
                    O[4] = lista.get(5);
                    tmp.addRow(O);
                    TableCompra.setModel(tmp);
                    Totalpagar();
                    LimpiarCompra();
                    txtCodigo.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Existencias Insuficientes");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese Una Cantidad");
            }
        }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        modelo = (DefaultTableModel) TableCompra.getModel();
        modelo.removeRow(TableCompra.getSelectedRow());
        Totalpagar();
        txtCodigo.requestFocus();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtNITKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNITKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtNIT.getText())){
                int NIT = Integer.parseInt(txtNIT.getText());
                cl = client.buscarCliente(NIT);
                if(cl.getNombre() != null){
                    txtNombre.setText(""+cl.getNombre());
                    txtDPI.setText(""+cl.getDPI());
                    txtTelefono.setText(""+cl.getTelefono());
                    txtDireccion.setText(""+cl.getDireccion());
                }else{
                    txtNIT.setText("");
                    txtNombre.setText("");
                    txtDPI.setText("");
                    txtTelefono.setText("");
                    txtDireccion.setText("");
                    txtNIT.requestFocus();
                    JOptionPane.showMessageDialog(null, "El Cliente No Existe");
                }
            }else{
                txtNIT.setText("");
                txtNombre.setText("");
                txtDPI.setText("");
                txtTelefono.setText("");
                txtDireccion.setText("");
                txtNIT.requestFocus();
                JOptionPane.showMessageDialog(null, "Ingrese un NIT por favor");
            }
        }
    }//GEN-LAST:event_txtNITKeyPressed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        CrearVenta();
        CrearDetalle();
        ActualizarStock();
        PDF();
        JOptionPane.showMessageDialog(null, "Compra Realizada Exitosamente");
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void txtCorreoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoUsuarioKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtCorreoUsuario.getText())){
                String correo = txtCorreoUsuario.getText();
                lg = login.buscarUsuario(correo);
                if(lg.getNombre() != null){
                    txtIDUSUARIO.setText(""+lg.getId_usuario());
                    txtNombreUsuario.setText(""+lg.getNombre());
                    txtPassUsuario.setText(""+lg.getPass());
                    txtNombre.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "Correo de usuario inexistente");
                    LimpiarUsuario();
                    txtCorreoUsuario.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un correo por favor");
                LimpiarUsuario();
                txtCorreoUsuario.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCorreoUsuarioKeyPressed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(null, "Bienvenido a nuestro sisrema de usuarios \nIngrese el correo "
                + "que le fue pedido al momento de registrarse \n"
                + "Una ves hecho esto presione la tecla ENTER");
        txtCorreoUsuario.requestFocus();
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if ("".equals(txtIDUSUARIO.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(txtNombreUsuario.getText()) || !"".equals(txtCorreoUsuario.getText()) || !"".equals(txtPassUsuario.getText())) {
                lg.setNombre(txtNombreUsuario.getText());
                lg.setCorreo(txtCorreoUsuario.getText());
                lg.setPass(txtPassUsuario.getText());
                lg.setId_usuario(Integer.parseInt(txtIDUSUARIO.getText()));
                login.ModificarUsuario(lg);
                JOptionPane.showMessageDialog(null, "Usuario Modificado");
                LimpiarUsuario();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(!"".equals(txtIDUSUARIO.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de querer eliminar??\n"
                    + "Si da click en aceptar, saldra automaticamente de el sistema");
            if(pregunta == 0){
                int id_usuario = Integer.parseInt(txtIDUSUARIO.getText());
                login.EliminarUsuario(id_usuario);
                JOptionPane.showMessageDialog(null, "Usuario Eliminado exitosamente");
                System.exit(0);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDeClientes;
    private javax.swing.JPanel PanelDeConfig;
    private javax.swing.JPanel PanelDePortada;
    private javax.swing.JTabbedPane TabedPane;
    private javax.swing.JTable TableCompra;
    private javax.swing.JTable TableProductos;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreoUsuario;
    private javax.swing.JTextField txtDPI;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtExistencias;
    private javax.swing.JTextField txtIDProd;
    private javax.swing.JTextField txtIDUSUARIO;
    private javax.swing.JTextField txtNIT;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPassUsuario;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
      private void LimpiarCompra(){
          txtCodigo.setText("");
          txtDescripcion.setText("");
          txtCantidad.setText("");
          txtPrecio.setText("");
          txtExistencias.setText("");
          txtIDProd.setText("");
      }
      private void Totalpagar(){
        TotalPagar = 0.00;
        int numFila = TableCompra.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(TableCompra.getModel().getValueAt(i, 4)));
            TotalPagar = TotalPagar + cal;
        }
        lblTotal.setText(String.format("%.2f", TotalPagar));
    }
      private void CrearVenta(){
        String cliente = txtNombre.getText();
        String vendedor = lblVendedor.getText();
        double monto = TotalPagar;
        vt.setCliente(cliente);
        vt.setVendedor(vendedor);
        vt.setTotal(monto);
        venta.GuardarVenta(vt);
    }
    private void CrearDetalle(){
        for (int i = 0; i < TableCompra.getRowCount(); i++) {
            String cod = TableCompra.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(TableCompra.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(TableCompra.getValueAt(i, 4).toString());
            int id = 1;
            Dv.setCod_pro(cod);
            Dv.setCantidad(cant);
            Dv.setPrecio(precio);
            Dv.setId_detalle(id);
            venta.RegistrarDetalle(Dv);
        }
    }
    private void ActualizarStock(){
        for (int i = 0; i < TableCompra.getRowCount(); i++) {
            String cod = TableCompra.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(TableCompra.getValueAt(i, 2).toString());
            pd = products.buscarProductos(cod);
            int StockActual = pd.getStock() - cant;
            venta.actualizarStock(StockActual, cod);
        }
    }
    private void LimpiarUsuario(){
        txtNombreUsuario.setText("");
        txtCorreoUsuario.setText("");
        txtPassUsuario.setText("");
    }
    private void PDF(){
        try{
            int id = venta.IdVenta();
            FileOutputStream archivo;
            File file = new File("src/org/miguelyac/pdf/Venta"+id+".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            //Aca se especifica todo sobre el archivo PDF
            Image img = Image.getInstance("src/org/miguelyac/recursos/Logo.png");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Factura NO: "+id+"\n"+"fecha: "+ new SimpleDateFormat("dd-MM-yyyy").format(date)+"\n\n");
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            Encabezado.addCell(img);
            //Datos de encabezado de la factura;
            config = venta.buscarDatos();
            String nombre = ""+config.getNombre();
            String tel = ""+config.getTelefono();
            String correo = ""+config.getCorreo();
            String direc = ""+config.getDireccion();
            
            Encabezado.addCell("");
            Encabezado.addCell("Nombre:"+nombre+ "\nTelefono:"+tel+"\nCorreo: "+correo+"\nDireccion:"+direc);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            
            //Creamos pharagraph para los clientes
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("Datos De Cliente"+ "\n\n");
            doc.add(cli);
            
            PdfPTable TableCliente = new PdfPTable(4);
            TableCliente.setWidthPercentage(100);
            TableCliente.getDefaultCell().setBorder(0);
            float[] ColumnaCli = new float[]{20f, 50f, 30f, 40f};
            TableCliente.setWidths(ColumnaCli);
            TableCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cl1 = new PdfPCell(new Phrase("NIT",negrita));
            PdfPCell cl2 = new PdfPCell(new Phrase("Nombre",negrita));
            PdfPCell cl3 = new PdfPCell(new Phrase("Telefono",negrita));
            PdfPCell cl4 = new PdfPCell(new Phrase("Direccion",negrita));
            cl1.setBorder(0);
            cl2.setBorder(0);
            cl3.setBorder(0);
            cl4.setBorder(0);
            TableCliente.addCell(cl1);
            TableCliente.addCell(cl2);
            TableCliente.addCell(cl3);
            TableCliente.addCell(cl4);
            TableCliente.addCell(txtNIT.getText());
            TableCliente.addCell(txtNombre.getText());
            TableCliente.addCell(txtTelefono.getText());
            TableCliente.addCell(txtDireccion.getText());
            doc.add(TableCliente);
            
            PdfPTable TableProd = new PdfPTable(4);
            TableProd.setWidthPercentage(100);
            TableProd.getDefaultCell().setBorder(0);
            float[] ColumnaProd = new float[]{10f, 50f, 15f, 20f};
            TableProd.setWidths(ColumnaCli);
            TableProd.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pro1 = new PdfPCell(new Phrase("Cant",negrita));
            PdfPCell pro2 = new PdfPCell(new Phrase("Descripcion",negrita));
            PdfPCell pro3 = new PdfPCell(new Phrase("Precio U.",negrita));
            PdfPCell pro4 = new PdfPCell(new Phrase("Total",negrita));
            pro1.setBorder(0);
            pro2.setBorder(0);
            pro3.setBorder(0);
            pro4.setBorder(0);
            pro1.setBackgroundColor(BaseColor.DARK_GRAY);
            pro2.setBackgroundColor(BaseColor.DARK_GRAY);
            pro3.setBackgroundColor(BaseColor.DARK_GRAY);
            pro4.setBackgroundColor(BaseColor.DARK_GRAY);
            TableProd.addCell(pro1);
            TableProd.addCell(pro2);
            TableProd.addCell(pro3);
            TableProd.addCell(pro4);
            for (int i = 0; i < TableCompra.getRowCount(); i++) {
                String cantidad = TableCompra.getValueAt(i, 2).toString();
                String producto = TableCompra.getValueAt(i, 1).toString();
                String precio = TableCompra.getValueAt(i, 3).toString();
                String total = TableCompra.getValueAt(i, 4).toString();
                TableProd.addCell(cantidad);
                TableProd.addCell(producto);
                TableProd.addCell(precio);
                TableProd.addCell(total);
            }
            doc.add(TableProd);
            
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total A Pagar: "+TotalPagar);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Firma De Cancelacion\n");
            firma.add("    Alex Campos     \n");
            firma.add(" Gerente de empresa ");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("Gracias Por Su Compra :)");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            // Aca cierra el archivo PDF
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        }catch(DocumentException | IOException e){
            System.out.println(e.toString());
        }
    }
}
