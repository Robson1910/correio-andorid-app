package io.github.robson.correioandroid.service;


import io.github.robson.correioandroid.model.Correio;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CorreioService {

    @GET("/ws/{cep}/json/")
    Call<Correio> getCep(@Path("cep") String cep);
}
