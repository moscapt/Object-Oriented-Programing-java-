
import java.util.ArrayList;
import java.math.*;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class Concurso {
    
    //Váriaveis de instancia
    private String cidade;
    private int ano;
    private boolean avPublico;
    private ArrayList<Concorrente> concorrentes;
 
    //Construtor
    public Concurso(String cidade, int ano, boolean avPublico){
        this.cidade = cidade;
        this.ano = ano;
        this.avPublico = avPublico;
        concorrentes = new ArrayList<Concorrente>();
    }
    
    //metodos selectores
    
    public String getCidade()
    {
        return cidade;
    }
    
    public int getAno()
    {
        return ano;
    }
    
    //metodos modificadores
    
    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }
    
    public void setAno(int ano)
    {
        this.ano = ano;
    }
    
    //Método que devolve a lista de concorrentes
    
    public ArrayList<Concorrente> getConcorrentes()
    {
        return concorrentes;
    }
        
    // metodo que adiciona um objecto da classe concorrente à lista
    
    public void addConcorrente(Concorrente concorrente)
    {   
        concorrentes.add(concorrente);
    }
    
    //metodo que verifica se o concurso tem avaliação do publico
    
    public boolean avPublicoIsOn()
    {
        return avPublico;
    }
    //método que devolve a informacão respectiva do de cada concorrente no arraylist
    public String getInfo(ArrayList<Concorrente> lista)
    {       
        String text = "";
        if (lista.size()>0){
            for (Concorrente c : lista)
            { 
                text += "Nome: " + c.getNome() + "\n"; 
                text += "Idade: " + c.getIdade() + "\n"; 
                text += "Profissao: " + c.getProfissao() + "\n"; 
                text += "Número de concorrente: " + c.getNumero() + "\n\n";
            }
        }
        
        return text;
    }
           
    //metodo toString
    
    public String toString()
    {
        String texto;
        texto = "Concurso de Música da cidade de " + cidade +", realizado no ano de " + ano + "\n";
        texto += "Com os seguintes concorrentes: " + "\n" + getInfo(concorrentes);
                
        return texto;
    }
    
}
