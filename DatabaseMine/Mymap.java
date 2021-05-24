import java.util.*;
import java.io.*;

public class Mymap{
  public ArrayList<String> value = new ArrayList<String>();
  public ArrayList<String> key = new ArrayList<String>();


  public Mymap(ArrayList<String> Key,ArrayList<String> Value){
    this.key = Key;
    this.value = Value;
  }

  public String get(String encryptedValue){
    for(int i = 0; i < value.size(); i++){
      if(value.get(i).equals(encryptedValue)){
        return key.get(i);
      }
      else{

      }
    }

  }

  public void put(String encryptedPassword, String plainPassword){
    value.add(encryptedPassword);
    key.add(plainPassword);
  }

  public int size(){
    return value.size();
  }


}
