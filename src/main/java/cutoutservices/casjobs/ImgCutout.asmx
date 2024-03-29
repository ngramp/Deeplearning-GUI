<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://skyserver.sdss.org/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://skyserver.sdss.org/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">This is an &lt;b&gt;XML Web Service&lt;/b&gt; interface to fetch &lt;b&gt;JPEG&lt;/b&gt; image cutouts from the &lt;b&gt;SDSS &lt;/b&gt; image archive.&lt;br&gt;Send comments to &lt;b&gt;Maria Nieto-Santisteban&lt;/b&gt; -- nieto@pha.jhu.edu</wsdl:documentation>
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://skyserver.sdss.org/">
      <s:element name="Revisions">
        <s:complexType />
      </s:element>
      <s:element name="RevisionsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="RevisionsResult" type="tns:ArrayOfString" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfString">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="string" nillable="true" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetJpeg">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="ra_" type="s:double" />
            <s:element minOccurs="1" maxOccurs="1" name="dec_" type="s:double" />
            <s:element minOccurs="1" maxOccurs="1" name="scale_" type="s:double" />
            <s:element minOccurs="1" maxOccurs="1" name="width_" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="height_" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="opt_" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetJpegResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetJpegResult" type="s:base64Binary" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetJpegQuery">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="ra_" type="s:double" />
            <s:element minOccurs="1" maxOccurs="1" name="dec_" type="s:double" />
            <s:element minOccurs="1" maxOccurs="1" name="scale_" type="s:double" />
            <s:element minOccurs="1" maxOccurs="1" name="width_" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="height_" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="opt_" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="query_" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetJpegQueryResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetJpegQueryResult" type="s:base64Binary" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="DimeJpeg">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="ra_" type="s:double" />
            <s:element minOccurs="1" maxOccurs="1" name="dec_" type="s:double" />
            <s:element minOccurs="1" maxOccurs="1" name="scale_" type="s:double" />
            <s:element minOccurs="1" maxOccurs="1" name="width_" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="height_" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="opt_" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="DimeJpegResponse">
        <s:complexType />
      </s:element>
      <s:element name="ArrayOfString" nillable="true" type="tns:ArrayOfString" />
      <s:element name="base64Binary" nillable="true" type="s:base64Binary" />
    </s:schema>
  </wsdl:types>
  <wsdl:message name="RevisionsSoapIn">
    <wsdl:part name="parameters" element="tns:Revisions" />
  </wsdl:message>
  <wsdl:message name="RevisionsSoapOut">
    <wsdl:part name="parameters" element="tns:RevisionsResponse" />
  </wsdl:message>
  <wsdl:message name="GetJpegSoapIn">
    <wsdl:part name="parameters" element="tns:GetJpeg" />
  </wsdl:message>
  <wsdl:message name="GetJpegSoapOut">
    <wsdl:part name="parameters" element="tns:GetJpegResponse" />
  </wsdl:message>
  <wsdl:message name="GetJpegQuerySoapIn">
    <wsdl:part name="parameters" element="tns:GetJpegQuery" />
  </wsdl:message>
  <wsdl:message name="GetJpegQuerySoapOut">
    <wsdl:part name="parameters" element="tns:GetJpegQueryResponse" />
  </wsdl:message>
  <wsdl:message name="DimeJpegSoapIn">
    <wsdl:part name="parameters" element="tns:DimeJpeg" />
  </wsdl:message>
  <wsdl:message name="DimeJpegSoapOut">
    <wsdl:part name="parameters" element="tns:DimeJpegResponse" />
  </wsdl:message>
  <wsdl:message name="RevisionsHttpGetIn" />
  <wsdl:message name="RevisionsHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:message name="GetJpegHttpGetIn">
    <wsdl:part name="ra_" type="s:string" />
    <wsdl:part name="dec_" type="s:string" />
    <wsdl:part name="scale_" type="s:string" />
    <wsdl:part name="width_" type="s:string" />
    <wsdl:part name="height_" type="s:string" />
    <wsdl:part name="opt_" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetJpegHttpGetOut">
    <wsdl:part name="Body" element="tns:base64Binary" />
  </wsdl:message>
  <wsdl:message name="GetJpegQueryHttpGetIn">
    <wsdl:part name="ra_" type="s:string" />
    <wsdl:part name="dec_" type="s:string" />
    <wsdl:part name="scale_" type="s:string" />
    <wsdl:part name="width_" type="s:string" />
    <wsdl:part name="height_" type="s:string" />
    <wsdl:part name="opt_" type="s:string" />
    <wsdl:part name="query_" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetJpegQueryHttpGetOut">
    <wsdl:part name="Body" element="tns:base64Binary" />
  </wsdl:message>
  <wsdl:message name="DimeJpegHttpGetIn">
    <wsdl:part name="ra_" type="s:string" />
    <wsdl:part name="dec_" type="s:string" />
    <wsdl:part name="scale_" type="s:string" />
    <wsdl:part name="width_" type="s:string" />
    <wsdl:part name="height_" type="s:string" />
    <wsdl:part name="opt_" type="s:string" />
  </wsdl:message>
  <wsdl:message name="DimeJpegHttpGetOut" />
  <wsdl:message name="RevisionsHttpPostIn" />
  <wsdl:message name="RevisionsHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:message name="GetJpegHttpPostIn">
    <wsdl:part name="ra_" type="s:string" />
    <wsdl:part name="dec_" type="s:string" />
    <wsdl:part name="scale_" type="s:string" />
    <wsdl:part name="width_" type="s:string" />
    <wsdl:part name="height_" type="s:string" />
    <wsdl:part name="opt_" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetJpegHttpPostOut">
    <wsdl:part name="Body" element="tns:base64Binary" />
  </wsdl:message>
  <wsdl:message name="GetJpegQueryHttpPostIn">
    <wsdl:part name="ra_" type="s:string" />
    <wsdl:part name="dec_" type="s:string" />
    <wsdl:part name="scale_" type="s:string" />
    <wsdl:part name="width_" type="s:string" />
    <wsdl:part name="height_" type="s:string" />
    <wsdl:part name="opt_" type="s:string" />
    <wsdl:part name="query_" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetJpegQueryHttpPostOut">
    <wsdl:part name="Body" element="tns:base64Binary" />
  </wsdl:message>
  <wsdl:message name="DimeJpegHttpPostIn">
    <wsdl:part name="ra_" type="s:string" />
    <wsdl:part name="dec_" type="s:string" />
    <wsdl:part name="scale_" type="s:string" />
    <wsdl:part name="width_" type="s:string" />
    <wsdl:part name="height_" type="s:string" />
    <wsdl:part name="opt_" type="s:string" />
  </wsdl:message>
  <wsdl:message name="DimeJpegHttpPostOut" />
  <wsdl:portType name="ImgCutoutSoap">
    <wsdl:operation name="Revisions">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Return CVS revision numbers</wsdl:documentation>
      <wsdl:input message="tns:RevisionsSoapIn" />
      <wsdl:output message="tns:RevisionsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJpeg">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Returns the bytes of the Jpeg image for a given pointing&lt;br&gt;&lt;b&gt;Input 1:&lt;/b&gt; RA in degrees (double)&lt;br&gt;&lt;b&gt;Input 2:&lt;/b&gt; Dec in degrees (double)&lt;br&gt;&lt;b&gt;Input 3:&lt;/b&gt; Scale, in arcsec/pixel (double)&lt;br&gt;&lt;b&gt;Input 4:&lt;/b&gt; Width in pixels (int)&lt;br&gt;&lt;b&gt;Input 5:&lt;/b&gt; Height in pixels (int)&lt;br&gt;&lt;b&gt;Input 6:&lt;/b&gt; Drawing options (string)&lt;br&gt;&lt;b&gt;Output:&lt;/b&gt; Image (byte[])</wsdl:documentation>
      <wsdl:input message="tns:GetJpegSoapIn" />
      <wsdl:output message="tns:GetJpegSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJpegQuery">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Returns the bytes of the Jpeg image for a given pointing.&lt;br&gt;&lt;b&gt;Input 1:&lt;/b&gt; RA in degrees (double)&lt;br&gt;&lt;b&gt;Input 2:&lt;/b&gt; Dec in degrees (double)&lt;br&gt;&lt;b&gt;Input 3:&lt;/b&gt; Scale, in arcsec/pixel (double)&lt;br&gt;&lt;b&gt;Input 4:&lt;/b&gt; Width in pixels (int)&lt;br&gt;&lt;b&gt;Input 5:&lt;/b&gt; Height in pixels (int)&lt;br&gt;&lt;b&gt;Input 6:&lt;/b&gt; Drawing options (string)&lt;br&gt;&lt;b&gt;Input 7:&lt;/B&gt; Marking selection (string)&lt;br&gt;The marking selection string can be:&lt;UL&gt;&lt;LI&gt;List of objects. RA and DEC columns must be included. &lt;B&gt;Example:&lt;/B&gt;&lt;BR&gt;&lt;br&gt;&lt;TABLE&gt;&lt;TR&gt;&lt;TD&gt;&lt;b&gt;ObjId&lt;/b&gt;&lt;/TD&gt;&lt;TD&gt;&lt;b&gt;RA&lt;/b&gt;&lt;/TD&gt;&lt;TD&gt;&lt;b&gt;DEC&lt;/b&gt;&lt;/TD&gt;&lt;TD&gt;&lt;b&gt;RMag&lt;/b&gt;&lt;/TD&gt;&lt;/TR&gt;&lt;TR&gt;&lt;TD&gt;582378008234755083&lt;/TD&gt;&lt;TD&gt; 195.578582&lt;/TD&gt;&lt;TD&gt; 2.548192&lt;/TD&gt;&lt;TD&gt; 23.565&lt;/TD&gt;&lt;/TR&gt;&lt;TR&gt;&lt;TD&gt; 582378008234754800&lt;/TD&gt;&lt;TD&gt; 195.572594&lt;/TD&gt;&lt;TD&gt; 2.554787&lt;/TD&gt;&lt;TD&gt; 21.446&lt;/TD&gt;&lt;/TR&gt;&lt;/TABLE&gt;&lt;LI&gt;SELECT SQL query. RA and DEC columns must be included. &lt;B&gt;Example:&lt;/B&gt;&lt;BR&gt;&lt;br&gt;'SELECT  top 10 p.objID, p.ra, p.dec, p.r&lt;br&gt;FROM fGetObjFromRect(195.5,195.65,2.5,2.6) n,   PhotoPrimary p&lt;br&gt;WHERE n.objID=p.objID'&lt;LI&gt;String&amp;nbsp;following the pattern: &lt;B&gt;&lt;I&gt;ObjType Band (low_mag, high_mag)&lt;/I&gt;&lt;/B&gt;&lt;UL&gt;&lt;LI&gt;&lt;EM&gt;&lt;STRONG&gt;ObjType:&lt;/STRONG&gt;&lt;/EM&gt; S | G | P&lt;br&gt;S for Stars&lt;br&gt;G for Galaxies&lt;br&gt;P for both Stars and Galaxies&lt;LI&gt;&lt;STRONG&gt;&lt;EM&gt;Band:&lt;/EM&gt;&lt;/STRONG&gt;&amp;nbsp;U |&amp;nbsp;G |&amp;nbsp;R | I&amp;nbsp;|&amp;nbsp;Z | A&lt;br&gt;to select objects with &lt;STRONG&gt;&lt;EM&gt;Band &lt;/EM&gt;&lt;/STRONG&gt;BETWEEN &lt;STRONG&gt;&lt;EM&gt;low_mag&lt;/EM&gt;&lt;/STRONG&gt; AND &lt;STRONG&gt;&lt;EM&gt;high_mag&lt;/EM&gt;&lt;/STRONG&gt;&lt;P&gt;&lt;br&gt;Band 'A' will look for all the objects with values betwen &lt;b&gt;&lt;i&gt;low_mag&lt;/i&gt;&lt;/b&gt; and &lt;b&gt;&lt;i&gt;high_mag&lt;/i&gt;&lt;/b&gt; 	  for any band (compositions of ORs).&lt;br&gt;Only Stars, Galaxies, or PhotoPrimary objects will be marked when magnitude     ranges are not specified. &lt;B&gt;Examples:&lt;/B&gt;&lt;BR&gt;&lt;br&gt;S&lt;br&gt;S R (0.0, 23.5)&lt;br&gt;G A (10, 25)&lt;/P&gt;&lt;/LI&gt;&lt;/UL&gt;&lt;/LI&gt;&lt;/UL&gt;&lt;b&gt;Output:&lt;/b&gt; Image (byte[])</wsdl:documentation>
      <wsdl:input message="tns:GetJpegQuerySoapIn" />
      <wsdl:output message="tns:GetJpegQuerySoapOut" />
    </wsdl:operation>
    <wsdl:operation name="DimeJpeg">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Returns the Jpeg image for a given pointing in a SOAP attachment (DIME)&lt;br&gt;&lt;b&gt;Input 1:&lt;/b&gt; RA in degrees J2000 (double)&lt;br&gt;&lt;b&gt;Input 2:&lt;/b&gt; Dec in degrees J2000 (double)&lt;br&gt;&lt;b&gt;Input 3:&lt;/b&gt; Scale, in arcsec/pixel (double)&lt;br&gt;&lt;b&gt;Input 4:&lt;/b&gt; Width in pixels (int)&lt;br&gt;&lt;b&gt;Input 5:&lt;/b&gt; Height in pixels (int)&lt;br&gt;&lt;b&gt;Input 6:&lt;/b&gt; Drawing options (string)&lt;br&gt;&lt;b&gt;Output:&lt;/b&gt; Jpeg image in attachment</wsdl:documentation>
      <wsdl:input message="tns:DimeJpegSoapIn" />
      <wsdl:output message="tns:DimeJpegSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="ImgCutoutHttpGet">
    <wsdl:operation name="Revisions">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Return CVS revision numbers</wsdl:documentation>
      <wsdl:input message="tns:RevisionsHttpGetIn" />
      <wsdl:output message="tns:RevisionsHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJpeg">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Returns the bytes of the Jpeg image for a given pointing&lt;br&gt;&lt;b&gt;Input 1:&lt;/b&gt; RA in degrees (double)&lt;br&gt;&lt;b&gt;Input 2:&lt;/b&gt; Dec in degrees (double)&lt;br&gt;&lt;b&gt;Input 3:&lt;/b&gt; Scale, in arcsec/pixel (double)&lt;br&gt;&lt;b&gt;Input 4:&lt;/b&gt; Width in pixels (int)&lt;br&gt;&lt;b&gt;Input 5:&lt;/b&gt; Height in pixels (int)&lt;br&gt;&lt;b&gt;Input 6:&lt;/b&gt; Drawing options (string)&lt;br&gt;&lt;b&gt;Output:&lt;/b&gt; Image (byte[])</wsdl:documentation>
      <wsdl:input message="tns:GetJpegHttpGetIn" />
      <wsdl:output message="tns:GetJpegHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJpegQuery">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Returns the bytes of the Jpeg image for a given pointing.&lt;br&gt;&lt;b&gt;Input 1:&lt;/b&gt; RA in degrees (double)&lt;br&gt;&lt;b&gt;Input 2:&lt;/b&gt; Dec in degrees (double)&lt;br&gt;&lt;b&gt;Input 3:&lt;/b&gt; Scale, in arcsec/pixel (double)&lt;br&gt;&lt;b&gt;Input 4:&lt;/b&gt; Width in pixels (int)&lt;br&gt;&lt;b&gt;Input 5:&lt;/b&gt; Height in pixels (int)&lt;br&gt;&lt;b&gt;Input 6:&lt;/b&gt; Drawing options (string)&lt;br&gt;&lt;b&gt;Input 7:&lt;/B&gt; Marking selection (string)&lt;br&gt;The marking selection string can be:&lt;UL&gt;&lt;LI&gt;List of objects. RA and DEC columns must be included. &lt;B&gt;Example:&lt;/B&gt;&lt;BR&gt;&lt;br&gt;&lt;TABLE&gt;&lt;TR&gt;&lt;TD&gt;&lt;b&gt;ObjId&lt;/b&gt;&lt;/TD&gt;&lt;TD&gt;&lt;b&gt;RA&lt;/b&gt;&lt;/TD&gt;&lt;TD&gt;&lt;b&gt;DEC&lt;/b&gt;&lt;/TD&gt;&lt;TD&gt;&lt;b&gt;RMag&lt;/b&gt;&lt;/TD&gt;&lt;/TR&gt;&lt;TR&gt;&lt;TD&gt;582378008234755083&lt;/TD&gt;&lt;TD&gt; 195.578582&lt;/TD&gt;&lt;TD&gt; 2.548192&lt;/TD&gt;&lt;TD&gt; 23.565&lt;/TD&gt;&lt;/TR&gt;&lt;TR&gt;&lt;TD&gt; 582378008234754800&lt;/TD&gt;&lt;TD&gt; 195.572594&lt;/TD&gt;&lt;TD&gt; 2.554787&lt;/TD&gt;&lt;TD&gt; 21.446&lt;/TD&gt;&lt;/TR&gt;&lt;/TABLE&gt;&lt;LI&gt;SELECT SQL query. RA and DEC columns must be included. &lt;B&gt;Example:&lt;/B&gt;&lt;BR&gt;&lt;br&gt;'SELECT  top 10 p.objID, p.ra, p.dec, p.r&lt;br&gt;FROM fGetObjFromRect(195.5,195.65,2.5,2.6) n,   PhotoPrimary p&lt;br&gt;WHERE n.objID=p.objID'&lt;LI&gt;String&amp;nbsp;following the pattern: &lt;B&gt;&lt;I&gt;ObjType Band (low_mag, high_mag)&lt;/I&gt;&lt;/B&gt;&lt;UL&gt;&lt;LI&gt;&lt;EM&gt;&lt;STRONG&gt;ObjType:&lt;/STRONG&gt;&lt;/EM&gt; S | G | P&lt;br&gt;S for Stars&lt;br&gt;G for Galaxies&lt;br&gt;P for both Stars and Galaxies&lt;LI&gt;&lt;STRONG&gt;&lt;EM&gt;Band:&lt;/EM&gt;&lt;/STRONG&gt;&amp;nbsp;U |&amp;nbsp;G |&amp;nbsp;R | I&amp;nbsp;|&amp;nbsp;Z | A&lt;br&gt;to select objects with &lt;STRONG&gt;&lt;EM&gt;Band &lt;/EM&gt;&lt;/STRONG&gt;BETWEEN &lt;STRONG&gt;&lt;EM&gt;low_mag&lt;/EM&gt;&lt;/STRONG&gt; AND &lt;STRONG&gt;&lt;EM&gt;high_mag&lt;/EM&gt;&lt;/STRONG&gt;&lt;P&gt;&lt;br&gt;Band 'A' will look for all the objects with values betwen &lt;b&gt;&lt;i&gt;low_mag&lt;/i&gt;&lt;/b&gt; and &lt;b&gt;&lt;i&gt;high_mag&lt;/i&gt;&lt;/b&gt; 	  for any band (compositions of ORs).&lt;br&gt;Only Stars, Galaxies, or PhotoPrimary objects will be marked when magnitude     ranges are not specified. &lt;B&gt;Examples:&lt;/B&gt;&lt;BR&gt;&lt;br&gt;S&lt;br&gt;S R (0.0, 23.5)&lt;br&gt;G A (10, 25)&lt;/P&gt;&lt;/LI&gt;&lt;/UL&gt;&lt;/LI&gt;&lt;/UL&gt;&lt;b&gt;Output:&lt;/b&gt; Image (byte[])</wsdl:documentation>
      <wsdl:input message="tns:GetJpegQueryHttpGetIn" />
      <wsdl:output message="tns:GetJpegQueryHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="DimeJpeg">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Returns the Jpeg image for a given pointing in a SOAP attachment (DIME)&lt;br&gt;&lt;b&gt;Input 1:&lt;/b&gt; RA in degrees J2000 (double)&lt;br&gt;&lt;b&gt;Input 2:&lt;/b&gt; Dec in degrees J2000 (double)&lt;br&gt;&lt;b&gt;Input 3:&lt;/b&gt; Scale, in arcsec/pixel (double)&lt;br&gt;&lt;b&gt;Input 4:&lt;/b&gt; Width in pixels (int)&lt;br&gt;&lt;b&gt;Input 5:&lt;/b&gt; Height in pixels (int)&lt;br&gt;&lt;b&gt;Input 6:&lt;/b&gt; Drawing options (string)&lt;br&gt;&lt;b&gt;Output:&lt;/b&gt; Jpeg image in attachment</wsdl:documentation>
      <wsdl:input message="tns:DimeJpegHttpGetIn" />
      <wsdl:output message="tns:DimeJpegHttpGetOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="ImgCutoutHttpPost">
    <wsdl:operation name="Revisions">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Return CVS revision numbers</wsdl:documentation>
      <wsdl:input message="tns:RevisionsHttpPostIn" />
      <wsdl:output message="tns:RevisionsHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJpeg">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Returns the bytes of the Jpeg image for a given pointing&lt;br&gt;&lt;b&gt;Input 1:&lt;/b&gt; RA in degrees (double)&lt;br&gt;&lt;b&gt;Input 2:&lt;/b&gt; Dec in degrees (double)&lt;br&gt;&lt;b&gt;Input 3:&lt;/b&gt; Scale, in arcsec/pixel (double)&lt;br&gt;&lt;b&gt;Input 4:&lt;/b&gt; Width in pixels (int)&lt;br&gt;&lt;b&gt;Input 5:&lt;/b&gt; Height in pixels (int)&lt;br&gt;&lt;b&gt;Input 6:&lt;/b&gt; Drawing options (string)&lt;br&gt;&lt;b&gt;Output:&lt;/b&gt; Image (byte[])</wsdl:documentation>
      <wsdl:input message="tns:GetJpegHttpPostIn" />
      <wsdl:output message="tns:GetJpegHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJpegQuery">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Returns the bytes of the Jpeg image for a given pointing.&lt;br&gt;&lt;b&gt;Input 1:&lt;/b&gt; RA in degrees (double)&lt;br&gt;&lt;b&gt;Input 2:&lt;/b&gt; Dec in degrees (double)&lt;br&gt;&lt;b&gt;Input 3:&lt;/b&gt; Scale, in arcsec/pixel (double)&lt;br&gt;&lt;b&gt;Input 4:&lt;/b&gt; Width in pixels (int)&lt;br&gt;&lt;b&gt;Input 5:&lt;/b&gt; Height in pixels (int)&lt;br&gt;&lt;b&gt;Input 6:&lt;/b&gt; Drawing options (string)&lt;br&gt;&lt;b&gt;Input 7:&lt;/B&gt; Marking selection (string)&lt;br&gt;The marking selection string can be:&lt;UL&gt;&lt;LI&gt;List of objects. RA and DEC columns must be included. &lt;B&gt;Example:&lt;/B&gt;&lt;BR&gt;&lt;br&gt;&lt;TABLE&gt;&lt;TR&gt;&lt;TD&gt;&lt;b&gt;ObjId&lt;/b&gt;&lt;/TD&gt;&lt;TD&gt;&lt;b&gt;RA&lt;/b&gt;&lt;/TD&gt;&lt;TD&gt;&lt;b&gt;DEC&lt;/b&gt;&lt;/TD&gt;&lt;TD&gt;&lt;b&gt;RMag&lt;/b&gt;&lt;/TD&gt;&lt;/TR&gt;&lt;TR&gt;&lt;TD&gt;582378008234755083&lt;/TD&gt;&lt;TD&gt; 195.578582&lt;/TD&gt;&lt;TD&gt; 2.548192&lt;/TD&gt;&lt;TD&gt; 23.565&lt;/TD&gt;&lt;/TR&gt;&lt;TR&gt;&lt;TD&gt; 582378008234754800&lt;/TD&gt;&lt;TD&gt; 195.572594&lt;/TD&gt;&lt;TD&gt; 2.554787&lt;/TD&gt;&lt;TD&gt; 21.446&lt;/TD&gt;&lt;/TR&gt;&lt;/TABLE&gt;&lt;LI&gt;SELECT SQL query. RA and DEC columns must be included. &lt;B&gt;Example:&lt;/B&gt;&lt;BR&gt;&lt;br&gt;'SELECT  top 10 p.objID, p.ra, p.dec, p.r&lt;br&gt;FROM fGetObjFromRect(195.5,195.65,2.5,2.6) n,   PhotoPrimary p&lt;br&gt;WHERE n.objID=p.objID'&lt;LI&gt;String&amp;nbsp;following the pattern: &lt;B&gt;&lt;I&gt;ObjType Band (low_mag, high_mag)&lt;/I&gt;&lt;/B&gt;&lt;UL&gt;&lt;LI&gt;&lt;EM&gt;&lt;STRONG&gt;ObjType:&lt;/STRONG&gt;&lt;/EM&gt; S | G | P&lt;br&gt;S for Stars&lt;br&gt;G for Galaxies&lt;br&gt;P for both Stars and Galaxies&lt;LI&gt;&lt;STRONG&gt;&lt;EM&gt;Band:&lt;/EM&gt;&lt;/STRONG&gt;&amp;nbsp;U |&amp;nbsp;G |&amp;nbsp;R | I&amp;nbsp;|&amp;nbsp;Z | A&lt;br&gt;to select objects with &lt;STRONG&gt;&lt;EM&gt;Band &lt;/EM&gt;&lt;/STRONG&gt;BETWEEN &lt;STRONG&gt;&lt;EM&gt;low_mag&lt;/EM&gt;&lt;/STRONG&gt; AND &lt;STRONG&gt;&lt;EM&gt;high_mag&lt;/EM&gt;&lt;/STRONG&gt;&lt;P&gt;&lt;br&gt;Band 'A' will look for all the objects with values betwen &lt;b&gt;&lt;i&gt;low_mag&lt;/i&gt;&lt;/b&gt; and &lt;b&gt;&lt;i&gt;high_mag&lt;/i&gt;&lt;/b&gt; 	  for any band (compositions of ORs).&lt;br&gt;Only Stars, Galaxies, or PhotoPrimary objects will be marked when magnitude     ranges are not specified. &lt;B&gt;Examples:&lt;/B&gt;&lt;BR&gt;&lt;br&gt;S&lt;br&gt;S R (0.0, 23.5)&lt;br&gt;G A (10, 25)&lt;/P&gt;&lt;/LI&gt;&lt;/UL&gt;&lt;/LI&gt;&lt;/UL&gt;&lt;b&gt;Output:&lt;/b&gt; Image (byte[])</wsdl:documentation>
      <wsdl:input message="tns:GetJpegQueryHttpPostIn" />
      <wsdl:output message="tns:GetJpegQueryHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="DimeJpeg">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Returns the Jpeg image for a given pointing in a SOAP attachment (DIME)&lt;br&gt;&lt;b&gt;Input 1:&lt;/b&gt; RA in degrees J2000 (double)&lt;br&gt;&lt;b&gt;Input 2:&lt;/b&gt; Dec in degrees J2000 (double)&lt;br&gt;&lt;b&gt;Input 3:&lt;/b&gt; Scale, in arcsec/pixel (double)&lt;br&gt;&lt;b&gt;Input 4:&lt;/b&gt; Width in pixels (int)&lt;br&gt;&lt;b&gt;Input 5:&lt;/b&gt; Height in pixels (int)&lt;br&gt;&lt;b&gt;Input 6:&lt;/b&gt; Drawing options (string)&lt;br&gt;&lt;b&gt;Output:&lt;/b&gt; Jpeg image in attachment</wsdl:documentation>
      <wsdl:input message="tns:DimeJpegHttpPostIn" />
      <wsdl:output message="tns:DimeJpegHttpPostOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="ImgCutoutSoap" type="tns:ImgCutoutSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="Revisions">
      <soap:operation soapAction="http://skyserver.sdss.org/Revisions" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJpeg">
      <soap:operation soapAction="http://skyserver.sdss.org/GetJpeg" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJpegQuery">
      <soap:operation soapAction="http://skyserver.sdss.org/GetJpegQuery" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DimeJpeg">
      <soap:operation soapAction="http://skyserver.sdss.org/DimeJpeg" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="ImgCutoutSoap12" type="tns:ImgCutoutSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="Revisions">
      <soap12:operation soapAction="http://skyserver.sdss.org/Revisions" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJpeg">
      <soap12:operation soapAction="http://skyserver.sdss.org/GetJpeg" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJpegQuery">
      <soap12:operation soapAction="http://skyserver.sdss.org/GetJpegQuery" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DimeJpeg">
      <soap12:operation soapAction="http://skyserver.sdss.org/DimeJpeg" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="ImgCutoutHttpGet" type="tns:ImgCutoutHttpGet">
    <http:binding verb="GET" />
    <wsdl:operation name="Revisions">
      <http:operation location="/Revisions" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJpeg">
      <http:operation location="/GetJpeg" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJpegQuery">
      <http:operation location="/GetJpegQuery" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DimeJpeg">
      <http:operation location="/DimeJpeg" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="ImgCutoutHttpPost" type="tns:ImgCutoutHttpPost">
    <http:binding verb="POST" />
    <wsdl:operation name="Revisions">
      <http:operation location="/Revisions" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJpeg">
      <http:operation location="/GetJpeg" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJpegQuery">
      <http:operation location="/GetJpegQuery" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DimeJpeg">
      <http:operation location="/DimeJpeg" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="ImgCutout">
    <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">This is an &lt;b&gt;XML Web Service&lt;/b&gt; interface to fetch &lt;b&gt;JPEG&lt;/b&gt; image cutouts from the &lt;b&gt;SDSS &lt;/b&gt; image archive.&lt;br&gt;Send comments to &lt;b&gt;Maria Nieto-Santisteban&lt;/b&gt; -- nieto@pha.jhu.edu</wsdl:documentation>
    <wsdl:port name="ImgCutoutSoap" binding="tns:ImgCutoutSoap">
      <soap:address location="http://casjobs.sdss.org/ImgCutoutDR7/ImgCutout.asmx" />
    </wsdl:port>
    <wsdl:port name="ImgCutoutSoap12" binding="tns:ImgCutoutSoap12">
      <soap12:address location="http://casjobs.sdss.org/ImgCutoutDR7/ImgCutout.asmx" />
    </wsdl:port>
    <wsdl:port name="ImgCutoutHttpGet" binding="tns:ImgCutoutHttpGet">
      <http:address location="http://casjobs.sdss.org/ImgCutoutDR7/ImgCutout.asmx" />
    </wsdl:port>
    <wsdl:port name="ImgCutoutHttpPost" binding="tns:ImgCutoutHttpPost">
      <http:address location="http://casjobs.sdss.org/ImgCutoutDR7/ImgCutout.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>