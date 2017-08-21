/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

//import java.io.*;
/**
 *
 * @author acer
 */
public class ConcursoDeMusica {
    
    private static ArrayList<Concurso> concursos;
    private static ArrayList<Concorrente> concorrentes;
    private static ArrayList<Cancao> cancoes;
    private static ArrayList<CancaoDueto> duetos;
    
    /**
     * @param args the command line arguments     
     */
    public static void main(String[] args){
        
        concursos = new ArrayList<Concurso>();
        concorrentes = new ArrayList<Concorrente>();
        cancoes = new ArrayList<Cancao>();
        duetos = new ArrayList<CancaoDueto>();
        
        int option = -1;
        
        //criaçao do concurso
        

    //criaçao de um objecto que lê o teclado
        
        Scanner scan = new Scanner(System.in);
    
    // cliclo de apresentaçao do menu
    
        while (option != 0)
        {
            apresentaMenu(); //apresentar o menu
            option = scan.nextInt(); //ler a opçao
            
            //executa a tarefa pretendida ou entao avisa
            // se a opção não é válida
            
            switch (option)
            {
                case 1:
                    criarConcurso();
                    break;
                    
                case 2:
                    criarConcorrente();
                    break;
                    
                case 3:
                    criarCancao();
                    break;
                    
                case 4:  
                    criarDueto();
                    break;
                    
                case 5:
                    associaCancao();                    
                    break;
                    
                case 6:
                    associaConcorrentes();
                    break;
                    
                case 7:
                    listarConcorrentes();
                    break;
                    
                case 8:
                    notaCancao();
                    break;
                    
                case 9:
                    listarCancoes();
                    break;
                
                case 10:
                    listarVencedores();
                    break;
                case 0:
                    System.out.println("Saindo da aplicação..");
                    break;
                
                default:
                    System.out.println("Opção não válida");
                    break;
            }
        }
    }

    private static void apresentaMenu()
    {
        //menu a apresentar
        
        System.out.println("-----------------------");
        System.out.println("O que pretende realizar ?");
        System.out.println("1 - Criar concurso");
        System.out.println("2 - Criar concorrente");
        System.out.println("3 - Criar canção");
        System.out.println("4 - Criar dueto");
        System.out.println("5 - Associar canção a um concorrente");
        System.out.println("6 - Associar concorrente a um concurso");
        System.out.println("7 - Listar os concorrentes de um concurso");
        System.out.println("8 - Atribuir nota a uma canção");
        System.out.println("9 - Listar canções de um concorrente e as notas");
        System.out.println("10 - Listar vencedores de um concurso");
        System.out.println("0 - Sair");
        System.out.println("-----------------------");
    }
    //método que cria concursos atraves do interface
    private static void criarConcurso()
    {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        int ano, optn;
        String cidade;
        System.out.println("Em que cidade será realizado o concurso?");
        cidade = scan1.nextLine();
        System.out.println("Qual o ano do concurso?");
        ano = scan2.nextInt();
        System.out.println("Com avaliação do público?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        optn = scan1.nextInt();
        boolean av;
        if(optn == 1)
            av = true;
        else
            av = false;
                    
        concursos.add(new Concurso(cidade, ano, av));
        System.out.println("Concurso criado!");
          
    }
    //metodo que cria concorrentes atraves do interface
    private static void criarConcorrente()
    {
        Scanner scan3 = new Scanner(System.in);
        Scanner scan4 = new Scanner(System.in);
        String nome, profissao;
        int idade;
        System.out.println("Qual o nome do concorrente?");
        nome = scan3.nextLine();
        System.out.println("Qual a idade do concorrente?");
        idade = scan4.nextInt();
        System.out.println("Qual a profissão do concorrente?");
        profissao = scan3.nextLine();
         
        concorrentes.add(new Concorrente(nome, idade, profissao));        
        System.out.println("Concorrente criado!"); 

    }
    //método que cria canções atraves do interface
    public static void criarCancao()
    {
        Scanner scan5 = new Scanner(System.in);                    
        String titulo, idioma, estilo;
        System.out.println("Qual o nome da canção?");
        titulo = scan5.nextLine();
        System.out.println("Qual o idioma da canção?");
        idioma = scan5.nextLine();
        System.out.println("Qual o estilo da canção?");
        estilo = scan5.nextLine();
        
        cancoes.add(new Cancao(titulo, idioma, estilo));
        System.out.println("Canção criada!");        
    }
    //método que associa cancoes
    public static void associaCancao()
    {
        Scanner scan6 = new Scanner(System.in); 
        String nome, cancao;
        System.out.println("Qual o nome do concorrente?");
        nome = scan6.nextLine();
        System.out.println("Qual o nome da cançao?");
        cancao = scan6.nextLine();
         
        if(selectCancao(cancao) == null || selectConcorrente(nome) == null)
        { 
            if(selectConcorrente(nome) == null)        
            {    
                System.out.println("O concorrente não existe!");
            }
       
            if(selectCancao(cancao) == null)
            {
                System.out.println("A canção não existe!");
            }                       
        }
        else
        {         
            selectConcorrente(nome).addCancao(selectCancao(cancao));
            System.out.println("A cancão " + cancao + " foi atribuida ao concorrente " + nome);    
        }
    }  
     //método que seleciona concorrentes atraves do nome
    public static Concorrente selectConcorrente(String nome)
    {
        Concorrente c = null;

        if(concorrentes.size()>0)
        {
            for (Concorrente x : concorrentes)
            {
                if(x.getNome().equals(nome))
                    
                    c = x;
            }
        }
        return c;
    }
    //método que seleciona cançoes atraves do nome
    public static Cancao selectCancao(String cancao)
    {
        Cancao c = null;

        if(cancoes.size()>0)
        {
            for (Cancao x : cancoes)
            {
                if(x.getNomeCancao().equals(cancao))
                    
                    c = x;
            }
        }
        return c;
    }      
    //método que lista os concorrentes pertencentes a um determinado concurso
    public static void listarConcorrentes()
    {
        Scanner scan7 = new Scanner(System.in);
        String cidade;
        System.out.println("Qual a cidade do concurso?");
        cidade = scan7.nextLine();
      
        
        if(selectConcurso(cidade) == null)
        {    
            System.out.println("O concurso não existe!"); 
        }
        
        else
        {         
            System.out.println(selectConcurso(cidade));    
        }     
    }
    //método que permite selecionar um concurso
    public static Concurso selectConcurso(String cidade)
    {
        Concurso c = null;

        if(concursos.size()>0)
        {
            for (Concurso x : concursos)
            {
                if(x.getCidade().equals(cidade))
                    
                    c = x;
            }
        }
        return c;
    }
    //metodo que associa concorrentes a um determinado concurso
    public static void associaConcorrentes()
    {
        Scanner scan8 = new Scanner(System.in); 
        String nome, cidade;
        System.out.println("Qual a cidade do concurso?");
        cidade = scan8.nextLine();
        System.out.println("Qual o nome do concorrente?");
        nome = scan8.nextLine();

        if(selectConcurso(cidade) == null || selectConcorrente(nome) == null )
        { 
            if(selectConcorrente(nome) == null)        
            {    
                System.out.println("O concorrente não existe!");
            }
       
            if(selectConcurso(cidade) == null)
            {
                System.out.println("O concurso não existe");
            }                       
        }
        else
        {         
            selectConcurso(cidade).addConcorrente(selectConcorrente(nome));
            System.out.println("O concorrente " + nome + " foi associado ao concurso da cidade de " + cidade);    
        }
    }
    //metodo que cria cançoes do tipo dueto
    public static void criarDueto()
    {
        Scanner scan9 = new Scanner(System.in);                    
        String titulo, idioma, estilo, nome1, nome2;
        System.out.println("Qual o nome da canção?");
        titulo = scan9.nextLine();
        System.out.println("Qual o idioma da canção?");
        idioma = scan9.nextLine();
        System.out.println("Qual o estilo da canção?");
        estilo = scan9.nextLine();
        System.out.println("Qual o nome do 1º concorrente?");
        nome1 = scan9.nextLine();
        System.out.println("Qual o nome do 2º concorrente?");
        nome2 = scan9.nextLine();
        
        if(selectConcorrente(nome1) == null || selectConcorrente(nome2) == null)
        { 
            if(selectConcorrente(nome1) == null)        
            {    
                System.out.println("O 1º concorrente não existe!");
            }
       
            if(selectConcorrente(nome2) == null)
            {
                System.out.println("O 2º concorrente não existe!");
            }                       
        }
        else
        {    
            duetos.add(new CancaoDueto(titulo, idioma, estilo, selectConcorrente(nome1), selectConcorrente(nome2)));
            selectConcorrente(nome1).addCancao(new CancaoDueto(titulo, idioma, estilo, selectConcorrente(nome1), selectConcorrente(nome2)));
            selectConcorrente(nome1).addCancao(new CancaoDueto(titulo, idioma, estilo, selectConcorrente(nome1), selectConcorrente(nome2)));                  
            System.out.println("A canção " + titulo + ", cantada em dueto entre os concorrentes " + nome1 + " e " + nome2 + " foi criada com sucesso!");
        }
    }
    //método que aceita a nota das canções
    public static void notaCancao()
    {
        Scanner scan10 = new Scanner(System.in);
        Scanner scan11 = new Scanner(System.in);
        Scanner scan12 = new Scanner(System.in);
        Scanner scan13 = new Scanner(System.in);
        Scanner scan14 = new Scanner(System.in);
        Scanner scan15 = new Scanner(System.in);
        
        String titulo;
        int notaj1, notaj2, notaj3, notapublico;
        double pesopublico;
        System.out.println("Qual o nome da canção?");
        titulo = scan10.nextLine();
        System.out.println("Qual a nota do 1º jurado?");
        notaj1 = scan11.nextInt();
        System.out.println("Qual a nota do 2º jurado?");
        notaj2 = scan12.nextInt();
        System.out.println("Qual a nota do 2º jurado?");
        notaj3 = scan13.nextInt();
        System.out.println("Qual o peso do público?");
        pesopublico = scan14.nextDouble();
        System.out.println("Qual a nota do público?");
        notapublico = scan15.nextInt();
     
        
        if(selectCancao(titulo) == null)
        {       
            System.out.println("A canção não existe!");                    
        }
        else
        {    
            selectCancao(titulo).calculaNota(notaj1, notaj2, notaj3, pesopublico, notapublico);                 
            System.out.println("A canção " + titulo + " obteve a nota de: " + selectCancao(titulo).getNota());
        }            
    }
    //metodo para listar as canções de um determinado concorrente
    public static void listarCancoes()
    {
        Scanner scan16 = new Scanner(System.in);
        String nome;
        System.out.println("Qual o nome do concorrente?");
        nome = scan16.nextLine();
        
        if(selectConcorrente(nome) == null)        
        {    
            System.out.println("O concorrente não existe!");
        }
        else
        {
           System.out.println(selectConcorrente(nome).getCancaoAndNotas(selectConcorrente(nome).getCancoes()));    
        }        
    }
    //método que não conseguimos por a funcionar
    public static void listarVencedores()
    {
            System.out.println("Opção não funciona correctamente");
    }
}      
        
   

