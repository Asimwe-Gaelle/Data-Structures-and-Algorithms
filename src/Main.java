public class Main {

    public static void main(String[] args) {

        // =========================================
        // PART 1: SINGLY LINKED LIST
        // =========================================

        System.out.println("========== PART 1: LINKED LIST ==========");

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(20);
        list.addFirst(10);
        list.addLast(30);
        list.addLast(40);

        System.out.print("Original list: ");
        list.display();

        System.out.println("Size: " + list.size());
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Middle element: " + list.findMiddle());

        System.out.println("Removed first: " + list.removeFirst());

        System.out.print("After removal: ");
        list.display();

        list.reverse();

        System.out.print("After reversing: ");
        list.display();

        System.out.println("Final size: " + list.size());


        // =========================================
        // PART 2A: STACK
        // =========================================

        System.out.println("\n========== PART 2A: STACK ==========");

        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Removed: " + stack.pop());
        System.out.println("New top: " + stack.peek());
        System.out.println("Is stack empty? " + stack.isEmpty());


        // =========================================
        // PART 2B: QUEUE USING TWO STACKS
        // =========================================

        System.out.println("\n========== PART 2B: QUEUE ==========");

        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Removed: " + queue.dequeue());
        System.out.println("New front: " + queue.peek());
        System.out.println("Is queue empty? " + queue.isEmpty());


        // =========================================
        // PART 2C: BALANCED BRACKETS
        // =========================================

        System.out.println("\n========== PART 2C: BALANCED BRACKETS ==========");

        System.out.println(
                "{[()]}: " + BalancedBrackets.isBalanced("{[()]}")
        );

        System.out.println(
                "([)]: " + BalancedBrackets.isBalanced("([)]")
        );

        System.out.println(
                "((())): " + BalancedBrackets.isBalanced("((()))")
        );

        System.out.println(
                "(((: " + BalancedBrackets.isBalanced("(((")
        );


        // =========================================
        // PART 3A: ROTATE ARRAY RIGHT
        // =========================================

        System.out.println("\n========== PART 3A: ROTATE RIGHT ==========");

        int[] numbers = {1, 2, 3, 4, 5};

        System.out.print("Original array: ");
        printArray(numbers);

        ArrayStringAlgorithms.rotateRight(numbers, 2);

        System.out.print("Rotated array: ");
        printArray(numbers);


        // =========================================
        // PART 3B: ANAGRAM
        // =========================================

        System.out.println("\n========== PART 3B: ANAGRAM ==========");

        System.out.println(
                "listen / silent: "
                        + ArrayStringAlgorithms.isAnagram("listen", "silent")
        );

        System.out.println(
                "hello / world: "
                        + ArrayStringAlgorithms.isAnagram("hello", "world")
        );

        System.out.println(
                "aabb / abab: "
                        + ArrayStringAlgorithms.isAnagram("aabb", "abab")
        );


        // =========================================
        // PART 3C: TWO SUM SORTED
        // =========================================

        System.out.println("\n========== PART 3C: TWO SUM SORTED ==========");

        int[] sortedArray = {1, 2, 4, 6, 8, 9};
        int target = 10;

        int[] result =
                ArrayStringAlgorithms.twoSumSorted(sortedArray, target);

        if (result[0] != -1) {
            System.out.println(
                    "Indices: [" + result[0] + ", " + result[1] + "]"
            );

            System.out.println(
                    "Values: " + sortedArray[result[0]]
                            + " + " + sortedArray[result[1]]
                            + " = " + target
            );
        } else {
            System.out.println("No pair found.");
        }
    }

    // Helper method to print an array without collections
    public static void printArray(int[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");


        // =========================================
        // PART 4: LRUCache
        // =========================================
        System.out.println("========== PART 4: LRUCache ==========");
        LRUCache cache = new LRUCache(3);

        System.out.println("Insert 1=100");
        cache.put(1, 100);
        cache.display();

        System.out.println("\nInsert 2=200");
        cache.put(2, 200);
        cache.display();

        System.out.println("\nInsert 3=300");
        cache.put(3, 300);
        cache.display();

        System.out.println("\nGet key 1: " + cache.get(1));
        cache.display();

        System.out.println("\nInsert 4=400");
        cache.put(4, 400);
        cache.display();

        System.out.println("\nGet key 2: " + cache.get(2));

        System.out.println("Get key 3: " + cache.get(3));
        cache.display();

        System.out.println("\nUpdate key 1 to 150");
        cache.put(1, 150);
        cache.display();
    }
}
