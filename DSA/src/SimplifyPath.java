import java.util.ArrayList;

public class SimplifyPath {

    public static String simplifyPath(String path){
        if(path.length() <= 1) return "/";

        ArrayList<String> temp = new ArrayList<>();

        for(int i = 1; i < path.length(); i++){
            if(path.charAt(i) == '/') i++;
            int j = i;
            while(j < path.length() && path.charAt(j) != '/') j++;

            if(path.substring(i, j).equals("..")) {
                if(temp.size() < 2) continue;
                temp.remove(temp.size() - 1);
                temp.remove(temp.size() - 1);
            }
            else if(path.substring(i, j).equals(".")) {
                continue;
            }
            else {
                if(!path.substring(i, j).equals("")) {
                    temp.add("/");
                    temp.add(path.substring(i, j));
                }
            }

            i = j;
        }

        if(temp.size() == 0) temp.add("/");

        ArrayList<Character> output = new ArrayList<>();
        while(!temp.isEmpty()) {
            String temp2 = temp.get(0);
            for(int i = 0; i < temp2.length(); i++){
                output.add(temp2.charAt(i));
            }
            temp.remove(0);
        }

        char[] temp3 = new char[output.size()];

        for(int i = 0; i < output.size(); i++) temp3[i] = output.get(i);

        return String.copyValueOf(temp3);
    }

    public static void main(String[] args){
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
    }

}
