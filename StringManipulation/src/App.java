public class App {

    public String[] divideString(String s, int k, char fill) {
        String[] Output = { "" };
        String word = "";
        int i = 0;
        double auxSize = Math.ceil(s.length() / k);
        int t = 0;
        for (int j = 0; j < auxSize; j++) {
            while (t % k != 0) {

                Output[j] = Output[j] + s.charAt(i);
                i++;
                t++;
            }
            System.out.println(Output[0]);
            t = 0;
        }
        return Output;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String[] res = { "" };
        res = divideString("abcdefghi", 3, "x");
    }

}
