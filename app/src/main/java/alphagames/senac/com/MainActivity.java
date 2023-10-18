package alphagames.senac.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import alphagames.senac.com.api.HttpServiceGenerator;
import alphagames.senac.com.api.service.ICategoriaService;
import alphagames.senac.com.databinding.ActivityMainBinding;
import alphagames.senac.com.model.Categoria;
import alphagames.senac.com.utils.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ActivityMainBinding binding;

    Login login = new Login();

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Call<List<Categoria>> call = HttpServiceGenerator.createHttpService(this, ICategoriaService.class).getCategorias();
        List<String> listaCategoria = new ArrayList<>();
        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if (response.isSuccessful()) {
                    List<Categoria> categorias = response.body();

                    for (Categoria categoria: categorias) {
                        String nomeCategoria = categoria.getCATEGORIA_NOME();
                        if(nomeCategoria.contains("Jogos de ")){
                            nomeCategoria = nomeCategoria.replace("Jogos de ", "");
                        }
                        listaCategoria.add(nomeCategoria.toUpperCase()  );
                    }
                    configureRecyclerView(listaCategoria);
                }
                else{
                    Log.i("ERROR", "Requisação não obtida");
                }

            }
            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {

            }
        });
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.inicio){
//                replaceFragment(new HomeFragment());
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else if(item.getItemId() == R.id.profile){
                if(login.isLogged()){
                    replaceFragment(new ProfileFragment());
                }else{
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);

                }

            }
            else if(item.getItemId() == R.id.store){
                replaceFragment(new StoreFragment());
            }
            else if(item.getItemId() == R.id.cart){
                replaceFragment(new CartFragment());
            }

            return true;
        });




        setTitle("Alpha Games");
        recyclerView = findViewById(R.id.category_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);


//        recyclerView.setAdapter(new MyRvAdapter(listaCategoria));



    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


    private void configureRecyclerView(List<String> listaCategoria) {
        recyclerView.setAdapter(new MyRvAdapter(listaCategoria));
    }

}