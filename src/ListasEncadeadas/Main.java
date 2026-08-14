package ListasEncadeadas;

public class Main {

        public static void main(String[] args) {
    
            ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
    
            System.out.println("Inserindo elementos no final da lista:");
    
            lista.adicionarFim(10);
            lista.adicionarFim(20);
            lista.adicionarFim(30);
            lista.adicionarFim(40);
            lista.adicionarFim(50);
    
            lista.mostrarLista();
    
            System.out.println("\nInserindo o valor 5 no início:");
            lista.adicionarInicio(5);
            lista.mostrarLista();
    
            System.out.println("\nInserindo o valor 25 na posição 3:");
            lista.adicionarNaPosicao(25, 3);
            lista.mostrarLista();
    
            System.out.println("\nExcluindo o primeiro elemento:");
            lista.excluirInicio();
            lista.mostrarLista();
    
            System.out.println("\nExcluindo o último elemento:");
            lista.excluirFim();
            lista.mostrarLista();
    
            System.out.println("\nExcluindo o elemento da posição 2:");
            lista.excluirPosicao(2);
            lista.mostrarLista();
    
            System.out.println("\nQuantidade de elementos: "
                    + lista.getTamanho());
        }
    }
    

