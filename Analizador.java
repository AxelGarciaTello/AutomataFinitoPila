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


import java.util.Stack;


public class Analizador {
    private String estado;
    private Stack<String> pila;
    
    public Analizador(){
        estado="0";
        pila=new Stack<String>();
        pila.push("z");
    }
    
    private void analizarCaracter(Tabla tabla, String caracter){
        int fila=0,
            columna=0,
            tamanio;
        String cimaPila=pila.pop();
        String ingresar;
        System.out.print("S("+estado+","+caracter+","+cimaPila+")|-(");
        while(!(estado.equals(tabla.mostrarDato(fila,0)) &&
                cimaPila.equals(tabla.mostrarDato(fila, 1)))){
            fila++;
        }
        switch(caracter){
            case "0":
                columna=2;
            break;
            case "1":
                columna=4;
            break;
            case "e":
                columna=6;
            break;
        }
        estado=tabla.mostrarDato(fila, columna+1);
        System.out.print(estado+",");
        if(!tabla.mostrarDato(fila, columna).equals("e")){
            ingresar=tabla.mostrarDato(fila, columna);
            System.out.print(ingresar);
            tamanio=ingresar.length();
            while(tamanio>0){
                pila.push(ingresar.charAt(tamanio-1)+"");
                tamanio--;
            }
        }
        else{
            System.out.print("e");
        }
        System.out.print(")\n");
    }
    
    public void analizarCadena(Tabla tabla, String cadena){
        int tamanio,
            contador=0;
        tamanio=cadena.length();
        while(contador<tamanio && !estado.equals(" ")){
            analizarCaracter(tabla,
                    cadena.charAt(contador)+"");
            contador++;
        }
        tabla.verificarEstado(estado);
    }
    
}
