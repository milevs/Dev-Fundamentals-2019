import java.util.Scanner;
import java.util.Arrays;
 
public class Validator {
 
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese una dirección IP: ");
        String cadena = teclado.next();
        String [] sNumeros=cadena.split("\\.");
        int [] Numeros= new int[4];
        // aqui vemos que clase de IP es
        while (sNumeros.length <4 || sNumeros.length >4){
            System.out.println("Error esto: " + cadena + "  NO es una direccion IP ");
            break;}
        if (Numeros[0]<=127 && Numeros[1]<=255 && Numeros[2]<=255 && Numeros[3]<=254)
        {
            System.out.println("La dirección IP " + cadena + " es valida y pertenece a la Clase A");
        }
        else if (Numeros[0]<=191 && Numeros[1]<=255 && Numeros[2]<=255 && Numeros[3]<=254 )
        {
            System.out.println("La dirección IP " + cadena + " ,es valida y pertenece a la Clase B");
        }
        else if (Numeros[0]<=223 && Numeros[1]<=255 && Numeros[2]<=255 && Numeros[3]<=254 )
        {
            System.out.println("La dirección IP " + cadena + " ,es valida y pertenece a la Clase C");
        }
        else if (Numeros[0]<=239 && Numeros[1]<=255 && Numeros[2]<=255 && Numeros[3]<=254 )
        {
            System.out.println("La dirección IP " + cadena + " ,es valida y pertenece a la Clase D");
        }
        else if (Numeros[0]<=255 && Numeros[1]<=255 && Numeros[2]<=255 && Numeros[3]<=254 )
        {
            System.out.println("La dirección IP " + cadena + " ,es valida y pertenece a la Clase E");
        }
    }
}