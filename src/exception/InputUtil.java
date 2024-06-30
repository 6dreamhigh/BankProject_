package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static long getLongInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Long.parseLong(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
            } catch (IOException e) {
                System.out.println("입력 중 오류가 발생했습니다. 다시 시도해 주세요.");
            }
        }
    }

    public static String getStringInput(String prompt) {
        try {
            System.out.print(prompt);
            return br.readLine();
        } catch (IOException e) {
            System.out.println("입력 중 오류가 발생했습니다. 다시 시도해 주세요.");
            return getStringInput(prompt);
        }
    }
}

