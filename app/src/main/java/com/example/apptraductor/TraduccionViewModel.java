package com.example.apptraductor;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TraduccionViewModel extends ViewModel {
/*manejar la lógica de traducción y exponer los datos observables
 (palabra traducida e imagen asociada) a la vista .*/

    private List<Palabra> palabras;
    /* LiveData permite que otros componentes, como actividades o fragmentos,
     puedan observar sus cambios y actualizar la UI automáticamente cuando cambian los datos.*/

        /*MutableLiveData es una subclase de LiveData que permite modificar su valor.
         Esto se hace a través de los métodos setValue() y postValue(),
         que permiten actualizar el dato almacenado*/

    private MutableLiveData<String> palabraTraducida = new MutableLiveData<>();
    private MutableLiveData<Integer> imagen = new MutableLiveData<>();

    public TraduccionViewModel() {

        palabras = new ArrayList<>(); // Inicializamos el array de objetos Palabra
        palabras.add(new Palabra("casa", "house", R.drawable.casa));
        palabras.add(new Palabra("conejo", "rabbit", R.drawable.conejito));
        palabras.add(new Palabra("perro", "dog", R.drawable.perrito));
        palabras.add(new Palabra("gato", "cat", R.drawable.gatito));
        palabras.add(new Palabra("manzana", "apple", R.drawable.manzana));

    }

    public void traducir(String palabraEspanol) {
        boolean encontrada = false;

            palabraEspanol = palabraEspanol.trim(); // Eliminar espacios en blanco antes y después
            for (Palabra palabra : palabras) {
                if (palabra.getPalabraEspanol() != null && palabra.getPalabraEspanol().trim().equalsIgnoreCase(palabraEspanol)) {

                    palabraTraducida.setValue(palabra.getPalabraIngles());
                    imagen.setValue(palabra.getImagen());
                    encontrada = true;
                    break;
                }
            }

        if (!encontrada) {
            palabraTraducida.setValue("No se ha encontrado traducción");
            imagen.setValue(R.drawable.nada1);
        }
    }

/*Estos métodos exponen los LiveData (palabraTraducida e imagen) alas activity
. Los componentes que deseen observar cambios en
  estos datos pueden hacerlo a través de estos métodos.
 */

    public LiveData<String> getPalabraTraducida(){
        return palabraTraducida;

    }
    public LiveData<Integer>getImagen(){
        return imagen;

    }



}

