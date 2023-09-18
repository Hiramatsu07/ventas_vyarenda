/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Cliente;
import Modelo.ClienteDao;
import Modelo.Detalle;
import Modelo.Producto;
import Modelo.ProductoDao;
import Modelo.Proveedor;
import Modelo.ProveedorDao;
import Modelo.Venta;
import Modelo.VentaDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import Reportes.Excel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author user
 */
public class Sistema extends javax.swing.JFrame {
    Cliente cl = new Cliente();
    ClienteDao cldao = new ClienteDao();
    Proveedor pr = new Proveedor();
    ProveedorDao prdao = new ProveedorDao();
    Producto prod = new Producto();
    ProductoDao prodao = new ProductoDao();
    Venta v = new Venta();
    VentaDao vdao = new VentaDao();
    Detalle d = new Detalle();
    DefaultTableModel modelo = new DefaultTableModel();
    int item;
    int totalpagar = 0;
    
    public Sistema() {
        initComponents();
        this.setLocationRelativeTo(null);
        RucClienteTXT.setVisible(false);
        AutoCompleteDecorator.decorate(ProveedorProductoCBX);
        prodao.ConsultarProveedor(ProveedorProductoCBX);
    }
    public void ListarClientes(){
        List<Cliente> ListarCl = cldao.ListarCLiente();
        modelo = (DefaultTableModel) ClienteTable.getModel();
        Object[] ob  = new Object[6];
        for(int i = 0; i < ListarCl.size(); i++){
            ob[0] = ListarCl.get(i).getId();
            ob[1] = ListarCl.get(i).getRuc();
            ob[2] = ListarCl.get(i).getNombre();
            ob[3] = ListarCl.get(i).getTelefono();
            ob[4] = ListarCl.get(i).getDireccion();
            ob[5] = ListarCl.get(i).getRazon();
            modelo.addRow(ob);
        }
        ClienteTable.setModel(modelo);
    }
    
    public void ListarProveedores(){
        List<Proveedor> ListarPr = prdao.ListarProveedor();
        modelo = (DefaultTableModel) ProveedorTable.getModel();
        Object[] ob  = new Object[6];
        for(int i = 0; i < ListarPr.size(); i++){
            ob[0] = ListarPr.get(i).getId();
            ob[1] = ListarPr.get(i).getRuc();
            ob[2] = ListarPr.get(i).getNombre();
            ob[3] = ListarPr.get(i).getTelefono();
            ob[4] = ListarPr.get(i).getDireccion();
            ob[5] = ListarPr.get(i).getRazon();
            modelo.addRow(ob);
        }
        ProveedorTable.setModel(modelo);
    }
    
    public void ListarProductos(){
        List<Producto> ListarProd = prodao.ListarProducto();
        modelo = (DefaultTableModel) ProductoTable.getModel();
        Object[] ob  = new Object[6];
        modelo.setRowCount(0);
        for(int i = 0; i < ListarProd.size(); i++){
            ob[0] = ListarProd.get(i).getId();
            ob[1] = ListarProd.get(i).getCodigo();
            ob[2] = ListarProd.get(i).getDescripcion();
            ob[3] = ListarProd.get(i).getCantidad();
            ob[4] = ListarProd.get(i).getPrecio();
            ob[5] = ListarProd.get(i).getProveedor();
            modelo.addRow(ob);
        }
        ProductoTable.setModel(modelo);
    }
    
    public void LimpiarTable(){
        for (int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    public void VaciarCamposCliente(){
        IdClienteTXT.setText("");
        NombreClienteTXT.setText("");
        TelefonoClienteTXT.setText("");
        RazonClienteTXT.setText("");
        RucClienteTXT.setText("");
        DireccionClienteTXT.setText("");
    }
    
    public void VaciarCamposProveedor(){
        IdProveedorTXT.setText("");
        NombreProveedorTXT.setText("");
        TelefonoProveedorTXT.setText("");
        RazonProveedorTXT.setText("");
        RucProveedorTXT.setText("");
        DireccionProveedorTXT.setText("");
    }
    
    public void VaciarCamposProducto(){
        IdProductoTXT.setText("");
        CodigoProductoTXT.setText("");
        DescripcionProductoTXT.setText("");
        PrecioProductoTXT.setText("");
        CantidadProductoTXT.setText("");
        PrecioProductoTXT.setText("");
        ProveedorProductoCBX.setSelectedItem(null);
    }
    
    public void TotalPagar(){
        totalpagar = 0;
        int numFila = NuevaVentaTable.getRowCount();
        for(int i = 0; i < numFila; i++){
            double cal = Double.parseDouble(String.valueOf(NuevaVentaTable.getModel().getValueAt(i, 4)));
            totalpagar = (int) (totalpagar + cal);
        }
        TotalVentaLBL.setText(String.format("%d", totalpagar));
    }
    
    private void VaciarCamposNuevaVenta(){
        CodigoVentaTXT.setText("");
        DescripcionVentaTXT.setText("");
        CantidadVentaTXT.setText("");
        PrecioVentaTXT.setText("");
        StockVentaTXT.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        NuevaVentaBTN = new javax.swing.JButton();
        ClientesBTN = new javax.swing.JButton();
        ProveedoresBTN = new javax.swing.JButton();
        ProductosBTN = new javax.swing.JButton();
        VentasBTN = new javax.swing.JButton();
        ConfiguracionBTN = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        VendedorLBL = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        EliminarBTN = new javax.swing.JButton();
        CodigoVentaTXT = new javax.swing.JTextField();
        DescripcionVentaTXT = new javax.swing.JTextField();
        CantidadVentaTXT = new javax.swing.JTextField();
        PrecioVentaTXT = new javax.swing.JTextField();
        StockVentaTXT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        NuevaVentaTable = new javax.swing.JTable();
        dni_lbl = new javax.swing.JLabel();
        nombre_lbl = new javax.swing.JLabel();
        RucVentaTXT = new javax.swing.JTextField();
        NombreVentaTXT = new javax.swing.JTextField();
        GenerarVentaBTN = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        TotalVentaLBL = new javax.swing.JLabel();
        TelefonoVentaTXT = new javax.swing.JTextField();
        DireccionCVTXT = new javax.swing.JTextField();
        RazonCVTXT = new javax.swing.JTextField();
        IdProTXT = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        RucClienteTXT = new javax.swing.JTextField();
        NombreClienteTXT = new javax.swing.JTextField();
        TelefonoClienteTXT = new javax.swing.JTextField();
        DireccionClienteTXT = new javax.swing.JTextField();
        RazonClienteTXT = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClienteTable = new javax.swing.JTable();
        GuardarClienteBTN = new javax.swing.JButton();
        EditarClienteBTN = new javax.swing.JButton();
        EliminarClienteBTN = new javax.swing.JButton();
        NuevoClienteBTN = new javax.swing.JButton();
        IdClienteTXT = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        EditarProveedorBTN = new javax.swing.JButton();
        NuevoProveedorBTN = new javax.swing.JButton();
        EliminarProveedorBTN = new javax.swing.JButton();
        GuardarProveedorBTN = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ProveedorTable = new javax.swing.JTable();
        NombreProveedorTXT = new javax.swing.JTextField();
        RucProveedorTXT = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        TelefonoProveedorTXT = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        DireccionProveedorTXT = new javax.swing.JTextField();
        RazonProveedorTXT = new javax.swing.JTextField();
        IdProveedorTXT = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        ActualizarProductoBTN = new javax.swing.JButton();
        NuevoProductoBTN = new javax.swing.JButton();
        EliminarProductoBTN = new javax.swing.JButton();
        GuardarProductoBTN = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ProductoTable = new javax.swing.JTable();
        DescripcionProductoTXT = new javax.swing.JTextField();
        CodigoProductoTXT = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        CantidadProductoTXT = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        PrecioProductoTXT = new javax.swing.JTextField();
        ProveedorProductoCBX = new javax.swing.JComboBox<>();
        ExcelProductoBTN = new javax.swing.JButton();
        IdProductoTXT = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        VentaTable = new javax.swing.JTable();
        PDFVentasBTN = new javax.swing.JButton();
        IdVentaTXT = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        NuevaVentaBTN.setForeground(new java.awt.Color(51, 51, 51));
        NuevaVentaBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nventa.png"))); // NOI18N
        NuevaVentaBTN.setText("Nueva Venta");
        NuevaVentaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaVentaBTNActionPerformed(evt);
            }
        });

        ClientesBTN.setForeground(new java.awt.Color(51, 51, 51));
        ClientesBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes.png"))); // NOI18N
        ClientesBTN.setText("Clientes");
        ClientesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesBTNActionPerformed(evt);
            }
        });

        ProveedoresBTN.setForeground(new java.awt.Color(51, 51, 51));
        ProveedoresBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedor.png"))); // NOI18N
        ProveedoresBTN.setText("Proveedores");
        ProveedoresBTN.setPreferredSize(new java.awt.Dimension(137, 56));
        ProveedoresBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedoresBTNActionPerformed(evt);
            }
        });

        ProductosBTN.setForeground(new java.awt.Color(51, 51, 51));
        ProductosBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/producto.png"))); // NOI18N
        ProductosBTN.setText("Productos");
        ProductosBTN.setPreferredSize(new java.awt.Dimension(123, 56));
        ProductosBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductosBTNActionPerformed(evt);
            }
        });

        VentasBTN.setForeground(new java.awt.Color(51, 51, 51));
        VentasBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compras.png"))); // NOI18N
        VentasBTN.setText("Ventas");
        VentasBTN.setPreferredSize(new java.awt.Dimension(102, 56));
        VentasBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasBTNActionPerformed(evt);
            }
        });

        ConfiguracionBTN.setForeground(new java.awt.Color(51, 51, 51));
        ConfiguracionBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/config.png"))); // NOI18N
        ConfiguracionBTN.setText("Configuración");
        ConfiguracionBTN.setPreferredSize(new java.awt.Dimension(143, 56));
        ConfiguracionBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiguracionBTNActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N

        VendedorLBL.setForeground(new java.awt.Color(255, 255, 255));
        VendedorLBL.setText("VENDEDOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NuevaVentaBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ClientesBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProveedoresBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(VentasBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProductosBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ConfiguracionBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(VendedorLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VendedorLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NuevaVentaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ClientesBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProveedoresBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProductosBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(VentasBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfiguracionBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 730));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/encabezado.png"))); // NOI18N
        jLabel2.setIconTextGap(0);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1000, 180));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Código");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Descripción");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Cantidad");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Precio");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Stock disponible");

        EliminarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        EliminarBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EliminarBTN.setFocusPainted(false);
        EliminarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBTNActionPerformed(evt);
            }
        });

        CodigoVentaTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoVentaTXTActionPerformed(evt);
            }
        });
        CodigoVentaTXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CodigoVentaTXTKeyPressed(evt);
            }
        });

        CantidadVentaTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadVentaTXTActionPerformed(evt);
            }
        });
        CantidadVentaTXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CantidadVentaTXTKeyPressed(evt);
            }
        });

        PrecioVentaTXT.setEditable(false);

        NuevaVentaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Cantidad", "Precio", "Total"
            }
        ));
        jScrollPane1.setViewportView(NuevaVentaTable);
        if (NuevaVentaTable.getColumnModel().getColumnCount() > 0) {
            NuevaVentaTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            NuevaVentaTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            NuevaVentaTable.getColumnModel().getColumn(2).setPreferredWidth(30);
            NuevaVentaTable.getColumnModel().getColumn(3).setPreferredWidth(30);
            NuevaVentaTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        dni_lbl.setText("CI/RUC");

        nombre_lbl.setText("NOMBRE");

        RucVentaTXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RucVentaTXTKeyPressed(evt);
            }
        });

        GenerarVentaBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        GenerarVentaBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GenerarVentaBTN.setFocusPainted(false);
        GenerarVentaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarVentaBTNActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/money.png"))); // NOI18N
        jLabel9.setText("Total a Pagar");

        TotalVentaLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalVentaLBL.setText("---");

        DireccionCVTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DireccionCVTXTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dni_lbl)
                            .addComponent(RucVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre_lbl)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(NombreVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TelefonoVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DireccionCVTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RazonCVTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                        .addComponent(GenerarVentaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalVentaLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(CodigoVentaTXT))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(DescripcionVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CantidadVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PrecioVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(StockVentaTXT))
                                .addGap(18, 18, 18)
                                .addComponent(IdProTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGap(18, 18, 18)
                        .addComponent(EliminarBTN)
                        .addGap(34, 34, 34))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodigoVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DescripcionVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CantidadVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PrecioVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StockVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdProTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(EliminarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dni_lbl)
                            .addComponent(nombre_lbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RucVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TelefonoVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DireccionCVTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RazonCVTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(GenerarVentaBTN)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalVentaLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nueva Venta", jPanel2);

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel11.setText("CI/RUC");

        jLabel12.setText("Nombre");

        jLabel13.setText("Télefono");

        jLabel14.setText("Dirección");

        jLabel15.setText("Razón Social");

        RucClienteTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RucClienteTXTActionPerformed(evt);
            }
        });

        NombreClienteTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreClienteTXTActionPerformed(evt);
            }
        });

        ClienteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "C.I/RUC", "NOMBRE", "TELÉFONO", "DIRECCIÓN", "RAZÓN SOCIAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ClienteTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClienteTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ClienteTable);
        if (ClienteTable.getColumnModel().getColumnCount() > 0) {
            ClienteTable.getColumnModel().getColumn(0).setPreferredWidth(8);
            ClienteTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            ClienteTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            ClienteTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            ClienteTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            ClienteTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        GuardarClienteBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        GuardarClienteBTN.setAlignmentY(0.0F);
        GuardarClienteBTN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GuardarClienteBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        GuardarClienteBTN.setIconTextGap(0);
        GuardarClienteBTN.setPreferredSize(new java.awt.Dimension(60, 60));
        GuardarClienteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarClienteBTNActionPerformed(evt);
            }
        });

        EditarClienteBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        EditarClienteBTN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EditarClienteBTN.setPreferredSize(new java.awt.Dimension(60, 60));
        EditarClienteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarClienteBTNActionPerformed(evt);
            }
        });

        EliminarClienteBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        EliminarClienteBTN.setPreferredSize(new java.awt.Dimension(60, 60));
        EliminarClienteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarClienteBTNActionPerformed(evt);
            }
        });

        NuevoClienteBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        NuevoClienteBTN.setPreferredSize(new java.awt.Dimension(60, 60));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(GuardarClienteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarClienteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NuevoClienteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarClienteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(RazonClienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DireccionClienteTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(RucClienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(IdClienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(TelefonoClienteTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(NombreClienteTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(RucClienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdClienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(NombreClienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(TelefonoClienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(DireccionClienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(RazonClienteTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GuardarClienteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditarClienteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EliminarClienteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NuevoClienteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel3);

        EditarProveedorBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        EditarProveedorBTN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EditarProveedorBTN.setPreferredSize(new java.awt.Dimension(60, 60));
        EditarProveedorBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarProveedorBTNActionPerformed(evt);
            }
        });

        NuevoProveedorBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        NuevoProveedorBTN.setPreferredSize(new java.awt.Dimension(60, 60));

        EliminarProveedorBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        EliminarProveedorBTN.setPreferredSize(new java.awt.Dimension(60, 60));
        EliminarProveedorBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProveedorBTNActionPerformed(evt);
            }
        });

        GuardarProveedorBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        GuardarProveedorBTN.setAlignmentY(0.0F);
        GuardarProveedorBTN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GuardarProveedorBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        GuardarProveedorBTN.setIconTextGap(0);
        GuardarProveedorBTN.setPreferredSize(new java.awt.Dimension(60, 60));
        GuardarProveedorBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarProveedorBTNActionPerformed(evt);
            }
        });

        jScrollPane3.setEnabled(false);

        ProveedorTable.setAutoCreateRowSorter(true);
        ProveedorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI/RUC", "NOMBRE", "TELÉFONO", "DIRECCIÓN", "RAZÓN SOCIAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProveedorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProveedorTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ProveedorTable);
        if (ProveedorTable.getColumnModel().getColumnCount() > 0) {
            ProveedorTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            ProveedorTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            ProveedorTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            ProveedorTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            ProveedorTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        NombreProveedorTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreProveedorTXTActionPerformed(evt);
            }
        });

        RucProveedorTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RucProveedorTXTActionPerformed(evt);
            }
        });

        jLabel16.setText("CI/RUC");

        jLabel17.setText("Nombre");

        jLabel18.setText("Télefono");

        jLabel19.setText("Dirección");

        jLabel20.setText("Razón Social");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel20)
                    .addComponent(GuardarProveedorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarProveedorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NuevoProveedorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarProveedorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(RazonProveedorTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DireccionProveedorTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(RucProveedorTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(IdProveedorTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(TelefonoProveedorTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(NombreProveedorTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(RucProveedorTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdProveedorTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(NombreProveedorTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(TelefonoProveedorTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(DireccionProveedorTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(RazonProveedorTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GuardarProveedorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EditarProveedorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EliminarProveedorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NuevoProveedorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proveedores", jPanel4);

        ActualizarProductoBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        ActualizarProductoBTN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ActualizarProductoBTN.setPreferredSize(new java.awt.Dimension(60, 60));
        ActualizarProductoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarProductoBTNActionPerformed(evt);
            }
        });

        NuevoProductoBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        NuevoProductoBTN.setPreferredSize(new java.awt.Dimension(60, 60));

        EliminarProductoBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        EliminarProductoBTN.setPreferredSize(new java.awt.Dimension(60, 60));
        EliminarProductoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProductoBTNActionPerformed(evt);
            }
        });

        GuardarProductoBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        GuardarProductoBTN.setAlignmentY(0.0F);
        GuardarProductoBTN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GuardarProductoBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        GuardarProductoBTN.setIconTextGap(0);
        GuardarProductoBTN.setPreferredSize(new java.awt.Dimension(60, 60));
        GuardarProductoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarProductoBTNActionPerformed(evt);
            }
        });

        ProductoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CÓDIGO", "DESCRIPCIÓN", "CANTIDAD", "PRECIO", "PROVEEDOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProductoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductoTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(ProductoTable);
        if (ProductoTable.getColumnModel().getColumnCount() > 0) {
            ProductoTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            ProductoTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            ProductoTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            ProductoTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            ProductoTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        DescripcionProductoTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescripcionProductoTXTActionPerformed(evt);
            }
        });

        CodigoProductoTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoProductoTXTActionPerformed(evt);
            }
        });

        jLabel21.setText("Código");

        jLabel22.setText("Descripción");

        jLabel23.setText("Cantidad");

        jLabel24.setText("Precio");

        jLabel25.setText("Proveedor");

        ProveedorProductoCBX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ProveedorProductoCBXFocusGained(evt);
            }
        });

        ExcelProductoBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/excel.png"))); // NOI18N
        ExcelProductoBTN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ExcelProductoBTN.setPreferredSize(new java.awt.Dimension(60, 60));
        ExcelProductoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcelProductoBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(CodigoProductoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(IdProductoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PrecioProductoTXT)
                            .addComponent(CantidadProductoTXT)
                            .addComponent(DescripcionProductoTXT)
                            .addComponent(ProveedorProductoCBX, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NuevoProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GuardarProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(ActualizarProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EliminarProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ExcelProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(CodigoProductoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdProductoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(DescripcionProductoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(CantidadProductoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(PrecioProductoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(ProveedorProductoCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ActualizarProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EliminarProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GuardarProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ExcelProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NuevoProductoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos", jPanel5);

        VentaTable.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        VentaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "VENDEDOR", "TOTAL"
            }
        ));
        jScrollPane5.setViewportView(VentaTable);
        if (VentaTable.getColumnModel().getColumnCount() > 0) {
            VentaTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            VentaTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            VentaTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            VentaTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        PDFVentasBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pdf.png"))); // NOI18N
        PDFVentasBTN.setPreferredSize(new java.awt.Dimension(60, 60));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1152, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(PDFVentasBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(IdVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 56, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(PDFVentasBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(IdVentaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Ventas", jPanel6);

        jLabel26.setText("RUC");

        jLabel27.setText("NOMBRE");

        jLabel28.setText("TELÉFONO");

        jLabel29.setText("DIRECCIÓN");

        jLabel30.setText("RAZÓN SOCIAL");

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar (2).png"))); // NOI18N
        jButton17.setText("ACTUALIZAR");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel31.setText("DATOS DE LA EMPRESA");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29)
                            .addComponent(jTextField20)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField24)
                                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28)
                                .addGap(196, 196, 196))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jButton17)
                                .addGap(413, 413, 413))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(338, 338, 338)))))
                .addGap(18, 18, 18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jButton17)
                .addGap(77, 77, 77))
        );

        jTabbedPane1.addTab("Configuración", jPanel7);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 1160, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevaVentaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaVentaBTNActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_NuevaVentaBTNActionPerformed

    private void ClientesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesBTNActionPerformed
        LimpiarTable();
        ListarClientes();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_ClientesBTNActionPerformed

    private void ProveedoresBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedoresBTNActionPerformed
        LimpiarTable();
        ListarProveedores();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_ProveedoresBTNActionPerformed

    private void ConfiguracionBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracionBTNActionPerformed
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_ConfiguracionBTNActionPerformed

    private void CodigoVentaTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoVentaTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoVentaTXTActionPerformed

    private void CantidadVentaTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadVentaTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadVentaTXTActionPerformed

    private void EliminarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBTNActionPerformed
        modelo = (DefaultTableModel) NuevaVentaTable.getModel();
        modelo.removeRow(NuevaVentaTable.getSelectedRow());
        TotalPagar();
        CodigoVentaTXT.requestFocus();
    }//GEN-LAST:event_EliminarBTNActionPerformed

    private void RucClienteTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RucClienteTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RucClienteTXTActionPerformed

    private void NombreClienteTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreClienteTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreClienteTXTActionPerformed

    private void NombreProveedorTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreProveedorTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreProveedorTXTActionPerformed

    private void RucProveedorTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RucProveedorTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RucProveedorTXTActionPerformed

    private void DescripcionProductoTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionProductoTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionProductoTXTActionPerformed

    private void CodigoProductoTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoProductoTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoProductoTXTActionPerformed

    private void DireccionCVTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DireccionCVTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionCVTXTActionPerformed

    private void GuardarClienteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarClienteBTNActionPerformed
        if(!"".equals(RucClienteTXT.getText()) || !"".equals(NombreClienteTXT.getText()) || !"".equals(TelefonoClienteTXT.getText()) || !"".equals(DireccionClienteTXT.getText()) || !"".equals(RazonClienteTXT.getText())){
            cl.setRuc(RucClienteTXT.getText());
            cl.setNombre(NombreClienteTXT.getText());
            cl.setTelefono(Integer.parseInt(TelefonoClienteTXT.getText()));
            cl.setDireccion(DireccionClienteTXT.getText());
            cl.setRazon(RazonClienteTXT.getText());
            cldao.RegistrarCliente(cl);
            LimpiarTable();
            ListarClientes();
            JOptionPane.showMessageDialog(null, "Cliente añadido satisfactoriamente");
        }else{
            JOptionPane.showMessageDialog(null, "Los campos están vacíos");
        }
            
    }//GEN-LAST:event_GuardarClienteBTNActionPerformed

    private void EliminarClienteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarClienteBTNActionPerformed
        if (!"".equals(IdClienteTXT.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Eliminar cliente?");
            if (pregunta == 0){
                int id = Integer.parseInt(IdClienteTXT.getText());
                cldao.EliminarCliente(id);
                LimpiarTable();
                ListarClientes();
                VaciarCamposCliente();
            }
        }
    }//GEN-LAST:event_EliminarClienteBTNActionPerformed

    private void ClienteTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClienteTableMouseClicked
        int fila = ClienteTable.rowAtPoint(evt.getPoint());
        IdClienteTXT.setText(ClienteTable.getValueAt(fila, 0).toString());
        RucClienteTXT.setText(ClienteTable.getValueAt(fila, 1).toString());
        NombreClienteTXT.setText(ClienteTable.getValueAt(fila, 2).toString());
        TelefonoClienteTXT.setText(ClienteTable.getValueAt(fila, 3).toString());
        DireccionClienteTXT.setText(ClienteTable.getValueAt(fila, 4).toString());
        RazonClienteTXT.setText(ClienteTable.getValueAt(fila, 5).toString());
        
    }//GEN-LAST:event_ClienteTableMouseClicked

    private void EditarClienteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarClienteBTNActionPerformed
        if ("".equals(IdClienteTXT.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione el cliente a editar");
        }else{
            cl.setId(Integer.parseInt(IdClienteTXT.getText()));
            cl.setRuc(RucClienteTXT.getText());
            cl.setNombre(NombreClienteTXT.getText());
            cl.setDireccion(DireccionClienteTXT.getText());
            cl.setTelefono(Integer.parseInt(TelefonoClienteTXT.getText()));
            cl.setRazon(RazonClienteTXT.getText());
            if(!"".equals(RucClienteTXT.getText()) && !"".equals(NombreClienteTXT.getText()) && !"".equals(TelefonoClienteTXT.getText())){
                cldao.ModificarCliente(cl);
                LimpiarTable();
                VaciarCamposCliente();
                ListarClientes();
                JOptionPane.showMessageDialog(null, "Cliente editado");
            }else{
                JOptionPane.showMessageDialog(null, "Los campos están vacíos");
            }
        }
    }//GEN-LAST:event_EditarClienteBTNActionPerformed

    private void GuardarProveedorBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarProveedorBTNActionPerformed
        if(!"".equals(RucProveedorTXT.getText()) || !"".equals(NombreProveedorTXT.getText()) || !"".equals(TelefonoProveedorTXT.getText()) || !"".equals(DireccionProveedorTXT.getText()) || !"".equals(RazonProveedorTXT.getText())){
            pr.setRuc(RucProveedorTXT.getText());
            pr.setNombre(NombreProveedorTXT.getText());
            pr.setTelefono(Integer.parseInt(TelefonoProveedorTXT.getText()));
            pr.setDireccion(DireccionProveedorTXT.getText());
            pr.setRazon(RazonProveedorTXT.getText());
            prdao.RegistrarProveedor(pr);
            LimpiarTable();
            ListarProveedores();
            JOptionPane.showMessageDialog(null, "Proveedor añadido satisfactoriamente");
        }else{
            JOptionPane.showMessageDialog(null, "Los campos están vacíos");
        }
    }//GEN-LAST:event_GuardarProveedorBTNActionPerformed
    
    private void ProveedorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProveedorTableMouseClicked
        int fila = ProveedorTable.rowAtPoint(evt.getPoint());
        IdProveedorTXT.setText(ProveedorTable.getValueAt(fila, 0).toString());
        RucProveedorTXT.setText(ProveedorTable.getValueAt(fila, 1).toString());
        NombreProveedorTXT.setText(ProveedorTable.getValueAt(fila, 2).toString());
        TelefonoProveedorTXT.setText(ProveedorTable.getValueAt(fila, 3).toString());
        DireccionProveedorTXT.setText(ProveedorTable.getValueAt(fila, 4).toString());
        RazonProveedorTXT.setText(ProveedorTable.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_ProveedorTableMouseClicked

    private void EditarProveedorBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarProveedorBTNActionPerformed
        if ("".equals(IdProveedorTXT.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione el proveedor a editar");
        }else{
            pr.setId(Integer.parseInt(IdProveedorTXT.getText()));
            pr.setRuc(RucProveedorTXT.getText());
            pr.setNombre(NombreProveedorTXT.getText());
            pr.setDireccion(DireccionProveedorTXT.getText());
            pr.setTelefono(Integer.parseInt(TelefonoProveedorTXT.getText()));
            pr.setRazon(RazonProveedorTXT.getText());
            if(!"".equals(RucProveedorTXT.getText()) && !"".equals(NombreProveedorTXT.getText()) && !"".equals(TelefonoProveedorTXT.getText())){
                prdao.ModificarProveedor(pr);
                LimpiarTable();
                VaciarCamposProveedor();
                ListarProveedores();
                JOptionPane.showMessageDialog(null, "Proveedor editado");
            }else{
                JOptionPane.showMessageDialog(null, "Los campos están vacíos");
            }
        }
    }//GEN-LAST:event_EditarProveedorBTNActionPerformed

    private void EliminarProveedorBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProveedorBTNActionPerformed
        if (!"".equals(IdProveedorTXT.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Eliminar proveedor?");
            if (pregunta == 0){
                int id = Integer.parseInt(IdProveedorTXT.getText());
                prdao.EliminarProveedor(id);
                LimpiarTable();
                ListarProveedores();
                VaciarCamposProveedor();
            }
        }
    }//GEN-LAST:event_EliminarProveedorBTNActionPerformed

    private void GuardarProductoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarProductoBTNActionPerformed
        if (!"".equals(CodigoProductoTXT.getText()) || !"".equals(DescripcionProductoTXT.getText()) || !"".equals(PrecioProductoTXT.getText()) || !"".equals(CantidadProductoTXT.getText()) || !"".equals(ProveedorProductoCBX.getSelectedItem())){
            prod.setCodigo(CodigoProductoTXT.getText());
            prod.setDescripcion(DescripcionProductoTXT.getText());
            prod.setPrecio(Integer.parseInt(PrecioProductoTXT.getText()));
            prod.setCantidad(Integer.parseInt(CantidadProductoTXT.getText()));
            prod.setProveedor(ProveedorProductoCBX.getSelectedItem().toString());
            prodao.RegistrarProducto(prod);
            LimpiarTable();
            ListarProductos();
            VaciarCamposProducto();
            JOptionPane.showMessageDialog(null, "Producto añadido satisfactoriamente");
        }else{
            JOptionPane.showMessageDialog(null, "Uno de los campos está vacíos");
        }
    }//GEN-LAST:event_GuardarProductoBTNActionPerformed

    private void ProductosBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductosBTNActionPerformed
        LimpiarTable();
        ListarProductos();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_ProductosBTNActionPerformed

    private void ProveedorProductoCBXFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProveedorProductoCBXFocusGained
        ProveedorProductoCBX.removeAllItems();
        prodao.ConsultarProveedor(ProveedorProductoCBX);
    }//GEN-LAST:event_ProveedorProductoCBXFocusGained

    private void ProductoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductoTableMouseClicked
       int fila = ProductoTable.rowAtPoint(evt.getPoint());
       IdProductoTXT.setText(ProductoTable.getValueAt(fila, 0).toString());
       CodigoProductoTXT.setText(ProductoTable.getValueAt(fila, 1).toString());
       DescripcionProductoTXT.setText(ProductoTable.getValueAt(fila, 2).toString());
       PrecioProductoTXT.setText(ProductoTable.getValueAt(fila, 3).toString());
       CantidadProductoTXT.setText(ProductoTable.getValueAt(fila, 4).toString());
       ProveedorProductoCBX.setSelectedItem(ProductoTable.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_ProductoTableMouseClicked

    private void ActualizarProductoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarProductoBTNActionPerformed
        if ("".equals(IdProductoTXT.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione el producto a editar");
        }else{
            prod.setId(Integer.parseInt(IdProductoTXT.getText()));
            prod.setCodigo(CodigoProductoTXT.getText());
            prod.setDescripcion(DescripcionProductoTXT.getText());
            prod.setPrecio(Integer.parseInt(PrecioProductoTXT.getText()));
            prod.setCantidad(Integer.parseInt(CantidadProductoTXT.getText()));
            prod.setProveedor(ProveedorProductoCBX.getSelectedItem().toString());
            if(!"".equals(CodigoProductoTXT.getText()) && !"".equals(DescripcionProductoTXT.getText()) && !"".equals(DescripcionProductoTXT.getText())){
                prodao.ModificarProducto(prod);
                LimpiarTable();
                VaciarCamposProducto();
                ListarProductos();
                JOptionPane.showMessageDialog(null, "Producto editado");
            }else{
                JOptionPane.showMessageDialog(null, "Los campos están vacíos");
            }
        }
    }//GEN-LAST:event_ActualizarProductoBTNActionPerformed

    private void EliminarProductoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProductoBTNActionPerformed
        if (!"".equals(IdProductoTXT.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Eliminar producto?");
            if (pregunta == 0){
                int id = Integer.parseInt(IdProductoTXT.getText());
                prodao.EliminarProducto(id);
                LimpiarTable();
                ListarProductos();
                VaciarCamposProducto();
            }
        }
    }//GEN-LAST:event_EliminarProductoBTNActionPerformed

    private void ExcelProductoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcelProductoBTNActionPerformed
        Excel.reporte();
    }//GEN-LAST:event_ExcelProductoBTNActionPerformed

    private void CodigoVentaTXTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigoVentaTXTKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(CodigoVentaTXT.getText())){
                String cod = CodigoVentaTXT.getText();
                prod = prodao.BuscarProducto(cod);
                if(prod.getDescripcion() != null){
                    DescripcionVentaTXT.setText(""+prod.getDescripcion());
                    PrecioVentaTXT.setText(""+prod.getPrecio());
                    StockVentaTXT.setText(""+prod.getCantidad());
                    DescripcionVentaTXT.setText(""+prod.getDescripcion());
                    CantidadVentaTXT.requestFocus();
                }else{
                    DescripcionVentaTXT.setText(""+prod.getDescripcion());
                    PrecioVentaTXT.setText(""+prod.getPrecio());
                    StockVentaTXT.setText(""+prod.getCantidad());
                    CodigoVentaTXT.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese el código del producto");
            }
        }
    }//GEN-LAST:event_CodigoVentaTXTKeyPressed

    private void CantidadVentaTXTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadVentaTXTKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(CantidadVentaTXT.getText())){
                String cod = CodigoVentaTXT.getText();
                String descripcion = DescripcionVentaTXT.getText();
                int cant = Integer.parseInt(CantidadVentaTXT.getText());
                int precio = Integer.parseInt(PrecioVentaTXT.getText());
                int total = cant * precio;
                int stock = Integer.parseInt(StockVentaTXT.getText());
                if(stock >= cant){
                    item = item + 1;
                    modelo = (DefaultTableModel) NuevaVentaTable.getModel();
                    for(int i = 0; i < NuevaVentaTable.getRowCount();i++){
                        if(NuevaVentaTable.getValueAt(i, 1).equals(DescripcionVentaTXT.getText())){
                            JOptionPane.showMessageDialog(null, "El producto ya está registrado");
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
                    Object[] o = new Object[5];
                    o[0] = lista.get(1);
                    o[1] = lista.get(2);
                    o[2] = lista.get(3);
                    o[3] = lista.get(4);
                    o[4] = lista.get(5);
                    modelo.addRow(o);
                    VentaTable.setModel(modelo);
                    TotalPagar();
                    VaciarCamposNuevaVenta();
                    CodigoVentaTXT.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "Stock no disponible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese cantidad");
            }
        }
    }//GEN-LAST:event_CantidadVentaTXTKeyPressed
  
    private void VentasBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasBTNActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_VentasBTNActionPerformed

    private void RucVentaTXTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RucVentaTXTKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(RucVentaTXT.getText())){
                int ruc = Integer.parseInt(RucVentaTXT.getText());
                cl = cldao.BuscarCliente(ruc);
                if(cl.getNombre() != null){
                    NombreVentaTXT.setText(""+cl.getNombre());
                    TelefonoVentaTXT.setText(""+cl.getTelefono());
                    DireccionCVTXT.setText(""+cl.getDireccion());
                    RazonCVTXT.setText(""+cl.getRazon());
                }else{
                    RucVentaTXT.setText("");
                    JOptionPane.showMessageDialog(null, "El cliente no existe");
                }
            }
        }
    }//GEN-LAST:event_RucVentaTXTKeyPressed

    private void GenerarVentaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarVentaBTNActionPerformed
        RegistrarVenta();
        RegistrarDetalle();
    }//GEN-LAST:event_GenerarVentaBTNActionPerformed
    
    private void RegistrarVenta(){
        String cliente = NombreVentaTXT.getText();
        String vendedor = VendedorLBL.getText();
        int monto = totalpagar;
        v.setCliente(cliente);
        v.setVendedor(vendedor);
        v.setTotal(monto);
        vdao.RegistrarVenta(v);
    }
    
    private void RegistrarDetalle(){
        int id = vdao.IdVenta();
        for(int i = 0; i < VentaTable.getRowCount(); i++){
            String cod = VentaTable.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(VentaTable.getValueAt(i, 2).toString());
            int precio = Integer.parseInt(VentaTable.getValueAt(i, 3).toString());
            d.setCod_prod(cod);
            d.setCantidad(cant);
            d.setPrecio(precio);
            d.setId(id);
            vdao.RegistrarDetalle(d);
        }
    }
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
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarProductoBTN;
    private javax.swing.JTextField CantidadProductoTXT;
    private javax.swing.JTextField CantidadVentaTXT;
    private javax.swing.JTable ClienteTable;
    private javax.swing.JButton ClientesBTN;
    private javax.swing.JTextField CodigoProductoTXT;
    private javax.swing.JTextField CodigoVentaTXT;
    private javax.swing.JButton ConfiguracionBTN;
    private javax.swing.JTextField DescripcionProductoTXT;
    private javax.swing.JTextField DescripcionVentaTXT;
    private javax.swing.JTextField DireccionCVTXT;
    private javax.swing.JTextField DireccionClienteTXT;
    private javax.swing.JTextField DireccionProveedorTXT;
    private javax.swing.JButton EditarClienteBTN;
    private javax.swing.JButton EditarProveedorBTN;
    private javax.swing.JButton EliminarBTN;
    private javax.swing.JButton EliminarClienteBTN;
    private javax.swing.JButton EliminarProductoBTN;
    private javax.swing.JButton EliminarProveedorBTN;
    private javax.swing.JButton ExcelProductoBTN;
    private javax.swing.JButton GenerarVentaBTN;
    private javax.swing.JButton GuardarClienteBTN;
    private javax.swing.JButton GuardarProductoBTN;
    private javax.swing.JButton GuardarProveedorBTN;
    private javax.swing.JTextField IdClienteTXT;
    private javax.swing.JTextField IdProTXT;
    private javax.swing.JTextField IdProductoTXT;
    private javax.swing.JTextField IdProveedorTXT;
    private javax.swing.JTextField IdVentaTXT;
    private javax.swing.JTextField NombreClienteTXT;
    private javax.swing.JTextField NombreProveedorTXT;
    private javax.swing.JTextField NombreVentaTXT;
    private javax.swing.JButton NuevaVentaBTN;
    private javax.swing.JTable NuevaVentaTable;
    private javax.swing.JButton NuevoClienteBTN;
    private javax.swing.JButton NuevoProductoBTN;
    private javax.swing.JButton NuevoProveedorBTN;
    private javax.swing.JButton PDFVentasBTN;
    private javax.swing.JTextField PrecioProductoTXT;
    private javax.swing.JTextField PrecioVentaTXT;
    private javax.swing.JTable ProductoTable;
    private javax.swing.JButton ProductosBTN;
    private javax.swing.JComboBox<String> ProveedorProductoCBX;
    private javax.swing.JTable ProveedorTable;
    private javax.swing.JButton ProveedoresBTN;
    private javax.swing.JTextField RazonCVTXT;
    private javax.swing.JTextField RazonClienteTXT;
    private javax.swing.JTextField RazonProveedorTXT;
    private javax.swing.JTextField RucClienteTXT;
    private javax.swing.JTextField RucProveedorTXT;
    private javax.swing.JTextField RucVentaTXT;
    private javax.swing.JTextField StockVentaTXT;
    private javax.swing.JTextField TelefonoClienteTXT;
    private javax.swing.JTextField TelefonoProveedorTXT;
    private javax.swing.JTextField TelefonoVentaTXT;
    private javax.swing.JLabel TotalVentaLBL;
    private javax.swing.JLabel VendedorLBL;
    private javax.swing.JTable VentaTable;
    private javax.swing.JButton VentasBTN;
    private javax.swing.JLabel dni_lbl;
    private javax.swing.JButton jButton17;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JLabel nombre_lbl;
    // End of variables declaration//GEN-END:variables
}
