package datastructures;

public class ZMyDynamicArray<String> {

  private Object[] data;
  private int size;
  private int initialCapacity;


  public ZMyDynamicArray(int initialCapacity) {
      this.initialCapacity = initialCapacity;
      data = new Object[initialCapacity];
  }

  public Object get(int index) {
      return data[index];
  }

  public void set(int index, String value) {
      data[index] = value;
  }

  public void insert(int index, String value) {
      if(this.size == initialCapacity) {
          this.resize();
      }
      if (data[index] == null) {
          data[index] = value;
      } else {
          for (int i = this.size; i > index; i-- ) {
              data[i] = data[i - 1];
          }
          data[index] = value;
          size++;
      }
  }

  private void resize() {
      // create new array double the size
      Object[] temp = new Object[initialCapacity*2];

      // copy things to new array
      for(int i = 0; i < initialCapacity; i++) {
          temp[i] = data[i];
      }
      data = temp;
      initialCapacity = initialCapacity*2;
  }


  public void delete(int index) {
      for (int i = index; i < size - 1; i++) {
          data[i] = data[i + 1];
      }
      size--;
  }

  public boolean Contains(String value) {
      for (int i = 0; i < size; i++) {
          String current = (String)data[i];
          if (current.equals(value)) {
              return true;
          }
      }
      return false;
  }

  public boolean isEmpty() {
      return size == 0;

  }

  public void traverse() {
      for (int i = 0; i < size; i++) {
          System.out.println(data[i]);
      }
  }

  public void add(String value) {
      if (size == initialCapacity) {
          resize();
      }
      data[size] = value;
      size++;
  }

  public int size() {
      return size;
  }

}
