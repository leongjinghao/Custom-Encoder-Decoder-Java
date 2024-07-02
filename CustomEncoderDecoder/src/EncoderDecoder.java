
public class EncoderDecoder implements EncoderDecoderInterface {
	private String referenceTable;
	private char offsetChar;
	
    public String getReferenceTable() {
		return referenceTable;
	}

	public void setReferenceTable(String referenceTable) {
		this.referenceTable = referenceTable;
	}
	
	public char getOffsetChar() {
		return offsetChar;
	}

	public void setOffsetChar(char offsetChar) {
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
