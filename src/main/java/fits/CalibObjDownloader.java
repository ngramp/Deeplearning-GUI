package fits;

import nom.tam.fits.Fits;
import nom.tam.fits.FitsException;
import nom.tam.fits.TableHDU;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.GZIPInputStream;

/**
 * Created by Graham Perry on 13/06/16.
 *
 * @author Graham Perry
 */
public class CalibObjDownloader {
    private final String sdssData = "https://data.sdss.org/sas/dr12/env/PHOTO_SWEEP/";
    private static final Logger logger = LogManager.getLogger(CalibObjDownloader.class);

    public static void main(String[] args) {
        //TODO: get FITS
        //getFITS();
        //TODO: load FITS into db
        //TODO: delete FITS;
    }

    public File getFITSFile(long run, long camcol){
        int rerun =301;
        File calibGZ = null;
        File calibFITSFile = null;
        try{
            URL website = new URL(sdssData+"/"+rerun+"/calibObj-"+run+"-"+camcol+"-gal.fits.gz");
            calibGZ = new File("calibObj-"+run+"-"+camcol+"-gal.fits.gz");
            FileUtils.copyURLToFile(website, calibGZ);
        }
        catch(MalformedURLException e){
            logger.fatal("Malformed URL");
        }
        catch(IOException e){
            logger.fatal("Input/Output error");
        }
        calibFITSFile = decompressGzipFile(calibGZ);
        return calibFITSFile;

    }
    private File decompressGzipFile(File gzipFile) {
        File fit = null;
        String filename = gzipFile.getName().substring(0,gzipFile.getName().length()-4);
        File fitsFile = new File(filename);
        try {
            FileInputStream fis = new FileInputStream(gzipFile);
            GZIPInputStream gis = new GZIPInputStream(fis);
            FileOutputStream fos = new FileOutputStream(fitsFile);
            byte[] buffer = new byte[1024];
            int len;
            while((len = gis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
            //close resources
            fos.close();
            gis.close();
            fit = new File(filename);

        } catch (IOException e) {
            logger.fatal("Input/Output error");
        }
        return fit;
    }
    private void getIndexFits(){

    }

    private void getGalFITSContents(File fitsFile) throws Exception{
        Fits f = new Fits(fitsFile);
        TableHDU table = (TableHDU) f.getHDU(1);
        for(int i=1; i<11; i++){

            Object[] row = table.getRow(i);
            CalibObjGalaxy calib = new CalibObjGalaxy();
            //            Index	$0	Long		Table row index
            calib.setRun((Long) row[0]);   //            RUN	$1	Short			I
            calib.setRerun((String) row[1]);       //            RERUN	$2	String			3A
            calib.setCamcol((Long) row[2]);      //            CAMCOL	$3	Short			B	true
            calib.setField((Long) row[3]);       //            FIELD	$4	Short			I
            calib.setId((Long) row[4]);          //            ID	$5	Short			I
            calib.setObjc_type((Long) row[5]);   //            OBJC_TYPE	$6	Integer			J
            calib.setObjc_flags((Long) row[6]);  //            OBJC_FLAGS	$7	Integer			J
            calib.setObjc_flags2((Long) row[7]); //            OBJC_FLAGS2	$8	Integer			J
            calib.setRowC((float[]) row[8]);        //            ROWC	$9	float[]	5		5E
            calib.setColC((float[]) row[9]);        //            COLC	$10	float[]	5		5E
            calib.setPetroth50((float[]) row[10]);   //            PETROTH50	$11	float[]	5		5E
            calib.setPetroth90((float[]) row[11]);   //            PETROTH90	$12	float[]	5		5E
            calib.setmRrCc((float[]) row[12]);  //            M_RR_CC	$13	float[]	5		5E
            calib.setmRrCcPsf((float[]) row[13]);	//            M_RR_CC_PSF	$14	float[]	5		5E
            calib.setThetaDev((float[]) row[14]);	//            THETA_DEV	$15	float[]	5		5E
            calib.setThetaExp((float[]) row[15]);	//            THETA_EXP	$16	float[]	5		5E
            calib.setFracDev((float[]) row[16]);	//            FRACDEV	$17	float[]	5		5E
            calib.setFlags((Float) row[17]);   //            FLAGS	$18	int[]	5		5J
            calib.setFlags2((Float) row[18]);	//            FLAGS2	$19	int[]	5		5J
            calib.setStar_lnl((float[]) row[19]);	//            STAR_LNL	$20	float[]	5		5E
            calib.setExp_lnl((float[]) row[20]);	//            EXP_LNL	$21	float[]	5		5E
            calib.setDev_lnl((float[]) row[21]);	//            DEV_LNL	$22	float[]	5		5E
            calib.setPsp_status((long[]) row[22]);	//            PSP_STATUS	$23	int[]	5		5J
            calib.setRa((Double) row[23]);	//            RA	$24	Double			D
            calib.setDec((Double) row[24]);	//            DEC	$25	Double			D
            calib.setPsf_fwhm((float[]) row[25]);	//            PSF_FWHM	$26	float[]	5		5E
            calib.setExtinction((float[]) row[26]);	//            EXTINCTION	$27	float[]	5		5E
            calib.setPsfflux((float[]) row[27]);	//            PSFFLUX	$28	float[]	5		5E
            calib.setPsfflux_ivar((float[]) row[28]);	//            PSFFLUX_IVAR	$29	float[]	5		5E
            calib.setFiberflux((float[]) row[29]);	//            FIBERFLUX	$30	float[]	5		5E
            calib.setFiberflux_ivar((float[]) row[30]);	//            FIBERFLUX_IVAR	$31	float[]	5		5E
            calib.setFiber2flux((float[]) row[31]);	//            FIBER2FLUX	$32	float[]	5		5E
            calib.setFiber2flux_ivar((float[]) row[32]);	//            FIBER2FLUX_IVAR	$33	float[]	5		5E
            calib.setModelflux((float[]) row[33]);	//            MODELFLUX	$34	float[]	5		5E
            calib.setModelflux_ivar((float[]) row[34]);	//            MODELFLUX_IVAR	$35	float[]	5		5E
            calib.setPetroflux((float[]) row[35]);	//            PETROFLUX	$36	float[]	5		5E
            calib.setPetroflux_ivar((float[]) row[36]);	//            PETROFLUX_IVAR	$37	float[]	5		5E
            calib.setDevflux((float[]) row[37]);	//            DEVFLUX	$38	float[]	5		5E
            calib.setDevflux_ivar((float[]) row[38]);	//            DEVFLUX_IVAR	$39	float[]	5		5E
            calib.setExpflux((float[]) row[39]);	//            EXPFLUX	$40	float[]	5		5E
            calib.setExpflux_ivar((float[]) row[40]);	//            EXPFLUX_IVAR	$41	float[]	5		5E
            calib.setAperflux((float[]) row[41]);	//            APERFLUX	$42	float[]	40		40E
            calib.setCalibStatus((int[]) row[42]);	//            CALIB_STATUS	$43	int[]	5		5J
            calib.setNmgypercount((float[]) row[43]);	//            NMGYPERCOUNT	$44	float[]	5		5E
            calib.setResolve_status((Integer) row[44]);	//            RESOLVE_STATUS	$45	Integer			J
            calib.setThing_id((Long) row[45]);	//            THING_ID	$46	Integer			J
            calib.setIfield((Long) row[46]);	//            IFIELD	$47	Integer			J
            calib.setBalkan_id((Long) row[47]);	//            BALKAN_ID	$48	Integer			J
            calib.setNdetect((Integer) row[48]);	//            NDETECT	$49	Integer			J
            //            CMODELFLUX_CLEAN	$50	float[]	5		5E
            //            CMODELFLUX_CLEAN_IVAR	$51	float[]	5		5E
            //            CMODELFLUX_CLEAN_VAR	$52	float[]	5		5E
            //            CMODELFLUX_CLEAN_CHI2	$53	float[]	5		5E
            //            CMODEL_CLEAN_NUSE	$54	short[]	5		5I
            //            CMODEL_CLEAN_MJD_MAXDIFF	$55	int[]	5		5J
            //            CMODEL_CLEAN_MJD_VAR	$56	float[]	5		5E
            //            MODELFLUX_CLEAN	$57	float[]	5		5E
            //            MODELFLUX_CLEAN_IVAR	$58	float[]	5		5E
            //            MODELFLUX_CLEAN_VAR	$59	float[]	5		5E
            //            MODELFLUX_CLEAN_CHI2	$60	float[]	5		5E
            //            MODEL_CLEAN_NUSE	$61	short[]	5		5I

        }


    }
}
