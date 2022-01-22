import controller.DriverController;
import controller.RouteController;
import entity.Route;
import helper.Helper;

public class Main {
    private static Helper helper=new Helper();
    private static DriverController driverController=new DriverController();
    private static RouteController routeController=new RouteController();
    public static void main(String[] args) {
          boolean run=true;
          do{
              helper.printMenu();
              int chose= helper.getInt(" ");
              switch(chose) {
                  case 1:
                      int chose_1;
                      do {
                          chose_1 = helper.getInt("Nhập lựa chọn:\n"
                                  + "[1] Thêm người lái.\n"
                                  + "[2] Xem danh sách người lái.\n"
                                  + "[3] Quay lại.\n"
                          );
                          if(chose_1>=1 && chose_1<=3){
                              break;
                          }
                          System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                      } while(true);
                      if(chose_1==1){
                          driverController.getInputListEntity();
                      }else if(chose_1==2){
                          driverController.printListData();
                      }else if(chose_1==3){
                          break;
                      }
                      boolean checkContinue_1= helper.askYesNo();
                      if(checkContinue_1){
                          break;
                      } else{run=false;}
                      break;
                  case 2:
                      int chose_2;
                      do {
                          chose_2 = helper.getInt("Nhập lựa chọn:\n"
                                  + "[1] Thêm tuyến đường.\n"
                                  + "[2] Xem danh sách tuyến đường.\n"
                                  + "[3] Quay lại.\n"
                          );
                          if(chose_2>=1 && chose_2<=3){
                              break;
                          }
                          System.out.println("Bạn phải nhập số nguyên từ 1 đến 3");
                      } while(true);
                      if(chose_2==1){
                          routeController.getInputListEntity();
                      }else if(chose_2==2){
                          routeController.printListData();
                      }else if(chose_2==3){
                          break;
                      }
                      boolean checkContinue_2= helper.askYesNo();
                      if(checkContinue_2){
                          break;
                      } else{run=false;}
                      break;

                  case 3:

                      break;

                  case 4:

                      break;
                  case 5:


                      break;

                  case 6:
                      run=false;
                      break;
                  default:
                      System.out.println("Bạn phải nhập số nguyên trong khoảng từ 1 đến 5");
              }
          }while(run);
        System.out.println("Đã thoát chương trình");
    }
}
