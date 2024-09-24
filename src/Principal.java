import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el número de la película de Star Wars que deseas consultar: ");
        ConsultaPelicula consulta = new ConsultaPelicula();

        try {
            var numero = Integer.parseInt(lectura.nextLine());
            PeliculaFinal pelicula = consulta.buscaPelicula(numero);
            System.out.println(pelicula);

            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);

        }catch (NumberFormatException e){
            System.out.println("Número no encontrado " + e.getMessage());
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Programa terminado*");
        }
    }
}
