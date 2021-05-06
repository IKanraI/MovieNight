package Commands;

import Util.Info;
import Util.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.javacord.api.DiscordApi;
import org.json.simple.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Setter @Getter
public class Commands {

    private DiscordApi api;
    private String suggestionList = "C:\\Users\\joelm\\Documents\\JavaProjects\\MovieNight\\bin\\MovieList.json";

    public Commands (DiscordApi api) {
        this.api = api;

        commandHandler(api);
    }

    @SneakyThrows
    private void addMovieToList(String movie) {
        Movie movie1 = new Movie();

        movie1.setName("What Happened to Monday");
        movie1.setAuthor("Kanra#4986");

        Movie movie2 = new Movie();

        movie2.setName("Pulp Fiction");
        movie2.setAuthor("foxx#4986");

        Movie movie3 = new Movie();

        movie3.setName("Freaky Friday");
        movie3.setAuthor("partTimer#4986");

        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);

        JSONObject obj = new JSONObject();
        Map<String, Movie> data = new HashMap<>();

        AtomicInteger count = new AtomicInteger();
        movieList.forEach(film -> {
            data.put(film.getName(), film);
            obj.put(film.getName(), data.get(film.getName()));
        });

        ObjectMapper map = new ObjectMapper();
        Files.write(Paths.get(suggestionList), map.writerWithDefaultPrettyPrinter().writeValueAsString(obj).getBytes());


    }

    private void commandHandler(DiscordApi api) {

        api.addMessageCreateListener(event -> {
            if (!event.getMessageContent().substring(0, 1).equals(Info.prefix)) {
                return;
            }
            System.err.println(event.getMessageContent().substring(1).split("\\s")[0]);
            switch (event.getMessageContent().substring(1).split("\\s")[0]) {
                    case "suggest":
                    addMovieToList(event.getMessageContent().split("\\s")[1]);
            }
        });
    }
}
