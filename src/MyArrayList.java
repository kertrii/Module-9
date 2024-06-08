import java.util.Arrays;

public class MyArrayList<T> {
    private T[] array;
    private int size = 0;

    public MyArrayList() {
        array = (T[]) new Object[10];
    }

    public void add(T value) {
        if (size == array.length) {
            resizeArray();
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    private void resizeArray() {
        int newArray = array.length * 2;
        array = Arrays.copyOf(array, newArray);
    }
}

