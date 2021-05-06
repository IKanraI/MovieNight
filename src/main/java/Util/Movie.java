package Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private String name;
    private String author;
    private String authorId;
    private LocalDateTime timestamp;
    private AtomicInteger timesSuggested;
    private List<String> authorsSuggested;

//    @SneakyThrows
//    public String toJsonString(Movie movie) {
//
//
//        ObjectMapper map = new ObjectMapper();
//        return map.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
//    }
//
//    @SneakyThrows
//    public void loadJson(File file) {
//
//
//        name = obj.get("name").toString();
//        author = obj.get("author").toString();
//    }


}
