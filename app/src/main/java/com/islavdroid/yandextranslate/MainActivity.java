package com.islavdroid.yandextranslate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private TextView textView;
    private final String KEY="Key";
    private final String LANG ="en-ru";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.edit_text);
        button =(Button)findViewById(R.id.translate_button);
        textView =(TextView)findViewById(R.id.translate_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text =editText.getText().toString();
                //подключаемся по url
                final YandexPoint apiService = ApiClient.getTranslate().create(YandexPoint.class);
                Call<Text> call =apiService.getText(KEY,text,LANG);
                  call.enqueue(new Callback<Text>() {
                      @Override
                      public void onResponse(Call<Text> call, Response<Text> response) {


                        //  textView.setText(response.body().getText()+"");
                          ArrayList<String>arrayList =response.body().getText();
                          for(String a :arrayList){
                              textView.setText(a);

                          }
                      }

                      @Override
                      public void onFailure(Call<Text> call, Throwable t) {

                      }
                  });

            }
        });
    }
}
