
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class ControladoraPersistencia {
    
MascotaJpaController m = new MascotaJpaController();

DuenioJpaController dueJpa = new DuenioJpaController();
MascotaJpaController masJpa = new MascotaJpaController();

   

    public void guardar(Duenio duenio, Mascota mascota) {
        
        // creamos en la BD  un duenio
        dueJpa.create(duenio);
        // creamos en la BD  una mascota
        masJpa.create(mascota);
       
    }

    public List<Mascota> traerMascotas() {
       
       return masJpa.findMascotaEntities();
    }

    public void eliminarMascota(int id_fila) {
        
    try {
        masJpa.destroy(id_fila);
   
    } catch (NonexistentEntityException ex) {
        Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public Mascota traerMascota(int num_cliente) {
      
        return masJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota mascota) {
     
    try {
        masJpa.edit(mascota);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "no se pudo modificar la mascota");
    }
    }

    public Duenio buscarDuenio(int id_duenio) {
        
        return dueJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio duenio) {
    try {
        dueJpa.edit(duenio);
    } catch (Exception ex) {
        Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

  

   

 
    
}
