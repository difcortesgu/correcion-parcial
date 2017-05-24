package Clima;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IUM {

    private ArrayList<Ciudad> ciudades;
    private Scanner s;
    private File f;

    public IUM() {
        ciudades = new ArrayList();
        f = new File("datos.txt");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(IUM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IUM.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.LeerDatos();
                
    }

    public IUM(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
    
    public void addCiudad(Ciudad c){
        ciudades.add(c);
    }
    
    public double[] Promedios(){
        double []p = {0,0,0};
        int []n ={0,0,0};
        for(Ciudad c:ciudades){
            for(Estacion e : c.getEstaciones()){
                for(Sensor s : e.getSensores()){
                    if(s instanceof Temperatura){
                        p[0] += ((Temperatura) s).getGrados();
                        n[0]++;
                    }
                    if(s instanceof Lluvia){
                        p[1] += ((Lluvia) s).getCantidad();
                        n[1]++;
                    }
                    if(s instanceof CargaElectrica){
                        p[2] += ((CargaElectrica) s).getNclasificacion();
                        n[2]++;
                    }
                }
            }
        }
        for(int i=0;i<3;i++){
            p[i]/=n[i]; 
        }
        return p;
    }
    
    public void LeerDatos(){
        s.useDelimiter(" ");
        while(s.hasNext()){
            
            ciudades.add(new Ciudad(s.next()));
            s.nextLine();
            int n = s.nextInt();
            for(int i=0;i<n;i++){
                s.nextLine();
                ciudades.get(ciudades.size()-1).addEstacion(new Estacion(s.nextInt()));
                s.nextLine();
                int a = s.nextInt();
                for(int j=0;j<a;j++){
                    s.nextLine();
                    ciudades.get(ciudades.size()-1).getEstacion(i).setFecha(s.next());
                    ciudades.get(ciudades.size()-1).getEstacion(i).addSensorT(s.nextInt());
                    ciudades.get(ciudades.size()-1).getEstacion(i).addSensorL(s.nextInt());
                    ciudades.get(ciudades.size()-1).getEstacion(i).addSensorC(s.nextInt());
                }
            }
            s.nextLine();
        }
        s.close();
    }
    
}
