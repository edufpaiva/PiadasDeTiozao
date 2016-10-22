package study.android.piadasdetiozao;

import java.io.Serializable;

/**
 * Created by pc on 21/10/2016.
 */

public class Postagem implements Serializable{
    private String avatar;
    private String nome;
    private String foto;
    private int rate;

    public Postagem(String avatar, String nome, String foto, int rate) {
        this.avatar = avatar;
        this.nome = nome;
        this.foto = foto;
        this.rate = rate;
    }

    public Postagem() {
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
