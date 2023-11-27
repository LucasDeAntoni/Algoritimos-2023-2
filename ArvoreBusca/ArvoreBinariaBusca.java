package ArvoreBusca;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

   

    public void inserir(T valor) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<T>(valor);
        if (getRaiz() == null) {
            setRaiz(novo);
        } else {
            NoArvoreBinaria<T> p = getRaiz();

            while (true) {
                NoArvoreBinaria<T> pai = p;
                if (valor.compareTo(p.getInfo()) < 0) {
                    p = pai.getEsq();
                    if (p == null) {
                        pai.setEsq(novo);
                        return;
                    }
                    } else {
                        p = pai.getDir();
                        if (p == null) {
                            pai.setDir(novo);
                            return;
                        }
                    }
                }
            }

        }

    

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        NoArvoreBinaria<T> p = getRaiz();

        while(p!=null && p.getInfo() != info){
            if(info.compareTo(p.getInfo())<0){
                p = p.getEsq();
            } else{
                p = p.getDir();
            }
        }
        return p;
    }

    private NoArvoreBinaria<T> extrairSucessor (NoArvoreBinaria<T> p){
        NoArvoreBinaria<T> atual = p.getDir();
        NoArvoreBinaria<T> paiSucessor = p;
        NoArvoreBinaria<T> sucessor = p;

        while(atual != null){
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }
        if ( sucessor !=p.getDir()){
            paiSucessor.setEsq(sucessor.getDir());
            sucessor.setDir(p.getDir());
        }

        return sucessor;
        
    }

    public void retirar(T info){
        NoArvoreBinaria<T> p = getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;
        //localizar o no
        while (p!= null && p.getInfo()!= info){
            pai = p;
            if (info.compareTo(p.getInfo())<0){
                filhoEsquerda = true;
                p = p.getEsq();
            } else{
                filhoEsquerda = false;
                p = p.getDir();
            }
        }
        //remove folha se for raiz
        if (p!=null){
            if(p.getEsq()==null && p.getDir() ==null){
                if(p == getRaiz()){
                    setRaiz(null);
                } else{
                    if(filhoEsquerda == true){
                            pai.setEsq(null);
                    } else{
                        pai.setDir(null);
                    }
                }
            //remove no com um filho    
            } else{
                if (p.getDir() == null){
                    if(p == getRaiz()){
                        setRaiz(p.getEsq());
                    } else{
                        if(filhoEsquerda==  true){
                            pai.setEsq(p.getEsq());
                        } else{
                            pai.setDir(p.getEsq());
                        }
                    }
                } else{
                    if (p.getEsq()==null){
                        if(p == getRaiz()){
                            setRaiz(p.getDir());
                        } else{
                            if(filhoEsquerda ==true){
                                pai.setEsq(p.getDir());
                            } else{
                                pai.setDir(p.getDir());
                            }
                        }
                    //no com dois filhos    
                    } else{
                        NoArvoreBinaria<T> sucessor = extrairSucessor(p);
                        if (p == getRaiz()){
                            setRaiz(sucessor);
                        } else{
                            if (filhoEsquerda == true){
                                pai.setEsq(sucessor);
                            } else{
                                pai.setDir(sucessor);
                            }
                        }
                        sucessor.setEsq(p.getEsq());
                    }
                    
                }
            }


        }

        
    }

    public static void main(String[] args) {
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();

       // NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria(null);

        // arvore.setRaiz(no1);
        /* 
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(40);
        arvore.inserir(25);
        arvore.inserir(75);
        arvore.inserir(65);
        arvore.inserir(35);  250,38,26,72,55,90,41,60,43,78,92,74

        arvore.inserir(60);
        *///52,90,48,71,63,67
      
         arvore.inserir(250);
        arvore.inserir(38);
        arvore.inserir(26);
        arvore.inserir(72);
        arvore.inserir(55);
        arvore.inserir(90);
        arvore.inserir(41);
        arvore.inserir(60);
        arvore.inserir(43);
        arvore.inserir(78);
        arvore.inserir(92);
        arvore.inserir(74);


        arvore.retirar(38);
        System.out.println(arvore.toString());
        
    }
 
}
