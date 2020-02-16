/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa;

public class Bind {

    private String tecla = null;
    private String programa = null;
    private String dir = null;
            
    public Bind(String t,String p, String d) {
        tecla = t;
        programa = p; 
        dir = d;
    }

    public String getTecla() {
        return tecla;
    }

    public String getPrograma() {
        return programa;
    }

    public String getDir() {
        return dir;
    }

    public void setTecla(String tecla) {
        this.tecla = tecla;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    
}
