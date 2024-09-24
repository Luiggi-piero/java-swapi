public class PeliculaFinal {
    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;

    public PeliculaFinal(Pelicula miPelicula) {
        this.title = miPelicula.title();
        this.episode_id = Integer.valueOf(miPelicula.episode_id());
        this.opening_crawl = miPelicula.opening_crawl();
        this.director = miPelicula.director();
        this.producer = miPelicula.producer();
        this.release_date = miPelicula.release_date();
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "( title: " + title
                + ", episode_id: " + episode_id
                + ", opening_crawl: " + opening_crawl +" )";
    }
}
