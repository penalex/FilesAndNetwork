public class Container {
    private Integer count = 0; //boxing

    public void addCount(int value) {
        count = count+value;
    } //unboxing

    public int getCount() {
        System.out.print("Проверка первого задания: ");
        return count;

    }

    //1040 - а 1103 - я  1105 - ё 1025 - Ё
    public void CharFinder() {
        System.out.println("Второе задание: ");
        for (int i = 0; i < 65536; i++) {
            char c = (char) i;
            if (i >= 1040 && i <= 1103) {
                if (i == 1045) {
                    System.out.println(i+" - "+c);
                    c = 1025;
                }
                if (i == 1077) {
                    System.out.println(i+" - "+c);
                    c = 1105;
                }
                System.out.println(i+" - "+c);
            }
        }
    }
}
