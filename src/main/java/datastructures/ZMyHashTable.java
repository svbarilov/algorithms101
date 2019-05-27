package datastructures;

public class ZMyHashTable {

    private class HashEntry {
        public String key;
        public String value;
        private HashEntry next;

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int size;
    private int initialCapacity;
    private HashEntry[] data;

    public ZMyHashTable(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new HashEntry[initialCapacity];
    }

    public void put(String key, String value) {
        HashEntry newHashEntry = new HashEntry(key, value);
        int index = getIndex(key);
        if (data[index] == null) {
            data[index]  = newHashEntry;
        } else {
            HashEntry currentEntry = data[index];
            while (currentEntry.next != null) {
                currentEntry = currentEntry.next;
            }
            currentEntry.next = newHashEntry;
        }
        size++;
    }

    public String get(String key) {
        int index = getIndex(key);
        HashEntry currentHashEntry = data[index];
        while (currentHashEntry.next != null && !currentHashEntry.key.equals(key)) {
            currentHashEntry = currentHashEntry.next;
        }
        size--;
        return currentHashEntry.value;
    }

    private int getIndex(String key) {
        // Hack to force collision for testing
        if (key.equals("John Smith") || key.equals("Sandra Dee")) {
            return 4;
        }
        int index = key.hashCode() % this.initialCapacity;
        return index > 0 ? index : index * -1;
    }




}
