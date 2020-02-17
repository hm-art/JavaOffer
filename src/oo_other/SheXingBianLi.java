package oo_other;
//蛇形遍历数组
public class SheXingBianLi {
    public static void main(String[] args) {
        char b[][]=new char[][]{
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'g','d','e','h'}
        };
        for(int i=0;i<b.length;i++){
            if(i%2!=0){
                for(int j=b[0].length-1;j>=0;j--){
                    System.out.println(b[i][j]);
                }
            }
            else if(i%2==0){
                for(int j=0;j<b[0].length;j++){
                    System.out.println(b[i][j]);
                }
            }
        }
    }
}

