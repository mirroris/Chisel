package track;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Manager {
  private Map<String, String> itemSelf;
  private Map<String, Integer> leastPrice; 
  private Map<String, Integer> mostPrice;
  private Map<String, Market> curMarket;
  private LinkedList<String> prevItem;
  private LinkedList<EndTime> endTime;
  private Time curTime;
  private int notSet = 10000000;

  public Manager(){
	  itemSelf = new HashMap<String, String>();
    leastPrice = new HashMap<String, Integer>();
    mostPrice = new HashMap<String, Integer>();
    curMarket = new HashMap<String, Market>();
    prevItem = new LinkedList<String>();
    endTime = new LinkedList<EndTime>();
    curTime = new Time(2023, 1, 1, 0, 0);
  }
  
  public void timeForward(Time toTime){
	    
		for (int i=0;i<endTime.size();i++) {
      EndTime et = endTime.removeFirst();
			Time t = et.getTime();
			String itemId = et.getId();
		  if (t.isEarlierthan(toTime)) {
        if(itemSelf.containsKey(itemId)) {
          Market cur = curMarket.get(itemId);
          String sbin;
          if(mostPrice.get(itemId)==notSet) sbin = "-";
          else sbin = String.valueOf(mostPrice.get(itemId));
          String owner;
          String price;
          if(cur.size()==0) {
        	  owner = "-";
        	  price = "-";
          }else {
        	  owner = cur.getCurOwner();
        	  price = String.valueOf(cur.getMaxPrice());
          }
          System.out.println("AUCTION_FINISHED: " + t.toFormat() + " " + itemId + " " + price + " " + sbin + " " + owner);
          itemSelf.remove(itemId);
        }
      }else break;
		}
    curTime = toTime;
  }

  public void sell(Time start, String usrId, String itemId, int minPrice, int binPrice, Time end){
	  timeForward(start);
    if(prevItem.contains(itemId)) {
    	System.out.println("SELL: this item_id is already in use");
    }else {
      itemSelf.put(itemId, usrId);
      leastPrice.put(itemId, minPrice);
      if(binPrice!=0) mostPrice.put(itemId, binPrice);
      else mostPrice.put(itemId, notSet);
      curMarket.put(itemId, new Market());
      int pos = 0;
      while(pos<endTime.size() && end.isEarlierthan(endTime.get(pos).getTime()))pos++;
      endTime.add(pos, new EndTime(itemId, end));
      prevItem.add(itemId);
    	System.out.println("SELL: accepted");
    }
  }

  public void sellCancel(Time reqTime, String usrId, String itemId) {
	  timeForward(reqTime);
	  if(!itemSelf.containsKey(itemId)) {
		  System.out.println("SELL_CANCEL: this item is currently not for sale");
	  }else {
      String seller = itemSelf.get(itemId);
      if(seller.equals(usrId)){
        itemSelf.remove(itemId);
        System.out.println("SELL_CANCEL: accepted");
      }else {
        System.out.println("SELL_CANCEL: user is not the seller of this item");
      }
    }
  }

  public void bid(Time reqTime, String usrId, String itemId, int reqPrice){
	  timeForward(reqTime);
    if(!itemSelf.containsKey(itemId)){
      System.out.println("BID: this item is currently not for sale");
    }else {
      String seller = itemSelf.get(itemId);
      if(seller.equals(usrId)){
        System.out.println("BID: user is the seller of this item");
      }else {
        int atLeast = leastPrice.get(itemId);
        if(atLeast>reqPrice){
          System.out.println("BID: the bid is lower than the minimum price");
        }else {
          int atMost = mostPrice.get(itemId);
          if(atMost<reqPrice){
            System.out.println("BID: the bid is higher than the BIN price");
          }else {
            Market cur = curMarket.get(itemId);
            if(cur.getCurPrice(usrId)>reqPrice){
              System.out.println("BID: the price must higher than the user's previous highest bid");
            }else {
            	cur.updatePrice(usrId, reqPrice);
              String sbin;
              if(atMost==notSet) sbin = "-";
              else sbin = String.valueOf(atMost);
            	System.out.println("BID: "+ cur.getMaxPrice() + " " + sbin + " " +cur.getCurOwner() );
              if(reqPrice==atMost){
                System.out.println("AUCTION_FINISHED: "+ reqTime.toFormat() + " " + itemId + " " +  atMost +  " " +atMost + " " + usrId);
                itemSelf.remove(itemId);
              }
            }
          }
        }
      }
    }
  }

  public void bidCancel(Time reqTime, String usrId, String itemId) {
	  timeForward(reqTime);
	  if(!itemSelf.containsKey(itemId)){
      System.out.println("BID_CANCEL: this item is currently not for sale");
    }else {
      Market cur = curMarket.get(itemId);
      if(!cur.contains(usrId)){
        System.out.println("BID_CANCEL: user has not bid on the item");
      }else {
          cur.cancel(usrId);
          String sbin;
          if(mostPrice.get(itemId)==notSet) sbin = "-";
          else sbin = String.valueOf(mostPrice.get(itemId));
          String owner;
          String price;
          if(cur.size()==0) {
        	  owner = "-";
        	  price = "-";
          }else {
        	  owner = cur.getCurOwner();
        	  price = String.valueOf(cur.getMaxPrice());
          }
          
        System.out.println("BID_CANCEL: " + price + " " + sbin + " " + owner);
      }
    }
  }

  public void finish(){
    timeForward(new Time(2023, 12, 31, 23, 59));
    return;
  }
}