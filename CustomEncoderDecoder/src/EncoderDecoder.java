
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

	@Override
	public String encode(String plainText) {
		if (referenceTable == null || referenceTable.isEmpty()) {
            throw new IllegalStateException("Reference table not set.");
        }
		
		int offsetIndex = referenceTable.indexOf(offsetChar);
		int referenceTableLen = referenceTable.length();
        StringBuilder encodedText = new StringBuilder();
        encodedText.append(offsetChar);
        
        // compute each char after offset with wrap around logic, if char not in ref table, map char back to itself
        for (char ch : plainText.toCharArray()) {
            int originalCharIndex = referenceTable.indexOf(ch);
            
            if (originalCharIndex != -1) {
                int newIndex = (originalCharIndex - offsetIndex + referenceTableLen) % referenceTableLen;
                encodedText.append(referenceTable.charAt(newIndex));
            }
            else {
            	encodedText.append(ch);
            }
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
		int referenceTableLen = referenceTable.length();
        StringBuilder decodedText = new StringBuilder();
        
        for (char ch : encodedText.substring(1).toCharArray()) {
            int originalCharIndex = referenceTable.indexOf(ch);
            
            if (originalCharIndex != -1) {
                int newIndex = (originalCharIndex + offsetIndex) % referenceTableLen;
                decodedText.append(referenceTable.charAt(newIndex));
            }
            else {
            	decodedText.append(ch);
            }
        }
        
        return decodedText.toString();
	}

}
