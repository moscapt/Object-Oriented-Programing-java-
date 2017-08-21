/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class Cancao {
    
    //Váriaveis de instancia
    private String nome, idioma, estilo;
    private double notacancao;
    
    //Construtor
    public Cancao(String nome, String idioma, String estilo){
        this.nome = nome;
        this.idioma = idioma;
        this.estilo = estilo;
        notacancao = 0;
    }
    
    //Método seletor
    public String getNomeCancao()
    {
        return nome;
    }
    
    public String getIdioma()
    {
        return idioma;
    }
    
    public String getEstilo()
    {
        return estilo;
    }
    
    public double getNota()
    {
        return notacancao;
    }
    
    //metodo modificador
    
    public void setNomeCancao(String nome)
    {
        this.nome = nome;
    }
    
    public void setIdioma(String idioma)
    {
        this.idioma = idioma;
    }
    
    public void setEstilo(String estilo)
    {
        this.estilo = estilo;
    }
    //metodo que calcula a noda da cançao
    public void calculaNota(int notaj1, int notaj2, int notaj3, double pesopublico, int notapublico)
    {            
        notacancao = ((((notaj1 + notaj2 + notaj3)/3)*(1-pesopublico))+(notapublico*pesopublico));        
    }
    
    
    //método toString
    public String toString(){
        String texto;
        //texto = Concorrente.toString();
        texto = "Musica: " + nome + "\nIdioma: " + idioma + "\nEstilo: " + estilo;
        return texto;
    }
    
    
}
