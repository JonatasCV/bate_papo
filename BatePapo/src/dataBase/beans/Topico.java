package dataBase.beans;

public class Topico {
    
    private Integer id;
    private String nome;

    public Topico() {
    }

    public Topico(Integer id, String nome) {
        this.id   = id;
        this.nome = nome;
    }

    // GETTERS
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    // SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
