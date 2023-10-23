package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputConsole {
    public String readPrediction(){
        String input = Console.readLine();
        if (isFormValid(input)){
            return input;
        } else throw new IllegalArgumentException("잘못된 예측값 포맷입니다.");
    }

    public String readUserIntentionForNewGame(){
        String input = Console.readLine();
        if (input == "1" || input == "2"){
            return input;
        } else throw new IllegalArgumentException("게임 재시작 여부는 1과 2만 받을 수 있습니다.");
    }

    private boolean isFormValid(String input){
        return isLengthThree(input) && containsOnlyDigit(input) && notContainsDuplicatedNumber(input);
    }

    private boolean isLengthThree(String input){
        if (input.length() != 3) throw new IllegalArgumentException("예측값 길이는 3이어야 합니다.");
        else return true;
    }

    private boolean containsOnlyDigit(String input){
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean notContainsDuplicatedNumber(String input){
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                result.add(digit);
            }
        }

        return result.size() == 3;
    }
}
