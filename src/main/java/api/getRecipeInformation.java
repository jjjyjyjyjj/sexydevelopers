package api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class getRecipeInformation implements getRecipeInformationInterface {
    private static final String API_URL = "https://api.spoonacular.com/recipes/%d/information";
    private static final String APP_KEY = "5ec040755f3843c0831136f62dffb896";
    private static final int SUCCESS_CODE = 200;

    public static String getAPIKey() {
        return APP_KEY;
    }

    /**
     * Fetch the source URL of a recipe by its ID.
     *
     * @param id The recipe ID.
     * @return The source URL of the recipe.
     * @throws IOException If an error occurs while fetching the recipe data.
     */
    public String getRecipeURL(int id) throws IOException {
        // Construct the URL with the recipe ID.
        String url = String.format(API_URL + "?apiKey=%s", id, getAPIKey());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Execute the request and process the response.
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response.code());
            }

            // Parse the JSON response using Jackson.
            String jsonResponse = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            // Extract and return the "sourceUrl" field.
            return rootNode.get("sourceUrl").asText();
        }
    }
}

