/*
Instituto Politécnico Nacional
Escuela Superior de Cómputo
Teoria Computacional
Grupo: 2CV1
Alumno: García Tello Axel
Profesor: Benjamin Luna Benoso
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
Lector de AFP

Fecha: 21 de octubre de 2019
*/


import java.io.IOException;
import java.util.Scanner;


public class AFP {
    private Archivo archivo;
    private Tabla tabla;
    private Scanner teclado;
    private Analizador analizador;
    
    public void iniciarAFP() throws IOException{
        String cadena;
        archivo=new Archivo();
        tabla=new Tabla();
        teclado=new Scanner(System.in);
        analizador=new Analizador();
        archivo.crearTabla(tabla);
        System.out.println("Ingrese la cadena que desea "
                + "analizar");
        cadena=teclado.nextLine();
        cadena+="e";
        analizador.analizarCadena(tabla, cadena);
    }
    
}
