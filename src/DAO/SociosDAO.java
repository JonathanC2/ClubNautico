/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *8
 * @author lalo_
 */
public class SociosDAO implements ISociosDAO{
    public iConexionBD conexion= new ConexionBD();

    public SociosDAO() {
    }

    public SociosDAO(iConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Socio socio){
        try{ 
        String query="INSERT INTO `clubnautico`.`socio` (`idSocio`, `Nombre`, `Direccion`, `Telefono`) VALUES ('"+socio.idSocio+"', '"+socio.Nombre+"', '"+socio.Direccion+"', '"+socio.Telefono+"')";
        Connection con=conexion.crearConexion();
        Statement comando = con.createStatement();
        comando.executeUpdate(query);
        con.close();
        return true;
        }
        catch(Exception ex){
            System.out.println(ex);
            return false;
        }
    }
    
    @Override
    public boolean actualizar(Socio socio)throws Exception {
        
         try{
         Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            String codigoSQL = String.format(
                    "UPDATE socio SET  nombre='%s', direccion='%s', telefono='%s' WHERE idSocio=%d ",
                    socio.getNombre(),
                    socio.getDireccion(),
                    socio.getTelefono(),
                    socio.getIdSocio()
            );
            

            int conteoRegistrosActualizados = comando.executeUpdate(codigoSQL);
            if (conteoRegistrosActualizados == 1) {
                System.out.println("Se actualizo el Socio" + socio.getIdSocio());
                
            } else {

                throw new Exception("No existe el Socio" + socio.getIdSocio());
            }
            con.close();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }

    }
  
    @Override
    public List<Socio> consultarTodos(){

        try{
        List<Socio> list= new ArrayList();
        String query="SELECT * FROM clubnautico.socio";
        Connection con=conexion.crearConexion();
        Statement comando = con.createStatement();
        ResultSet datos = comando.executeQuery(query);
        while(datos.next()){
            Socio socio =new Socio();
            socio.idSocio=datos.getInt("idSocio");
            socio.Nombre=datos.getString("Nombre");
            socio.Direccion=datos.getString("Direccion");
            socio.Telefono=datos.getString("Telefono");
            list.add(socio);
            
        }
        con.close();
        
        return list;
        }
        catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
     
        @Override
    public Socio consultar(Integer id) {
        Socio socio = null;
        try {
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            String codigoSQL = String.format("SELECT idSocio, Nombre, Direccion, Telefono FROM socios WHERE idSocios = %d",
                    id);
            ResultSet resultado = comando.executeQuery(codigoSQL);
            
            if (resultado.next()) {
                Integer idSocio = resultado.getInt("idcliente");
                String nombre = resultado.getString("nombre");
                String direccion = resultado.getString("direccion");
                String telefono = resultado.getString("telefono");
                socio = new Socio(idSocio, nombre, direccion, telefono);
            }
            con.close();
            System.out.println("Se consulto el socio " + id);
            return socio;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return socio;
        }
    }

  
    @Override
    public void eliminar(Integer id) {
     try {
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            String codigoSQL = String.format("DELETE FROM socio WHERE idSocio= %d",
                    id);
             int conteoRegistrosAfectados= comando.executeUpdate(codigoSQL);
             if(conteoRegistrosAfectados == 1){
                 System.out.println("Se elimino el socio " + id);
             }
            con.close();
           
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
