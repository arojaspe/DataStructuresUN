class arbolBST { 

    class Node { 
        int key; 
        Node left;
        Node right; 
   
        public Node(int data){ 
            key = data; 
            left = right = null; 
        } 
    } 
    Node root; 
    
    arbolBST(){ //Constructor
        root = null; 
    } 
    //Métodos BST   
    //Inserción
    void insert(int key)  { 
        root = insertRecursive(root, key); 
    } 
    Node insertRecursive(Node root, int key) { 
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        if (key < root.key)   
            root.left = insertRecursive(root.left, key); 
        else if (key > root.key)    
            root.right = insertRecursive(root.right, key); 
        return root; 
    } 
    /*****************************************/
    //Eliminación ****************************/
    void deleteNode(int key) { 
        root = deleteRecursive(root, key); 
    } 
    Node deleteRecursive(Node root, int key)  { 
        if (root == null){
            return root; 
            }
        if (key < root.key)
            root.left = deleteRecursive(root.left, key); 
        else if (key > root.key) 
            root.right = deleteRecursive(root.right, key);
            
        else  { 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
   
            root.key = minimum(root.right); 
            root.right = deleteRecursive(root.right, root.key); 
        } 
        return root;         
    }
    /**************************************/
    
    //Mínimo valor ***********************/
     int minimum(Node root)  { 
        //initially minval = root
        int valorMinimo = root.key; 
        //find minval
        while (root.left != null)  { 
            valorMinimo = root.left.key; 
            root = root.left; 
        } 
        return valorMinimo; 
    }  
    /*************************************/
    
    //Impresión**************************/    
    void printInorder() { 
        inorderRecursive(root); 
    } 
    void inorderRecursive(Node root) { 
        if (root != null) { 
            inorderRecursive(root.left); 
            System.out.print(root.key + " "); 
            inorderRecursive(root.right); 
        } 
    } 
    /*****************************/
    
    //Búsqueda***************************/
    boolean search(int key)  { 
        root = searchRecursive(root, key); 
        if (root!= null)
            return true;
        else
            return false;
    }
    Node searchRecursive(Node root, int key)  { 
        if (root==null || root.key==key) 
            return root; 
        if (root.key > key) 
            return searchRecursive(root.left, key); 
        return searchRecursive(root.right, key); 
    } 
    /************************************/
}
class Main{
    public static void main(String[] args)  { 
        /*
              45 
           /     \ 
          10      90 
         /  \    /   \
        7   12  50   
        */
        arbolBST bst = new arbolBST(); 
        
        bst.insert(45); 
        bst.insert(10); 
        bst.insert(7); 
        bst.insert(12); 
        bst.insert(90); 
        bst.insert(50); 
        bst.printInorder(); 
        System.out.println();
        
        bst.deleteNode(12); 
        bst.printInorder(); 
        System.out.println();
        
        bst.deleteNode(90); 
        bst.printInorder(); 
        System.out.println();
                 
        bst.deleteNode(45); 
        bst.printInorder(); 
        System.out.println();
        
        boolean existencia = bst.search (50);
        System.out.println(existencia);
        existencia = bst.search (12);
        System.out.println(existencia);
     } 
}
 
