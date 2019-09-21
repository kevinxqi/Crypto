import java.util.Random;
import java.util.Scanner;
/**
 * This class runs the encryption and decryption process
 * @author Kevin Qi
 *
 */
public class Simulator {

		static Scanner input = new Scanner(System.in);
		static Random rand = new Random();

		public static void main(String[] args) 
		{
			int shift = rand.nextInt(10);
			System.out.print("What message you like to encrypt? ");
			String word = input.nextLine();
			System.out.print("Your encrypted message is: ");
			System.out.println(Encryption.encryptString(word, shift, rand.nextInt(5))); 
			
			System.out.print("What message would you like to decrypt? ");
			String encryptedWord = input.nextLine();
			System.out.print("Your decrypted message is: ");
			System.out.println(Decryption.decryptString(encryptedWord, shift));
		}


}


