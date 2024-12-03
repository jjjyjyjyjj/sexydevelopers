package api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class summarizeRecipe implements summarizeRecipeInterface {

    private static final String API_URL = "https://api.spoonacular.com/recipes/{id}/summary";
    private static final String APP_KEY = "5ec040755f3843c0831136f62dffb896"; // Replace with your actual key
    private static final int SUCCESS_CODE = 200;

    public static String getAPIKey() {
        return APP_KEY;
    }

    @Override
    public String getRecipeSummary(int id) throws IOException {
        String url = String.format("https://api.spoonacular.com/recipes/%d/summary?apiKey=%s",
                id, getAPIKey().trim());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.code() != SUCCESS_CODE) {
                throw new RuntimeException("Failed to summarize recipe. " + response.message());
            }

            String responseBody = response.body().string();

            // Extract the summary value
            String summaryTag = "\"summary\":\"";
            int startIndex = responseBody.indexOf(summaryTag) + summaryTag.length();
            int endIndex = responseBody.indexOf("\"", startIndex);
            String summary = responseBody.substring(startIndex, endIndex);

            return summary;
        }
    }
}
