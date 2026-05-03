import java.util.Random;

public class Main {
    public static void main(String[] args) {

        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(11);

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int randomId = random.nextInt(1000000);

            MyTestingClass key = new MyTestingClass(randomId);
            Student value = new Student("Student" + i);

            table.put(key, value);
        }

        System.out.println("\nHASH TABLE BUCKETS:");
        table.printBucketSizes();


        
        System.out.println("\nBST TEST:");

        BST<Integer, String> tree = new BST<>();

        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(7, "Seven");
        tree.put(1, "One");
        tree.put(4, "Four");

        System.out.println("Size: " + tree.size());
        System.out.println("Get 3: " + tree.get(3));

        System.out.println("In-order traversal:");
        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}