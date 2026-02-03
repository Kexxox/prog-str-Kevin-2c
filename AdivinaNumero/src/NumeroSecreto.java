import java.util.Random;
import java.util.Scanner;

public class NumeroSecreto {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Random random = new Random();
        int min=1;
        int max=100;
        int intentos = 0;
        int limiteIntentos=7;
        boolean gano = false;
        int secreto = random.nextInt(100)+1;

        System.out.println("Adivina el numero (1-100) " +"tienes: "+limiteIntentos+" para lograrlo");

        while(intentos<limiteIntentos){
            int numero=obtenerNumeroValido("Intento: "+(intentos+1),leer,min,max);
            intentos++;
            if(numero==secreto){
                System.out.println("Felicidades ganaset en el intento: "+intentos);
                gano=true;
                break;
            }else if(numero>secreto) {
                System.out.println("El numero secreto es menor a" +numero);
            }else{
                System.out.println("El numero secreto es mayor a "+secreto);
            }
        }
        if(!gano){
            System.out.println("Perdiste, el numero secreto era: "+secreto);
        }
    }
    public static int obtenerNumeroValido(String mensaje, Scanner leer, int min, int max){
        int entrada;
        while(true){
            System.out.println(mensaje);
            if(leer.hasNextInt()){
                entrada=leer.nextInt();
                if(entrada>min && entrada<max){
                    return entrada;
                }
                System.out.println("El numero ingresado esta fuera de rango (1-100)");
            }else{
                System.out.println("El dato ingresado no es numerico");
                leer.next();
            }
        }
    }
}
