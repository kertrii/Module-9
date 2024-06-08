public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("Size: " + list.size());

        System.out.println("Element at index 1: " + list.get(1));

        list.remove(1);
        System.out.println("Removed element: " + list.get(1));
        System.out.println("Size after removal: " + list.size());

        list.clear();
        System.out.println("Size after clearing: " + list.size());
        System.out.println();


        MyLinkedList<String> list1 = new MyLinkedList<>();

        list1.add("First");
        list1.add("Second");
        list1.add("Third");

        System.out.println("Size: " + list1.size());

        System.out.println("Element at index 0: " + list1.get(0));

        list1.remove(1);
        System.out.println("Removed element: " + list1.get(1));
        System.out.println("Size after removal: " + list1.size());

        list1.clear();
        System.out.println("Size after clearing: " + list1.size());
        System.out.println();


        MyQueue<String> queue = new MyQueue<>();

        queue.add("10");
        queue.add("20");
        queue.add("30");

        System.out.println("First element: " + queue.peek());

        System.out.println("Size: " + queue.size());

        System.out.println("Poll: " + queue.poll());
        System.out.println("Size after poll: " + queue.size());

        queue.clear();
        System.out.println("Size after clearing: " + queue.size());
        System.out.println();


        MyStack<String> stack = new MyStack<>();

        stack.push("Apple");
        stack.push("Banana");
        stack.push("Orange");

        System.out.println("Size: " + stack.size());

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Size after pop: " + stack.size());
        System.out.println();


        MyHashMap map = new MyHashMap();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        System.out.println("Size of HashMap: " + map.size());

        System.out.println("Value for 'key1': " + map.get("key1"));
        System.out.println("Value for 'key2': " + map.get("key2"));
        System.out.println("Value for 'key3': " + map.get("key3"));

        map.remove("key2");
        System.out.println("Value for 'key2' after removal: " + map.get("key2"));
        System.out.println("Size after removal: " + map.size());

        map.clear();
        System.out.println("Size after clearing: " + map.size());
    }
}