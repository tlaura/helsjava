import java.util.*;

public class PersonDirectory {

    private Map<String, Set<String>> numberByName;
    private Map<String, String> nameByNumber;
    private Map<String, String> addressByName;

    public PersonDirectory() {
        this.numberByName = new HashMap<>();
        this.nameByNumber = new HashMap<>();
        this.addressByName = new HashMap<>();
    }

    public void addPhoneNumber(String name, String number) {
        if (!numberByName.containsKey(name)) {
            numberByName.put(name, new HashSet<>());
        }
        if (!nameByNumber.containsKey(number)) {
            nameByNumber.put(number, name);
        }
        numberByName.get(name).add(number);
    }

    public void searchNumber(String name) {
        if (numberByName.containsKey(name)) {
            for (String number : numberByName.get(name)) {
                System.out.println(" " + number);
            }
        } else {
            System.out.println(" not found");
        }
    }

    public void searchNameByNumber(String number){
        if(nameByNumber.containsKey(number)){
            System.out.println(" " + nameByNumber.get(number));
        } else {
            System.out.println(" not found");
        }
    }

    public void addAddress(String name, String address){
        if(!addressByName.containsKey(name)){
            addressByName.put(name, address);
        }
    }

    public void searchPersonalInfo(String name){
        if(!addressByName.containsKey(name) && !numberByName.containsKey(name)){
            System.out.println("  not found");
        } else {
            if(addressByName.containsKey(name)){
                System.out.println("  address: " + addressByName.get(name));
            } else {
                System.out.println("  address unknown");
            }
            if(numberByName.containsKey(name)){
                System.out.println("  phone numbers:");
                for(String number: numberByName.get(name)){
                    System.out.println("   " + number);
                }
            } else {
                System.out.println("  phone number not found");
            }
        }
    }

    public void deletePersonalInfo(String name){
//        first delete phone numbers with numberByName map
        if(numberByName.containsKey(name)){
            for(String number: numberByName.get(name)){
                nameByNumber.remove(number);
            }
            numberByName.remove(name);
        }

        if(addressByName.containsKey(name)){
            addressByName.remove(name);
        }
    }

    public void filteredSearch(String keyword){
        TreeMap<String, String> addressByNameSorted = new TreeMap<>(addressByName);
        boolean found = false;

        for(String name: addressByNameSorted.keySet()){
            if(name.contains(keyword) ||
                    (addressByName.containsKey(name) && addressByName.get(name).contains(keyword))){
                System.out.println("\n " + name);
                searchPersonalInfo(name);
                found = true;
            }
        }
        if(!found){
            System.out.println(" keyword not found");
        }
    }
}
