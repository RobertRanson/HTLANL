import java.util.ArrayList;


public class ArrayListExample {
    static ArrayList<String> dogsArrayList = new ArrayList<String>();

    public static void addDogs(String name) {
        dogsArrayList.add(name);
    }

    public static int getLength() {
        return dogsArrayList.size();
    }

    public static String getElement(int index) {
        return dogsArrayList.get(index);
    }

    public static void setElement(int index, String name){
        dogsArrayList.set(index, name);
    }

    public static void removeElement(int index) {
        dogsArrayList.remove(index);
    }

    public static void removeAll() {
        dogsArrayList.clear();
    }

    public static int getIndex(String name) {
        return dogsArrayList.indexOf(name);
    }

    public static void printAllDogs() {
        for(int i = 0; i<dogsArrayList.size();i++){
            System.out.println((i+1) +": " + getElement(i));
        }        
    }
    public static void main(String[] args) {
        System.out.println("\n\n--------------------------------------------------------");

        addDogs("German Shepherd");
        addDogs("Labrador Retriever");
        addDogs("Siberian Husky");
        addDogs("King Charles Cavalier Spaniel");
        addDogs("Border Collie");
        addDogs("Dalmatian");

        // System.out.println("Dog at index [2]: " + getElement(2));

        setElement(0, "Springer Spaniel");

        removeElement(2);

        removeElement(getIndex("Dalmatian"));

        removeAll();

        System.out.println("Number of Dogs: "+ getLength());
        

        printAllDogs();
        System.out.println("--------------------------------------------------------");

    }    
}