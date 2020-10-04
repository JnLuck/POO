import entities.Person;

public class Main {
    
    public static void main(String[] args){
        Person p = new Person();
        p.setName("Alex "+p);
        p.setSex("M");
        System.out.println("sexo = "+p.getSex() );
        p.laugh();

        Person p2 = new Person("Maria");
        p.setSex("F");
        System.out.println("sexo = "+p2.getSex() );
        p2.laugh();

        Person p3 = new Person("Albert");
        p.setSex("M");
        System.out.println("sexo = "+p3.getSex() );
        p3.laugh();
    }


}
