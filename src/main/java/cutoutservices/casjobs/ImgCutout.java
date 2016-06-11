/**
 * ImgCutout.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cutoutservices.casjobs;

public interface ImgCutout extends javax.xml.rpc.Service {

    /**
     * This is an <b>XML Web Service</b> interface to fetch <b>JPEG</b>
     * image cutouts from the <b>SDSS </b> image archive.<br>Send comments
     * to <b>Maria Nieto-Santisteban</b> -- nieto@pha.jhu.edu
     */
    String getImgCutoutSoapAddress();

    cutoutservices.casjobs.ImgCutoutSoap_PortType getImgCutoutSoap() throws javax.xml.rpc.ServiceException;

    cutoutservices.casjobs.ImgCutoutSoap_PortType getImgCutoutSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
