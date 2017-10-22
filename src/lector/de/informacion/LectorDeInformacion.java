/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lector.de.informacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author augusto-btz
 */
public class LectorDeInformacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opciones=0;
        System.out.println("Ingrese una cancion");
        File f;
        javax.swing.JFileChooser j = new javax.swing.JFileChooser();
        FileNameExtensionFilter filt=new FileNameExtensionFilter("mp3", "mp3");
        j.setFileFilter(filt);
        j.showOpenDialog(j);
        String path=j.getSelectedFile().getAbsolutePath();
        String lectura="";
       
        String ruta=path;
        int leido;
        f = new File(path);
        try {
            FileReader fr=new FileReader(f);
            BufferedReader br = new BufferedReader(fr); 
            leido=br.read();
           
            if(leido==73)
            {
                leido=br.read();
                if(leido==68)
                {
                    leido=br.read();
                    if(leido==51)
                    {
                        System.out.println("Archivo Correcto");
                        
                        leido=br.read();
                        while(leido!=-1){  
                        if(leido==84)
                        {    
                            leido=br.read();
                            if(leido==80)///////etiqueta artista
                            {
                               
                                 leido=br.read();
                                 
                                 if(leido==69)
                                 {
                                     
                                      leido=br.read();
                                      if(leido==50)
                                      {
                                        
                                          String artista="";
                                          leido=br.read();
                                          while(leido!=84)
                                          {
                                              if(leido!=0)
                                              {
                                                  artista=artista+(char)leido;
                                                 
                                              }
                                              leido=br.read();
                                          }
                                          System.out.println("Artista: "+artista);
                                          
                                      }
                                 }
                            }
                            if(leido==84)//titulo
                            {   
                                leido=br.read();
                                if(leido==73)
                                {   
                                    leido=br.read();
                                    if(leido==84)
                                    {
                                        leido=br.read();
                                        if(leido==50)
                                        {
                                        
                                        
                                        String titulo="";
                                        leido=br.read();
                                        while(leido!=84)
                                        {
                                             if(leido!=0)
                                              {
                                                  titulo=titulo+(char)leido;
                                                 
                                              }
                                              leido=br.read();
                                        }
                                         System.out.println("Titulo: "+titulo);
                                    }
                                                                                }

                                }
                            }
                        }
                         leido=br.read();
                        }//
                    }
                }
            }
           
            
            fr.close();
            br.close();
               
                
               
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LectorDeInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LectorDeInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
