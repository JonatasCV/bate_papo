package dataBase.beans;

import java.util.Calendar;

public class Chat {
    
    private Usuario  usuario1;
    private Usuario  usuario2;
    private Calendar dataHora;
    private Topico   topico;

    public Chat() {
    }

    public Chat(Usuario usuario1, Usuario usuario2, Calendar dataHora, Topico topico) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.dataHora = dataHora;
        this.topico   = topico;
    }

    // GETTERS
    public Usuario getUsuario1() {
        return usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public Topico getTopico() {
        return topico;
    }
    
    // SETTERS
    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }
}
