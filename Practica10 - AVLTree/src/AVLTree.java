public class AVLTree {

    Node root;

    // Функция для получения высоты дерева
    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // Правый поворот
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Сам поворот
        x.right = y;
        y.left = T2;

        // Обновление высоты
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Возвращение нового корня дерева
        return x;
    }

    // Левый поворот
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Сам поворот
        y.left = x;
        x.right = T2;

        // Обновление высоты
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Возвращение нового корня дерева
        return y;
    }

    // Получение баланса
    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }
    //Вставка нового узла
    Node insert(Node node, int key) {

        /* 1.Стандартная вставка для бинарного дерева поиска*/
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        /* 2.Обновление высоты узла-предка*/
        node.height = 1 + Math.max(height(node.left),
                height(node.right));
  
        /* 3.Получаем фактор баланса узла-предка, чтобы проверить, не стал ли он несбалансированным */
        int balance = getBalance(node);

        // Если узел не сбалансирован, то имеем четыре случая:
        //

        // Левый левый поворот
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Правый правый поворот
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Левый правый поворот
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Правый левый поворот
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* Если узел сбалансирован, возвращаем его (без изменений)*/
        return node;
    }
    public static void printBinaryTree(Node node, int level)
    {
        if (node!=null){
            printBinaryTree(node.left, level+1);
            for (int i=0;i<level;i++)
                System.out.print("   ");
            System.out.println(node.key);
            printBinaryTree(node.right,level+1);
        }
    }
    public static void TreeBuild(AVLTree tree, int key1, int key2, int key3, int key4, int key5, int key6, int key7, int key8)
    {
        tree.root = tree.insert(tree.root, key1);
        tree.root = tree.insert(tree.root, key2);
        tree.root = tree.insert(tree.root, key3);
        tree.root = tree.insert(tree.root, key4);
        tree.root = tree.insert(tree.root, key5);
        tree.root = tree.insert(tree.root, key6);
    }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        System.out.println("Первое дерево");
        //Строим дерево
        TreeBuild(tree, 10, 20, 30, 40, 50, 25, 0, 0);
        /* Так будет выглядеть это дерево
             30
            /  \
          20   40
         /  \     \
        10  25    50
                    */
        //Выводим дерево
        printBinaryTree(tree.root, 0);

        System.out.println("Второе дерево");
        //Строим дерево
        TreeBuild(tree, 40, 15, 5, 20, 50, 65, 70, 85);
        /* Так будет выглядеть это дерево
               30
             /    \
          50       20
         /  \     /  \
        65  40   25   10
                /       \
               15        5
                          */
        //Выводим дерево
        printBinaryTree(tree.root, 0);

    }
}