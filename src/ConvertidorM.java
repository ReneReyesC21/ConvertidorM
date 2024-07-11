import java.util.Scanner;

public class ConvertidorM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido al Conversor de Monedas");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir de USD a EUR");
            System.out.println("2. Convertir de EUR a USD");
            System.out.println("3. Convertir de USD a MXN");
            System.out.println("4. Convertir de MXN a USD");
            System.out.println("5. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad en USD: ");
                    double cantidadUSD = scanner.nextDouble();
                    double tasaUSDaEUR = ExchangeRateAPI.getExchangeRate("USD", "EUR");
                    double cantidadEUR = cantidadUSD * tasaUSDaEUR;
                    System.out.println(cantidadUSD + " USD son " + cantidadEUR + " EUR");
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad en EUR: ");
                    double cantidadEUR2 = scanner.nextDouble();
                    double tasaEURaUSD = ExchangeRateAPI.getExchangeRate("EUR", "USD");
                    double cantidadUSD2 = cantidadEUR2 * tasaEURaUSD;
                    System.out.println(cantidadEUR2 + " EUR son " + cantidadUSD2 + " USD");
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad en USD: ");
                    double cantidadUSD3 = scanner.nextDouble();
                    double tasaUSDaMXN = ExchangeRateAPI.getExchangeRate("USD", "MXN");
                    double cantidadMXN = cantidadUSD3 * tasaUSDaMXN;
                    System.out.println(cantidadUSD3 + " USD son " + cantidadMXN + " MXN");
                    break;
                case 4:
                    System.out.print("Ingrese la cantidad en MXN: ");
                    double cantidadMXN2 = scanner.nextDouble();
                    double tasaMXNaUSD = ExchangeRateAPI.getExchangeRate("MXN", "USD");
                    double cantidadUSD4 = cantidadMXN2 * tasaMXNaUSD;
                    System.out.println(cantidadMXN2 + " MXN son " + cantidadUSD4 + " USD");
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 5.");
            }
            System.out.println();
        } while (opcion != 5);

        scanner.close();
    }
}
