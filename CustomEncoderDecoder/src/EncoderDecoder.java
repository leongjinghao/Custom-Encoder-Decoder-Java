/**
 * EncoderDecoder class that implements the EncoderDecoderInterface.
 * This class provides methods to encode and decode text based on a reference table and an offset character.
 */
public class EncoderDecoder implements EncoderDecoderInterface {
	private String referenceTable;
	private char offsetChar;
	
    public String getReferenceTable() {
		return referenceTable;
	}
	
	public char getOffsetChar() {
		return offsetChar;
	}

    /**
     * Sets the reference table.
     * @param referenceTable The reference table string.
     * @throws IllegalArgumentException if the reference table is null or empty.
     */
	public void setReferenceTable(String referenceTable) {
		if (referenceTable == null || referenceTable.isEmpty()) {
            throw new IllegalArgumentException("Reference table cannot be null or empty.");
        }
		
		this.referenceTable = referenceTable;
	}

	/**
     * Sets the offset character.
     * @param offsetChar The offset character.
     * @throws IllegalArgumentException if the offset character is not in the reference table.
     */
	public void setOffsetChar(char offsetChar) {
		if (referenceTable == null || referenceTable.indexOf(offsetChar) == -1) {
            throw new IllegalArgumentException("Offset character must be in the reference table.");
        }
		
		this.offsetChar = offsetChar;
	}
	
	private char getEncodedChar(char ch, int offsetIndex) {
		int originalCharIndex = referenceTable.indexOf(ch);
		int referenceTableLen = referenceTable.length();
		
		if (originalCharIndex == -1) {
			return ch;
		}

        int newIndex = (originalCharIndex - offsetIndex + referenceTableLen) % referenceTableLen;
        return referenceTable.charAt(newIndex);
	}
	
	private char getDecodedChar(char ch, int offsetIndex) {
		int originalCharIndex = referenceTable.indexOf(ch);
		int referenceTableLen = referenceTable.length();
		
		if (originalCharIndex == -1) {
			return ch;
		}

        int newIndex = (originalCharIndex + offsetIndex) % referenceTableLen;
        return referenceTable.charAt(newIndex);
	}

	/**
     * Encodes the given plain text using the set reference table and offset character.
     * @param plainText The plain text to encode.
     * @return The encoded text.
     * @throws IllegalStateException if the reference table is not set.
     */
	@Override
	public String encode(String plainText) {
		if (referenceTable == null || referenceTable.isEmpty()) {
            throw new IllegalStateException("Reference table not set.");
        }
		
		int offsetIndex = referenceTable.indexOf(offsetChar);
        StringBuilder encodedText = new StringBuilder();
        
        encodedText.append(offsetChar);
        
        for (char ch : plainText.toCharArray()) {
        	encodedText.append(getEncodedChar(ch, offsetIndex));
        }
        
        return encodedText.toString();
	}

	/**
     * Decodes the given encoded text using the set reference table.
     * The first character of the encoded text is used as the offset character.
     * @param encodedText The encoded text to decode.
     * @return The decoded plain text.
     * @throws IllegalStateException if the reference table is not set.
     */
	@Override
	public String decode(String encodedText) {
		if (referenceTable == null || referenceTable.isEmpty()) {
            throw new IllegalStateException("Reference table not set.");
        }
		
		char offset = encodedText.charAt(0);
        int offsetIndex = referenceTable.indexOf(offset);
        StringBuilder decodedText = new StringBuilder();
        
        for (char ch : encodedText.substring(1).toCharArray()) {
        	decodedText.append(getDecodedChar(ch, offsetIndex));
        }
        
        return decodedText.toString();
	}

}
