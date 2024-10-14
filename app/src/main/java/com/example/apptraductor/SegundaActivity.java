package com.example.apptraductor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.apptraductor.databinding.ActivityMainBinding;
import com.example.apptraductor.databinding.ActivitySegundaBinding;

public class SegundaActivity extends AppCompatActivity {
    //En esta activity( muestra la traducción), tenemos que generar un observable y asociar el viewModel
    private ActivitySegundaBinding binding;
    private TraduccionViewModel traduccionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivitySegundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //inicializo el vM
        traduccionViewModel=new ViewModelProvider(this).get(TraduccionViewModel.class);

        String palabraRecibida=getIntent().getStringExtra("palabraRecibida");//Se recupera la palabra que fue enviada desde la MainActivity a través del Intent con la clave "palabraRecibida".

        if(palabraRecibida!=null && !palabraRecibida.isEmpty()){
            traduccionViewModel.traducir(palabraRecibida);
        }else {
            binding.etPalabraTraducida.setText("No se recibió ninguna palabra para traducir");
        }


        //OBSERVADORES
    /*    Al observar un LiveData, garantizas que la interfaz de usuario se actualice
     automáticamente cuando cambien los datos en el ViewModel. Esto significa que no
      necesitas gestionar manualmente la actualización de la UI cada vez que ocurre un cambio
       en los datos
     */

        traduccionViewModel.getPalabraTraducida().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String palabraTraducida) {// a la vista que seteamos la palabra que viene por parámetro.
                binding.etPalabraTraducida.setText(palabraTraducida);

            }
        });

        traduccionViewModel.getImagen().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer imagen) {// a la vista que seteamos a img que viene por parámetro.
                binding.ivImg.setImageResource(imagen);

            }

        });

        binding.bVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SegundaActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }

}