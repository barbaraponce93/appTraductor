package com.example.apptraductor;

public class Palabra {
    private String palabraEspanol;
    private String palabraIngles;
    private int imagen;

    public Palabra(String palabraEspanol, String palabraIngles, int imagen) {
        this.palabraEspanol = palabraEspanol;
        this.palabraIngles = palabraIngles;
        this.imagen = imagen;
    }

    public String getPalabraEspanol() {
        return palabraEspanol;
    }

    public String getPalabraIngles() {
        return palabraIngles;
    }


    public int getImagen() {
        return imagen;
    }


}
