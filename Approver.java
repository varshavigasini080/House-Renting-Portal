import java.util.*;
public class Approver {
    List<ArrayList<String>> houseList = new ArrayList<>();
    Owner owner = new Owner();
    public void approveHouse(){
        if(houseList.isEmpty()){
            System.out.println("No Requests");
        }
        else{
            for(ArrayList<String> housee : houseList){
                ArrayList<String> addHouse= new ArrayList<>(housee);
                owner.houses.add(addHouse);
                System.out.println(addHouse);
                System.out.println(owner.houses.get(owner.houses.size()-1));

            }
            System.out.println("Status: Approved\nHouse added");
            houseList.clear();
        }
        
    }
    public void displayHouseReqApr(){
        if(houseList.isEmpty()){
            System.out.println("No Requests");
        }
        else{
            System.out.println("Locality-City-Sqrft-Type-RentAmount-OwnerId");
            for(ArrayList<String> values : houseList){
                for(int i=0;i<houseList.get(0).size()-2;i++){
                    System.out.print(values.get(i)+" ");
                }
                System.out.println();
            }
        }
        
    }
    public static void main(String[] args){
        
    }
    
}
