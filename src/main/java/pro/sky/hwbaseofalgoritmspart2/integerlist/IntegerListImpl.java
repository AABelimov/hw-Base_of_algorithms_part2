package pro.sky.hwbaseofalgoritmspart2.integerlist;

import pro.sky.hwbaseofalgoritmspart2.exception.ItemNotFoundException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] list;
    private int size = 0;

    public IntegerListImpl(int capacity) {
        list = new Integer[capacity];
    }

    public IntegerListImpl() {
        this(10);
    }

    public IntegerListImpl(Integer... arr) {
        list = arr;
        size = arr.length;
        grow();
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }

    private void grow() {
        list = Arrays.copyOf(list, (int) (list.length * 1.5));
    }

    private Integer[] sortSelection(Integer[] arr) {
        Integer[] copyArr = Arrays.copyOf(arr, size);
        for (int i = 0; i < size; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (copyArr[j] < copyArr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            int temp = copyArr[i];
            copyArr[i] = copyArr[minElementIndex];
            copyArr[minElementIndex] = temp;
        }
        return copyArr;
    }

    private int binarySearch(Integer[] arr, int item) {
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return mid;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        if (size == list.length) {
            grow();
        }
        list[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateItem(item);
        if (index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
            return add(item);
        } else {
            return addNotToEnd(index, item);
        }
    }

    private Integer addNotToEnd(int index, Integer item) {
        if (list.length == size) {
            grow();
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        size++;
        list[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateItem(item);
        if (index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
            return add(item);
        } else {
            list[index] = item;
            return item;
        }
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                count++;
                removeItem(i, item);
            }
        }
        if (count == 0) {
            throw new ItemNotFoundException("Item can't be removed, because it was not found");
        }
        return item;
    }

    private void removeItem(int i, Integer item) {
        while (i < size - 1) {
            if (list[i + 1].equals(item)) {
                removeItem(i + 1, item);
            }
            list[i] = list[++i];
        }
        list[size] = null;
        size--;
    }

    @Override
    public Integer remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Integer item = list[index];
        removeItem(index);
        return item;
    }

    private void removeItem(int i) {
        while (i < size) {
            list[i] = list[++i];
        }
        list[size] = null;
        size--;
    }

    @Override
    public boolean contains(Integer item) {
        validateItem(item);
        return binarySearch(sortSelection(list), item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntegerListImpl that = (IntegerListImpl) o;

        if (size != that.size) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(list);
        result = 31 * result + size;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        list = new Integer[10];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(list, size);
    }
}