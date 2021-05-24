import java.util.*;
import java.io.*;

public class DatabaseMine implements DatabaseInterface{
  int N = 100000;
  int numberOfdisplacements;

  String m2[] = new String[N];

  int hashFunction(String key){
    int address = key.hashCode()%N;
    return (address>=0)?address:(address+N);
  }

  public DatabaseMine(){

  }

  @Override
  public String save(String plainPassword, String encryptedPassword) {
    String temp = null;
    if(m2[hashFunction(encryptedPassword)] == null){

    }
    else{
      numberOfdisplacements++;
    }
    try {
      temp = Sha1.hash(plainPassword);
    } catch (UnsupportedEncodingException e) {
    e.printStackTrace();
    }
  //System.out.println(newPassword);
  //System.out.println(encryptedPassword);
    if(temp.equals(encryptedPassword)) {
    //String previousValue = m2.get(encryptedPassword);//get the previous existing value
      int index = hashFunction(temp);
      m2[index] = plainPassword;//putting the password into the dictionary
      return temp;
    }else {
      return null;
    }
}


  @Override
  public String decrypt(String encryptedPassword){
    if(m2[hashFunction(encryptedPassword)].equals(null)){
      return "Not Found";
    }
    else{
      return m2[hashFunction(encryptedPassword)];
    }
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
    int sizeofm = size();
    System.out.println("*** DatabaseStandard Statistics ***");
		System.out.println("Size is " + sizeofm + " passwords");
    System.out.println("Number of Indexes is " + N);
    double loadfactor = ((sizeofm+0.0)/(N+0.0));
    System.out.println("Load Factor is " + loadfactor);
		System.out.println("Number of displacements (due to collisions) "+numberOfdisplacements);
		System.out.println("*** End DatabaseMine Statistics ***");
  }
}
