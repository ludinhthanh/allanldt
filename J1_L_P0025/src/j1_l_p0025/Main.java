package j1_l_p0025;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static StringBuffer input() throws FileNotFoundException,IOException{
        StringBuffer s = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader("J1_L_P0025\\input.txt"));
        String line = br.readLine();
        while (line!=null){
            if (line.length()>0){
                s.append(line.trim());
                s.append("\n");
            }
            line=br.readLine();
        }
        br.close();
        return s;
    }
    public static StringBuffer normalize(StringBuffer s){
        StringBuffer result=new StringBuffer();
        int n=s.length()-1;
        boolean upper=true;
        for (int i=0;i<n-1;i++){
            char temp1=s.charAt(i);
            char temp2=s.charAt(i+1);
            if (upper){
                temp1=Character.toUpperCase(temp1);
                upper=false;
            }else if ((temp1>='A')&&(temp1<='Z')) temp1=Character.toLowerCase(temp1);
            if (temp1==' '){
                if ((temp2==' ')||(temp2=='.')||(temp2==',')||(temp2==':')) continue;
            }
            if ((temp1=='.')||(temp1==',')||(temp1==':')){
                if (temp2!=' ') {
                    result.append(temp1);
                    result.append(" ");
                    if ((temp1=='.')||(temp1=='\n'))upper=true;
                    continue;
                }
            }
            result.append(temp1);
        }
        result.append(s.charAt(n-1));
        return result;
    }
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer();
        try {
            s = input();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Read file error");
            System.exit(1);
        }
        StringBuffer result=normalize(s);
        
        System.out.println(result.toString());
    }
}