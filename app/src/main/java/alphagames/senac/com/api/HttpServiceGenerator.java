package alphagames.senac.com.api;

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpServiceGenerator {
//    private static final String url = "http://127.0.0.1:8000/api/";
    private static final String url = "http://192.168.0.17:8000/api/";
    private static final OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create());

    public static Retrofit retrofit = builder.build();

    public static <S> S createHttpService(Context context, Class<S> clientClass) {
        // Intercepta todas as requisições e inclui o header Authorization
        httpClientBuilder.addInterceptor(chain -> {
            Request request = chain.request();
            Request.Builder newRequest = request.newBuilder();

//            // Authorization - JWT Token
//            String token = context.getSharedPreferences("AlphaGamesPrefs", Context.MODE_PRIVATE).getString("JwtToken", "");
//            if (!token.isEmpty()) {
//                newRequest.header("Authorization", String.format("Bearer %s", token));
//            }

            // Accept - Sempre deve ter retorno em JSON
//            newRequest.header("Accept", "application/json");

            return chain.proceed(newRequest.build());
        });

        builder = builder.client(httpClientBuilder.build());
        retrofit = builder.build();

        return retrofit.create(clientClass);
    }

}
