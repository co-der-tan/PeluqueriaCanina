package com.mycompany.peluqueriacanina.logica;
import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia cont = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color,
            String nombreDuenio, String celDuenio, String observaciones,
            String alergico, String atEspecial) {

        Duenio duenio = new Duenio();
        
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);

        Mascota mascota = new Mascota();

        mascota.setNombre(nombreMasco);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atEspecial);
        mascota.setObservaciones(observaciones);
        mascota.setUnDuenio(duenio);
        
        cont.guardar(duenio, mascota);
                
            
    }

    public List<Mascota> traerMascotas() {
       return cont.traerMascotas();
        
    }

    public void eliminarMascota(int id_fila) {
        cont.eliminarMascota(id_fila);
      
    }

    public Mascota traerMascota(int num_cliente) {
    
        return cont.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota mascota, String nombreMasco, String raza, 
            String color, String observaciones, String alergico, String atEspecial,
            String nombreDuenio, String celDuenio) {
        
        mascota.setNombre(nombreMasco);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atEspecial);
        
        // modificamos los datos de la mascota
        cont.modificarMascota(mascota);
        
        Duenio duenio = this.buscarDuenio(mascota.getUnDuenio().getId_duenio());
        // seteamos en duenio que devolvio el metodo buscarDuenio los nuevos valores que puedan llegar a cambiar en la interfaz
        
        duenio.setCelDuenio(celDuenio);
        duenio.setNombre(nombreDuenio);
        
        // creamos un metodo para modificar un dueño
        this.modificarDuenio(duenio);
        
    }
    
    
    // metodo para buscar el dueño de una mascota pasandole el id del dueño de la mascota
    private Duenio buscarDuenio(int id_duenio) {
        return cont.buscarDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
       cont.modificarDuenio(duenio);
    }

    
}
