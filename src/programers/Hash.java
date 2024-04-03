package programers;

public class Hash {

    public String[] hashTable;

    public Hash(int size){
        hashTable = new String[size];
    }

    public int hashFuncthin(String key){
        return key.hashCode()%this.hashTable.length;
    }

    public boolean saveData(String key, String value){
        Integer address = this.hashFuncthin(key);
        this.hashTable[address]=value;
        return true;
    }


}
