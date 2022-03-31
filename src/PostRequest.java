
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class PostRequest {
	public static final String URL_POST = "http://httpbin.org/forms/post";
	public static final String FILE_JSON = "C:\\Users\\Lais\\Desktop\\workspace\\exec_Voto\\src\\exec_salario_funcionari";

	public static void main(String[] args) throws IOException, InterruptedException {

		// client
		HttpClient client = HttpClient.newHttpClient();
		// create Request
		HttpRequest request = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_POST))
                .build();
		// Request asynchronous
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenAccept(System.out::println)
        .join();
	}
}
