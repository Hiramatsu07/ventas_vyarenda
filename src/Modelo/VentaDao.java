/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hiramatsu
 */
public class VentaDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM VENTAS";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return id;
    }
    
    public int RegistrarVenta(Venta v){
        String sql = "INSERT INTO ventas (cliente, vendedor, total) VALUES(?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setInt(3, v.getTotal());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
         }finally{
            try{
                con.close();
            } catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public int RegistrarDetalle(Detalle d){
        String sql = "INSERT INTO detalle (cod_prod, cantidad, precio, id_venta)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, d.getCod_prod());
            ps.setInt(2, d.getCantidad());
            ps.setInt(3, d.getPrecio());
            ps.setInt(4, d.getId_venta());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            } catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public boolean ActualizarStock(int cant, String cod)
    
    {
        String sql = "UPDATE productos SET stock = ? WHERE cod";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
       }catch(SQLException e){
           System.out.println(e.toString());
           return false;
       }
    }
}
