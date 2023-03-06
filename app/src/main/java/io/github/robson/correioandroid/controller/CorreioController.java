package io.github.robson.correioandroid.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import io.github.robson.correioandroid.model.Correio;
import io.github.robson.correioandroid.service.CorreioService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CorreioController {

    private static final String URL = "https://viacep.com.br";
    private Correio correio;

    public CorreioController() {
    }

    public Correio getCorreioCep(String cep){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CorreioService service = retrofit.create(CorreioService.class);

        Call<Correio> call = service.getCep(cep);

        if (call != null) {
            call.enqueue(new Callback<Correio>() {
                @Override
                public void onResponse(@NonNull Call<Correio> call, @NonNull Response<Correio> response) {
                    if (response.isSuccessful()) {
                        correio = response.body();
                    } else {
                        correio = null;
                        Log.d("Error", "retorno vazio!");
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Correio> call, @NonNull Throwable t) {
                    correio = null;
                    Log.d("Error", "Erro na chamada da API!");
                }
            });
        }else{
            correio = null;
            Log.d("Error", "Retorno da chamada nulo!");
        }
        return correio;
    }
}
