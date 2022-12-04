import java.util.List;

public class User {

   private String name;
   private String id;
   public String org ;
    public User(String name , String id, String org) {
        this.name= name;
        this.id= id;
        this.org = org ;
    }
    public User(String name , String id) {
        this.name= name;
        this.id= id;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int checkCapacity(int noOfStudents , int roomType){
        switch(roomType){
            case 1: if (noOfStudents > 60) { System.out.println("Out of capacity for Nab room");
               return 1; } break;
            case 2 : if(noOfStudents>150) { System.out.println("Out of capacity for Ltc hall");
                return 1;} break;
            case 3 : if(noOfStudents>25) { System.out.println("Out of capacity for library brainstorming room");
                return 1;} break;
        }
        return 0;
    }

    public void checkAvailabiity(Room room){
    room.showAllAvailableRooms();
    }

    public void makeRequest(List<BookingRequest> requestList, BookingRequest request){
        requestList.add(request);
    }

    public void updatePurpose(List<BookingRequest> requestList , String purpose) {
        for (BookingRequest request : requestList) {
            if (request.getUser().getName().equals(this.getName())) {
                request.setPurpose(purpose);
            }
        }
    }
    public void deleteRequest(List<BookingRequest> requestList){
        for (BookingRequest request : requestList) {
            if (request.getUser().getName().equals(this.getName())) {
                requestList.remove(request);
            }
    }}

    public void track(List<BookingRequest> requestList){
        for(BookingRequest request:requestList){
            if(request.getUser().getName().equals(this.getName())){
                if(request.isBookingStatus().equals("Approved"))
                    System.out.println(" Request Approved");
                else if(request.isBookingStatus().equals("Disapproved"))
                    System.out.println("Request not approved");
                else
                    System.out.println("Request not checked yet");
            }
        }
    }
}
