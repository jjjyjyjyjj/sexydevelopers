package api;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class getRecipeInformation implements getRecipeInformationInterface {

    private static final String API_URL = "https://api.spoonacular.com/recipes";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    private static final String APP_KEY = "your_app_key"; // Replace with your actual key
    private static final int SUCCESS_CODE = 200;

    public static String getAPIKey() {
        return System.getenv(APP_KEY);
    }

    public String getRecipeURL(int id, boolean includeNutrition, boolean addWinePairing, boolean addTasteData) throws
            IOException {
        String url = String.format("https://api.spoonacular.com/recipes/{id}/information",
                API_URL, id, includeNutrition, addWinePairing, addTasteData, getAPIKey());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();

        // Execute the request and get the response
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response.code());
            }

            // Parse the JSON response using Jackson
            String jsonResponse = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            // Extract the "sourceUrl" field
            int recipeId = rootNode.get("id").asInt();
            String sourceUrl = rootNode.get("sourceUrl").asText();

            // Return the sourceUrl
            return sourceUrl;
        }
    }
}

