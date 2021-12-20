package code_1220;

import java.util.Scanner;

public class acm18121 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        String input = sc.nextLine();
        Long convertZero = getSwitch(input, "[0]+");
        Long convertOne = getSwitch(input, "[1]+");
        System.out.println(Math.min(convertZero,convertOne));
    }

    public static Long getSwitch(String input, String regex){
        return input.replaceAll(regex,"2")
                .chars()
                .filter(a -> a == '2')
                .count();
    }
}
