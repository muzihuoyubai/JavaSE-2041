class ArrayFilter {
    public static void main(String[] args) {
        filtArray(new int[] {1, 3, 3, 1, -3, -9, 12, 33});

    }

    static int[] filtArray(int[] target) {
        int finalCount = target.length;
        for (int i = 0; i < finalCount; i++) {
            for (int j = i + 1; j < finalCount ; j++) {
                if (target[i] == target[j]) {
                    target[j] = target[finalCount - 1];
                    finalCount--;
                    j--;
                }
            }
        }

        for (int one : target) {
            System.out.printf("%d ", one);
        }

        System.out.println();

        int[] rlt = new int[finalCount];
        for (int i = 0; i < finalCount ; i++ ) {
            rlt[i] = target[i];
        }

        for (int one : rlt) {
            System.out.printf("%d ", one);
        }
        System.out.println();
        return rlt;
    }
}