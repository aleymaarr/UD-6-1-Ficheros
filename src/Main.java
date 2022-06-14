import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        int numeroLitros = 0;


        String opcion = "";
        String apodo="";
        String numero="";
        float fuelLevel;
        String pilotCallSign;
        String squadNumber;
        File archivo = new File("data/plane.dat");

        Plane f18 = new Plane((float) numeroLitros,apodo,numero);

        Scanner sc = new Scanner(System.in);

        while(!opcion.equals("Q")){
            System.out.println("Por favor, seleccione la operación");
            System.out.println("1.  Inicializar F18");
            System.out.println("2.  Alternar estado de los flaps");
            System.out.println("3.  Alternar estado del tren de aterrizaje");
            System.out.println("4.  Armar sistema de eyección");
            System.out.println("5.  Eyectar piloto");
            System.out.println("Q - Salir");
            System.out.println("Por favor introduzca un número: ");
            opcion = sc.next();
            switch(opcion) {
                case "1":
                    boolean flaps = true;
                    boolean landingGear = false;
                    boolean ejectionSystem = false;
                    boolean seatOccupation = true;
                    System.out.println("Introduzca el número de litros de combustible cargados: ");
                    numeroLitros = sc.nextInt();
                    System.out.println("Introduzca apodo del piloto: ");
                    apodo = sc.next();
                    System.out.println("Introduzca número de escuadrón ");
                    numero = sc.next();

                    f18.setFuelLevel(numeroLitros);
                    f18.setPilotCallSign(apodo);
                    f18.setSquadNumber(numero);
                    f18.setSeatOccupation(seatOccupation);
                    f18.setFlaps(flaps);
                    f18.setLandingGear(landingGear);
                    f18.setEjectionSystem(ejectionSystem);
                    System.out.println(f18);
                    break;
                case "2":
                    if (f18.isFlaps()==true){
                        f18.setFlaps(false);
                    }else{
                        f18.setFlaps(true);
                    }
                    System.out.println(f18);
                    break;
                case "3":
                    if (f18.isLandingGear()==true){
                        f18.setLandingGear(false);
                    }else{
                        f18.setLandingGear(true);
                    }
                    System.out.println(f18);
                    break;
                case "4":
                    if (f18.isEjectionSystem()==true){
                        f18.setEjectionSystem(false);
                    }else{
                        f18.setEjectionSystem(true);
                    }
                    System.out.println(f18);
                    break;
                case "5":
                    if (f18.isEjectionSystem()==true){
                        f18.setSeatOccupation(false);
                    }else{
                        f18.setSeatOccupation(true);
                    }
                    System.out.println(f18);
                    break;
                case "Q":
                    try {
                        FileWriter escribir = new FileWriter(archivo,true);
                        String estado = f18.toString();
                        escribir.write(estado);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("Es usted demasiado totufo para utilizar esta aplicación");
                    break;
            }
        }
            System.out.println("Ha salido del programa");
        }


    }

