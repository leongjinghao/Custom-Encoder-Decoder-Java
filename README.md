# Custom-Encoder-Decoder-Java
The EncoderDecoder application is a Java-based program that encodes and decodes text based on a custom reference table and an offset character. This project includes a command-line interface (CLI) for user interaction.

## I. Algorithm
### Encoding Algorithm
1. **Reference Table**: A custom reference table is set, consisting of characters that will be used for encoding and decoding.
2. **Offset Character**: The offset character is used to determine the starting point for the encoding process.
3. **Offset Calculation**: The position of the offset character in the reference table determines the shift for encoding each character in the plain text.
4. **Character Shifting**: Each character in the plain text is shifted by the offset value within the bounds of the reference table.
5. **Encoded Text**: The offset character is prefixed to the encoded text to facilitate decoding.

### Decoding Algorithm
1. **Extract Offset Character**: The first character of the encoded text is used as the offset character.
2. **Offset Calculation**: The position of the offset character in the reference table determines the shift for decoding each character in the encoded text.
3. **Character Shifting**: Each character in the encoded text is shifted back by the offset value within the bounds of the reference table.
4. **Decoded Text**: The resultant string after shifting the characters back is the original plain text.

## II. Implementation and Features:
### Implementation
- **EncoderDecoderInterface**: Defines the contract for encoding and decoding operations.
- **EncoderDecoder**: Implements the encoding and decoding logic, ensuring input validation and error handling.
- **EncoderDecoderTest**: Unit test for _EncoderDecoder_ class.
- **CustomEncoderDecoder**: Provides an interactive command-line interface for users to encode and decode text.

### Features
- **Custom Reference Table**: Allows users to set a custom reference table for encoding and decoding operations.
- **Offset Character Validation**: Ensures the offset character is valid and present in the reference table.
- **Interactive CLI**: Provides a straightforward command-line interface for user interaction.
- **User-Friendly GUI**: Offers a graphical user interface with text input fields and buttons for encoding and decoding operations.
- **Robust Error Handling**: Handles invalid inputs gracefully, providing informative error messages to the user.
- **Unit Tests**: Comprehensive unit tests to ensure the reliability and correctness of the encoding and decoding logic.

## III. Usage
### Command-Line Interface (CLI)
![image](https://github.com/leongjinghao/Custom-Encoder-Decoder-Java/assets/73938217/dd3807b9-437b-48d3-b15c-f1b71f41b6a5)
1. CLI application executable from the main function in CustomEncoderDecoder class
2. Select the option to perform, note that the reference table and offset character should be configured prior to encoding and decoding
3. Review output shown
