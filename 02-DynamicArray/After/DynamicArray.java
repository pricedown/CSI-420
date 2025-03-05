public class DynamicArray {
    private static final int GROWTH_INCREMENT = 4;
    private Object[] elements;
    private int size;
    private boolean readOnly;

    public void add(Object element) {

        if (readOnly)
            return;

        if (atCapacity()) {
            grow();
        }
        addElement(element);
    }

    private void addElement(Object element) {
        elements[size++] = element;
    }

    private void grow() {
        Object[] newElements = new Object[elements.length + GROWTH_INCREMENT];
        for (int i = 0; i < size; i++)
            newElements[i] = elements[i];
        elements = newElements;
    }

    private boolean atCapacity() {
        int newSize = size + 1;
        return newSize > elements.length;
    }

    public DynamicArray() {
        size = 0;
        readOnly = false;
        elements = new Object[0];
    }

    public void printContent() {
        for (Object obj : elements)
            System.out.println(obj);
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Object[] getElements() {
        return elements;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        DynamicArray list = new DynamicArray();
        for (int i = 1; i <= 5; i++)
            list.add(new Integer(i * 10));
        list.printContent();
    }
}