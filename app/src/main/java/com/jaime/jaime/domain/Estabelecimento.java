package com.jaime.jaime.domain;

import java.io.Serializable;

public class Estabelecimento implements Serializable{

    private int id;//
    private String nome;//
    private String telefone;//
    private String site;//
    private String descricao;//
    private String endereco;//
    private String categoria;
    private String horarioAbre;//
    private String horarioFecha;//
    private int nota;//
    private int totalVotos;//
    private Long latitude;
    private Long longitude;
    private int imagem;//
    private boolean isLocalPublico;//

    public Estabelecimento() {
    }

    public Estabelecimento(int id, String nome, String telefone, String site, String descricao, String endereco, String categoria, String horarioAbre, String horarioFecha, int nota, int totalVotos, Long latitude, Long longitude, int imagem, boolean isLocalPublico) {
        this.setId(id);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setSite(site);
        this.setDescricao(descricao);
        this.setEndereco(endereco);
        this.setCategoria(categoria);
        this.setHorarioAbre(horarioAbre);
        this.setHorarioFecha(horarioFecha);
        this.setNota(nota);
        this.setTotalVotos(totalVotos);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setImagem(imagem);
        this.setLocalPublico(isLocalPublico);
    }

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", site='" + site + '\'' +
                ", descricao='" + descricao + '\'' +
                ", endereco='" + endereco + '\'' +
                ", categoria='" + categoria + '\'' +
                ", horarioAbre='" + horarioAbre + '\'' +
                ", horarioFecha='" + horarioFecha + '\'' +
                ", nota=" + nota +
                ", totalVotos=" + totalVotos +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", imagem=" + imagem +
                ", isLocalPublico=" + isLocalPublico +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estabelecimento that = (Estabelecimento) o;

        if (id != that.id) return false;
        if (nota != that.nota) return false;
        if (totalVotos != that.totalVotos) return false;
        if (imagem != that.imagem) return false;
        if (isLocalPublico != that.isLocalPublico) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (telefone != null ? !telefone.equals(that.telefone) : that.telefone != null)
            return false;
        if (site != null ? !site.equals(that.site) : that.site != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null)
            return false;
        if (endereco != null ? !endereco.equals(that.endereco) : that.endereco != null)
            return false;
        if (categoria != null ? !categoria.equals(that.categoria) : that.categoria != null)
            return false;
        if (horarioAbre != null ? !horarioAbre.equals(that.horarioAbre) : that.horarioAbre != null)
            return false;
        if (horarioFecha != null ? !horarioFecha.equals(that.horarioFecha) : that.horarioFecha != null)
            return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null)
            return false;
        return longitude != null ? longitude.equals(that.longitude) : that.longitude == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (site != null ? site.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        result = 31 * result + (horarioAbre != null ? horarioAbre.hashCode() : 0);
        result = 31 * result + (horarioFecha != null ? horarioFecha.hashCode() : 0);
        result = 31 * result + nota;
        result = 31 * result + totalVotos;
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + imagem;
        result = 31 * result + (isLocalPublico ? 1 : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHorarioAbre() {
        return horarioAbre;
    }

    public void setHorarioAbre(String horarioAbre) {
        this.horarioAbre = horarioAbre;
    }

    public String getHorarioFecha() {
        return horarioFecha;
    }

    public void setHorarioFecha(String horarioFecha) {
        this.horarioFecha = horarioFecha;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public boolean isLocalPublico() {
        return isLocalPublico;
    }

    public void setLocalPublico(boolean localPublico) {
        isLocalPublico = localPublico;
    }
}
