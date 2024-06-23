class MyHashMap<K, V> {

    private Entry<K, V>[] table;
    private int capacity = 4;
    private int size = 0;
    private Entry<K, V> nullKeyEntry = null;

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Entry[capacity];
    }

    public void put(K newKey, V data) {
//        if (newKey == null)
//            return;


        if (newKey == null) {
            if (nullKeyEntry == null) {
                nullKeyEntry = new Entry<>(null, data, null);
                size++;
            } else {
                nullKeyEntry.value = data;
            }
            return;
        }

        ensureCapacity();

        int hash = hash(newKey);
        Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(newKey)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
        size++;
    }

    public V get(K key) {
        if (key == null) {
            return nullKeyEntry == null ? null : nullKeyEntry.value;
        }

        int hash = hash(key);
        Entry<K, V> current = table[hash];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {
                        table[hash] = table[hash].next;
                        size--;
                        return true;
                    } else {
                        previous.next = current.next;
                        size--;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        } else {
            return Math.abs(key.hashCode()) % capacity;
        }
//        return Math.abs(key.hashCode()) % capacity;
    }

    private void ensureCapacity() {
        if (size >= capacity * 0.75) {
            resize();
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        Entry<K, V>[] newTable = new Entry[newCapacity];

        for (Entry<K, V> entry : table) {
            while (entry != null) {
                Entry<K, V> next = entry.next;
                int hash = hash(entry.key);
                entry.next = newTable[hash];
                newTable[hash] = entry;
                entry = next;
            }
        }

        table = newTable;
        capacity = newCapacity;
    }

    public int size() {
        return size;
    }
}