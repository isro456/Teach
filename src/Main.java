public class Main {
    public static void main(String[] args) {
        Minheap heap = new Minheap(10);

        heap.add(10);
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);

        System.out.println("Корень кучи: " + heap.peek());

        heap.removeMin();

        System.out.println("Корень после удаления: " + heap.peek());

        heap.add(2);

        System.out.println("Корень после добавления: " + heap.peek());
    }
}

class Minheap {
    int[] heap;
    int size;
    int capacity;

    public Minheap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Добавление элемента
    void add(int value) {
        if (size == capacity) {
            System.out.println("Куча заполнена!");
            return;
        }

        heap[size] = value;
        int i = size;
        size++;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap[parent] <= heap[i]) {
                break;
            }

            swap(parent, i);
            i = parent;
        }
    }

    // Просмотр корневого элемента
    int peek() {
        if (size == 0) {
            throw new IllegalStateException("Куча пустая");
        }

        return heap[0];
    }

    // Удаление корневого элемента
    void removeMin() {
        if (size == 0) {
            throw new IllegalStateException("Куча пустая");
        }

        heap[0] = heap[size - 1];
        size--;

        int i = 0;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest == i) {
                break;
            }

            swap(i, smallest);
            i = smallest;
        }
    }
}