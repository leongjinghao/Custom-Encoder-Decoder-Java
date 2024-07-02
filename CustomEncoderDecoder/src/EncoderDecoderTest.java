import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncoderDecoderTest {

	private EncoderDecoder encoderDecoder;

    @BeforeEach
    public void setUp() {
        encoderDecoder = new EncoderDecoder();
        encoderDecoder.setReferenceTable("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./");
    }
    
    @Test
    public void testEncodeWithOffsetB() {
        encoderDecoder.setOffsetChar('B');
        String encodedText = encoderDecoder.encode("HELLO WORLD");
        assertEquals("BGDKKN VNQKC", encodedText);
    }

    @Test
    public void testDecodeWithOffsetB() {
        encoderDecoder.setOffsetChar('B');
        String decodedText = encoderDecoder.decode("BGDKKN VNQKC");
        assertEquals("HELLO WORLD", decodedText);
    }

    @Test
    public void testEncodeWithOffsetF() {
        encoderDecoder.setOffsetChar('F');
        String encodedText = encoderDecoder.encode("HELLO WORLD");
        assertEquals("FC/GGJ RJMG.", encodedText);
    }

    @Test
    public void testDecodeWithOffsetF() {
        encoderDecoder.setOffsetChar('F');
        String decodedText = encoderDecoder.decode("FC/GGJ RJMG.");
        assertEquals("HELLO WORLD", decodedText);
    }

}
