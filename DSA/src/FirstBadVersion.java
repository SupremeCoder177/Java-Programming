public class FirstBadVersion {

    public static boolean isBadVersion(int n){
        return false;
    }

    public static int firstBadVersion(int n){
        int pointer = n / 2;
        int endPointer = n;
        int startPointer = 0;

        while(startPointer <= endPointer){
            if(!isBadVersion(pointer)){
                if(isBadVersion(pointer + 1)) return pointer + 1;
                startPointer = pointer - 1;
                pointer = ((endPointer  - startPointer) / 2) + startPointer;
            }else{
                if(!isBadVersion(pointer - 1)) return pointer;
                endPointer = pointer + 1;
                pointer = ((endPointer - startPointer) / 2) + startPointer;
            }
        }
        return -1;
    }

}
