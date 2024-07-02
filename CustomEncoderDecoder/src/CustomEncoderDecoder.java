
public class CustomEncoderDecoder {
	public static void main(String[] args) {
		EncoderDecoder customEncoderDecoder = new EncoderDecoder();
		customEncoderDecoder.setReferenceTable("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./");
		String encodedText;
		String decodedText;
		
		/*
		 * Example 1.
		 * Plain text: HELLO WORLD
		 * Offset Character: B
		 */
		System.out.println("-------- EXAMPLE 1 --------\nPlain text: \tHELLO WORLD\nOffset Character: \tB\n");
		customEncoderDecoder.setOffsetChar('B');
        encodedText = customEncoderDecoder.encode("HELLO WORLD");
        System.out.println("Encoded Text: \t" + encodedText);
        
        decodedText = customEncoderDecoder.decode(encodedText);
        System.out.println("Decoded Text: \t" + decodedText);
        
        /*
		 * Example 2.
		 * Plain text: HELLO WORLD
		 * Offset Character: F
		 */
		System.out.println("\n\n-------- EXAMPLE 2 --------\nPlain text: \tHELLO WORLD\nOffset Character: \tF\n");
		customEncoderDecoder.setOffsetChar('F');
        encodedText = customEncoderDecoder.encode("HELLO WORLD");
        System.out.println("Encoded Text: \t" + encodedText);
        
        decodedText = customEncoderDecoder.decode(encodedText);
        System.out.println("Decoded Text: \t" + decodedText);
	}

}
