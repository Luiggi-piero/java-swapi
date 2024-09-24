import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {

    Gson gson = new GsonBuilder()
//            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public PeliculaFinal buscaPelicula(int numeroDePelicula){

//        URI direccion = URI.create("https://swapi.py4e.com/api/films/"+ numeroDePelicula);
        URI direccion = URI.create("https://swapi.dev/api/films/"+ numeroDePelicula);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Pelicula miPelicula = gson.fromJson(json, Pelicula.class);
            PeliculaFinal peliculaFinal = new PeliculaFinal(miPelicula);
            return peliculaFinal;
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa película");
        }
    }
}
