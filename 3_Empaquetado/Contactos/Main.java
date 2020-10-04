import java.util.Scanner;
import java.util.List;
import data.PersonData;
import entities.Person;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //System.out.println("Ingrese una oracion: ");
        //String name = input.nextLine();
        //System.out.println("Escribiste: " + name);
        String di = "__________________________________________\n";
        int opt = 0;

        PersonData persondata = new PersonData();

        do{
            System.out.println("***** CRUD PERSON *****");
            System.out.println("1 Create Person ");
            System.out.println("2 Update Person ");
            System.out.println("3 List Person");
            System.out.println("4 Delete Person");
            System.out.println("5 Detail Person");
            System.out.println("0 Exit ");
            System.out.println("Choice option: ");
            opt = input.nextInt();
            System.out.println("You chosed: " + opt);
            input.nextLine(); // Limpiar el buffer
            // input.nextInt()
            switch (opt) {

                case 1: 
                    System.out.println("Option 1 Create");
                    Person person = new Person();
                    System.out.print("Input Name: ");
                    person.setName(input.nextLine());
                    System.out.print("Input Sex: ");
                    person.setSex(input.nextLine());
                    System.out.print("Input Age: ");
                    person.setAge(Integer.parseInt(input.nextLine()));
                    persondata.create(person);
                    System.out.print(di);
                    break;

                case 2: 
                    System.out.println("Option 2 Update");
                    System.out.print("Input Id Update: ");
                    int idx = Integer.parseInt(input.nextLine());
                    System.out.print("Input Name: ");
                    String namex = input.nextLine();
                    System.out.print("Input Sex: ");
                    String sexx = input.nextLine();
                    System.out.print("Input Age: ");
                    int agex = Integer.parseInt(input.nextLine());
                    persondata.update(idx, namex, sexx, agex);
                    System.out.print("Person Update");
                    System.out.print(di);
                    break;

                case 3: 
                    System.out.println("Option 3 List");
                    List<Person> lis = persondata.list();
                    System.out.println("ID \t  Name \t  Sex \t  Age");
                    for (Person personl : lis) {
                        System.out.println(personl.getId() + "\t" + personl.getName() + "\t" + personl.getSex() + "\t" + personl.getAge());
                    }
                    System.out.print(di);
                    break;
                case 4: 
                    System.out.println("Option 4 Delete Person");
                    System.out.print("Input Id Delete: ");
                    persondata.delete(Integer.parseInt(input.nextLine()));
                    System.out.println("Delete Person");
                    System.out.print(di);
                    break;
                case 5: 
                    System.out.println("Option 5 Detail Person");
                    System.out.print("Input Id Detail: ");
                    Person personget = persondata.getid(Integer.parseInt(input.nextLine()));
                    System.out.println("Id: " + personget.getId() + "\n" + "Name: " + personget.getName() + "\n" + "Sex: " + personget.getSex() + "\n" + "Age: " + personget.getAge());
                    System.out.print(di);
                    break;

                default: System.out.println("Syntax error");
            }
        }while(opt != 0);       
    } 
    
}