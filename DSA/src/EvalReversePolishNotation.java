import java.util.ArrayList;

public class EvalReversePolishNotation {

    public static int evalRPN(String[] tokens){
        if(tokens.length < 1) return 0;
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);

        int output = 0;
        int left_ptr = 0;
        int right_ptr = 0;
        String operand_holder = "";
        boolean left_shift = false;

        ArrayList<String> operands = new ArrayList<>();
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");

        for(int i = 0; i < tokens.length; i++){
            if(operands.contains(tokens[i])){
                left_ptr = i - 2;
                right_ptr = i - 1;
                break;
            }
        }

        operand_holder = tokens[right_ptr + 1];
        output = addStrings(tokens[left_ptr], tokens[right_ptr], operand_holder);
        right_ptr += 2;

        while(left_ptr >= 0 && right_ptr < tokens.length){

            if(operands.contains(tokens[right_ptr])){
                left_ptr--;
                operand_holder = tokens[right_ptr];
                left_shift = true;
                right_ptr++;
            }else{
                if(operands.contains(tokens[right_ptr + 1])) {
                    left_shift = false;
                    operand_holder = tokens[right_ptr + 1];
                }else{
                    if(operands.contains(tokens[right_ptr + 1])){
                        operand_holder = tokens[right_ptr + 1];
                    }else{
                        int temp_val = 0;
                        while(true) {
                            int operand_count = 0;
                            String temp_operand = "";
                            int index = 0;
                            for (int i = right_ptr; i < tokens.length; i++) {
                                if (operands.contains(tokens[i])) operand_count++;
                                if (operand_count == 1) {
                                    temp_operand = tokens[i];
                                    index = i;
                                    if (operands.contains(tokens[index + 1])) {
                                        operand_count = 2;
                                        operand_holder = tokens[index + 1];
                                    }
                                    break;
                                }
                            }
                            if (operand_count == 2) {
                                output = addStrings(String.valueOf(output), String.valueOf(addStrings(tokens[index - 2], tokens[index - 1], temp_operand)), operand_holder);
                                right_ptr += 4;
                                break;
                            } else {
                                right_ptr += 3;
                            }
                        }
                    }
                    left_shift = false;
                }
            }

            if(left_shift){
                output = addStrings(tokens[left_ptr], String.valueOf(output), operand_holder);
            }else{
                output = addStrings(String.valueOf(output), tokens[right_ptr], operand_holder);
                right_ptr += 2;
            }
        }

        return output;
    }

    public static int addStrings(String t1, String t2, String operation){
        int temp1 = Integer.parseInt(t1);
        int temp2 = Integer.parseInt(t2);
        return switch (operation) {
            case "-" -> temp1 - temp2;
            case "+" -> temp1 + temp2;
            case "*" -> temp1 * temp2;
            case "/" -> temp1 / temp2;
            default -> 0;
        };
    }


    public static void main(String[] args){
        System.out.println(evalRPN(new String[]{"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"}));
    }
}
