import java.util.InputMismatchException;
import java.util.Scanner;

import data.Conn;
import data.PersonData;
import data.ItemsData;
import entities.Person;
import entities.Items;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opt = 0;

        do {
            System.out.println("***** CRUD MENU *****");
            System.out.println("1 CRUD PERSON");
            System.out.println("2 CRUD ITEMS");
            System.out.println("0 Exit ");
            System.out.println("Choice option: ");
            opt = input.nextInt();
            System.out.println("You chosed: " + opt);
            input.nextLine(); // Limpiar el buffer
            
            switch (opt) {
                case 1:
                    PersonData data = new PersonData();
                    int son = 0;
        
                    do {
                        System.out.println("***** CRUD PERSON *****");
                        System.out.println("1 List ");
                        System.out.println("2 New ");
                        System.out.println("3 Delete ");
                        System.out.println("4 Get byID ");
                        System.out.println("5 Update ");
                        System.out.println("0 Exit ");
                        System.out.println("Choice option: ");
                        son = input.nextInt();
                        System.out.println("You chosed: " + son);
                        input.nextLine(); // Limpiar el buffer
                        switch (son) {
                            case 1:
                                System.out.println("Listado de personas ");
                                for (Person d : data.list("")) {
                                    System.out.println(d.getId() + "\t" + d.getName() + "\t" + d.getSex() + "\t" + d.getAge());
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
                                System.out.print("id: ");
                                data.delete(input.nextInt());
                                break;
                            case 4:
                                int b4 = 1;
                                do {
                                    System.out.println("get persona ");
                                    System.out.print("id: ");
                                    int id = 0;
                                    try {
                                        b4 = 0;
                                        id = input.nextInt();
                                        Person d = data.get(id);
                                        if (d != null) {
                                            System.out.println("ID" + "\t" + "NAME" + "\t" + "SEXO" + "\t" + "AGE" + "\t" + "NATIONALITY");
                                            System.out.println(d.getId() + "\t" + d.getName() + "\t" + d.getSex() + "\t" + d.getAge());
                                        } else {
                                            System.out.print("la person no existe");
                                        }
                                    } catch (Exception e) {
                                        input.nextLine(); // Limpiar el buffer
                                        System.out.print("id no valido, debe ser un numero");
                                        b4 = 1;
                                    }

                                } while (b4 != 0);

                                break;
                            case 5:
                                System.out.println("update persona ");
                                System.out.print("id: ");

                                Person per = data.get(input.nextInt());

                                if (per != null) {
                                    System.out.println("Name current: " + per.getName());
                                    System.out.println("Sex current: " + per.getSex());

                                    input.nextLine(); // Limpiar el buffer
                                    System.out.print("new name: ");
                                    per.setName(input.nextLine());

                                    System.out.print("new sex: ");
                                    per.setSex(input.nextLine());

                                    System.out.print("edad: ");
                                    try {
                                        per.setAge(input.nextInt());
                                        data.update(per);
                                    } catch (Exception e) {
                                        // per.setAge(0);
                                        input.nextLine(); // Limpiar el buffer
                                        System.out.print("Option not valid");
                                    }
                                } else {
                                    System.out.println("NOT FOUND");
                                }

                                break;

                            default:
                                System.out.println("Option not valid");
                        }
                    } while (son != 0);
        
                    break;




                case 2:
                    ItemsData dataI = new ItemsData();
                    int it = 0;

                    do {
                        System.out.println("***** CRUD ITEMS *****");
                        System.out.println("1 Listing ");
                        System.out.println("2 New ");
                        System.out.println("3 Delete ");
                        System.out.println("4 Get byID ");
                        System.out.println("5 Update ");
                        System.out.println("0 Exit ");
                        System.out.println("Choice option: ");
                        it = input.nextInt();
                        System.out.println("You chosed: " + it);
                        input.nextLine(); // Limpiar el buffer
                        switch (it) {
                            case 1:
                                System.out.println("Product listing ");
                                System.out.println("ID" + "\t" + "NOMBRE" + "\t" + "CATEGORIA" + "\t" + "FAMILIA" + "\t" + "PRECIO");
                                for (Items d : dataI.list("")) {
                                    System.out.println(d.getId() + "\t" + d.getNombre() + "\t" + d.getCategoria() + "\t" + "\t" + d.getFamilia() + "\t" +  d.getPrecio());
                                }
                                break;

                            case 2:
                                System.out.println("New item ");
                                Items p = new Items();
                                System.out.print("Name: ");
                                p.setNombre(input.nextLine());
                                System.out.print("Categoria: ");
                                p.setCategoria(input.nextLine());
                                System.out.print("Familia: ");
                                p.setFamilia(input.nextLine());

                                boolean bandera02 = true;
                                do {
                                    System.out.print("Precio: ");
                                    try {
                                        p.setPrecio(input.nextInt());
                                        dataI.create(p);
                                        bandera02 = false;
                                    } catch (Exception e) {
                                        input.nextLine(); // Limpiar el buffer
                                        System.out.print("Debe ser numero");
                                        bandera02 = true;
                                    }

                                }while (bandera02);

                                break;

                            case 3:
                                System.out.println("Delete");
                                System.out.print("Id : ");
                                dataI.delete(input.nextInt());

                                break;

                            case 4:
                                int b4 = 1;
                                do {
                                    System.out.println("Get");
                                    System.out.print("Id: ");
                                    int id = 0;
                                    try {
                                        b4 = 0;
                                        id = input.nextInt();
                                        Items d = dataI.get(id);
                                        if (d != null) {
                                            System.out.println("ID" + "\t" + "NOMBRE" + "\t" + "CATEGORIA" + "\t" + "FAMILIA" + "\t" + "PRECIO");
                                            System.out.println(d.getId() + "\t" + d.getNombre() + "\t" + d.getCategoria() + "\t" + d.getFamilia() + "\t" +  d.getPrecio());
                                        } else {
                                            System.out.print("The item not exist");
                                        }
                                    } catch (Exception e) {
                                        input.nextLine(); // Limpiar el buffer
                                         System.out.print("Id not valid, enter number");
                                        b4 = 1;
                                    }

                                } while (b4 != 0);

                                break;
                            case 5:
                                System.out.println("update");
                                System.out.print("id: ");
                
                                Items ite = dataI.get(input.nextInt());
                
                                if (ite != null) {
                                    System.out.println("Nombre current: " + ite.getNombre());
                                    System.out.println("Categoria current: " + ite.getCategoria());
                                    System.out.println("Familia current: " + ite.getFamilia());
                
                                    input.nextLine(); // Limpiar el buffer
                                    System.out.print("new nombre: ");
                                    ite.setNombre(input.nextLine());
                
                                    System.out.print("new categoria: ");
                                    ite.setCategoria(input.nextLine());

                                    System.out.print("new familia: ");
                                    ite.setFamilia(input.nextLine());
                
                                    System.out.print("precio: ");
                                    try {
                                        ite.setPrecio(input.nextInt());
                                        dataI.update(ite);
                                    } catch (Exception e) {
                                        // per.setAge(0);
                                        input.nextLine(); // Limpiar el buffer
                                        System.out.print("Debe der numero");
                                    }
                
                                } else {
                                    System.out.println("NO encontrado");
                                }

                                break;

                            default:
                                System.out.println("NOT FOUND");
                        }
                    } while (it!= 0);  
                default:
                System.out.println("Opcion no valida");
            }
        
        
        } while (opt != 0);                     

    }     
}
