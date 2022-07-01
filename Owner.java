
import java.util.*;

public class Owner {
    static List<ArrayList<String>> houses = new ArrayList<>();
    List<ArrayList<String>> reqList = new ArrayList<>();
    Stack<String> history = new Stack<>();
    Scanner sc = new Scanner(System.in);
   
    public void rentalDetails(){
        
        houses.add( new ArrayList<>(Arrays.asList("Kodambakkam","Chennai","798","2BHK","Rs.6000/Month","1","0","0")));
        houses.add( new ArrayList<>(Arrays.asList("Goripalayam","Madurai","500","1BHK","Rs.5500/Month","2","0","0")));
        houses.add( new ArrayList<>(Arrays.asList("Anna Nagar","Chennai","1208","3BHK","Rs.15000/Month","3","0","0")));

    }
    public void displayHistory(){
        if(history.empty()){
            System.out.println("No history of rentals");
        }
        else{
           System.out.println(Arrays.toString(history.toArray()));
        }
       
    }
    public void displayHouses(){
        System.out.println("Locality-City-Sqrft-Type-RentAmount-OwnerId");
        for(ArrayList<String> values : houses){
            for(int i=0;i<houses.get(0).size()-1;i++){
                System.out.print(values.get(i)+" ");
            }
            System.out.println();
        }

    }
    public void displayHouseBasedOnCity(String city){
        System.out.println("Locality-City-Sqrft-Type-RentAmount-OwnerId");
        for(ArrayList<String> values : houses){
            if(values.get(1).equalsIgnoreCase(city)){
                for(int i=0;i<houses.get(0).size()-1;i++){
                    System.out.print(values.get(i)+" ");
                }
                System.out.println();

            }
        }
    }
    public void updateRequest(String ownId,String userid){
        for(ArrayList<String> values : houses){
            if(values.get(5).equals(ownId)){
                values.set(6,"1");
                ArrayList<String> temp= new ArrayList<>(values);
                values.add(userid);
                reqList.add(temp);
            }
        }
    }
    public void showStatus(String ownId){
        for(ArrayList<String> values : houses){
            if(values.get(5).equals(ownId)){
                if(values.get(7).equals("1")){
                    System.out.println("Request Accepted!\nYour owner will contact you shortly..");
                }
                else{
                    System.out.println("Request Not Accepted");
                }
            }
        }
    }
    public void displayOwnerHouse(String ownid){
        System.out.println("Locality-City-Sqrft-Type-RentAmount-OwnerId");
        for(ArrayList<String> values : houses){
            if(values.get(5).equals(ownid)){
                for(int i=0;i<houses.get(0).size()-1;i++){
                    System.out.print(values.get(i)+" ");
                }
                System.out.println();

            }
        }
    }

    public void viewAndApproveRequest(String ownid){
        if(reqList.isEmpty()){
            System.out.println("No Requests");
        }
        else{
        for(ArrayList<String> values : reqList){
            System.out.println(values);
            System.out.println("Do you want to accept the request? y/n");
            String reqFlag=sc.next();
            if(reqFlag.equalsIgnoreCase("y")){
                approveRequest(ownid, values.get(reqList.size()-1));
            } 

          }

          reqList.clear();
        }
    }

    public void approveRequest(String ownid,String userid){
        for(ArrayList<String> values : houses){
            if(values.get(5).equals(ownid)){
                values.set(7,"1");
                String str="Locality:"+values.get(0);
                System.out.println(str);
                history.push(str);
            }
        }
    }
    public static void main(String[] args){
       
    }
    
}
