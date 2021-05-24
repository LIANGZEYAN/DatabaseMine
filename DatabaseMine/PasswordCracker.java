import java.util.*;
import java.io.*;

public class PasswordCracker{
  public PasswordCracker(){

  }

  void createDatabase(ArrayList<String> commonPasswords, DatabaseInterface database){
    ArrayList<String> valueOfmap = new ArrayList<String>();
    ArrayList<String> keyOfmap = new ArrayList<String>();
    int mod = commonPasswords.size();
    System.out.println(mod);
    String editedPassword;
    ArrayList<String> editedString = new ArrayList<String>();
    int sizeOfeditedString = editedString.size();
    try{
      for(int i = 0; i < mod;i++){
        editedString.clear();



        keyOfmap.add(commonPasswords.get(i));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i)));
        //common password 1
        keyOfmap.add((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)));
        //common password capital the frist alphabet 2
        keyOfmap.add((commonPasswords.get(i)+"2018"));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i)+"2018"));
        //common password add 2018 3
        keyOfmap.add((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)+"2018"));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)+"2018"));
        //common password capital the frist alphabet add 2018 4
        keyOfmap.add((commonPasswords.get(i).replace('a', '@')));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).replace('a', '@')));
        //common replace a to @ 5
        keyOfmap.add(((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('a', '@')));
        valueOfmap.add(Sha1.hash((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('a', '@')));
        //common password capital the frist alphabet replace a to @ 6
        keyOfmap.add((commonPasswords.get(i).replace('a', '@')+"2018"));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).replace('a', '@')+"2018"));
        //common password add 2018 replace a to @ 7
        keyOfmap.add(((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('a', '@')+2018));
        valueOfmap.add(Sha1.hash((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('a', '@')+2018));
        //common password capital the frist alphabet add 2018 replace a to @ 8
        keyOfmap.add((commonPasswords.get(i).replace('e', '3')));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).replace('e', '3')));
        //common replace e to 3 9
        keyOfmap.add(((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('e', '3')));
        valueOfmap.add(Sha1.hash((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('e', '3')));
        //common password capital the frist alphabet replace a to @ 10
        keyOfmap.add((commonPasswords.get(i).replace('e', '3')+"2018"));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).replace('e', '3')+"2018"));
        //common password add 2018 replace a to @ 11
        keyOfmap.add(((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('e', '3')+2018));
        valueOfmap.add(Sha1.hash((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('e', '3')+2018));
        //common password capital the frist alphabet add 2018 replace a to @ 12
        keyOfmap.add((commonPasswords.get(i).replace('i', '1')));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).replace('i', '1')));
        //common replace a to @ 13
        keyOfmap.add(((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('i', '1')));
        valueOfmap.add(Sha1.hash((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('i', '1')));
        //common password capital the frist alphabet replace a to @ 14
        keyOfmap.add((commonPasswords.get(i).replace('i', '1')+"2018"));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).replace('i', '1')+"2018"));

        keyOfmap.add((commonPasswords.get(i).replace('i', '1').replace('e', '3')+"2018"));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).replace('i', '1').replace('e', '3')+"2018"));

        keyOfmap.add((commonPasswords.get(i).replace('i', '1').replace('e', '3')+"2018"));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).replace('i', '1').replace('e', '3')+"2018"));

        keyOfmap.add((commonPasswords.get(i).replace('i', '1').replace('e', '3').replace('a', '@')+"2018"));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).replace('i', '1').replace('e', '3').replace('a', '@')+"2018"));

        keyOfmap.add((commonPasswords.get(i).replace('i', '1').replace('e', '3').replace('a', '@')));
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).replace('i', '1').replace('e', '3').replace('a', '@')));
        //common password add 2018 replace a to @ 15
        keyOfmap.add(((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('i', '1')+2018));
        valueOfmap.add(Sha1.hash((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('i', '1')+2018));
        //common password capital the frist alphabet add 2018 replace a to @ 16
        keyOfmap.add(commonPasswords.get(i).replace('e', '3').replace('a', '@')+2018);
        valueOfmap.add(Sha1.hash(commonPasswords.get(i).replace('e', '3').replace('a', '@')+2018));

        keyOfmap.add(((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('i', '1').replace('e', '3')+2018));
        valueOfmap.add(Sha1.hash((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('i', '1').replace('e', '3')+2018));

        keyOfmap.add(((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('i', '1').replace('e', '3').replace('a', '@')+2018));
        valueOfmap.add(Sha1.hash((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('i', '1').replace('e', '3').replace('a', '@')+2018));

        keyOfmap.add(((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('i', '1').replace('e', '3')));
        valueOfmap.add(Sha1.hash((commonPasswords.get(i).substring(0,1).toUpperCase()+commonPasswords.get(i).substring(1)).replace('i', '1').replace('e', '3')));
      }
    }catch (UnsupportedEncodingException e){
      e.printStackTrace();
    }

    int sizeOfmap1 = keyOfmap.size();
    for(int j = 0; j < sizeOfmap1;j++) {
			database.save(keyOfmap.get(j),valueOfmap.get(j));
		}


  }

  String crackPassword(String encryptedPassword, DatabaseInterface database) {
		return database.decrypt(encryptedPassword);
	}

}
