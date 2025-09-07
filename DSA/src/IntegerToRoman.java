import java.util.ArrayList;

public class IntegerToRoman {

    public static String intToRoman(int num){
        ArrayList<Character> chars = new ArrayList<>();
        String temp = String.valueOf(num);
        while(num > 0){
            System.out.println(num);
            int temp2 = (int) Math.pow(10, temp.length() - 1);
            if(temp.charAt(0) != '4' && temp.charAt(0) != '9') {
                if(temp2 == 1000){
                    chars.add('M');
                    num -= 1000;
                }else if(temp2 == 100){
                    if((int) temp.charAt(0) - (int) '0' >= 5){
                        chars.add('D');
                        num -= 500;
                    }else{
                        chars.add('C');
                        num -= 100;
                    }
                }else if(temp2 == 10){
                    if((int) temp.charAt(0) - (int) '0' >= 5) {
                        chars.add('L');
                        num -= 50;
                    }else{
                        chars.add('X');
                        num -= 10;
                    }
                }else if(temp2 == 1){
                    if((int) temp.charAt(0) - (int) '0' >= 5) {
                        chars.add('V');
                        num -= 5;
                    } else{
                        chars.add('I');
                        num -= 1;
                    }
                }
            }else {
                if (temp.charAt(0) == '4') {
                    if (temp2 == 1000) {
                        chars.add('X');
                        chars.add('M');
                        num -= 1000;
                    } else if (temp2 == 100) {
                        chars.add('C');
                        chars.add('D');
                        num -= 400;
                    } else if (temp2 == 10) {
                        chars.add('X');
                        chars.add('L');
                        num -= 40;
                    } else{
                        chars.add('I');
                        chars.add('V');
                        num -= 4;
                    }
                }else{
                    if(temp2 == 1000){
                        chars.add('C');
                        chars.add('M');
                        num -= 1000;
                    }else if(temp2 == 100){
                        chars.add('C');
                        chars.add('M');
                        num -= 900;
                    }else if(temp2 == 10){
                        chars.add('X');
                        chars.add('C');
                        num -= 90;
                    }
                    else{
                        chars.add('I');
                        chars.add('X');
                        num -= 9;
                    }
                }
            }
            temp = String.valueOf(num);

        }
        char[] output = new char[chars.size()];
        for(int i = 0; i < chars.size(); i++){
            output[i] = chars.get(i);
        }

        return String.valueOf(output);
    }

    public static void main(String[] args){
        System.out.println(intToRoman(60));
    }
}
