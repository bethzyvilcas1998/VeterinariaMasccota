/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangerBean;

import dao.ClienteDao;
import entidades.Cliente;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
  * @author BETHZY
 */
@ManagedBean
@ViewScoped
public class ClienteBean {
    
     private Cliente clientes;
    private ClienteDao clientesDao;
    private boolean respuesta;
    
    public ClienteBean() {
        this.clientes = new Cliente();
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }
    
    public ArrayList<Cliente> listClientes() {

        ArrayList<Cliente> list = new ArrayList<>();
        clientesDao = new ClienteDao();
        list = clientesDao.listClientes();
        return list;

    }
    
    public String insertClientes(){
        
        clientesDao = new ClienteDao();
        respuesta = clientesDao.insertClientes(clientes);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/RegistrarCliente";
        
    }
    
    public String clean(){
        return "/RegistrarCliente";
    }
    
    public String updateClientes(){
        
        clientesDao = new ClienteDao();
        respuesta = clientesDao.updateClientes(clientes);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro actualizado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/RegistrarCliente";
        
    }
    
    public String deleteClientes(Cliente clientes){
        
        clientesDao = new ClienteDao();
        respuesta = clientesDao.deleteClientes(clientes);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito", "exito"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/RegistrarCliente";
        
    }
    
}
