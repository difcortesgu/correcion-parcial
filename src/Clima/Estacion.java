package Clima;

import java.util.ArrayList;

public class Estacion {

    private int nombre;
    private String ubicacion;
    private String fecha;
    private Ciudad ciudad;
    private ArrayList<Sensor> sensores;

    public Estacion(int nombre, String ubicacion, String fecha, Ciudad ciudad) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.ciudad = ciudad;
        sensores = new ArrayList();
    }

    public Estacion(int nombre) {
        this.nombre = nombre;
        sensores = new ArrayList();
    }
    
    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<Sensor> getSensores() {
        return sensores;
    }
    
    public void addSensorT(int grados){
        sensores.add(new Temperatura(grados));
    }
    
    public void addSensorL(int c){
        sensores.add(new Lluvia(c));
    }
    
    public void addSensorC(int c){
        sensores.add(new CargaElectrica(c));
    }
    
    public void setSensores(ArrayList<Sensor> sensores) {
        this.sensores = sensores;
    }
    
}
