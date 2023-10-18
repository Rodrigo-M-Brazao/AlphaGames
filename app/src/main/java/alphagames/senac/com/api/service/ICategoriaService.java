package alphagames.senac.com.api.service;

import java.util.List;

import alphagames.senac.com.model.Categoria;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ICategoriaService {
    @GET("categorias")
    Call<List<Categoria>> getCategorias();
}
