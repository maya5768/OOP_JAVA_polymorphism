public class Ex3_1 {
    public static void main(String[] args) {
        String[] names = { "Shukri", "Maya", "Vilner", "Gadi" };
        sortByLetter(names, 2);
        
        System.out.println("Sorted names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
    
    public static void sortByLetter (String[] a, int k) {
        int index = 0;
        for (int c = 0; c < 128; c++) {
            for (int i = 0; i < a.length; i++) {
                String str = a[i];
                char ch = str.charAt(k);
                int ascii = (int) ch;
                if (c == ascii) {
                    String temp = a[index];
                    a[index] = a[i];
                    a[i] = temp;
                    index++;
                }
            }
        }
    }
}
