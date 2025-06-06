package Nuevo;

import java.util.Scanner;

class AVLTree {
    class Node {
        int key, height;
        Node left, right;
        
        Node(int d) {
            key = d;
            height = 1;
        }
    }
    
    private Node root;
    
    // Método para obtener altura
    int height(Node node) {
        return node == null ? 0 : node.height;
    }
    
    // Método para calcular balance
    int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }
    
    // Rotación derecha (para Left-Left case)
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        
        x.right = y;
        y.left = T2;
        
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        
        return x;
    }
    
    // Rotación izquierda (para Right-Right case)
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        
        y.left = x;
        x.right = T2;
        
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y;
    }
    
    // Inserción con balanceo AVL
    Node insert(Node node, int key) {
        // 1. Inserción normal BST
        if (node == null) return new Node(key);
        
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // No duplicados
        
        // 2. Actualizar altura
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        // 3. Obtener factor de balance
        int balance = getBalance(node);
        
        // 4. Aplicar rotaciones según el caso
        
        // Left-Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
        
        // Right-Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
        
        // Left-Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Right-Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    // Método público para insertar
    public void insert(int key) {
        root = insert(root, key);
    }
    
    // Visualización del árbol en formato ASCII
    public void printTree() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }
        
        printTree(root, "", true);
    }
    
    private void printTree(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.key + " (h:" + node.height + ")");
            printTree(node.left, prefix + (isTail ? "    " : "│   "), false);
            printTree(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }
    
    // Visualización en formato gráfico (como solicitaste)
    public void printFormattedTree() {
        if (root == null) return;
        
        System.out.println("\nEstructura del árbol:");
        System.out.println("   " + root.key);
        if (root.left != null || root.right != null) {
            System.out.println("  / \\");
            printFormattedLevel(root.left, root.right);
        }
    }
    
    private void printFormattedLevel(Node left, Node right) {
        String leftStr = left != null ? String.valueOf(left.key) : " ";
        String rightStr = right != null ? String.valueOf(right.key) : " ";
        System.out.println(leftStr + "   " + rightStr);
        
        if (hasChildren(left) || hasChildren(right)) {
            System.out.print((hasChildren(left) ? "/ \\ " : "    "));
            System.out.println(hasChildren(right) ? "/ \\" : "");
            
            printFormattedLevel(
                left != null ? left.left : null,
                left != null ? left.right : null);
            printFormattedLevel(
                right != null ? right.left : null,
                right != null ? right.right : null);
        }
    }
    
    private boolean hasChildren(Node node) {
        return node != null && (node.left != null || node.right != null);
    }
}

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Árbol AVL Balanceado ===");
        System.out.println("Ingrese números (o 'exit' para terminar):");
        
        while (true) {
            System.out.print("\nNúmero: ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) break;
            
            try {
                int number = Integer.parseInt(input);
                tree.insert(number);
                
                System.out.println("\nÁrbol AVL (con alturas):");
                tree.printTree();
                
                System.out.println("\nEstructura visual:");
                tree.printFormattedTree();
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido");
            }
        }
        
        scanner.close();15
        20
        16

    }75
    30
    50
    100

    120
      26
    24
    12
    Exit oul-1
    -1
    
    



}
