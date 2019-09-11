import java.util.*;

public class PersonDirectory {
    public ArrayList<String> people;
    public Map<String, String> nameByNumber;
    public Map<String, Set<String>> numberByName;
    public Map<String, String> addressByName;
    public Map<String, String> nameByAddress;


    public PersonDirectory(){
        this.people = new ArrayList<>();
        this.nameByNumber = new HashMap<>();
        this.numberByName = new HashMap<>();
        this.addressByName = new HashMap<>();
        this.nameByAddress = new HashMap<>();
    }

    public void addPhoneNumber(String name, String num){
        this.people.add(name);
        if(!this.numberByName.containsKey(name)){
            this.numberByName.put(name, new HashSet<>());
        }
        if(!this.nameByNumber.containsKey(num)){
            this.nameByNumber.put(num, name);
        }
        this.numberByName.get(name).add(num);
    }

    public void setAddress(String name, String address){
        if(!this.addressByName.containsKey(name)){
            this.addressByName.put(name, address);
        }
        if(!this.nameByAddress.containsKey(address)){
            this.nameByAddress.put(address, name);
        }
    }

    public Set<String> getPhoneNumbers(String name){
        return this.numberByName.get(name);
    }

    public String getNameBasedOnNumber(String num){
        return this.nameByNumber.get(num);
    }

    public String getAddress(String name){
        return this.addressByName.get(name);
    }

    public void printPhoneNumbers(Set<String> nums){
        for(String num: nums){
            System.out.println(" " + num);
        }
    }

    public void deleteInfo(String name){
        Set<String> numbersOfPerson = getPhoneNumbers(name);
        for(String num: numbersOfPerson){
            this.nameByNumber.remove(num);
        }
        String address = this.addressByName.get(name);
        this.nameByAddress.remove(address);
        this.numberByName.remove(name);
        this.addressByName.remove(name);
        this.people.remove(name);
    }

    public void printAllInformation(String name){
        if(getAddress(name) != null && getPhoneNumbers(name) != null){
            System.out.println(" address: " + getAddress(name));
            System.out.println(" phone numbers: ");
            printPhoneNumbers(getPhoneNumbers(name));

        } else if(getAddress(name) == null && getPhoneNumbers(name) != null){
            System.out.println(" address unknown");
            System.out.println(" phone numbers: ");
            printPhoneNumbers(getPhoneNumbers(name));

        } else if(getPhoneNumbers(name) == null && getAddress(name) != null){
            System.out.println(" address: " + getAddress(name));
            System.out.println(" phone number not found");

        } else {
            System.out.println(" not found");
        }
    }


// search methods
    private String searchAddress(String keyword){
        String found = "";
        for(String address: nameByAddress.keySet()){
            if(address.indexOf(keyword) >= 0){
                found = nameByAddress.get(address);
            }
        }
        return found;
    }

    public ArrayList<String> searchNames(String keyword){
        ArrayList<String> found = new ArrayList<String>();
        for (String name : people) {
            if (name.indexOf(keyword) >= 0){
                found.add(name);
            } else {
                found.add(searchAddress(keyword));
            }
        }
        return found;
    }

    public void search(String name){
        printAllInformation(name);
    }
}
