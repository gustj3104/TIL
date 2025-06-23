import java.util.*;

class PG_오픈채팅방 {
  public String[] solution(String[] record) {
    HashMap<String, String> map = new HashMap<String, String>();
    List<String> answer = new ArrayList<>();

    for (String r : record){
      String[] m = r.split(" ");
      String cmd = m[0];

      if (cmd.equals("Enter") || cmd.equals("Change")){
        String uid = m[1];
        String name = m[2];
        map.put(uid, name);
      }
    }

    for(String r : record){
      String[] m = r.split(" ");
      String cmd = m[0];
      String uid = m[1];

      if (cmd.equals("Enter")){
        answer.add(map.get(uid) + "님이 들어왔습니다.");
      } else if(cmd.equals("Leave")) {
        answer.add(map.get(uid) + "님이 나갔습니다.");
      }
    }



    return answer.toArray(new String[0]);
  }
}