import java.util.Scanner;

public class CustomEncoderDecoder {
	public static void main(String[] args) {
		EncoderDecoder customEncoderDecoder = new EncoderDecoder();
        Scanner scanner = new Scanner(System.in);
        String referenceTable;
        char offsetChar;
        String plainText;
		String encodedText;
		String decodedText;
        
        System.out.println("Welcome to the Custom Encoder Decoder application!");
        System.out.println("\nSelect Options: \n- 1: Configure reference table \n- 2: Configure offset character \n- 3: Encode plain text \n- 4: Decode plain text \n- 5: Exit application");

        app: while (true) {
            try {
                System.out.print("\nEnter option: ");
                String option = scanner.nextLine();
                
                switch(option) {
                	case "1":
                		System.out.print("Enter reference table string: ");
                		referenceTable = scanner.nextLine();
                        customEncoderDecoder.setReferenceTable(referenceTable);
                        break;
                	case "2":
                		System.out.print("Enter offset character: ");
                        offsetChar = scanner.nextLine().charAt(0);
                        customEncoderDecoder.setOffsetChar(offsetChar);
                        break;
                	case "3":
                		System.out.print("Enter plain text to encode: ");
                		plainText = scanner.nextLine();
                		encodedText = customEncoderDecoder.encode(plainText);
                        System.out.println("Encoded Text: " + encodedText);
                        break;
                	case "4":
                		System.out.print("Enter encoded text to decode: ");
                		encodedText = scanner.nextLine();
                		decodedText = customEncoderDecoder.decode(encodedText);
                        System.out.println("Decoded Text: " + decodedText);
                        break;
                	case "5":
                		break app;
            		default:
            			System.out.println("Invalid option given! Please select one of the following options: \n- 1: Configure reference table \n- 2: Configure offset character \n- 3: Encode plain text \n- 4: Decode plain text \n- 5: Exit application");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
	}

}
