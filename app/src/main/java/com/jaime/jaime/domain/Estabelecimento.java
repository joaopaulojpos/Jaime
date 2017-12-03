package com.jaime.jaime.domain;

import java.io.Serializable;

public class Estabelecimento implements Serializable{

    private int id;
    private String nome;
    private String telefone;
    private String site;
    private String descricao;
    private String endereco;
    private String categoria;
    private String horarioAbre;
    private String horarioFecha;
    private Float nota;
    private Float notaMedia;
    private Integer totalVotos;
    private Long latitude;
    private Long longitude;
    private Integer imagem;
    private Integer localPublico;
    private Integer isFavorito;

    public Estabelecimento() {
    }

    public Estabelecimento(int id, String nome, String telefone, String site, String descricao, String endereco, String categoria, String horarioAbre, String horarioFecha, Float nota, Float notaMedia, Integer totalVotos, Long latitude, Long longitude, Integer imagem, Integer localPublico, Integer isFavorito) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.site = site;
        this.descricao = descricao;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horarioAbre = horarioAbre;
        this.horarioFecha = horarioFecha;
        this.nota = nota;
        this.notaMedia = notaMedia;
        this.totalVotos = totalVotos;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imagem = imagem;
        this.localPublico = localPublico;
        this.isFavorito = isFavorito;
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
                ", notaMedia=" + notaMedia +
                ", totalVotos=" + totalVotos +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", imagem=" + imagem +
                ", localPublico=" + localPublico +
                ", isFavorito=" + isFavorito +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estabelecimento that = (Estabelecimento) o;

        if (id != that.id) return false;
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
        if (nota != null ? !nota.equals(that.nota) : that.nota != null) return false;
        if (notaMedia != null ? !notaMedia.equals(that.notaMedia) : that.notaMedia != null)
            return false;
        if (totalVotos != null ? !totalVotos.equals(that.totalVotos) : that.totalVotos != null)
            return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null)
            return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null)
            return false;
        if (imagem != null ? !imagem.equals(that.imagem) : that.imagem != null) return false;
        if (localPublico != null ? !localPublico.equals(that.localPublico) : that.localPublico != null)
            return false;
        return isFavorito != null ? isFavorito.equals(that.isFavorito) : that.isFavorito == null;
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
        result = 31 * result + (nota != null ? nota.hashCode() : 0);
        result = 31 * result + (notaMedia != null ? notaMedia.hashCode() : 0);
        result = 31 * result + (totalVotos != null ? totalVotos.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (imagem != null ? imagem.hashCode() : 0);
        result = 31 * result + (localPublico != null ? localPublico.hashCode() : 0);
        result = 31 * result + (isFavorito != null ? isFavorito.hashCode() : 0);
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

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Float getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(Float notaMedia) {
        this.notaMedia = notaMedia;
    }

    public Integer getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(Integer totalVotos) {
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

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }

    public Integer getLocalPublico() {
        return localPublico;
    }

    public void setLocalPublico(Integer localPublico) {
        this.localPublico = localPublico;
    }

    public Integer getIsFavorito() {
        return isFavorito;
    }

    public void setIsFavorito(Integer isFavorito) {
        this.isFavorito = isFavorito;
    }
}
