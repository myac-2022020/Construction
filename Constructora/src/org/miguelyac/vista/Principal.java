package org.miguelyac.vista;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.miguelyac.controlador.ClienteDAO;
import org.miguelyac.controlador.LoginDAO;
import org.miguelyac.controlador.ProductosDAO;
import org.miguelyac.controlador.VentaDAO;
import org.miguelyac.controlador.adminDAO;
import org.miguelyac.modelo.Cliente;
import org.miguelyac.modelo.DatosDeEmpresa;
import org.miguelyac.modelo.Detalle;
import org.miguelyac.modelo.Login;
import org.miguelyac.modelo.LoginAdmin;
import org.miguelyac.modelo.Productos;
import org.miguelyac.modelo.Venta;
import org.miguelyac.reportes.Grafico;

class PanelDeImagen extends JPanel{
    private Image imagen;
    public PanelDeImagen(Image imagen){
        this.imagen = imagen;
    }
    @Override
    protected void paintComponent(Graphics grafico){
        super.paintComponent(grafico);
        grafico.drawImage(imagen,0,0,1148,627,this);
    }
}
public class Principal extends javax.swing.JFrame {
    Date fechaVenta = new Date();
    String fechaActual = new SimpleDateFormat("dd/MM/yyyy").format(fechaVenta);
    Cliente cl = new Cliente();
    ClienteDAO cliente = new ClienteDAO();
    LoginAdmin ad = new LoginAdmin();
    adminDAO admin = new adminDAO();
    Login lg = new Login();
    LoginDAO login = new LoginDAO();
    Productos pd = new Productos();
    ProductosDAO  products = new ProductosDAO();
    Venta vt = new Venta();
    VentaDAO ventas = new VentaDAO();
    Detalle Dv = new Detalle();
    DefaultTableModel modelo = new DefaultTableModel();
    DatosDeEmpresa config = new DatosDeEmpresa();
    private Image imagenDeFondo;
    int item;
    double TotalPagar = 0.00;
    public Principal() {
        String nombreImagen = "/org/miguelyac/recursos/FondoConstruccion.png";
        cargarImagenDeFondo(this.getClass().getResource(nombreImagen));
        initComponents();
        this.setLocationRelativeTo(null);
        ListarConfig();
    }
    public void cargarImagenDeFondo(URL nombreImagen){
        try{
            imagenDeFondo = ImageIO.read(nombreImagen);
        }catch(IOException error){
            error.printStackTrace();
        }
    }
    public void ListarUsuarios(){
        List<Login> ListarUS = login.ListarUsuarios();
        modelo = (DefaultTableModel) TableUsuario.getModel();
        Object[] ob = new Object[4];
        for(int i=0; i < ListarUS.size();i++){
            ob[0] = ListarUS.get(i).getId_usuario();
            ob[1] = ListarUS.get(i).getNombre();
            ob[2] = ListarUS.get(i).getCorreo();
            ob[3] = ListarUS.get(i).getPass();
            modelo.addRow(ob);
        }
        TableUsuario.setModel(modelo);
    }
    public void ListarCliente(){
        List<Cliente> ListarCL = cliente.ListarCliente();
        modelo = (DefaultTableModel) TableClientes.getModel();
        Object[] ob = new Object[9];
        for(int i=0; i < ListarCL.size();i++){
            ob[0] = ListarCL.get(i).getId_cliente();
            ob[1] = ListarCL.get(i).getNIT();
            ob[2] = ListarCL.get(i).getDPI();
            ob[3] = ListarCL.get(i).getNombre();
            ob[4] = ListarCL.get(i).getTelefono();
            ob[5] = ListarCL.get(i).getDireccion();
            modelo.addRow(ob);
        }
        TableClientes.setModel(modelo);
    }
    public void ListarPorductos(){
        List<Productos> ListarPD = products.ListarProductos();
        modelo = (DefaultTableModel) TableProductos.getModel();
        Object[] ob = new Object[6];
        for(int i=0; i< ListarPD.size(); i++){
            ob[0] = ListarPD.get(i).getId_producto();
            ob[1] = ListarPD.get(i).getCodigo();
            ob[2] = ListarPD.get(i).getDescripcion();
            ob[3] = ListarPD.get(i).getNombre();
            ob[4] = ListarPD.get(i).getStock();
            ob[5] = ListarPD.get(i).getPrecio();
            modelo.addRow(ob);
        }
        TableProductos.setModel(modelo);
    }
    public void ListarAdmin(){
        List<LoginAdmin> ListarAdmin = admin.ListarAdmin();
        modelo = (DefaultTableModel) TableAdmins.getModel();
        Object[] ob = new Object[4];
        for(int i=0; i < ListarAdmin.size(); i++){
            ob[0] = ListarAdmin.get(i).getId_admin();
            ob[1] = ListarAdmin.get(i).getNombre_admin();
            ob[2] = ListarAdmin.get(i).getCorreo_admin();
            ob[3] = ListarAdmin.get(i).getPass_admin();
            modelo.addRow(ob);
        }TableAdmins.setModel(modelo);
    }
    public void ListarUsuarios2(){
        List<Login> ListarUS = login.ListarUsuarios();
        modelo = (DefaultTableModel) TableAscenso.getModel();
        Object[] ob = new Object[4];
        for(int i=0; i < ListarUS.size();i++){
            ob[0] = ListarUS.get(i).getId_usuario();
            ob[1] = ListarUS.get(i).getNombre();
            ob[2] = ListarUS.get(i).getCorreo();
            ob[3] = ListarUS.get(i).getPass();
            modelo.addRow(ob);
        }
        TableAscenso.setModel(modelo);
    }
    public void ListarProductos(){
        List<Productos> ListarPD = products.ListarProductos();
        modelo = (DefaultTableModel) TableProductos.getModel();
        Object[] ob = new Object[6];
        for(int i=0; i < ListarPD.size(); i++){
            ob[0] = ListarPD.get(i).getId_producto();
            ob[1] = ListarPD.get(i).getCodigo();
            ob[2] = ListarPD.get(i).getDescripcion();
            ob[3] = ListarPD.get(i).getNombre();
            ob[4] = ListarPD.get(i).getStock();
            ob[5] = ListarPD.get(i).getPrecio();
            modelo.addRow(ob);
        }TableProductos.setModel(modelo);
    }
    public void ListarVenta(){
        List<Venta> ListaVentas = ventas.ListarVenta();
        modelo = (DefaultTableModel) TableControlVentas.getModel();
        Object[] o = new Object[5];
        for (int i = 0; i < ListaVentas.size(); i++) {
            o[0] = ListaVentas.get(i).getId_venta();
            o[1] = ListaVentas.get(i).getCliente();
            o[2] = ListaVentas.get(i).getVendedor();
            o[3] = ListaVentas.get(i).getTotal();
            o[4] = ListaVentas.get(i).getFecha();
            modelo.addRow(o);
        }TableControlVentas.setModel(modelo);
        
    }
    public void ListarConfig(){
        config = ventas.buscarDatos();
        txtIDConfig.setText(""+config.getId_config());
        txtNombreEmpresa.setText(""+config.getNombre());
        txtTelefonoEmpresa.setText(""+config.getTelefono());
        txtCorreoEmpresa.setText(""+config.getCorreo());
        txtDireccionEmpresa.setText(""+config.getDireccion());
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

        PanelDeAdmin = new PanelDeImagen(imagenDeFondo);
        jPanel1 = new javax.swing.JPanel();
        lblVendedor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnAscenso = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtExistencias = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCompra = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtNIT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtDPI = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnGraficar = new javax.swing.JButton();
        MyDate = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtNITCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableClientes = new javax.swing.JTable();
        btnGuardarCliente = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        txtIDCliente = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtDPICliente = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnGuardarUsuario = new javax.swing.JButton();
        btnActualizarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnNuevoUsuario = new javax.swing.JButton();
        txtNombreUsuario = new javax.swing.JTextField();
        txtCorreoUsuario = new javax.swing.JTextField();
        txtPassUsuario = new javax.swing.JPasswordField();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableUsuario = new javax.swing.JTable();
        txtIDUSUARIO = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNombreAscenso = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCorreoAscenso = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPassAscenso = new javax.swing.JPasswordField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableAscenso = new javax.swing.JTable();
        btnAscenderUsuario = new javax.swing.JButton();
        txtIDUsuario = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDescripcionProducto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        btnActualizarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnGuardarProducto = new javax.swing.JButton();
        btnNuevoProducto = new javax.swing.JButton();
        txtIDProducto = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableProductos = new javax.swing.JTable();
        lblPrecioProducto = new javax.swing.JLabel();
        txtPrecioProducto = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableControlVentas = new javax.swing.JTable();
        btnGenerarPDF = new javax.swing.JButton();
        txtIDVenta = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtNombreAdmin = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtCorreoAdmin = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtPassAdmin = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableAdmins = new javax.swing.JTable();
        btnActualizarAdmin = new javax.swing.JButton();
        btnEiminarAdmin = new javax.swing.JButton();
        txtIDAdmin = new javax.swing.JTextField();
        btnLimpiarAdmin = new javax.swing.JButton();
        btnGuardarAdmin = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtTelefonoEmpresa = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtDireccionEmpresa = new javax.swing.JTextField();
        txtIDConfig = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCorreoEmpresa = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblVendedor.setForeground(new java.awt.Color(255, 255, 255));
        lblVendedor.setText("Constructora OMEG4");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Logo.png"))); // NOI18N

        btnComprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Nventa.png"))); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnAscenso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Icono_Ascenso.png"))); // NOI18N
        btnAscenso.setText("Ascenso");
        btnAscenso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAscensoActionPerformed(evt);
            }
        });

        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/producto.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/compras.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/config.png"))); // NOI18N
        btnConfig.setText("Config");
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Icono Usuario.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/icono admin.png"))); // NOI18N
        jButton1.setText("Admins");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAscenso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblVendedor)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVendedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnComprar)
                .addGap(18, 18, 18)
                .addComponent(btnClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAscenso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProductos)
                .addGap(18, 18, 18)
                .addComponent(btnVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btnConfig)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Codigo");

        jLabel3.setText("Descripcion");

        jLabel4.setText("Cantidad");

        jLabel5.setText("Precio");

        jLabel6.setText("Existencias");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        txtDescripcion.setEditable(false);

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
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

        txtID.setEditable(false);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableCompra);
        if (TableCompra.getColumnModel().getColumnCount() > 0) {
            TableCompra.getColumnModel().getColumn(0).setPreferredWidth(15);
            TableCompra.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableCompra.getColumnModel().getColumn(2).setPreferredWidth(20);
            TableCompra.getColumnModel().getColumn(3).setPreferredWidth(20);
            TableCompra.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        jLabel7.setText("NIT");

        txtNIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNITKeyPressed(evt);
            }
        });

        jLabel8.setText("Nombre");

        txtNombre.setEditable(false);

        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/print.png"))); // NOI18N
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/money.png"))); // NOI18N
        jLabel9.setText("Total A Pagar");

        txtDPI.setEditable(false);

        txtTelefono.setEditable(false);

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTotal.setText("---");

        txtDireccion.setEditable(false);

        btnGraficar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/torta.png"))); // NOI18N
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        jLabel33.setText("Seleccionar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnGenerarVenta)
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel9)
                                        .addGap(32, 32, 32)
                                        .addComponent(lblTotal)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(btnGraficar))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(MyDate, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar)
                                .addGap(44, 44, 44))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGraficar)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MyDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerarVenta)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(lblTotal)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Compras", jPanel2);

        jLabel10.setText("NIT");

        jLabel11.setText("Nombre");

        jLabel12.setText("Telefono");

        jLabel13.setText("Direccion");

        TableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NIT", "DPI", "Nombre", "Telefono", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableClientes);
        if (TableClientes.getColumnModel().getColumnCount() > 0) {
            TableClientes.getColumnModel().getColumn(0).setPreferredWidth(15);
            TableClientes.getColumnModel().getColumn(1).setPreferredWidth(30);
            TableClientes.getColumnModel().getColumn(2).setPreferredWidth(50);
            TableClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
            TableClientes.getColumnModel().getColumn(4).setPreferredWidth(40);
            TableClientes.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        btnGuardarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/GuardarTodo.png"))); // NOI18N
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/nuevo.png"))); // NOI18N
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/eliminar.png"))); // NOI18N
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnActualizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Actualizar.png"))); // NOI18N
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        txtIDCliente.setEditable(false);

        jLabel25.setText("DPI");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDireccionCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNITCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDPICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel25))
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminarCliente)
                            .addComponent(btnGuardarCliente))
                        .addGap(46, 46, 46)
                        .addComponent(btnActualizarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevoCliente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNITCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDPICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardarCliente))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnNuevoCliente)
                                    .addComponent(btnActualizarCliente))))
                        .addGap(28, 28, 28)
                        .addComponent(btnEliminarCliente))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel3);

        jLabel24.setText("Nombre");

        lblCorreo.setText("Correo");

        jLabel27.setText("Contraseña");

        btnGuardarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/GuardarTodo.png"))); // NOI18N
        btnGuardarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuarioActionPerformed(evt);
            }
        });

        btnActualizarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Actualizar.png"))); // NOI18N
        btnActualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/eliminar.png"))); // NOI18N
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        btnNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/nuevo.png"))); // NOI18N
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });

        TableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Correo", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUsuarioMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TableUsuario);
        if (TableUsuario.getColumnModel().getColumnCount() > 0) {
            TableUsuario.getColumnModel().getColumn(1).setPreferredWidth(30);
            TableUsuario.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableUsuario.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        txtIDUSUARIO.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarUsuario)
                            .addComponent(btnActualizarUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(83, 83, 83))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDUSUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDUSUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(lblCorreo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Usuarios", jPanel8);

        jLabel14.setText("Nombre");

        jLabel15.setText("Correo");

        jLabel16.setText("Contraseña");

        TableAscenso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Correo", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableAscenso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAscensoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableAscenso);
        if (TableAscenso.getColumnModel().getColumnCount() > 0) {
            TableAscenso.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableAscenso.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableAscenso.getColumnModel().getColumn(2).setPreferredWidth(80);
            TableAscenso.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        btnAscenderUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Icono_Ascenso.png"))); // NOI18N
        btnAscenderUsuario.setText("Ascender");
        btnAscenderUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAscenderUsuarioActionPerformed(evt);
            }
        });

        txtIDUsuario.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(btnAscenderUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassAscenso, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtCorreoAscenso)
                            .addComponent(txtNombreAscenso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreAscenso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreoAscenso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassAscenso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnAscenderUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ascenso", jPanel4);

        jLabel17.setText("Codigo");

        jLabel18.setText("Descripcion");

        jLabel19.setText("Marca");

        jLabel20.setText("Stock");

        btnActualizarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Actualizar.png"))); // NOI18N
        btnActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/eliminar.png"))); // NOI18N
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnGuardarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/GuardarTodo.png"))); // NOI18N
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });

        btnNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/nuevo.png"))); // NOI18N
        btnNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProductoActionPerformed(evt);
            }
        });

        txtIDProducto.setEditable(false);

        TableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Descripcion", "Marca", "Stock", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TableProductos);
        if (TableProductos.getColumnModel().getColumnCount() > 0) {
            TableProductos.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableProductos.getColumnModel().getColumn(1).setPreferredWidth(40);
            TableProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            TableProductos.getColumnModel().getColumn(4).setPreferredWidth(40);
            TableProductos.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        lblPrecioProducto.setText("Precio");

        jLabel31.setText("GTQ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnNuevoProducto)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarProducto))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnGuardarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarProducto))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(lblPrecioProducto)
                    .addComponent(txtNombreProducto)
                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrecioProducto)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarProducto)
                            .addComponent(btnGuardarProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarProducto)
                            .addComponent(btnNuevoProducto)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos", jPanel5);

        TableControlVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Proveedot", "Total", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableControlVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableControlVentasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TableControlVentas);
        if (TableControlVentas.getColumnModel().getColumnCount() > 0) {
            TableControlVentas.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableControlVentas.getColumnModel().getColumn(1).setPreferredWidth(150);
            TableControlVentas.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableControlVentas.getColumnModel().getColumn(3).setPreferredWidth(50);
            TableControlVentas.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        btnGenerarPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/pdf.png"))); // NOI18N
        btnGenerarPDF.setText("Factura PDF");
        btnGenerarPDF.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPDFActionPerformed(evt);
            }
        });

        txtIDVenta.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnGenerarPDF)
                .addGap(38, 38, 38)
                .addComponent(txtIDVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Ventas", jPanel6);

        jLabel28.setText("Nombre");

        jLabel29.setText("Correo");

        jLabel30.setText("Contraseña");

        TableAdmins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Correo", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableAdmins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAdminsMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TableAdmins);
        if (TableAdmins.getColumnModel().getColumnCount() > 0) {
            TableAdmins.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableAdmins.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableAdmins.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableAdmins.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        btnActualizarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/Actualizar.png"))); // NOI18N
        btnActualizarAdmin.setText("Actualizar Admin");
        btnActualizarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAdminActionPerformed(evt);
            }
        });

        btnEiminarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/eliminar.png"))); // NOI18N
        btnEiminarAdmin.setText("Eliminar Admin");
        btnEiminarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEiminarAdminActionPerformed(evt);
            }
        });

        txtIDAdmin.setEditable(false);

        btnLimpiarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/nuevo.png"))); // NOI18N
        btnLimpiarAdmin.setText("Limpiar");
        btnLimpiarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAdminActionPerformed(evt);
            }
        });

        btnGuardarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/miguelyac/recursos/GuardarTodo.png"))); // NOI18N
        btnGuardarAdmin.setText("Guardar");
        btnGuardarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreoAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassAdmin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(btnGuardarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(txtIDAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEiminarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(btnGuardarAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEiminarAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiarAdmin)
                        .addGap(43, 43, 43))))
        );

        jTabbedPane1.addTab("Admins", jPanel9);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel21.setText("ᴅᴀᴛᴏꜱ ᴅᴇ ʟᴀ ᴇᴍᴘʀᴇꜱᴀ");

        jLabel22.setText("Nombre");

        jLabel23.setText("Telefono");

        jLabel26.setText("Direccion");

        txtIDConfig.setEditable(false);

        jLabel32.setText("Correo");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtIDConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(343, 343, 343))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel26)
                            .addComponent(txtDireccionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 56, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCorreoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(txtDireccionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("Config", jPanel7);

        javax.swing.GroupLayout PanelDeAdminLayout = new javax.swing.GroupLayout(PanelDeAdmin);
        PanelDeAdmin.setLayout(PanelDeAdminLayout);
        PanelDeAdminLayout.setHorizontalGroup(
            PanelDeAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDeAdminLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane1))
        );
        PanelDeAdminLayout.setVerticalGroup(
            PanelDeAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDeAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        getContentPane().add(PanelDeAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        txtCodigo.requestFocus();
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        LimpiarTabla();
        LimpiarCliente();
        ListarCliente();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnAscensoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAscensoActionPerformed
        LimpiarTabla();
        LimpiarUsuario();
        ListarUsuarios2();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnAscensoActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        LimpiarTabla();
        LimpiarProducto();
        ListarPorductos();
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        LimpiarTabla();
        ListarVenta();
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        LimpiarTabla();
        ListarUsuarios();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnGuardarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioActionPerformed
            if(!"".equals(txtNombreUsuario.getText()) || !"".equals(txtCorreoUsuario.getText()) || !"".equals(txtPassUsuario.getText())){
            lg.setNombre(txtNombreUsuario.getText());
            lg.setCorreo(txtCorreoUsuario.getText());
            lg.setPass(txtPassUsuario.getText());
            login.RegistrarUsuario(lg);
            LimpiarTabla();
            ListarUsuarios();
            LimpiarUsuario();
            JOptionPane.showMessageDialog(null, "Guardado Exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo nuevamente");
        } 
    }//GEN-LAST:event_btnGuardarUsuarioActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        if(!"".equals(txtNITCliente.getText()) || !"".equals(txtDPICliente.getText()) || !"".equals(txtNombreCliente.getText()) || !"".equals(txtTelefonoCliente.getText()) || !"".equals(txtDireccionCliente.getText())){
            cl.setNIT(Integer.parseInt(txtNITCliente.getText()));
            cl.setDPI(txtDPICliente.getText());
            cl.setNombre(txtNombreCliente.getText());
            cl.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
            cl.setDireccion(txtDireccionCliente.getText());
            cliente.RegistrarCliente(cl);
            LimpiarTabla();
            LimpiarCliente();
            ListarCliente();
            JOptionPane.showMessageDialog(null, "Cliente Registrado Exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo nuevamente");
        }
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
       if(!"".equals(txtCodigoProducto.getText()) || !"".equals(txtDescripcionProducto.getText()) || !"".equals(txtCantidadProducto.getText()) || !"".equals(txtNombreProducto.getText()) || !"".equals(txtPrecioProducto.getText())){
           pd.setCodigo(txtCodigoProducto.getText());
           pd.setDescripcion(txtDescripcionProducto.getText());
           pd.setStock(Integer.parseInt(txtCantidadProducto.getText()));
           pd.setNombre(txtNombreProducto.getText());
           pd.setPrecio(Double.parseDouble(txtPrecioProducto.getText()));
           products.RegistrarPorducto(pd);
           LimpiarTabla();
           LimpiarProducto();
           ListarProductos();
           JOptionPane.showMessageDialog(null, "Producto Guardado");
       }else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo nuevamente");
       }
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void btnAscenderUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAscenderUsuarioActionPerformed
            if(!"".equals(txtNombreAscenso.getText()) || !"".equals(txtCorreoAscenso.getText()) || !"".equals(txtPassAscenso.getText())){
            ad.setNombre_admin(txtNombreAscenso.getText());
            ad.setCorreo_admin(txtCorreoAscenso.getText());
            ad.setPass_admin(txtPassAscenso.getText());
            admin.RegistrarUsuarioAdmin(ad);
            LimpiarTabla();
            LimpiarAscenso();
            ListarUsuarios2();
            JOptionPane.showMessageDialog(null, "Ascendido Exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo nuevamente");
        } 
    }//GEN-LAST:event_btnAscenderUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       LimpiarTabla();
       ListarAdmin();
       jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableAscensoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAscensoMouseClicked
        int fila = TableAscenso.rowAtPoint(evt.getPoint());
        txtIDUsuario.setText(TableAscenso.getValueAt(fila, 0).toString());
        txtNombreAscenso.setText(TableAscenso.getValueAt(fila, 1).toString());
        txtCorreoAscenso.setText(TableAscenso.getValueAt(fila, 2).toString());
        txtPassAscenso.setText(TableAscenso.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_TableAscensoMouseClicked

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        if(!"".equals(txtIDUSUARIO.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de querer eliminar??");
            if(pregunta == 0){
                int id_usuario = Integer.parseInt(txtIDUSUARIO.getText());
                login.EliminarUsuario(id_usuario);
                LimpiarTabla();
                ListarUsuarios();
            }
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void TableUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUsuarioMouseClicked
        int fila = TableUsuario.rowAtPoint(evt.getPoint());
        txtIDUSUARIO.setText(TableUsuario.getValueAt(fila, 0).toString());
        txtNombreUsuario.setText(TableUsuario.getValueAt(fila, 1).toString());
        txtCorreoUsuario.setText(TableUsuario.getValueAt(fila, 2).toString());
        txtPassUsuario.setText(TableUsuario.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_TableUsuarioMouseClicked

    private void TableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableClientesMouseClicked
        int fila = TableClientes.rowAtPoint(evt.getPoint());
        txtIDCliente.setText(TableClientes.getValueAt(fila, 0).toString());
        txtNITCliente.setText(TableClientes.getValueAt(fila, 1).toString());
        txtDPICliente.setText(TableClientes.getValueAt(fila, 2).toString());
        txtNombreCliente.setText(TableClientes.getValueAt(fila, 3).toString());
        txtTelefonoCliente.setText(TableClientes.getValueAt(fila, 4).toString());
        txtDireccionCliente.setText(TableClientes.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TableClientesMouseClicked

    private void TableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductosMouseClicked
        int fila = TableProductos.rowAtPoint(evt.getPoint());
        txtIDProducto.setText(TableProductos.getValueAt(fila, 0).toString());
        txtCodigoProducto.setText(TableProductos.getValueAt(fila, 1).toString());
        txtDescripcionProducto.setText(TableProductos.getValueAt(fila, 2).toString());
        txtNombreProducto.setText(TableProductos.getValueAt(fila, 3).toString());
        txtCantidadProducto.setText(TableProductos.getValueAt(fila, 4).toString());
        txtPrecioProducto.setText(TableProductos.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TableProductosMouseClicked

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        if(!"".equals(txtIDProducto.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de querer eliminar??");
            if(pregunta == 0){
                int id_producto = Integer.parseInt(txtIDProducto.getText());
                products.EliminarProducto(id_producto);
                LimpiarTabla();
                ListarProductos();
            }
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProductoActionPerformed
        LimpiarProducto();
    }//GEN-LAST:event_btnNuevoProductoActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        if(!"".equals(txtIDCliente.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de querer eliminar??");
            if(pregunta == 0){
                int id_cliente = Integer.parseInt(txtIDCliente.getText());
                cliente.EliminarCliente(id_cliente);
                LimpiarTabla();
                LimpiarCliente();
                ListarCliente();
            }
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void TableAdminsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAdminsMouseClicked
        int fila = TableAdmins.rowAtPoint(evt.getPoint());
        txtIDAdmin.setText(TableAdmins.getValueAt(fila, 0).toString());
        txtNombreAdmin.setText(TableAdmins.getValueAt(fila, 1).toString());
        txtCorreoAdmin.setText(TableAdmins.getValueAt(fila, 2).toString());
        txtPassAdmin.setText(TableAdmins.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_TableAdminsMouseClicked

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        if ("".equals(txtIDCliente.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(txtNITCliente.getText()) || !"".equals(txtDPICliente.getText()) || !"".equals(txtNombreCliente.getText()) || !"".equals(txtTelefonoCliente.getText()) || !"".equals(txtDireccionCliente.getText())) {
                cl.setNIT(Integer.parseInt(txtNITCliente.getText()));
                cl.setDPI(txtDPICliente.getText());
                cl.setNombre(txtNombreCliente.getText());
                cl.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
                cl.setDireccion(txtDireccionCliente.getText());
                cl.setId_cliente(Integer.parseInt(txtIDCliente.getText()));
                cliente.ModificarCliente(cl);
                JOptionPane.showMessageDialog(null, "Cliente Modificado");
                LimpiarTabla();
                LimpiarCliente();
                ListarCliente();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        LimpiarCliente();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed
        LimpiarUsuario();
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnLimpiarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAdminActionPerformed
        LimpiarAdmins();
    }//GEN-LAST:event_btnLimpiarAdminActionPerformed

    private void btnActualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarUsuarioActionPerformed
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
                LimpiarTabla();
                LimpiarUsuario();
                ListarUsuarios();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnActualizarUsuarioActionPerformed

    private void btnEiminarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEiminarAdminActionPerformed
       if(!"".equals(txtIDAdmin.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de querer eliminar??");
            if(pregunta == 0){
                int id_admin = Integer.parseInt(txtIDAdmin.getText());
                admin.EliminarAdmin(id_admin);
                LimpiarTabla();
                LimpiarAdmins();
                ListarAdmin();
            }
        }
    }//GEN-LAST:event_btnEiminarAdminActionPerformed

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProductoActionPerformed
        if ("".equals(txtIDProducto.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(txtCodigoProducto.getText()) || !"".equals(txtDescripcionProducto.getText()) || !"".equals(txtNombreProducto.getText()) || !"".equals(txtCantidadProducto.getText()) || !"".equals(txtPrecioProducto.getText())) {
                pd.setCodigo(txtCodigoProducto.getText());
                pd.setDescripcion(txtDescripcionProducto.getText());
                pd.setNombre(txtNombreProducto.getText());
                pd.setStock(Integer.parseInt(txtCantidadProducto.getText()));
                pd.setPrecio(Double.parseDouble(txtPrecioProducto.getText()));
                pd.setId_producto(Integer.parseInt(txtIDProducto.getText()));
                products.ActualizarProductos(pd);
                JOptionPane.showMessageDialog(null, "Producto Modificado");
                LimpiarTabla();
                LimpiarProducto();
                ListarProductos();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnActualizarProductoActionPerformed

    private void btnActualizarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAdminActionPerformed
        if ("".equals(txtIDAdmin.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(txtNombreAdmin.getText()) || !"".equals(txtCorreoAdmin.getText()) || !"".equals(txtPassAdmin.getText())) {
                ad.setNombre_admin(txtNombreAdmin.getText());
                ad.setCorreo_admin(txtCorreoAdmin.getText());
                ad.setPass_admin(txtPassAdmin.getText());
                ad.setId_admin(Integer.parseInt(txtIDAdmin.getText()));
                admin.ModificarUsuario(ad);
                JOptionPane.showMessageDialog(null, "Admin Modificado");
                LimpiarTabla();
                LimpiarAdmins();
                ListarAdmin();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnActualizarAdminActionPerformed

    private void btnGuardarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAdminActionPerformed
        if(!"".equals(txtNombreAdmin.getText()) || !"".equals(txtCorreoAdmin.getText()) || !"".equals(txtPassAdmin.getText())){
            ad.setNombre_admin(txtNombreAdmin.getText());
            ad.setCorreo_admin(txtCorreoAdmin.getText());
            ad.setPass_admin(txtPassAdmin.getText());
            admin.RegistrarUsuarioAdmin(ad);
            LimpiarTabla();
            LimpiarAdmins();
            ListarAdmin();
            JOptionPane.showMessageDialog(null, "Admin agregado Exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intentelo nuevamente");
        }
    }//GEN-LAST:event_btnGuardarAdminActionPerformed

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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        modelo = (DefaultTableModel) TableCompra.getModel();
        modelo.removeRow(TableCompra.getSelectedRow());
        Totalpagar();
        txtCodigo.requestFocus();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNITKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNITKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtNIT.getText())){
                int NIT = Integer.parseInt(txtNIT.getText());
                cl = cliente.buscarCliente(NIT);
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
        LimpiarTabla();
        LimpiarDatosCliente();
        txtCodigo.requestFocus();
        JOptionPane.showMessageDialog(null, "Compra Realizada Exitosamente");
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void TableControlVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableControlVentasMouseClicked
        int fila = TableControlVentas.rowAtPoint(evt.getPoint());
        txtIDVenta.setText(TableControlVentas.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_TableControlVentasMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if ("".equals(txtIDConfig.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(txtNombreEmpresa.getText()) || !"".equals(txtTelefonoEmpresa.getText()) || !"".equals(txtCorreoEmpresa.getText()) || !"".equals(txtDireccionEmpresa.getText())) {
                config.setNombre(txtNombreEmpresa.getText());
                config.setTelefono(Integer.parseInt(txtTelefonoEmpresa.getText()));
                config.setCorreo(txtCorreoEmpresa.getText());
                config.setDireccion(txtDireccionEmpresa.getText());
                config.setId_config(Integer.parseInt(txtIDConfig.getText()));
                ventas.ModificarEmpresa(config);
                JOptionPane.showMessageDialog(null, "Datos De Empresa Modificados");
            } else {
                JOptionPane.showMessageDialog(null, "Existen Campos Vacios");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPDFActionPerformed
        try {
            int id = Integer.parseInt(txtIDVenta.getText());
            File file = new File("src/org/miguelyac/pdf/Venta"+id+".pdf");
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarPDFActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        String fechaReporte = new SimpleDateFormat("dd/MM/yyyy").format( MyDate.getDate());
        Grafico.Graficar(fechaReporte);
    }//GEN-LAST:event_btnGraficarActionPerformed
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser MyDate;
    private javax.swing.JPanel PanelDeAdmin;
    private javax.swing.JTable TableAdmins;
    private javax.swing.JTable TableAscenso;
    private javax.swing.JTable TableClientes;
    private javax.swing.JTable TableCompra;
    private javax.swing.JTable TableControlVentas;
    private javax.swing.JTable TableProductos;
    private javax.swing.JTable TableUsuario;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarAdmin;
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnActualizarProducto;
    private javax.swing.JButton btnActualizarUsuario;
    private javax.swing.JButton btnAscenderUsuario;
    private javax.swing.JButton btnAscenso;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnEiminarAdmin;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnGenerarPDF;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnGraficar;
    private javax.swing.JButton btnGuardarAdmin;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JButton btnGuardarUsuario;
    private javax.swing.JButton btnLimpiarAdmin;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoProducto;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblPrecioProducto;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCorreoAdmin;
    private javax.swing.JTextField txtCorreoAscenso;
    private javax.swing.JTextField txtCorreoEmpresa;
    private javax.swing.JTextField txtCorreoUsuario;
    private javax.swing.JTextField txtDPI;
    private javax.swing.JTextField txtDPICliente;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescripcionProducto;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDireccionEmpresa;
    private javax.swing.JTextField txtExistencias;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDAdmin;
    private javax.swing.JTextField txtIDCliente;
    private javax.swing.JTextField txtIDConfig;
    private javax.swing.JTextField txtIDProducto;
    private javax.swing.JTextField txtIDUSUARIO;
    private javax.swing.JTextField txtIDUsuario;
    private javax.swing.JTextField txtIDVenta;
    private javax.swing.JTextField txtNIT;
    private javax.swing.JTextField txtNITCliente;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreAdmin;
    private javax.swing.JTextField txtNombreAscenso;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPassAdmin;
    private javax.swing.JPasswordField txtPassAscenso;
    private javax.swing.JPasswordField txtPassUsuario;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoEmpresa;
    // End of variables declaration//GEN-END:variables
    private void LimpiarCliente(){
        txtIDCliente.setText("");
        txtNITCliente.setText("");
        txtDPICliente.setText("");
        txtNombreCliente.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCliente.setText("");
    }
    private void LimpiarUsuario(){
        txtIDUSUARIO.setText("");
        txtNombreUsuario.setText("");
        txtCorreoUsuario.setText("");
        txtPassUsuario.setText("");
    }
    private void LimpiarAscenso(){
        txtIDUsuario.setText("");
        txtNombreAscenso.setText("");
        txtCorreoAscenso.setText("");
        txtPassAscenso.setText("");
    }
    private void LimpiarProducto(){
        txtIDProducto.setText("");
        txtCodigoProducto.setText("");
        txtDescripcionProducto.setText("");
        txtNombreProducto.setText("");
        txtCantidadProducto.setText("");
        txtPrecioProducto.setText("");
    }
    private void LimpiarAdmins(){
        txtIDAdmin.setText("");
        txtNombreAdmin.setText("");
        txtCorreoAdmin.setText("");
        txtPassAdmin.setText("");
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
    private void LimpiarCompra(){
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtCantidad.setText("");
        txtExistencias.setText("");
        txtPrecio.setText("");
    }
    private void LimpiarDatosCliente(){
        txtNIT.setText("");
        txtNombre.setText("");
        txtDPI.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }
    private void CrearVenta(){
        String cliente = txtNombre.getText();
        String vendedor = lblVendedor.getText();
        double monto = TotalPagar;
        vt.setCliente(cliente);
        vt.setVendedor(vendedor);
        vt.setTotal(monto);
        vt.setFecha(fechaActual);
        ventas.GuardarVenta(vt);
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
            ventas.RegistrarDetalle(Dv);
        }
    }
    private void ActualizarStock(){
        for (int i = 0; i < TableCompra.getRowCount(); i++) {
            String cod = TableCompra.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(TableCompra.getValueAt(i, 2).toString());
            pd = products.buscarProductos(cod);
            int StockActual = pd.getStock() - cant;
            ventas.actualizarStock(StockActual, cod);
        }
    }
    private void PDF(){
        try{
            int id = ventas.IdVenta();
            FileOutputStream archivo;
            File file = new File("src/org/miguelyac/pdf/Venta"+id+".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            //Aca se especifica todo sobre el archivo PDF
            com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("src/org/miguelyac/recursos/Logo.png");
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
            config = ventas.buscarDatos();
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