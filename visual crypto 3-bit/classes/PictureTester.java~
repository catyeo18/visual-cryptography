/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods. 
 * 
 */
public class PictureTester
{
  /** Method to test randomNoise */
  public static void testRandomNoise() 
  {
    Picture pixels = new Picture("pixels.jpg");
    pixels.randomNoise();
    pixels.explore();
  }
  
  /** Method to test visualCrypto */
  public static void testVisualCrypto()
  {
    Picture pixels = new Picture("pixels.jpg");
    Picture pixels1 = new Picture("pixels.jpg");
    Picture pixels2 = new Picture("pixels.jpg");
    pixels.visualCrypto(pixels1, pixels2);
  }
  
  /** Method to test xor */
  public static void testXOR() 
  {
    Picture pixels = new Picture("pixels.jpg");
    Picture pixels1 = new Picture("pixels.jpg");
    Picture pixels2 = new Picture("pixels.jpg");
    pixels.visualCrypto(pixels1, pixels2);
    pixels.xor(pixels1, pixels2);
    pixels.explore();
  }
  
  public static void encrypt() 
  {
    /* ALGORITHM 
     * O = original
     * S1 = 1st random image
     * S2 = O XOR S1 (S2 in this case is the one that shows the edges)
     * to recover O: S1 XOR S2 = S1 XOR (O XOR S1) = S1 XOR S1 XOR O = ZERO XOR O = O
     * Now, given S2, create another random image S3 and create S4 as follows:
     * S2 XOR S3 = S4
     * To recover S2: S2 = S4 XOR S3
     * To recover O from S1, S3, S4: O = S1 XOR S2 = S1 XOR (S3 XOR S4) = S1 XOR S3 XOR S4 */
    
    Picture original = new Picture("mickey_mouse.jpg");
    Picture s1 = new Picture("mickey_mouse.jpg");
    s1.randomNoise();
    s1.explore();
    Picture s2 = new Picture("mickey_mouse.jpg");
    original.xor(s1, s2);
    s2 = original;
    s2.explore();
    Picture s3 = new Picture("mickey_mouse.jpg");
    s3.randomNoise();
    s3.explore();
    Picture s4 = new Picture("mickey_mouse.jpg");
    s4.xor(s2, s3);
    s4.explore();
    
    original.xor(s1, s3);
    s2.xor(original, s4);
    s2.explore();
  }
  
  /** Main method for testing. */
  public static void main(String[] args)
  {
//    testRandomNoise();
//    testVisualCrypto();
//    testXOR();
    encrypt();
  }
}