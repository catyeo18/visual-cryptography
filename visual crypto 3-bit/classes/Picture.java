import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 */
public class Picture extends SimplePicture 
{
  
  public Picture ()
  {
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  
  // Generate random noise for an image
  public void randomNoise() {
    Pixel[][] pixels1 = this.getPixels2D();
    for (int i = 0; i < pixels1.length; i++) {
      for (int j = 0; j < pixels1[0].length; j++) {
        int rand = (int)(Math.random()*2+1);
        Pixel pixelObj = pixels1[i][j];
        if (rand == 1) {
          pixelObj.setRed(0);
          pixelObj.setGreen(0);
          pixelObj.setBlue(0);
        } else {
          pixelObj.setRed(255);
          pixelObj.setGreen(255);
          pixelObj.setBlue(255);
        }
      }
    }
  }
    
    /* XOR the pixel colors of the first image and the original image to get the new pixel color */
    public void visualCrypto(Picture p1, Picture p2) {
      Pixel[][] pixels = this.getPixels2D(); // original
      
      p1.randomNoise();
      Pixel[][] pixels1 = p1.getPixels2D(); // noise
      
      Pixel[][] pixels2 = p2.getPixels2D(); // the one being changed
      
      for (int i = 0; i < pixels.length; i++) {
        for (int j = 0; j < pixels[0].length; j++) {
          int sum = pixels[i][j].getRed() + pixels[i][j].getGreen() + pixels[i][j].getBlue();
          int sum1 = pixels1[i][j].getRed() + pixels1[i][j].getGreen() + pixels1[i][j].getBlue();
          
          if (sum == sum1) {
              pixels2[i][j].setRed(0);
              pixels2[i][j].setGreen(0);
              pixels2[i][j].setBlue(0);
          }
          else {
              pixels2[i][j].setRed(255);
              pixels2[i][j].setGreen(255);
              pixels2[i][j].setBlue(255);
          }
        }
      }
      
//      p1.explore();
//      p2.explore();
    }
    
    
    // combines the two encrypted images to decrypt them
    // @return the decrypted (original) image
    public void xor(Picture p1, Picture p2) {
      Pixel[][] pixels = this.getPixels2D();
      Pixel[][] pixels1 = p1.getPixels2D();
      Pixel[][] pixels2 = p2.getPixels2D();
      
      int rows = pixels.length;
      int cols = pixels[0].length;
        
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          int sum1 = pixels1[i][j].getRed() + pixels1[i][j].getGreen() + pixels1[i][j].getBlue();
          int sum2 = pixels2[i][j].getRed() + pixels2[i][j].getGreen() + pixels2[i][j].getBlue();
          
          int n = 0;
          if (sum1 == sum2) {
            n = 0;
          } else {
            n = 255;
          }
          
          pixels[i][j].setRed(n);
          pixels[i][j].setGreen(n);
          pixels[i][j].setBlue(n);
        }
      }
    }
    
  } 
