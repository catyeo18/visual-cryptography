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
  
  /** Method to test overlay */
  public static void testOverlay() 
  {
    Picture pixels = new Picture("pixels.jpg");
    Picture pixels1 = new Picture("pixels.jpg");
    Picture pixels2 = new Picture("pixels.jpg");
    pixels.visualCrypto(pixels1, pixels2);
    pixels.overlay(pixels1, pixels2);
    pixels.explore();
  }
  
  /** Main method for testing. */
  public static void main(String[] args)
  {
//    testRandomNoise();
//    testVisualCrypto();
    testOverlay();
  }
}