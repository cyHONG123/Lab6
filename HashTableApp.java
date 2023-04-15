import java.io.*;
import java.util.Scanner;

class DataItem {
	private int iData; // data item (key)

	public DataItem(int ii) {
		iData = ii;
	}

	public String getStars() {
		return "**";
	}

	public void changeData(int input) {
		iData = input;
	}

	public String getKey() {
		if (iData == -1) {
			return getStars();
		}
		else {
			return String.valueOf(iData);
		}
	}

} // end class DataItem

class HashTable {

	private DataItem[] hashArray; // array holds hash table
	private int arraySize;
	public int mod;

	public HashTable(int size) { // constructor
		hashArray = new DataItem[size];
		arraySize = 0;
	}

	public void displayTable() {	// displays hash table
		System.out.print("Table: ");
		for (int i = 0; i < hashArray.length; i++) {
			if (hashArray[i]!=null) {
				System.out.print(hashArray[i].getKey() + " ");
			}
		}
		System.out.println("");
	}

	public int hashFunc(int key) {	// hash function
		// to complete with a hash function of your choice
		int result = 0;
		for (int i = 0; i < arraySize; i++) {
			if (Integer.parseInt((hashArray[i].getKey()))==(key)) {
				result = i;
				break;
			}
		}
		return result;
	}

	public void insert(DataItem item) {  //insert a DataItem
		int a = 0;
		int cir = 0;
		a = Integer.parseInt(item.getKey()) % mod;
		while(true) {
			if (hashArray[a] != null) {
				a++;
				if(a >= hashArray.length){
					if(cir == 0) {
						a = 0;
						cir++;
					} else {
						System.out.println("Array Full Already!");
						break;
					}
				}
			} else {
				hashArray[a] = item;
				System.out.println("inserted " + hashArray[a].getKey());
				break;
			}
		}

	} // end insert()


	public DataItem delete(int key) { // delete a DataItem
		int a = key % mod;
		DataItem k = hashArray[0];
		int cir = 0;
		//find the position after mod
		while (true) {
			if (hashArray[a] == null) {
				System.out.println("Key entered does not exist!");
				break;
			}
			if (Integer.parseInt(hashArray[a].getKey()) != key) {
				a++;
				if (a >= hashArray.length){
					if (cir == 0) {
						a = 0;
						cir++;
					} else {
						System.out.println("Key to delete does not exist!");
						break;
					}
				}
			} else {
				k = hashArray[a];
				hashArray[a] = null;
				break;
			}
		}
		return k;
	} // end delete()


	public DataItem find(int key) { // find item with key
		// to complete
		int a = key % mod;
		DataItem k = hashArray[0];
		int cir = 0;
		//find the position after mod
		while (true) {
			if (hashArray[a] == null) {
				System.out.println("Key entered does not exist!");
				break;
			}
			if (Integer.parseInt(hashArray[a].getKey()) != key) {
				a++;
				if(a >= hashArray.length){
					if(cir == 0) {
						a = 0;
						cir++;
					} else {
						System.out.println("Key entered does not exist!");
						break;
					}
				}
			} else {
				k = hashArray[a];
				System.out.println("Found " + key + " at index " + a);
				return k;
			}
		}
		return null;
	}


} // end class HashTable

class HashTableApp {
	public static void main(String[] args) throws IOException {
		//DataItem aDataItem;
		HashTable test = new HashTable(30);
		test.mod = 29;
		while(true) {

			System.out.print("Enter first letter of - ");
			System.out.print("show, insert, delete, or find: ");

			Scanner scan = new Scanner(System.in);
			String choice = scan.next();

			switch(choice) {
				case "s":
					test.displayTable();
				break;

				case "i":
				System.out.print("Enter key value to insert: ");
				Scanner key_scan1 = new Scanner(System.in);
				int key1 = key_scan1.nextInt();
				test.insert(new DataItem(key1));
				break;

				case "d":
				System.out.print("Enter key value to delete: ");
				Scanner key_scan2 = new Scanner(System.in);
				int key2 = key_scan2.nextInt();
					test.delete(key2);
				break;

				case "f":
				System.out.print("Enter key value to find: ");
				Scanner key_scan3 = new Scanner(System.in);
				int key3 = key_scan3.nextInt();
				test.find(key3);
				break;

				default:
				System.out.print("Invalid entry\n");

			}

		}

	}


}
