import data.PersonData;
import entities.Person;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonData personData = new PersonData();
        boolean var = true;
        while (var) {
            System.out.println("1.- List\n" +
                    "2.- Create\n" +
                    "3.- Get\n" +
                    "4.- Update\n" +
                    "5.- Remove\n" +
                    "6.- Exit\n");
            System.out.print("Enter: ");
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    for (Person p: personData.list()) {
                        System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getAge() + "\t" + p.getSex() + "\t" + p.getCountry());
                    }
                    System.out.println("");
                    break;
                case "2":
                    Person p = new Person();
                    System.out.print("Enter name: ");
                    p.setName(sc.nextLine());
                    System.out.print("Enter age: ");
                    try {
                        p.setAge(sc.nextInt());
                        sc.nextLine();
                    } catch (Exception e) {
                        sc.nextLine();
                        System.out.print("The age Integer");
                    }
                    System.out.print("Enter sex: ");
                    p.setSex(sc.nextLine());
                    System.out.print("Enter country: ");
                    p.setCountry(sc.nextLine());
                    personData.create(p);
                    break;
                case "3":
                    System.out.print("Enter the id: ");
                    int id = sc.nextInt();
                    Person person = personData.get(id);
                    System.out.println(person.getId() + "\t" + person.getName() + "\t" + person.getAge() + "\t" + person.getSex() + "\t" + person.getCountry());
                    sc.nextLine();
                    break;
                case "4":
                    System.out.print("Enter the id: ");
                    Person person1 = personData.get(sc.nextInt());
                    if (person1 != null) {
                        sc.nextLine();
                        System.out.print("new name: ");
                        person1.setName(sc.nextLine());
                        System.out.print("new age: ");
                        try {
                            person1.setAge(sc.nextInt());
                            sc.nextLine();
                        } catch (Exception e) {
                            sc.nextLine();
                            System.out.print("The age Integer");
                        }
                        System.out.print("new sex: ");
                        person1.setSex(sc.nextLine());
                        System.out.print("new country: ");
                        person1.setCountry(sc.nextLine());
                        personData.update(person1);
                    } else {
                        System.out.println("Not results");
                    }
                    break;
                case "5":
                    System.out.print("Enter id remove: ");
                    personData.delete(sc.nextInt());
                    System.out.println("The delete successfully!");
                    sc.nextLine();
                    break;
                case "6":
                    var = false;
                    break;
            }
        }
    }
}