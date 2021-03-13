class Solution {
  
    public class Room {
     int locked; // -1 representes unlocked, 0 to Java.Max = key Id;
     List<Room> children; //represents the 1 to n rooms accessible from the current room.
     boolean hasTreasure; //true = has treasure
     int hasKey; //-1 = no key, 0 to Java.max = keyId 
    }
    
    public static void main(String[] args) {
  
    }
    // O(V+E) where v = # of rooms in total and e = # of room connections
    
    // O(v+ v+v) -> O(V)
    
    public boolean canFindTreasure(Room initial) {
      HashMap<Integer, Room> listOfKeys = new HashMap<>(); [1 -> Room1, 3->room3]
      HashSet<Integer> unusedKeyList = new HashSet<>(); //2
      Queue<Room> line = new ArrayList<>(); //0
      line.add(initial);
      while(!line.isEmpty()) {
        Room current = line.poll(); //  -1 ->treasure
        if (current.hasTreasure) {
         return true; 
        }
        if (current.hasKey != -1) { 
          if (listOfKeys.hasKey(current.hasKey)) {
            line.add(listOfKeys.get(current.hasKey)); 
          }
          else {
            unusedKeyList.add(current.hasKey); 
          }
        }
        for (int i = 0; i < current.children.size(); i++) {
          Room child = current.children.get(i);
          if (child.locked != -1) {
           if (unusedKeyList.contains(child.locked)) {
              line.add(child); 
           }
           else {
            listOfKeys.put(child.locked, child); 
           }
          }
          else {
           line.add(child); 
          }
        }
      }
      return false;
    }
  }