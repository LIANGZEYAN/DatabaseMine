import java.util.*;
import java.io.*;

public class DatabaseStandard implements DatabaseInterface{
  Map<String,String> m1 = new HashMap<String,String>();

  public DatabaseStandard(){

  }

  @Override
  public String save(String plainPassword, String encryptedPassword) {


  String newPassword = null;
  try {
    newPassword = Sha1.hash(plainPassword);
  } catch (UnsupportedEncodingException e) {
    e.printStackTrace();
  }
  //System.out.println(newPassword);
  //System.out.println(encryptedPassword);
  if(newPassword.equals(encryptedPassword)) {
    String previousValue = m1.get(encryptedPassword);//get the previous existing value
    m1.put(encryptedPassword, plainPassword);//putting the password into the dictionary
    return previousValue;
  }else {
    return null;
  }
}
  /*public String save(String plainPassword, String encryptedPassword){
    try{
      if(Sha1.hash(plainPassword).equals(encryptedPassword)){
        String originalValue = m1.get(encryptedPassword);
        m1.put(encryptedPassword,plainPassword);
        //Object put(Object k, Object v)
        return originalValue;
      }
      else{
        return null;
      }
    }catch (UnsupportedEncodingException e){
      e.printStackTrace();
    }



  }*/

  @Override
  public String decrypt(String encryptedPassword){
    return m1.get(encryptedPassword);
    //	Object get(Object k)
  }

  @Override
  public int size(){
    int sizeOfmap = m1.size( );
    return sizeOfmap;
    //int size( )
  }

  @Override
  public void printStatistics(){
    System.out.println("*** DatabaseStandard Statistics ***");
		System.out.println("Size is " + m1.size() + " passwords");
    int NOI = 16 + m1.size();
		System.out.println("Initial Number of Indexes when Created " + NOI );
		System.out.println("*** End DatabaseStandard Statistics ***");
  }
}
