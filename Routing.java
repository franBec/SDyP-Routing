import java.util.ArrayList;
import java.util.Scanner;

public class Routing {

    public static void main(String[] args) {
        //Declaracion
        int dimension;
        String nodoIni, nodoFin;
        Scanner in = new Scanner(System.in);
        
        //Solicitud de valores
        System.out.print("Ingrese la dimension del hipercubo: ");
        dimension = in.nextInt();
        //Controlar que sea mayor a 0
        while(dimension<=0){
            System.out.println("La dimension debe ser un valor mayor a 0.");
            System.out.print("Ingrese nuevamente la dimension: ");
            dimension = in.nextInt();
        }
        
        in.nextLine();//Limpio el buffer porque quedaba con basura.
        
        System.out.print("Ingrese el nodo de inicio: ");
        nodoIni = in.nextLine();
        //Controlar que solo sean 0 o 1 y la dimension
        while(!nodoIni.matches("^[01]+$") || nodoIni.length() != dimension){
            if(!nodoIni.matches("^[01]+$")){
                System.out.println("Los caracteres admitidos son unicamente 0 y 1.");
                System.out.print("Intente nuevamente: ");
            }
            else{
                System.out.println("El tamaño de la cadena ingresada no corresponde a la dimension.");
                System.out.print("Ingrese nuevamente el nodo de inicio (dimesion "+dimension+"): ");
            }
            nodoIni = in.nextLine();
        }
        //Controlar que solo sean 0 o 1 y la dimension
        System.out.print("Ingrese el nodo de fin: ");
        nodoFin = in.nextLine();
        while(!nodoFin.matches("^[01]+$") || nodoFin.length() != dimension){
            if(!nodoFin.matches("^[01]+$")){
                System.out.println("Los caracteres admitidos son unicamente 0 y 1.");
                System.out.print("Intente nuevamente: ");
            }
            else{
                System.out.println("El tamaño de la cadena ingresada no corresponde a la dimension.");
                System.out.print("Ingrese nuevamente el nodo de inicio (dimesion "+dimension+"): ");
            }
            nodoFin = in.nextLine();
        }
        routing(dimension, nodoIni, nodoFin);
        
    }
    
    public static void routing(int dimension, String nodoInicio, String nodoDestino){
        //Declaracion
        ArrayList<String> recorrido = new ArrayList<>();
        int cant,i;
        StringBuilder nodo;
        
        //Inicializacion
        recorrido.add(nodoInicio);
        cant=0;
        i=nodoDestino.length()-1;
        
        
        //Iteracion
        while(!recorrido.get(cant).equals(nodoDestino)){
            while(recorrido.get(cant).toCharArray()[i] == nodoDestino.toCharArray()[i]){
                i--;
            }
            
            nodo = new StringBuilder(recorrido.get(cant));
            if(recorrido.get(cant).toCharArray()[i]=='1'){
                nodo.setCharAt(i, '0');
            }
            else{
                nodo.setCharAt(i, '1');
            }
            recorrido.add(nodo.toString());
            cant++;
        }
        System.out.println("El recorrido de la funcion de routing es el siguiente:");
        for (String elemento : recorrido) {
            System.out.println(elemento);           
        }
    }
    
}