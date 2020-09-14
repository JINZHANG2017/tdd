public class VowelsStringTransfer {
    public static String transfer(String originString){
        if(originString==null){
            return null;
        }
        if("".equals(originString)){
            return "";
        }
        String returnString=originString;
        int[] continuousVowelsPosAndLen=getMostContinuousVowelsPosAndLen(originString);
        while(continuousVowelsPosAndLen[1]>=2&&continuousVowelsPosAndLen[1]>returnString.length()*0.3){
            returnString=insertSequence(returnString,continuousVowelsPosAndLen);
            continuousVowelsPosAndLen=getMostContinuousVowelsPosAndLen(returnString);
        }
        return returnString;
    }

    private static String insertSequence(String originString, int[] continuousVowelsPosAndLen) {
        StringBuilder sb=new StringBuilder();
        sb.append(originString.substring(0,continuousVowelsPosAndLen[0]+1));
        sb.append("mommy");
        sb.append(originString.substring(continuousVowelsPosAndLen[0]+1,originString.length()));
        return sb.toString();
    }

    private static int[] getMostContinuousVowelsPosAndLen(String originString) {
        int pos=0;
        int len=0;
        int maxLen=0;
        int maxPos=0;
        char tempStoredChar=' ';
        for(int i=0;i<originString.length();i++){
            char currentChar=originString.charAt(i);
            if(isVowel(currentChar)){
                if(tempStoredChar==' '){
                    pos=i;
                }
                len++;
                tempStoredChar=currentChar;
            }else{
                if(maxLen<len){
                    maxLen=len;
                    maxPos=pos;
                }
                len=0;
                tempStoredChar=' ';
            }
        }
        int[] result=new int[2];
        result[0]=maxPos;
        result[1]=maxLen;
        return result;
    }

    private static boolean isVowel(char c) {
        String vowelString="aeiou";
        if(vowelString.indexOf(c)>=0){
            return true;
        }
        return false;
    }
}
