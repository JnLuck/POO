package entities;

public class Person {
    int id;
    String name;
    int age;
    String sex;

    public Person() {

    }

    public Person(String name) {
        this.name=name;
    }

    public Person(String name, String sex) {
        this.name=name;
        this.sex=sex;
    }

    public void laugh() {
        System.out.println( name + " : Quiero comer!");
    }

    public void laugh(String x) {
        System.out.println( name + " : Quiero comer!" + x);
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    
}
