import java.util.ArrayList;

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3){
        if(s3.isEmpty()){
            return s1.isEmpty() && s2.isEmpty();
        }
        if(s1.isEmpty()){
            return s2.equals(s3);
        }
        if(s2.isEmpty()){
            return s1.equals(s3);
        }

        int len1 = s1.length(), len2 = s2.length();
        int t = 1, m = 1;

        while(t <= len1 && m <= len2){

            for(int[] len : getAllPossibles(s1, s2, t, m, len1, len2)){
                String temp1 = joinSubs(s1, s2, len[0], len[1], len1, len2);
                String temp2 = joinSubs(s2, s1, len[1], len[0], len2, len1);
                if(temp1.equals(s3) || temp2.equals(s3)) return true;
            }

            if(t + 1 <= len1) {
                for (int[] len : getAllPossibles(s1, s2, t + 1, m, len1, len2)) {
                    String temp1 = joinSubs(s1, s2, len[0], len[1], len1, len2);
                    String temp2 = joinSubs(s2, s1, len[1], len[0], len2, len1);
                    if (temp1.equals(s3) || temp2.equals(s3)) return true;
                }
            }

            if(m + 1 <= len2) {
                for (int[] len : getAllPossibles(s1, s2, t, m + 1, len1, len2)) {
                    String temp1 = joinSubs(s1, s2, len[0], len[1], len1, len2);
                    String temp2 = joinSubs(s2, s1, len[1], len[0], len2, len1);
                    if (temp1.equals(s3) || temp2.equals(s3)) return true;
                }
            }

            if(t <= len1) t++;
            if(m <= len2) m++;
        }

        return false;
    }

    public static ArrayList<int[]> getAllPossibles(String s1, String s2, int t, int m, int len1, int len2){
        ArrayList<int[]> output = new ArrayList<>();

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(len1 / i == t && len2 / j == m){
                    output.add(new int[]{i, j});
                }
            }
        }

        return output;
    }

    public static String joinSubs(String s1, String s2, int t, int m, int n1, int n2){
        StringBuilder output = new StringBuilder();
        int index1 = 0, index2 = 0;
        while(true){
            if(index1 < n1) {
                if(index1 + t <= n1)
                output.append(s1, index1, index1 + t);
                else{
                    output.append(s1, index1, n1);
                }
            }
            if(index2 < n2) {
                if(index2 + m <= n2)
                output.append(s2, index2, index2 + m);
                else{
                    output.append(s2, index2, n2);
                }
            }
            index1 += t;
            index2 += m;
            if(index1 >= n1 && index2 >= n2) break;
        }
        return output.toString();
    }

    public static void main(String[] args){
        System.out.println(isInterleave("aabd", "abdc", "aabdabcd"));
    }

}
