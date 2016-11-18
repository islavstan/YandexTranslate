package com.islavdroid.yandextranslate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface YandexPoint {
  /* @GET("/translate?key=trnsl.1.1.20161118T100805Z.31fde225bb41c01e.68f76975a93052046af80392f74d89f9bb8d439c&text={translate_text}&lang=ru-en")
    Call<Text> getText(@Path("translate_text")String text);*/

    @GET("/api/v1.5/tr.json/translate")
    Call<Text> getText(@Query("key")String key,@Query("text") String text,@Query("lang") String lang);
}
