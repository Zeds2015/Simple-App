package zed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App00{
    //<editor-fold defaultstate="collapsed" desc="Descrição do App00">
    /*
     * Pequeno aplicativo que dada uma lista. Cria duas variaveis n e m.
     * Tal que n seja o primeiro elemento na posição par desta lista e m seja o primeiro elemento na posição impar desta lista,
     * ele separa a lista em duas uma com elementos na posição par e outra com elementos na posição impar,
     * para assim poder comparar os elementos que estão na posição par com n, e os que estão na posição impar com m.
     */
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Detalhes Técnicos">
    /**
     * l = #lista original
     * n = #primeiro elemento em posição par de l
     * m = #primeiro elemento em posicao ímpar de l
     * e = #elementos de lista e:p -> elementos da lista par. e:i -> elementos da lista impar.
     * p = #lista com elementos em posição par de l
     * i = #lista com elementos em posição ímpar de l
     * 
     * l -> separe(p,i)
     * compare(e:p,n)
     * compare(e:i,m)
     */
     //</editor-fold>
     
    /**
     * Tem uma função aqui, o que será que ela faz?
     * função principal, onde crio a lista preenchida com a entrada do usuário e verifico se a condição principal foi ou não correspondida.
     * @param args 
     */
    public static void main(String[] args) {
        int numero;
        List<Integer> numeros = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        final int MAX = 6;
        for (int i = 0; i < MAX; i++) {
            System.out.println("Digite um número: ");
            numero = teclado.nextInt();
            while(numero > 1000 && numero < 0){
                System.out.println("Número Inválido");
                break;
            }
            numeros.add(numero);
        }
        observarEmFormaDeTabela(numeros);
        if(verificarCondicaoPrincipal(filtrarNumeros(numeros,true),filtrarNumeros(numeros,false)))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    
    /**
     * Tem uma função aqui, o que será que ela faz?
     * @param l -> lista original.
     * @param paridade -> variavel de controle usada para separar o joio do trigo (as listas).kkkkkkkkkk.
     * @return -> retorna as listas criadas com elementos em POSIÇÕES pares e ímpares de l, são duas listas diferentes. 
     */
    private static List<Integer> filtrarNumeros(List<Integer> l, boolean paridade){
        if(paridade)
            return l.stream().filter(e -> ehPar(l.indexOf(e))).collect(Collectors.toList());
        return l.stream().filter(e -> !ehPar(l.indexOf(e))).collect(Collectors.toList());
    }
    
    /**
     * Tem uma função aqui, o que será que ela faz?
     * @param pares -> lista com elementos nas POSIÇÕES pares de l
     * @param impares -> lista com elementos nas POSIÇÕES ímpares de l
     * @return -> verifica se todos os elementos são menores do que o primeiro elemento em cada uma destas duas listas.  
     */
    private static boolean verificarCondicaoPrincipal(List<Integer> pares, List<Integer> impares){
        return pares.stream().allMatch(e -> e < pares.get(0)) && impares.stream().allMatch(e -> e < impares.get(0));
    }
    
    /**
     * Tem uma função aqui, o que será que ela faz?
     * @param e -> POSIÇÃO do elemento da lista l
     * @return  -> verifica se o elemento está em uma posição par ou ímpar.
     */
    private static boolean ehPar(Integer e) {
        return e % 2 == 0;
    }
    
    /**
     * Tem uma função aqui, o que será que ela faz?
     * @param numeros -> lista original a tal da l
     * Apenas cuida da parte estética da parada, faz aquelas tuplas da saída. (pos. par, pos. impar)
     */
    private static void observarEmFormaDeTabela(List<Integer> numeros) {
        StringBuilder sb = new StringBuilder();
        sb.append("(posições pares, posições impares)");
        sb.append("\n(n = ").append(numeros.get(0)).append(", m = ").append(numeros.get(1)).append(")");
        for (int i = 0; i < numeros.size(); i++) {
            if(i % 2 == 0 && i > 0){
                sb.append("\n(").append(numeros.get(i-1)).append(",").append(numeros.get(i)).append(")");
            }
        }
       System.out.println(sb);
    }
}