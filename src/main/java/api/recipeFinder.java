package api;

import java.util.List;
import java.util.Map;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class recipeFinder implements recipeFinderInterface {
    private static final String API_URL = "https://api.edamam.com/search";
    private static final String APP_ID = "your_app_id";
    private static final String APP_KEY = "your_app_key";

    public static String getAPIKey() { return System.getenv(APP_KEY); }

    @Override
    public List<Map<String, Object>> getRecipeByIngredient(List<String> ingredients) {
    };


}
