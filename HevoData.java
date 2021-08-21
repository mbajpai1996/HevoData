import java.util.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;


class Service{

    public class Message{
        Integer msgID;
        String mode;
        String userId;
        String phoneNo;
        String emailID;
        String msg;
        Timestamp msgTime;
           }

    class Client{
        HashMap<Integer,Message> MsgMap;


    }

    static HashMap<String,Client> clientMap;


    void sendNotification(String clientId,Integer mID,String Msg,String Mb,String email,Timestamp t1){

        if(clientMap.containsKey(clientId)){
            Client cl= clientMap.get(clientId);
            Message m= new Message();
            m.msgID=mID;
            m.msg=Msg;
            m.phoneNo=Mb;
            m.emailID=email;
            m.msgTime=t1;

            cl.MsgMap.put(mID,m);

        }
        else{
            Client cl = new Client();
            cl.MsgMap =new HashMap<>();

            Message m= new Message();
            m.msgID=mID;
            m.msg=Msg;
            m.phoneNo=Mb;
            m.emailID=email;
            m.msgTime=t1;
            cl.MsgMap.put(mID,m);

            clientMap.put(clientId,cl);

        }


    }



}

public class HevoData {
    static Integer msgCounter;



    public static void main(String args[]) {
      msgCounter=0;
      Service server=new Service();
      server.clientMap=new HashMap<>();
      System.out.println("executing sample Test");
      String clientId="CX8291";
      String Msg1="Order Created";
      String Mb1="9000000001";
      String email1="";
      Date date = new java.util.Date();
	  Timestamp timestamp1 = new Timestamp(date.getTime());
      Calendar cal = Calendar.getInstance();
	  cal.setTimeInMillis(timestamp1.getTime());
      msgCounter++;
      server.sendNotification(clientId,msgCounter,Msg1,Mb1,email1,timestamp1);

      String Msg2="Order Shipped";
      String Mb2="9000000002";
      String email2="";
      Timestamp timestamp2= new Timestamp(date.getTime());
      cal.setTimeInMillis(timestamp2.getTime());
      msgCounter++;

      server.sendNotification(clientId,msgCounter,Msg2,Mb2,email2,timestamp2);

      String Msg3="Order Cancelled";
      String Mb3="9000000003";
      String email3="bazinga@bbt.com";
      Timestamp timestamp3= new Timestamp(date.getTime());
      cal.setTimeInMillis(timestamp3.getTime());
      msgCounter++;

      server.sendNotification(clientId,msgCounter,Msg3,Mb3,email3,timestamp3);

      String Msg4="Order Updated";
      String Mb4="911";
      String email4="";
      Timestamp timestamp4= new Timestamp(date.getTime());
      cal.setTimeInMillis(timestamp4.getTime());
      msgCounter++;

      server.sendNotification(clientId,msgCounter,Msg4,Mb4,email4,timestamp3);
      cal.add(Calendar.SECOND, 120);

      String Msg5="Order Created";
      String Mb5="9000000001";
      String email5="";
	  Timestamp timestamp5 = new Timestamp(date.getTime());
	  cal.setTimeInMillis(timestamp5.getTime());
      msgCounter++;
      server.sendNotification(clientId,msgCounter,Msg5,Mb5,email5,timestamp5);

      String clientId2="CX8292";
      String Msg6="Order Cancelled";
      String Mb6="9000000004";
      String email6="aazingb@bbt.com";
      Timestamp timestamp6= new Timestamp(date.getTime());
      cal.setTimeInMillis(timestamp6.getTime());
      msgCounter++;

      server.sendNotification(clientId2,msgCounter,Msg6,Mb6,email6,timestamp6);

      String clientId3="CX8293";
      String Msg7="Order created";
      String Mb7="9000000005";
      String email7="cazinga@bbt.com";
      Timestamp timestamp7= new Timestamp(date.getTime());
      cal.setTimeInMillis(timestamp7.getTime());
      msgCounter++;

      server.sendNotification(clientId3,msgCounter,Msg7,Mb7,email7,timestamp7);

      //server.getStatistics();

      //server.fetchMessages(cleintId,3);


    }
}