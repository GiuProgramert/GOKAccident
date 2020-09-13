package pruebaalgo;

import java.util.Scanner;

public class SuperCalculadora{

    public static void main(String args[]){

        Scanner data = new Scanner(System.in);

        String name        =  "";
        String clave1      =  "";
        String name2       =  "";
        String clave2      =  "";
        String eleccion2 = "";

        int num_1     = 0;
        int num_2     = 0;
        int resultado = 0;
        int eleccion  = 0;

        System.out.println("*********************************");
        System.out.println("Bienvenido a la SuperCalculadora");
        System.out.println("*********************************");

        System.out.println("");
        System.out.println("Registrate, coloca nombre y clave");

        System.out.println("Ingrese su nombre");
        name = data.nextLine();

        System.out.println("Ingrese su clave");
        clave1 = data.nextLine();

        System.out.println("porfavor verifique su nombre y clave");
         System.out.println("");

        System.out.println("Ingrese su nombre otra vez");
        name2 = data.nextLine();

        System.out.println("Ingrese su clave otra vez");
        clave2 = data.nextLine();

        if(name.equalsIgnoreCase(name2) && clave1.equals(clave2)){
            
        System.out.println("*************************");
        System.out.println("Inicio de sesion correcto");
        System.out.println("*************************");

        do{

            System.out.println("Presione 1 para una suma, 2 para una resta, 3 para una multiplicacion o 4 para una division");
             eleccion = data.nextInt(); 

         switch(eleccion){


            case 1: 

                    System.out.println("Ingrese el primer numero");
                    num_1 = data.nextInt(); 

                    System.out.println("Ingrese el segundo numero");
                    num_2 = data.nextInt(); 

                    resultado = num_1 + num_2;

                    System.out.println("el resultado es " + resultado);

                      System.out.println("");
                       eleccion2 = data.nextLine();

                    break;
            
            case 2: 

                    System.out.println("Ingrese el primer numero");
                    num_1 = data.nextInt(); 

                    System.out.println("Ingrese el segundo numero");
                    num_2 = data.nextInt(); 

                    resultado = num_1 - num_2;

                    System.out.println("el resultado es " + resultado);

                      System.out.println("");
                       eleccion2 = data.nextLine();

                    break;

            case 3: 

                    System.out.println("Ingrese el primer numero");
                    num_1 = data.nextInt(); 

                    System.out.println("Ingrese el segundo numero");
                    num_2 = data.nextInt(); 

                    resultado = num_1 * num_2;

                    System.out.println("el resultado es " + resultado);

                      System.out.println("");
                       eleccion2 = data.nextLine();

                    break;

            case 4: 

                    System.out.println("Ingrese el primer numero");
                    num_1 = data.nextInt(); 

                    System.out.println("Ingrese el segundo numero");
                    num_2 = data.nextInt(); 

                    resultado = num_1 / num_2;

                    System.out.println("el resultado es " + resultado);                  

                      System.out.println("");
                       eleccion2 = data.nextLine();

                    break;

             default:  System.out.println("error, escoje una opcion valida");

                      System.out.println("");
                       eleccion2 = data.nextLine();

                 break;


                       
         }

            System.out.println("desea intentarlo de nuevo?");
                       eleccion2 = data.nextLine();

        }while(eleccion2.equalsIgnoreCase("si"));



        } else {

           System.out.println("Inicio de sesion incorrecto");

        }
          System.out.println("");
          System.out.println("Gracias por usar la calculadora");

    }

}
