import Commands.Commands;
import lombok.SneakyThrows;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MovieNight {

    @SneakyThrows
    public static void main(String[] args) {

        String token = Files.readAllLines(Path.of("C:\\Users\\joelm\\Documents\\JavaProjects\\Hidden\\MovieToken.txt")).get(0);

        DiscordApi api = new DiscordApiBuilder().setToken(token).setAllIntents().login().join();

        Commands commandInit = new Commands(api);
    }
}
