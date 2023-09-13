/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ProductoDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProducto(Producto prod){
        String sql = "INSERT INTO productos (codigo, descripcion, stock, precio, proveedor) VALUES (?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getDescripcion());
            ps.setInt(3, prod.getStock());
            ps.setInt(4, prod.getPrecio());
            ps.setString(5, prod.getProveedor());
            ps.execute();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
           return false; 
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println(e.toString());
            }
        }
        return false;
    }
    
    public List ListarProducto(){
        List<Producto> ListaProd = new ArrayList();
        String sql = "SELECT * FROM productos";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Producto prod = new Producto();
                prod.setId(rs.getInt("id"));
                prod.setCodigo(rs.getString("codigo"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setStock(rs.getInt("stock"));
                prod.setPrecio(rs.getInt("precio"));
                prod.setProveedor(rs.getString("proveedor"));
                ListaProd.add(prod);
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return ListaProd;
    }
    
    public boolean EliminarProducto(int id){
        String sql = "DELETE FROM productos WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        }catch(Exception e){
           System.out.println(e.toString());
           return false;
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean ModificarProducto(Producto prod){
        String sql = "UPDATE productos SET codigo=?, descripcion=?, stock=?, precio=?, proveedor=? WHERE id=?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getDescripcion());
            ps.setInt(3, prod.getStock());
            ps.setInt(4, prod.getPrecio());
            ps.setString(5, prod.getProveedor());
            ps.setInt(6, prod.getId());
            ps.execute();
            return true;
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public void ConsultarProveedor(JComboBox proveedor){
        String sql = "SELECT nombre FROM proveedores";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                proveedor.addItem(rs.getString("nombre"));
            }
        }catch(SQLException e){  
            System.out.println(e.toString());
        }
    }
}
