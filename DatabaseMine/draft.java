import java.util.*;
import java.io.*;

public class DatabaseMine implements DatabaseInterface{
  int N = 100000;
  int numberOfdisplacements;

  String m2[] = new String[500000];
  String m3[] = new String[500000];

  int hashFunction(String key){
    int address = key.hashCode()%N;
    return (address>=0)?address:(address+N);
  }

  public DatabaseMine(){

  }

  @Override
  public String save(String plainPassword, String encryptedPassword) {
    String temp = null;
    try {
      temp = Sha1.hash(plainPassword);
    } catch (UnsupportedEncodingException e) {
    e.printStackTrace();
    }
    int index = hashFunction(temp);

    if(m2[hashFunction(encryptedPassword)] == null){
    //System.out.println(newPassword);
    //System.out.println(encryptedPassword);
      if(temp.equals(encryptedPassword)) {
      //String previousValue = m2.get(encryptedPassword);//get the previous existing value
        m2[index] = encryptedPassword;
        m3[index] = plainPassword;
        return temp;
      }else {
        return null;
      }

    }
    else{
      numberOfdisplacements++;
      while(m2[index] != null){
        index = (index+1);
        numberOfdisplacements++;

      }
      m2[index] = encryptedPassword;
      m3[index] = plainPassword;
      return temp;
    }
}


  @Override
  public String decrypt(String encryptedPassword){
    String temp1 = "NOT FOUND";
    for(int i =0; i < N; i++){
      if(m2[i].equals(encryptedPassword)){
        temp1 = m3[i];
      }
      else{
        if(i==(N-1)){
          temp1 =  "NOT FOUND";
        }
        else{

        }

      }
    }
    return temp1;
  }

  @Override
  public int size(){
    int numberOfpassword = 0;
    for (int i = 0; i < N; i++){
      if (m2[i] == null){

      }
      else{
        numberOfpassword++;
      }

    }

    return numberOfpassword;
    //int size( )
  }

  @Override
  public void printStatistics(){
    System.out.println("*** DatabaseStandard Statistics ***");
		System.out.println("Size is " + size() + " passwords");
    System.out.println("Number of Indexes is " + N);
    System.out.println("Load Factor is " +(size()/N));
		System.out.println("Number of displacements (due to collisions) "+numberOfdisplacements);
		System.out.println("*** End DatabaseMine Statistics ***");
  }
}
