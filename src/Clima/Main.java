package Clima;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        
        IUM uim= new IUM();
        for(int i=0;i<3;i++){
            System.out.println(uim.Promedios()[i]);
        }
    }
    
}
