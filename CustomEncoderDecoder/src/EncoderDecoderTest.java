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
    
    @Test
    public void testEncodeWithoutSettingReferenceTable() {
        EncoderDecoder encoderDecoderWithoutTable = new EncoderDecoder();
        assertThrows(IllegalStateException.class, () -> {
            encoderDecoderWithoutTable.encode("HELLO WORLD");
        });
    }
    
    @Test
    public void testDecodeWithoutSettingReferenceTable() {
        EncoderDecoder encoderDecoderWithoutTable = new EncoderDecoder();
        assertThrows(IllegalStateException.class, () -> {
            encoderDecoderWithoutTable.decode("BGDKKN VNQKC");
        });
    }
    
    @Test
    public void testEncodeWithoutSettingOffsetChar() {
        assertThrows(IllegalStateException.class, () -> {
            encoderDecoder.encode("HELLO WORLD");
        });
    }
    
    @Test
    public void testDecodeWithoutSettingOffsetChar() {
        assertThrows(IllegalStateException.class, () -> {
            encoderDecoder.decode("BGDKKN VNQKC");
        });
    }
    
    @Test
    public void testSetReferenceTableWithNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            encoderDecoder.setReferenceTable(null);
        });
    }
    
    @Test
    public void testSetOffsetCharNotInReferenceTable() {
        assertThrows(IllegalArgumentException.class, () -> {
            encoderDecoder.setOffsetChar('!');
        });
    }

}
