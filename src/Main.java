import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {

        int [] tablaHash = new int[8];
        int [] lista = {147,237,121,724,100};

        for(int num  : lista){
            if(!isFull(tablaHash)) {
                insertarHash(tablaHash, num, 0);
            }
        }
        for(int num : tablaHash){
            System.out.print(num+" ");
        }

        for(int count = 0; count <tablaHash.length; count++){
            if(tablaHash[count] == 724){
                tablaHash[count]=0;
            }
        }

        insertarHash(tablaHash, 10, 0);

        System.out.println();
        for(int num : tablaHash){
            System.out.print(num+" ");
        }
    }

    private static int ultimoDigito(int num){
        return num %10;
    }

    private static void insertarHash (int[] tablaHash, int num, int i){
        int aux = ultimoDigito(num);
        int cal = (aux+((int)pow(i,2)))%tablaHash.length;
        if(tablaHash[cal]==0) {
            tablaHash[cal] = num;
        }else if(i<tablaHash.length){
            i++;
            insertarHash(tablaHash, num, i);
        }else{
            System.out.println("El numero "+num+" no se puede meter");
        }
    }

    private static boolean isFull(int[] lista){
        for(int num  : lista){
            if(num==0){
                return false;
            }
        }
        return true;
    }

}