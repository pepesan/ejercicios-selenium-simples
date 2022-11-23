package com.cursosdedesarrollo.app.integracion;

public class Caja {
    private Objeto objeto;

    private String datosProcesados;

    public Caja() {
        this.objeto = null;
        this.datosProcesados = null;
    }

    public Caja(Objeto objeto) {
        this.objeto = objeto;
        this.datosProcesados = null;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }
    
    public void procesaDatos(){
        this.datosProcesados = objeto.getCadena()+"1";
    }

    public String getDatosProcesados() {
        return datosProcesados;
    }

    public void setDatosProcesados(String datosProcesados) {
        this.datosProcesados = datosProcesados;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "objeto=" + objeto +
                ", datosProcesados='" + datosProcesados + '\'' +
                '}';
    }
}
