

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class Concorrente {
    
    //Variaveis de instancia
    private String nome, profissao;
    private int idade;
    private final int numero;
    private double notafinal;
    //private Concurso seuConcurso;
    private ArrayList<Cancao> cancoes;
    
    private static int contador = 1;   
    
    //Construtores
    
    public Concorrente(String nome, int idade, String profissao){
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
        notafinal = 0;
        cancoes = new ArrayList<Cancao>();
        numero = contador;
        contador++;
    }
    
    //Métodos seletores
    public String getNome()
    {
        return nome;
    }
    
    public int getIdade()
    {
        return idade;
    }
    
    public String getProfissao()
    {
        return profissao;
    }
    
    public int getNumero()
    {
        return numero;
    }
    
    public double getNotaFinal()
    {
        return notafinal;
    }
    
    
        
    //Métodos modificadores

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setIdade(int idade)
    {
        this.idade = idade;
    }    
    
    public void setProfissao(String profissao)
    {
        this.profissao = profissao;
    }
    
    //Método que devolve a lista de canções
    
    public ArrayList<Cancao> getCancoes()
    {
        return cancoes;
    }
    
    // metodo que adiciona um objecto da classe canção à lista
    
    public void addCancao(Cancao cancao)
    {
        cancoes.add(cancao);
    }
    //método que calcula nota final do concorrente, dependendo das notas em cada cançao
    public void calculaNotaFinal(ArrayList<Cancao> lista)
    {            
        double resultado = 0;
           
        if (lista.size()>0){
            for (Cancao c : lista)
            { 
                resultado += c.getNota();
            }
        }
        
        notafinal = resultado;          
    }
    //método que devolve a lista de canções e respectiva nota, desde que a lista em questão não esteja vazia
    public String getCancaoAndNotas(ArrayList<Cancao> lista)
    {       
        String text = "";
        if (lista.size()>0){
            for (Cancao c : lista)
            { 
                text += "Nome da Canção: " + c.getNomeCancao() + "\n"; 
                text += "Idioma: " + c.getIdioma() + "\n"; 
                text += "Estilo " + c.getEstilo() + "\n"; 
                text += "Nota: " + c.getNota() + "\n\n";
            }
        }
        
        return text;
    }
     
    
    //metodo toString
    
    public String toString()
    {
        String texto;
        texto = "Nome: " + nome + "\n" + "Profissão: " + profissao + "\n" + "Idade: " + idade +"\n";
        texto += "Número de concorrente: " + numero + "\n" + "Lista de canções :" + cancoes + "\n";
        return texto;
        
    }
}
