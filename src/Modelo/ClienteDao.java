/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class ClienteDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCliente(Cliente cl){
        String sql = "INSERT INTO clientes (ruc, nombre, telefono, direccion, razon) VALUES (?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getRuc());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getRazon());
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
    
    public List ListarCLiente(){
        List<Cliente> ListaCl = new ArrayList();
        String sql = "SELECT * FROM CLIENTES";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setRuc(rs.getString("ruc"));
                cl.setNombre(rs.getString("nombre"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setRazon(rs.getString("razon"));   
                ListaCl.add(cl);
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return ListaCl;
    }
    
    public boolean EliminarCliente(int id){
        String sql = "DELETE FROM clientes where id = ?";
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
    
    public boolean ModificarCliente(Cliente cl){
        String sql = "UPDATE clientes SET ruc=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getRuc());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getRazon());
            ps.setInt(6, cl.getId());
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
    
    public Cliente BuscarCliente(int ruc){
        Cliente cl = new Cliente();
        String sql = "SELECT * FROM clientes WHERE ruc = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ruc);
            rs = ps.executeQuery();
            if(rs.next()){
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setRazon(rs.getString("razon"));
            }
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return cl;
    }
}
