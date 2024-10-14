package com.example.apptraductor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apptraductor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String palabraRecibida=binding.etPalabra.getText().toString();
                Intent intent=new Intent(MainActivity.this,SegundaActivity.class);//creamos el intent para ir a la 2°activity
                intent.putExtra("palabraRecibida",binding.etPalabra.getText().toString());//paso la palabra antes de cargar la 2°act
                startActivity(intent);//inicio la 2°activity


            }
        });






    }
};