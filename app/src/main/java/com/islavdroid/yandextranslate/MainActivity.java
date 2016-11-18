package com.islavdroid.yandextranslate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private ImageButton changeLanguageButton;

    private TextView textView,rusText,englishText;
    private final String KEY="trnsl.1.1.20161118T100805Z.31fde225bb41c01e.68f76975a93052046af80392f74d89f9bb8d439c";
    private String LANG ="en-ru";
    private boolean engLang =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rusText=(TextView)findViewById(R.id.rusText) ;
        englishText=(TextView)findViewById(R.id.englishText) ;
        changeLanguageButton=(ImageButton)findViewById(R.id.changeLanguageButton);

        changeLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(engLang){
                    rusText.setText("англ");
                    englishText.setText("рус ");
                    LANG="ru-en";
                    engLang=false;
                }else {
                    englishText.setText("англ");
                    rusText.setText("рус ");
                    LANG="en-ru";
                    engLang=true;
                }
            }
        });

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
