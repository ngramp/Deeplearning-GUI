package cutoutservices;

import cutoutservices.casjobs.ImgCutoutLocator;
import cutoutservices.casjobs.ImgCutoutSoap_PortType;
import javafx.scene.image.Image;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


/*
 A simple dime client which will pull down a requesed image from
 SDDS DR1 Image Cutout WebService.

<pre>
 Current Version
 ===============
 ID:		$Id: cutoutservices.CutOutClient.java,v 1.1.1.1 2003/03/19 16:21:50 womullan Exp $
 Revision:	$Revision: 1.1.1.1 $
 Date/time:	$Date: 2003/03/19 16:21:50 $
</pre>
*/

public class CutOutClient {
    private static final Logger logger = LogManager.getLogger(CutOutClient.class);

    /**
     * simple main loop which parses command line to call the webservice
     * if you pass no args defaults are provided
     * otherwise you must specify
     * FileName RA DEC PPD WIDTH HEIGHT [OPTIONS]
     */
    public static void main(String[] args) throws Exception {
        CutOutClient cl = new CutOutClient();
        int ind = 0;
        String fname = "cutoutservices.CutOutClient.jpg";
        double ra = 180;
        double dec = 0;
        int ppd = 9000;
        int width = 512;
        int height = 512;
        String opt = "";

        if (args.length == 7) {
            fname = args[ind++];
            ra = Double.parseDouble(args[ind++]);
            dec = Double.parseDouble(args[ind++]);
            ppd = Integer.parseInt(args[ind++]);
            width = Integer.parseInt(args[ind++]);
            height = Integer.parseInt(args[ind++]);
            opt = args[ind++];
        } else if (args.length > 0) {
            System.err.println("Pass no args to use the defaults otherwise pass:");
            System.err.println("FileName RA DEC PPD WIDTH HEIGHT OPTIONS");
            System.exit(2);
        }

        //cl.saveImage(fname,ra,dec,ppd,width,height,opt);
    }


    /**
     * Scrollable the webservice and get the image out of it.
     * This is returns as Javafx.scene.image.
     */

    public Image getImage(double ra, double dec, double scale,
                          int width, int height, String opt) throws Exception {
        ImgCutoutLocator loc = new ImgCutoutLocator();
        ImgCutoutSoap_PortType imgProvider = loc.getImgCutoutSoap();
        byte[] imageInByte = imgProvider.getJpeg(ra, dec, scale, width, height, opt);
        InputStream in = new ByteArrayInputStream(imageInByte);

        return new Image(in);
    }


    /**
     * Save the image to the given file
     */
//	public void saveImage(String fname, double ra, double dec, int ppd,
//								int width , int height , String opt ) throws Exception {
//		      BufferedImage dh = this.getImage(ra,dec,ppd,width,height,opt);
//			  FileOutputStream fs = new FileOutputStream(fname);
//			  dh.writeTo(fs);
//			  fs.close();
//			  // need to delete temp file which Axis creates
//			  File f = new File(dh.getName());
//			  f.delete();
//	}

}


/**********************************************************************
 * Revision History
 * ================
 * <p>
 * $Log: cutoutservices.CutOutClient.java,v $
 * Revision 1.1.1.1  2003/03/19 16:21:50  womullan
 * import
 **/
