
public class ListaEstatica {

    int tamanho;
    int[] info;

    public ListaEstatica() {

        info = new int[10];
        tamanho = 0;

    }

    private void redimensionar() {
        int[] novo;
        int novoTamanho = info.length+10;

        novo = new int[novoTamanho];

        for (int i = 0; i < tamanho; i++) {

            novo[i] = info[i];
           
        }
        info = novo;
    }

    public void inserir (int numero){
        if(tamanho == info.length){
            redimensionar();
        }
        info[tamanho] = numero;
        tamanho++;
    }

    public void exibir(){

        for(int i =0; i<tamanho; i++){
            System.out.println(info[i]);
        }
    }

    public int buscar (int nuemro){
        for (int i = 0; i<tamanho-1; i++){
            if (info[i] == nuemro){
                return i;
            }
        }
        return -1;
    }

       public void retirar(int numero) {
        int posicao = buscar(numero);

        if (posicao != -1) {
            for (int i = posicao; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    public void liberar(){
    	info = new int [10];
    	tamanho = 0;
    	/*
        int[] novo;
        int novoTamanho = 0;

        novo = new int[novoTamanho];

        info = novo;
        */

    }

    public int obterElemento(int posicao){
        if (posicao >=0 && posicao < tamanho ){
            return info[posicao];
            
        } else {
            throw new  IndexOutOfBoundsException("posição invalida");
        }
    }

    public boolean estaVazia(){
    	return tamanho ==0;
    	/*
        if(info.length == 0){
            return true;
        }
        else{
            return false;
        }
        */
    }

    public int getTamanho(){
        return tamanho;
    }

    public String toSTring(){

        String infoString = info[0] + "";

        for (int i = 1; i< tamanho; i++){
            infoString = infoString + "," + info[i];
        }
        return infoString;
    }


    public static void main(String[] args) {
    ListaEstatica lista = new ListaEstatica();
     
    lista.inserir(5);
    lista.inserir(10);
    lista.inserir(15);
    lista.inserir(20);
    //lista.liberar();
    /*
   // System.out.println(lista.getTamanho());
    System.out.println(lista.getTamanho());
    System.out.println(lista.toSTring());
    System.out.println(lista.buscar(15));
    System.out.println(lista.buscar(13));
    lista.retirar(10);
    System.out.println(lista.getTamanho());
    System.out.println(lista.toSTring());
    */
    /* 
        lista.inserir(15);lista.inserir(14);lista.inserir(13);lista.inserir(12);lista.inserir(11);lista.inserir(10);
        lista.inserir(9);lista.inserir(8);lista.inserir(7);lista.inserir(6);lista.inserir(5); lista.inserir(4);
        lista.inserir(3); lista.inserir(2); lista.inserir(1);

        System.out.println(lista.toSTring());
        System.out.println(lista.getTamanho());
        */

        System.out.println(lista.obterElemento(3));
        lista.liberar();
        System.out.println(lista.estaVazia());

}


}
