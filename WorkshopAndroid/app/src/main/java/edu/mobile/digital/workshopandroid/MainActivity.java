package edu.mobile.digital.workshopandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imagem;
    OuvinteEventos ouvinteEventos = new OuvinteEventos(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String event = getIntent().getStringExtra("event");
        imagem = findViewById(R.id.imagem);
        switch (event){
            case "Click Event":
                imagem.setOnClickListener(ouvinteEventos);
                break;
            case "Long Click Event":
                imagem.setOnLongClickListener(ouvinteEventos);
                break;
            case "Move Event":
                imagem.setOnTouchListener(ouvinteEventos);
                break;
        }
    }
}
