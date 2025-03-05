public class DynamicArray {
    public static final int GROWTH_INCREMENT = 4;
    private Object[] elements;
    private int size;
    private boolean readOnly;

    public DynamicArray() {
        size = 0;
        readOnly = false;
        elements = new Object[0];
    }

    public void add(Object element) {
        if (readOnly)
            return;

        if (atCapacity())
            grow();

        addElement(element);
    }

    private void addElement(Object element) {
        elements[size++] = element;
    }

    private void grow() {
        Object[] newElements = new Object[elements.length + GROWTH_INCREMENT];
        if (size >= 0) System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    private boolean atCapacity() {
        return (size + 1) > elements.length;
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
        for (int i = 1 ; i <=5 ; i++)
            list.add(i * 10);
        list.printContent();
    }
}