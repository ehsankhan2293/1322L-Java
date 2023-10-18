import java.util.ArrayList;
import java.util.Scanner;
class Encryption {
    ArrayList<Character> symbols = new ArrayList<Character>();
    ArrayList<Character> alphabets = new ArrayList<Character>();

    public Encryption() {
        symbols.add('!');
        symbols.add('@');
        symbols.add('#');
        symbols.add('$');
        symbols.add('^');
        symbols.add('&');
        symbols.add('*');
        symbols.add('(');
        symbols.add(')');
        symbols.add('_');
        symbols.add('-');
        symbols.add('+');
        symbols.add('=');
        symbols.add('?');
        symbols.add(',');
        symbols.add('{');
        symbols.add('}');
        symbols.add('[');
        symbols.add(']');
        symbols.add('/');
        symbols.add('|');
        symbols.add(';');
        symbols.add(':');
        symbols.add('.');
        symbols.add('<');
        symbols.add('>');

        for (char letter = 'a'; letter <= 'z'; letter++) {
            alphabets.add(letter);
        }
    }

    public char return_alphabet(int index) {
        char letter=alphabets.get(index);
        return letter;
    }

    public int return_alphabet_index(char letter){
        int index=alphabets.indexOf(letter);
        return index;
    }

    public char return_symbol(int index){
        char symbol=symbols.get(index);
        return symbol;
    }

    public int return_symbol_index(char symbol){
        int index=symbols.indexOf(symbol);
        return index;
    }

    public String takeUserInput(String userPrompt) {
        Scanner input = new Scanner(System.in);
        System.out.println(userPrompt);
        return input.nextLine();
    }


    public String encrypt_message(String message){
        StringBuilder encryptedString=new StringBuilder();
        char[] messageCharArray = message.toLowerCase().toCharArray();
        for (char letter : messageCharArray) {
            if (return_alphabet_index(letter) <= 25) {
                letter = return_symbol(return_alphabet_index(letter));
                encryptedString.append(letter);
            } else {
                System.out.println("Error: Invalid Character");
            }
        }

        return encryptedString.toString();
        }


    public String decrypt_message(String message1){
        StringBuilder decryptedString= new StringBuilder();
        char[]message1charArray=message1.toCharArray();
        for (char symbol : message1charArray){
            if (return_symbol_index(symbol)<=25){
                symbol=return_alphabet(return_symbol_index(symbol));
                decryptedString.append(symbol);
            }
        else{
            System.out.println("Error: Invalid Symbol");
        }
        }
        return decryptedString.toString();
    }
}


public class Assignment2 {
    public static void main(String[] args) {
        Encryption obj = new Encryption();
        int choice = 1;

        while (choice > 0 && choice < 3) {
            System.out.println();
            System.out.print("1 Encrypt a message\n" +
                    "2 Decrypt a message\n" +
                    "3 Quit");
            System.out.println();
            Scanner input = new Scanner(System.in);
            System.out.println("\nEnter Choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    String userInputForEncryption = obj.takeUserInput("Enter the plain text message:");
                    System.out.println();
                    String encryptedString = obj.encrypt_message(userInputForEncryption);
                    System.out.println("Encrypted message: "+encryptedString);
                    break;

                case 2:
                    String userInputForDecryption = obj.takeUserInput("Enter the encrypted message:");
                    System.out.println();
                    System.out.println("Decrypted message: "+obj.decrypt_message(userInputForDecryption));
                    break;

            }

        }

    }
}
