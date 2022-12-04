
import java.util.*;

public class Room {
    String name;
    List<RoomStructure> roomsList = new ArrayList<>();
    int roomNo;
    int seatingCapacity;
    public Room(int roomNo , int seatingCapacity){
        this.roomNo = roomNo;
        this.seatingCapacity = seatingCapacity;
    }

    public void showAllAvailableRooms(){
        for(RoomStructure room:  roomsList){
            int t=1;
            System.out.println("Room Number: " +room.name+"    Seating Capacity: "+ room.noOfSeats);
                 System.out.println("Slot No.\t\tSlot Time");
            for(Map.Entry<String, User> slot: room.slots.entrySet()){
                if(slot.getValue()==null)
                {System.out.println("\t"+t++ +"\t\t\t"+slot.getKey());}
                else {t++;}
            }    System.out.println("==============================================");
        }
    }

    public void showAllRooms(){
        for(RoomStructure room:  roomsList){
            int t=1;
            System.out.println("Room Number: " +room.name+"    Seating Capacity: "+ room.noOfSeats);
                 System.out.println("Slot No.\t\t\t\tSlot Time\t\t\t\tStatus");
            for(Map.Entry<String, User> slot: room.slots.entrySet()){
                if(slot.getValue()==null)
                {   System.out.println("\t"+t++ +"\t\t\t"+slot.getKey() + "\t\tAvailable");}
                else {
                    System.out.println("\t"+t++ +"\t\t\t"+slot.getKey() + "\talloted to " + slot.getValue().getName());
                }
            }
            System.out.println("==============================================");
        }
    }

    public void instantiate(){
        Calendar now = Calendar.getInstance();
        for(int j=0 ; j<4 ; j++){
            TreeMap<String,User> slotList = new TreeMap<>();
            for(int k=0;k<4;k++){   int t=4;
                for(int i =0 ; i<4 ;i++) {
                    slotList.put(String.valueOf(now.get(Calendar.DATE) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR))  +" "+ t+":00pm - "+(t++ +1)+":00pm", null);
                }   now.add(Calendar.DATE, 1);}
            roomsList.add(new RoomStructure(String.valueOf(this.roomNo++) , this.seatingCapacity ,slotList ));
            now = Calendar.getInstance();
        }

    }



}
