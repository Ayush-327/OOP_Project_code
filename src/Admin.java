import java.util.*;

public class Admin {
    String name;
String password;
    public Admin(){
        this.name = "ADMIN";
        this.password = "admin";
    }

    public void getAllRequests(List<BookingRequest> requests) {
        for (BookingRequest request: requests) {
            if (request.isBookingStatus() == null) {
                request.printBookingDetails();
                System.out.println("---------------------------------------------");
            }
        }
    }

        public void bookRoom(int requestNo , int action ) {
            BookingRequest request = null;
            for (BookingRequest eachRequest : Main.requestList) {
                if (eachRequest.getRequestNo() == requestNo) {
                    request = eachRequest;
                    break;
                }
            }
            Room room = null;
            switch (request.getRoomType()) {
                case 1:
                    room = Main.nab;
                    break;
                case 2:
                    room = Main.ltc;
                    break;
                case 3:
                    room = Main.lib;
                    break;
            }

            Calendar now = Calendar.getInstance();


            String slotName = BookingRequest.slotName(request.getSlotNo());


            if (action == 1) {
                int booked = 0;
                for (RoomStructure eachRoom : room.roomsList) {
                    if (eachRoom.slots.get(slotName) == null && booked == 0 && request.isBookingStatus().equals("") ) {
                        booked = 1;
                        eachRoom.slots.put(slotName, request.getUser());
                        request.setBookingStatus("Approved");
                        request.setAdminRemark("Request Approved." );
                        request.setRoomAlloted(Integer.parseInt(eachRoom.name));
                        System.out.println("Request approved successfully");
                        System.out.println("Alloted room no. "+ Integer.parseInt(eachRoom.name) + " to "+ request.getUser().getName());
                    }
                }
            }

            else if(action==2){
                request.setBookingStatus("Disapproved");
                request.setAdminRemark("Request disapproved." );
                System.out.println("Request disapproved successfully");
            }

            else if(action==3) {
                System.out.println("Enter remark");
                Scanner sc = new Scanner(System.in);
                String remark = sc.nextLine();
                request.setAdminRemark(remark); }
        }

    public void showARequest(List<BookingRequest> requests , int requestNo){
        for (BookingRequest request: requests) {
            if(request.getRequestNo() == requestNo)
            { request.printBookingDetails(); break;}
        }
    }
}
