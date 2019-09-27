import java.util.Scanner;

public class App {
    Scanner scan = new Scanner(System.in);
    PersonDirectory pd = new PersonDirectory();

    public void start() {
        operations();
        command();
    }

    public void operations(){
        System.out.println("phone search\n" +
                "available operations:\n" +
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
        boolean quit = false;
        while(!quit) {
            System.out.print("\ncommand: ");
            String command = scan.nextLine();
            switch (command) {
                case "x":
                    quit = true;
                    break;
                case "1":
                    addNumber();
                    break;
                case "2":
                    searchNumber();
                    break;
                case "3":
                    searchPersonByNumber();
                    break;
                case "4":
                    addAddress();
                    break;
                case "5":
                    searchPersonalInfo();
                    break;
                case "6":
                    deletePersonalInfo();
                    break;
                case "7":
                    filteredSearch();
                    break;
            }
        }
    }

    private void addNumber() {
        System.out.print("whose number: ");
        String name = scan.nextLine();
        System.out.print("number: ");
        String number = scan.nextLine();
        pd.addPhoneNumber(name, number);
    }

    private void searchNumber(){
        System.out.print("whose number: ");
        String name = scan.nextLine();
        pd.searchNumber(name);
    }

    private void searchPersonByNumber(){
        System.out.print("number: ");
        String number = scan.nextLine();
        pd.searchNameByNumber(number);
    }

    private void addAddress(){
        System.out.print("whose address: ");
        String name = scan.nextLine();
        System.out.print("street: ");
        String street = scan.nextLine();
        System.out.print("city: ");
        String city = scan.nextLine();
        String address = street + " " + city;
        pd.addAddress(name, address);
    }

    private void searchPersonalInfo(){
        System.out.print("whose information: ");
        String name = scan.nextLine();
        pd.searchPersonalInfo(name);
    }

    private void deletePersonalInfo(){
        System.out.print("whose information: ");
        String name = scan.nextLine();
        pd.deletePersonalInfo(name);
    }

    private void filteredSearch(){
        System.out.print("keyword (if empty, all listed): ");
        String keyword = scan.nextLine();
        pd.filteredSearch(keyword);
    }
}
