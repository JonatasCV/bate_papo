package dataBase.beans;

import java.util.Calendar;

public class Acesso {
    
    private Usuario usuario;
    private Calendar dataHora;

    public Acesso() {
    }

    public Acesso(Usuario usuario, Calendar dataHora) {
        this.usuario  = usuario;
        this.dataHora = dataHora;
    }

    // GETTERS
    public Usuario getUsuario() {
        return usuario;
    }

    public Calendar getDataHora() {
        return dataHora;
    }
    
    // SETTERS
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }
    
}
