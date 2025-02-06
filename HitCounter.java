import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int numOfOperations = Integer.parseInt(scan.nextLine());
      
      HitCounter hitCounter = new HitCounter();
      
      while(numOfOperations > 0) {
        numOfOperations--;
        String[] input = (scan.nextLine()).trim().split("\\s+");
        String operation = input[0];
        int timestamp = Integer.parseInt(input[1]);
        if (operation.equals("hit")) {
          hitCounter.hit(timestamp);
        } else if (operation.equals("getHits")) {
          System.out.println(hitCounter.getHits(timestamp));
        } else {
          System.out.println("Invalid operation: " + operation);
        }
        
      }
  }
}

class HitCounter {
  
  Integer[] timestamp = new Integer[300];
  Integer[] hitCount = new Integer[300];
  // List<Integer> counterList;
  // private int getHitIndexAtOrBeforeTime(int time) {
  //   int low = 0, high = counterList.size()-1;
  //   int res = counterList.size();
  //   while(low <= high) {
  //     int mid = low + ((high-low)/2);
  //     if (counterList.get(mid) > time) {
  //       res = mid;
  //       high = mid-1;
  //     } else {
  //       low = mid+1;
  //     }
  //   }
  //   return res;
  // }
  
  //Queue<Integer>  q;
  
  public HitCounter() {
    //counterList = new ArrayList<>();
    //q = new ArrayDeque<>();

    for (int i=0; i<300; i++) {
      hitCount[i] = 0;
      timestamp[i] = -305;
    }
  }
  public void hit(int time) {
    //counterList.add(time);
    // q.add(time);
    // int expiredTime = time - 300;
    // while(!q.isEmpty() && q.peek() <= expiredTime) {
    //   q.remove();
    // }
    
    int index = time%300;
    if (timestamp[index] != time) {
      hitCount[index] = 1 ;
      timestamp[index] = time;
    } else {
      hitCount[index]++;
    }
  }
  
  public int getHits(int time) {
    // int index1 = getHitIndexAtOrBeforeTime(time);
    // int index2 = getHitIndexAtOrBeforeTime(time - 300);
    // return index1 - index2;
    //-------------------------------
    // int expiredTime = time - 300;
    // while(!q.isEmpty() && q.peek() <= expiredTime) {
    //   q.remove();
    // }
    // return q.size();
    int ans = 0;
    for (int i=0 ; i<300; i++) {
      if (time - timestamp[i] < 300) {
        ans+=hitCount[i];
      }
    }
    return ans;
  }
}
