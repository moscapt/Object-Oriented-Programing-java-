/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class Test2 {
    
    private static ArrayList<Concorrente> concorrentes;
    private static ArrayList<Cancao> cancoes;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               
        concorrentes = new ArrayList<Concorrente>();
        cancoes = new ArrayList<Cancao>();

        concorrentes.add(new Concorrente("eu", 99, "a"));
        
        concorrentes.add(new Concorrente("tu", 99, "b"));
        
        cancoes.add(new Cancao("morte","tuga","metal morte"));
        
        cancoes.add(new Cancao("death","eng","death metal"));
        
        System.out.println(selectConcorrente("eu"));
        System.out.println(selectCancao("morte"));
        //selectConcorrente("eu").addCancao(selectCancao("morte"));
        
        System.out.print(selectConcorrente("eu"));
        associaCancao();
    }
    
    public static void associaCancao()
    {
        Scanner scan6 = new Scanner(System.in); 
        String nome, cancao;
        System.out.println("Qual o nome do concorrente?");
        nome = scan6.nextLine();
        System.out.println("Qual o nome da cançao?");
        cancao = scan6.nextLine();
        
       selectConcorrente(nome).addCancao(selectCancao(cancao)); 
    }   

    
    public static Concorrente selectConcorrente(String nome)
    {
        
        Concorrente c = null;

        if(concorrentes.size()>0)
        {
            for (Concorrente x : concorrentes)
            {
                if(x.getNome() == nome)
                    
                    c = x;
            }
        }
        return c;
    }
    
    public static Cancao selectCancao(String nome)
    {
        Cancao c = null;

        if(cancoes.size()>0)
        {
            for (Cancao x : cancoes)
            {
                if(x.getNomeCancao() == nome)
                    
                    c = x;
            }
        }
        return c;
    }
}
