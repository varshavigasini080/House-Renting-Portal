import java.util.*;

public class Main {
    public static void main(String[] args){
        Owner owner = new Owner();
        owner.rentalDetails();
        Approver apr = new Approver();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to House Rental Portal!");
        while(true){
            System.out.println("Select Options:\n 1.User\n 2.Owner\n 3.Approver\n 4.Exit");
            int option=sc.nextInt();
            if(option==4){
                break;
            }
            switch(option){
                case 1:{
                    System.out.println("Enter userid");
                    String userid=sc.next();
                    while(true){
                    System.out.println("Available Houses For Rent");
                    owner.displayHouses();
                    System.out.println("Select Options:\n 1.Rent a house\n 2.Check Status\n 3.View History\n 4.Exit");
                    String optFlag=sc.next();
                    if(optFlag.equals("1")){
                        System.out.println("Which city?");
                        String city = sc.next();
                        owner.displayHouseBasedOnCity(city);
                        System.out.println("Select OwnerId to rent the house");
                        String ownId=sc.next();
                        owner.updateRequest(ownId,userid);
                        System.out.println("Your request has been sent successfully!");
                    }
                    

                    else if(optFlag.equals("2")){
                            System.out.println("Enter your Owner Id");
                            String oid=sc.next();
                            owner.showStatus(oid);
                    }
                    else if(optFlag.equals("3")){
                        System.out.println("Your History");
                        owner.displayHistory();
                    }
                    else if(optFlag.equals("4")){
                        System.out.println("You are logged out successfully");
                        break;
                    }
                    }
                    break;
                
                }
                
                case 2:{
                    System.out.println("Enter your Owner Id");
                    String ownid=sc.next();
                    while(true){
                        System.out.println("Select option\n 1.View your houses\n 2.Add a house\n 3.View Requests\n 4.Exit");
                        int ownerOptions=sc.nextInt();
                        if(ownerOptions==1){
                            owner.displayOwnerHouse(ownid);
                        }
                        else if(ownerOptions==2){
                            System.out.println("Specify your house details in below order");
                            System.out.println("Locality-City-Sqrft-Type-RentAmount-OwnerId");
                            String sttr= sc.next();
                            String [] hl = sttr.split("-");
                            ArrayList<String> addHouseList= new ArrayList<>(Arrays.asList(hl));
                            addHouseList.add("0");
                            addHouseList.add("0");
                            apr.houseList.add(addHouseList);
                            System.out.println("House will be added after verification by approver");
                            
                        }
                        else if(ownerOptions==3){
                            owner.viewAndApproveRequest(ownid);
                        }
                        else if(ownerOptions==4){
                            System.out.println("You are logged out successfully");
                            break;
                        }
                    }
                    break;
                    
                }
                case 3:{
                    while(true){
                        System.out.println("Select option\n 1.View request\n 2.Approve Request\n 3.Exit");
                        int aprOption=sc.nextInt();
                        if(aprOption==1){
                            apr.displayHouseReqApr();
                        }
                        else if(aprOption==2){
                            apr.approveHouse();
                        }
                        else if(aprOption==3){
                            System.out.println("You are logged out successfully");
                            break;
                        }
                    }
                    break;
                }
                


            }
          
        }
    }
    
}