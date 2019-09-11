import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner scan = new Scanner(System.in);

    public void operations(){
        System.out.println("phone search\n" +
                " available operations: \n" +
                " 1 add a number\n" +
                " 2 search for a number\n" +
                " 3 search for a person by phone number\n" +
                " 4 add an address\n" +
                " 5 search for personal information\n" +
                " 6 delete personal information\n" +
                " 7 filtered listing\n" +
                " x quit\n");
    }

    public void command(){
        PersonDirectory pd = new PersonDirectory();

        while(true){
            System.out.print("command: ");
            String command = scan.nextLine();

            if(command.equals("1")){
                System.out.print("whose number: ");
                String name = scan.nextLine();
                System.out.print("number: ");
                String num = scan.nextLine();
                pd.addPhoneNumber(name, num);
                System.out.println();
            }

            if(command.equals("2")){
                System.out.print("whose number: ");
                String name = scan.nextLine();
                if(pd.getPhoneNumbers(name) != null){
                    pd.printPhoneNumbers(pd.getPhoneNumbers(name));
                } else {
                    System.out.println(" not found");
                }
                System.out.println();
            }

            if(command.equals("3")){
                System.out.print("number: ");
                String number = scan.nextLine();
                if(pd.getNameBasedOnNumber(number) == null){
                    System.out.println(" not found");
                } else {
                    System.out.println(" " + pd.getNameBasedOnNumber(number));
                }
                System.out.println();
            }

            if(command.equals("4")){
                System.out.print("whose address: ");
                String name = scan.nextLine();
                System.out.print("street: ");
                String addressStreet = scan.nextLine();
                System.out.print("city: ");
                String addressCity = scan.nextLine();
                String fullAddress = addressStreet + " " + addressCity;
                pd.setAddress(name, fullAddress);
                System.out.println();
            }

            if(command.equals("5")){
                System.out.print("whose information: ");
                String name = scan.nextLine();
                pd.printAllInformation(name);
                System.out.println();
            }

            if(command.equals("6")){
                System.out.print("whose information: ");
                String name = scan.nextLine();
                pd.deleteInfo(name);
                System.out.println();
            }

            if(command.equals("7")){
                System.out.print("keyword (if empty, all listed): ");
                String keyword = scan.nextLine();
                System.out.println();
                ArrayList<String> namesFound = pd.searchNames(keyword);
                for(String name : namesFound){
                    System.out.println(name);
                    pd.search(name);
                    System.out.println();
                }
                System.out.println();
            }
        }
    }

}
