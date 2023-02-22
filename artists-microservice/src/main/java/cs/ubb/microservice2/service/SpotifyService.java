package cs.ubb.microservice2.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cs.ubb.microservice2.dto.ItemsDto;
import cs.ubb.microservice2.dto.SpotifyDto;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class SpotifyService {

    public SpotifyService() {
    }

    public Long getDurationOfSong(String songName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://spotify23.p.rapidapi.com/search/?q=" + songName.replace(" ", "%20") +
                                "&type=tracks&offset=0&limit=10&numberOfTopResults=5"))
                .header("X-RapidAPI-Key", "0b1eccb89cmshdb8a53c1e99b639p1f861ajsn85aaf9283a6d")
                .header("X-RapidAPI-Host", "spotify23.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder().create();
        SpotifyDto spotifyDto = gson.fromJson(response.body(), SpotifyDto.class);
        return spotifyDto.getTracks().getItems().stream().map(ItemsDto::getData)
                .filter(data -> data.getName().equalsIgnoreCase(songName))
                .map(data -> data.getDuration().getTotalMilliseconds()).findFirst().orElseThrow(() -> {
                    throw new RuntimeException("");
                });
    }
}
