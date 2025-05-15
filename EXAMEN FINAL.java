import java.util.Scanner;
class AVLTree { 
    class Node {
        int key, height;
        Node left, right;
        Node(int d) {
            key= d;
             height = 1;
        }
    }
    private Node root;
    // Obtener el máximo entre dos enteros
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
    //Rotación derecha
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        //Rotación
        x.right = y;
        y.left = T2;

        //Actualización de alturas
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;

        }

        //Obtener el factor de balanceo de un nodo
        int getBalance(Node node, int key) {
            if (node == null)
            return (N== null) ? 0: height(N.left) - height(N.right);


        //Inserción en el árbol AVL
        Node insert (Node node, int key) {
            ig (node ==null)
            return new Node (key);
            
            if (key < node.key)
            node.left = insert(node.left,key);
            else if (key > node.key)
            node.right = insert(node.right,key);

            else
            return node; // No se permiten duplicados

            // Actualizar la altura del ancestro
            node.height = 1 + max(height(node.left), height(node.rigth));

            //Obtener el balance
            int balance = getBalance(node;
            
            //Rebalanceo según el caso
            
            //Izquierda Izquierda
            if(balance > 1 && key < node.left.key)
            return rightRotate(node);

            //Derecha Derecha
            if (balance < -1 && key > node.right.key)
            return leftRotate(node);

            //Izquierda Derecha
            if (balance > 1 && key > node.left.key) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
                }

                return node;
                
            }

            public  void insert(int key) {
                root = insert(root, key);
                }

                private void printTree(Node node, String indent, boolean last) {
                    if (node != null) {
                        System.out.print(indent);
                        System.out.print(last ? "|¬":"|¬");
                        System.out.println(node.key);

                        indent += last? " " : "| " ;

                        printTree(node.left, indent, false);
                        printTree(node.right, indent, true);
                    }
                }
            }

                        public class AVLConsoleDemo {
                            public static void main(String[] args) {
                                AVLTree tree = new AVLTree();
                                Scanner scanner = new Scanner(System.in);

                                System.out.println("=== Árbol AVL Dinámico ===");
                                System.out.println("Ingrese números para insertar (escriba "exit" para salir):");

                                While (true) {
                                    System.out.print("Número a insertar: ");
                                    String input = scanner.nextLine();
                                    if (input.equalsIgnoreCase("exit"))
                                    break;

                                    try{

                                        int number = Integer.parseInt(input);
                                        tree.insert(number);
                                        System.out.println("Árbol AVl actualizado");
                                        tree.printTree();
                                        } catch (NumberFormatException e) {
                                            System.out.println("Entrada inválida. Ingrese un número entero");
                                            }
                                        }

                                            scanner.close();
                                        }
                                    }




nod