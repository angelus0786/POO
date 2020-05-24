package miagenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class MiAgenda {
    
    static File archivo = new File("agenda.txt");
    static FileWriter fw = null;
    static BufferedWriter bw = null;
    static FileReader fr = null;
    static BufferedReader br=null;

  
    public static void main(String[] args) {
        MiAgenda agenda = new MiAgenda();
        Persona p=null;
        Scanner leerNumeros = new Scanner(System.in);
        Scanner leerCaracteres = new Scanner(System.in);
        int opcion=0;
        
        while (opcion!=4) {
            System.out.println("Menu");
            System.out.println("1. Ingresar contacto");
            System.out.println("2. Consultar Agenda");
            System.out.println("3. Buscar contacto por Nombre");
            System.out.println("4. Salir");
            try {
                opcion= leerNumeros.nextInt();
            } catch (Exception e) {
                leerNumeros = new Scanner(System.in);
            }
                
            switch (opcion) {
                case 1:
                    System.out.println("Nombre:");
                    String nombre = leerCaracteres.nextLine();
                    System.out.println("Apellido Paterno:");
                    String apPaterno = leerCaracteres.nextLine();
                    System.out.println("Apellido Materno:");
                    String apMaterno = leerCaracteres.nextLine();
                    System.out.print("Telefono:");
                    String telefono = leerCaracteres.nextLine();
                    System.out.print("Correo:");
                    String correo = leerCaracteres.nextLine();
                    p = new Persona(nombre, apPaterno, apMaterno, telefono, correo);
                    agenda.escribirContacto(p);
                    break;
                case 2:
                    agenda.leerContactos();
                    break;
                case 3:
                    System.out.println("Ingresar Nombre:");
                    String nombreB = leerCaracteres.nextLine();
                    agenda.buscar(nombreB);
                    break;    
                default:
                    System.out.println("opcion invalida");
                    break;
            }//fin switch
 
        }//fin while
    }//fin main
    
    private  void escribirContacto(Persona p) {
       
        try {
         fw = new FileWriter(archivo,true);   
         bw = new BufferedWriter(fw);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }else{
                bw.write(p.toString()+"\n");
                bw.close();
            }
           
        } 
        catch(IOException e){
            System.out.println("Exception IO:"+e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception:"+e.getMessage());
        }
    }

    private void leerContactos() {
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String cadena;
            while ( (cadena=br.readLine())!=null ) {
              String contacto[] = cadena.split("%");
               Persona p =
               new Persona(contacto[0], contacto[1], contacto[2], contacto[3], contacto[4]);
               p.mostrar();
               System.out.println("**************");
            }
            br.close();
        }
        catch(IOException e){
            System.out.println("Exception IO:"+e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception:"+e.getMessage());
        }
    }

    private void buscar(String nombreB) {
         try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String cadena;
            boolean bandera=false;
            while ( (cadena=br.readLine())!=null ) {
               String contacto[] = cadena.split("%");
                if (contacto[0].equals(nombreB)) {
                   bandera =true;
                   Persona p =
                   new Persona(contacto[0], contacto[1], contacto[2], contacto[3], contacto[4]);
                   p.mostrar();
                  System.out.println("**************"); 
                }
            }//fin while
             if (bandera==false) {
                 System.out.println("El contacto no existe.");
             }
            br.close();
        }
        catch(IOException e){
            System.out.println("Exception IO:"+e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception:"+e.getMessage());
        }
    }
    
}
