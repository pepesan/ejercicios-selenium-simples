package com.cursosdedesarrollo.app.integracion;

public class Objeto {
    private String cadena;
    public Objeto() {
        this.cadena = "";
    }

    public Objeto(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "cadena='" + cadena + '\'' +
                '}';
    }
}
