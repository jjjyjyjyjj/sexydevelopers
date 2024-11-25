package api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class summarizeRecipe implements summarizeRecipeInterface {

    private static final String API_URL = "https://api.spoonacular.com/recipes";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    private static final String APP_KEY = "your_app_key"; // Replace with your actual key
    private static final int SUCCESS_CODE = 200;

    public static String getAPIKey() {
        return System.getenv(APP_KEY);
    }


    @Override
    public String getRecipeSummary(int id) throws IOException {
        String url = String.format("https://api.spoonacular.com/recipes/{id}/summary",
                API_URL, getAPIKey());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.code() != SUCCESS_CODE) {
                throw new RuntimeException("Failed to summarize recipe." + response.message());
            }

            String responseBody = response.body().string();
            return responseBody;
        }
    }

}
