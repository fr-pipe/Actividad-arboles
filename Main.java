import java.util.Scanner;

class Nodo {
    int valor;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(int valor) {
        this.valor = valor;
        izquierda = null;
        derecha = null;
    }
}

class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(int valor) {

        Nodo nuevo = new Nodo(valor);
        Nodo actual = raiz;

        while (true) {

            if (valor < actual.valor) {

                if (actual.izquierda == null) {
                    actual.izquierda = nuevo;
                    return;
                }

                actual = actual.izquierda;

            } else {

                if (actual.derecha == null) {
                    actual.derecha = nuevo;
                    return;
                }

                actual = actual.derecha;

            }

        }

    }

    public void inorden(Nodo nodo) {

        if (nodo != null) {

            inorden(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecha);

        }

    }

    public boolean buscar(Nodo nodo, int valor){

        if (nodo == null) {
            return false;
        }

        if (nodo.valor == valor) {
            return true;
        }

        if (valor < nodo.valor) {
            return buscar(nodo.izquierda, valor);
        } else {
            return buscar(nodo.derecha, valor);
        }

    }

}

public class Main {

    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el valor del nodo raiz:");
        int valor = scanner.nextInt();

        arbol.raiz = new Nodo(valor);

        arbol.insertar(3);
        arbol.insertar(10);
        arbol.insertar(1);
        arbol.insertar(6);

        System.out.println("Recorrido inorden del arbol:");
        arbol.inorden(arbol.raiz);

        System.out.println("Ingrese el numero a buscar:");
        int buscar = scanner.nextInt();

        if (arbol.buscar(arbol.raiz, buscar)) {
            System.out.println("El numero existe en el arbol");
        } else {
            System.out.println("El numero no existe en el arbol");
        }

    }

}