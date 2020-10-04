
import java.util.Scanner;

import data.PersonData;
import entities.Person;

public class Main {

    public static void main(String[] args) {
        PersonData data = new PersonData();
        Scanner input = new Scanner(System.in);
        int opt = 0;
        do {
            System.out.println("***** CRUD PERSON *****");
            System.out.println("1 List ");
            System.out.println("2 New ");
            System.out.println("3 Delete ");
            System.out.println("4 Get byID ");
            System.out.println("5 Update ");
            System.out.println("0 Exit ");
            System.out.println("Choice option: ");
            opt = input.nextInt();
            System.out.println("You chosed: " + opt);
            input.nextLine(); // Limpiar el buffer
            switch (opt) {
                case 1:
                    System.out.println("Listado de personas ");
                    for (Person d : data.list("")) {
                        System.out.println(d.getId() + "\t" + d.getName()
                        + "\t" + d.getSex()+ "\t" + d.getAge());
                    }
                    break;
                case 2:
                    System.out.println("Nueva persona ");
                    Person p = new Person();
                    System.out.print("name: ");
                    p.setName(input.nextLine());
                    System.out.print("sex: ");
                    p.setSex(input.nextLine());

                    System.out.print("edad: ");
                    try {
                        p.setAge(input.nextInt());
                        data.create(p);
                    } catch (Exception e) {
                        input.nextLine(); // Limpiar el buffer
                        System.out.print("Edad debe ser entero, no se guardo");
                    }
                    
                    break;
                case 3:
                    System.out.println("Eliminar persona ");
                    boolean bandera3 = true;
                    String idd;
                    do{
                        System.out.print("id: ");
                        try{
                            data.delete(Integer.parseInt(input.nextLine()));
                            bandera3 = false;
                        } catch (Exception e) {
                            input.nextLine();
                            System.out.print("No pongas letras");
                            bandera3 = true;
                        }
                    }while (bandera3);
                    // do{
                    //     System.out.print("id: ");
                    //     try{
                    //         int idd = input.nextInt();
                    //         data.delete(idd);
                    //         bandera3 = false;
                    //     } catch (Exception e) {
                    //         input.nextInt();
                    //         System.out.print("Id invalido");
                    //         bandera3 = true;
                    //     }
                    // }while (bandera3);
                    
                    break;
                case 4:
                    System.out.println("get persona ");
                    boolean bandera4 = true;
                    do{
                        System.out.print("id: ");
                        try{
                            Person d = data.get(input.nextInt());
                            if (d != null) {
                                System.out.println("Id: " + d.getId());
                                System.out.println("Name: " + d.getName());
                            }else{
                                System.out.println("Id no found");
                            }
                            bandera4 = false;
                        } catch (Exception e) {
                            input.nextLine(); // Limpiar el buffer
                            System.out.print("Id invalido \n");
                            bandera4 = true;
                        }
                    } while (bandera4);

                    break;

                case 5:
                    System.out.println("update persona ");
                    boolean bandera = true;
                    do {
                        System.out.print("id: ");
                        try {
                            Person per = data.get(input.nextInt());
                            if (per != null) {
                                System.out.println("Name current: " + per.getName());
                                System.out.println("Sex current: "+per.getSex());

                                input.nextLine(); // Limpiar el buffer
                                System.out.print("new name: ");
                                per.setName(input.nextLine());
                                
                                System.out.print("new sex: ");
                                per.setSex(input.nextLine());
                                data.update(per);
                            }
                            bandera = false;
                        } catch (Exception e) {
                            input.nextLine(); // Limpiar el buffer
                            System.out.print("Id invalido \n");
                            bandera = true;
                        }
                    } while (bandera); 

                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        } while (opt != 0);
    }
}
