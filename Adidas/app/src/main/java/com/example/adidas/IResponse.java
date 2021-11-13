package com.example.adidas;

import java.util.List;

public interface IResponse {
    void onSucces(List<Model> workouts);

    void onError(String mesaj);
}
