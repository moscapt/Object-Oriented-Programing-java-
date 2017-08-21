/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class CancaoDueto extends Cancao {
    
    //Variaveis de instancia
    
    private int nota1, nota2;
    private Concorrente concorrente1, concorrente2;
    
    //construtores
    public CancaoDueto(String nome, String idioma, String estilo, Concorrente concorrente1, Concorrente concorrente2)
    {
        super(nome, idioma, estilo);
        this.concorrente1 = concorrente1;
        this.concorrente2 = concorrente2;
        nota1 = 0;
        nota2 = 0;
    }
       
    //método seletor
    
    public Concorrente getConcorrente1()
    {
        return concorrente1;
    }
    
    public Concorrente getConcorrente2()
    {
        return concorrente2;
    }  
    
    //método modificador
    
    public void setConcorrentes(Concorrente concorrente1, Concorrente concorrente2)
    {        
        this.concorrente1 = concorrente1;
        this.concorrente1 = concorrente2;
    }
    
    public void setAvaliacao(int nota1, int nota2)
    {
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
    
    //método toString
    
    public String toString(){
        String texto;
        texto = super.toString(); 
        texto += "\n cantada pelos concorrentes; " + concorrente1.getNome() + "e" + concorrente2.getNome();        
        return texto;
    }
    
}    