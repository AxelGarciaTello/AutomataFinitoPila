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


public class Tabla {
    private String[][] tabla;
    private char[] estadoAceptacion;
    
    public Tabla(){
        tabla=new String[15][15];
        estadoAceptacion=new char[15];
    }
    
    public void ingresarDato(int fila, int columna,
            String dato){
        tabla[fila][columna]=dato;
    }
    
    public void ingresarAceptacion(int lugar, char dato){
        estadoAceptacion[lugar]=dato;
    }
    
    public void imprimirTabla(){
        for(int x=0;x<15;x++){
            for(int y=0;y<15;y++){
                System.out.print(tabla[x][y]+"|");
            }
            System.out.println("");
        }
    }
    
    public String mostrarDato(int fila, int columna){
        return tabla[fila][columna];
    }
    
    public void verificarEstado(String estado){
        boolean aceptacion=false;
        for(int x=0;x<15;x++){
            if(estado.equals(estadoAceptacion[x]+"")){
                aceptacion=true;
                x=16;
            }
        }
        if(aceptacion){
            System.out.println("La cadena es valida para "
                    + "este AFP");
        }
        else{
            System.out.println("la cadena no es valida para"
                    + " este AFP");
        }
    }
    
}
