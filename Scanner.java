import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.*;


public class Scanner {
	
	BufferedImage Image = new BufferedImage(703,344,BufferedImage.TYPE_BYTE_GRAY );
	
	public static void main(String [ ] args) throws IOException
	{
		//int[][] arr = new int[img.getWidth()][img.getheight()];

		//BufferedImage img = null;
		//try {
		//    img = ImageIO.read(new File("Mars_MGS_MOLA_DEM_mosaic_global_1024.jpg"));
		//} catch (IOException e) {
		//}
		
		
		BufferedImage img = ImageIO.read(new File("Mars_MGS_MOLA_DEM_mosaic_global_463m.jpg"));

		
		
		//int gray= img.getRGB(x, y)& 0xFF;/////////will be the gray value
		//System.out.println(img.getRGB(5, 5));
		
		//int[][] arr = new int[img.getWidth()][img.getHeight()];
		//System.out.println(img.getRGB(5 ,5)& 0xFF);
		
     //for(int i = 0; i < 2048; i++)
   // for(int j = 0; j < 2048; j++)
     //   arr[i][j] = img.getRGB(i, j);
		
		
		//BufferedWriter br = new BufferedWriter(new FileWriter("Output.csv"));
        PrintWriter pw = new PrintWriter(new File("Output4.csv"));
		StringBuilder sb = new StringBuilder();

		// Append strings from array img.getWidth()-1
        for (int i = 0; i < img.getHeight()  ; i++) {
        	for (int j = 0; j < img.getWidth() ; j++) {
        		sb.append(img.getRGB(j ,i)& 0xFF);
        		//sb.append(aroundLowestDel(j,i,img));
        		//if (aroundLowestDel(j,i,img) <= 2) {
        		//	sb.append(1);
        		//}
        		//else sb.append(0);
        		
        		sb.append(",");
        		System.out.println(aroundLowestDel(j,i,img));
        		System.out.println(i + " " + j);

        	}
        	
        	sb.append("\r");
		}

		//br.write(sb.toString());
		//br.close();
        pw.write(sb.toString());
        pw.close();
		//test();
		//BufferedImage Image = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_BYTE_GRAY );
	}
	
    public static void test() throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File("test.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append(',');
        sb.append("Name");
        sb.append('\n');

        sb.append("1");
        sb.append(',');
        sb.append("Prashant Ghimire");
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }
    public static int aroundLowestDel(int x,int y, BufferedImage img) {
    	
    	int grey = img.getRGB(x ,y)& 0xFF;
    	int greyL = grey;
    	int greyR = grey;
    	int greyB = grey;
    	int greyT = grey;
    	
    	try { 
    	greyT = img.getRGB(x ,y - 1)& 0xFF;
    	} catch (ArrayIndexOutOfBoundsException exception) {
		}
    	try {
    	greyB = img.getRGB(x ,y + 1)& 0xFF;
    	} catch (ArrayIndexOutOfBoundsException exception) {
		}
    	try {
    	greyR = img.getRGB(x + 1,y)& 0xFF;
    	} catch (ArrayIndexOutOfBoundsException exception) {
		}
    	try {
    	greyL = img.getRGB(x - 1,y)& 0xFF;
    	} catch (ArrayIndexOutOfBoundsException exception) {
		}
    	int delT = Math.abs(grey-greyT);
    	int delB = Math.abs(grey-greyB);
    	int delR = Math.abs(grey-greyR);
    	int delL = Math.abs(grey-greyL);
    	
    	
    	return Math.max(Math.max(delT,delB),Math.max(delR,delL));
    }
    
}
