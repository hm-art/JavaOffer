package oo_ZiXue.ZiJieMa;
class Person {
    private String name;
    private int age;
    public Person(int age, String name){
       this.age = age;
       this.name = name;
    }
    public void run(){
    }
}
interface IStudyable {
public int study(int a, int b);
}