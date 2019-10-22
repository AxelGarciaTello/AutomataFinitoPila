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


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Archivo {
    private Scanner teclado;
    private FileReader fp;
    private BufferedReader caracter;
    private String textoCompleto="";
    
    private void leerArchivo() throws FileNotFoundException,
            IOException{
        teclado=new Scanner(System.in);
        String archivo,
               texto;
        System.out.println("¿Cómo se llama su archivo?");
        archivo=teclado.nextLine();
        fp=new FileReader(archivo);
        if(fp==null){
            System.out.println("No se pudo leer el archivo");
        }
        caracter=new BufferedReader(fp);
        texto=caracter.readLine();
        while(texto!=null){
            textoCompleto+=texto;
            texto=caracter.readLine();
        }
        caracter.close();
        fp.close();
    }
    
    public void crearTabla(Tabla tabla) throws IOException{
        leerArchivo();
        int tamanio,
            contador=0,
            aceptacion=0,
            fila=0,
            columna=0;
        char dato;
        String informacion="";
        tamanio=textoCompleto.length();
        while(textoCompleto.charAt(contador)!=';'){
            if(textoCompleto.charAt(contador)=='q'){
                contador++;
                dato=textoCompleto.charAt(contador);
                tabla.ingresarAceptacion(aceptacion, dato);
                aceptacion++;
            }
            contador++;
        }
        while(textoCompleto.charAt(contador)!='>'){
            contador++;
        }
        contador++;
        while(contador<tamanio){
            if(textoCompleto.charAt(contador)=='|'){
                tabla.ingresarDato(fila, columna,
                        informacion);
                informacion="";
                columna++;
            }
            else if(textoCompleto.charAt(contador)==';'){
                tabla.ingresarDato(fila, columna,
                        informacion);
                informacion="";
                columna=0;
                fila++;
            }
            else{
                informacion+=textoCompleto.charAt(contador);
            }
            contador++;
        }
    }
    
}
