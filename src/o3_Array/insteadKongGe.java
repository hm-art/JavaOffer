package o3_Array;

public class insteadKongGe {
    public static void main(String[] args) {
        char[] c={'w','e',' ','a','r','e',' ','h','a','p','p','y','.','\n',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int length=c.length;
        instead(c,length);
    }
    public static void instead(char []c,int length){
        if(c==null||c.length==0){
            return;
        }
        int yuanl=0;
        int kongl=0;
        while(c[yuanl]!='\0'){
            if(c[yuanl]!=' '){
                kongl+=1;
            }else
                kongl+=3;
            yuanl++;
        }
        if(length<kongl){
            return;
        }
        while (yuanl>0&&yuanl<kongl) {
            if (c[yuanl] == ' ') {
                c[kongl--] = '0';
                c[kongl--] = '2';
                c[kongl--] = '%';
            } else {
                c[kongl--] = c[yuanl];
            }
            yuanl--;
        }
        System.out.println(c);
    }
}
