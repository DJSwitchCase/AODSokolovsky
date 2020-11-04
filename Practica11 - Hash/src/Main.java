
import java.util.ArrayList;


//Узел цепей
class HashNode<K, V>

{

    K key;

    V value;



    // "Указатель" на следующий узел

    HashNode<K, V> next;



    // Конструктор

    public HashNode(K key, V value)

    {

        this.key = key;

        this.value = value;

    }

}


// Класс для представления хеш-таблицы

class Map<K, V>

{

    //Создаём ArrayList для хранения массива цепей

    private ArrayList<HashNode<K, V>> bucketArray;



    // Текущий объём списка массивов

    private int numBuckets;



    // Текущий размер списка массивов

    private int size;



    // Конструктор (Инициализируем объём, размер и

    //создаём пустые цепи).

    public Map()

    {

        bucketArray = new ArrayList<>();

        numBuckets = 10;

        size = 0;



        //Создаём пустые цепи

        for (int i = 0; i < numBuckets; i++)

            bucketArray.add(null);

    }



    public int size() { return size; }

    public boolean isEmpty() { return size() == 0; }



    // Хеш-функция для получения индекса ключа через .hashCode() функцию Java и кол-во ячеек хеш-таблицы
    private int getBucketIndex(K key)

    {

        int hashCode = key.hashCode();

        int index = hashCode % numBuckets;

        return index;

    }



    // Метод для удаления ключа

    public V remove(K key)

    {

        // Применяем хеш-функцию для поиска индекса для данного ключа

        int bucketIndex = getBucketIndex(key);



        HashNode<K, V> head = bucketArray.get(bucketIndex);



        //Ищем элемент в цепи. Если он найден, инициализируем новым значением

        HashNode<K, V> prev = null;

        while (head != null)

        {

            if (head.key.equals(key))

                break;

            prev = head;

            head = head.next;

        }

        if (head == null)

            return null;

        size--;


        if (prev != null)

            prev.next = head.next;

        else

            bucketArray.set(bucketIndex, head.next);



        return head.value;

    }



    // Возвращаем значение ключа

    public V get(K key)

    {
        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);



        // Поиск ключа в цепочке

        while (head != null)

        {

            if (head.key.equals(key))

                return head.value;

            head = head.next;

        }



        // Если ключ не найден

        return null;

    }



    // Добавляем пару ключ-значение в хеш

    public void add(K key, V value)

    {

        // Находим начало цепочки для данного ключа

        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);



        // Проверяем, присутствует ли ключ

        while (head != null)

        {

            if (head.key.equals(key))

            {

                head.value = value;

                return;

            }

            head = head.next;

        }



        // Вставляем ключ в цепь

        size++;

        head = bucketArray.get(bucketIndex);

        HashNode<K, V> newNode = new HashNode<K, V>(key, value);

        newNode.next = head;

        bucketArray.set(bucketIndex, newNode);



        // Если коэффициент загрузки превышает пороговое значение (0.7), то

        // увеличиваем кол-во ячеек хеш-таблицы в два раза

        if ((1.0*size)/numBuckets >= 0.7)

        {

            ArrayList<HashNode<K, V>> temp = bucketArray;

            bucketArray = new ArrayList<>();

            numBuckets = 2 * numBuckets;

            size = 0;

            for (int i = 0; i < numBuckets; i++)

                bucketArray.add(null);



            for (HashNode<K, V> headNode : temp)

            {

                while (headNode != null)

                {

                    add(headNode.key, headNode.value);

                    headNode = headNode.next;

                }

            }

        }

    }

    public static void main(String[] args)

    {

        Map<String, Integer>map = new Map<>();
        //Создаём коллизию
        map.add("Apple",123456 );

        map.add("Grape",123456 );

        map.add("Banana",423412 );

        map.add("Milkr",5432123 );

        System.out.println(map.size());

        map.remove("Apple");

        map.remove("Grape");

        System.out.println(map.size()); //Проверяем размер хеш-таблицы после удаления двух элементов

    }

}