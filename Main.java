public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.add(0, 10);
        list.add(1, 20);
        list.add(1, 15);

        System.out.println("Elemento na posição 1: " + list.get(1)); 
        System.out.println("Tamanho da lista: " + list.getSize());

        list.remove(1);
        System.out.println("Elemento na posição 1 após remoção: " + list.get(1));
        System.out.println("Tamanho da lista após remoção: " + list.getSize());
    }
}
