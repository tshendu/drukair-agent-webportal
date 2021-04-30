package com.ttpl.asd.drukairagentwebportal.service;

import com.ttpl.asd.drukairagentwebportal.auth.dao.UserDao;
import com.ttpl.asd.drukairagentwebportal.auth.model.User;
import com.ttpl.asd.drukairagentwebportal.dto.UserDataDTO;
import com.ttpl.asd.drukairagentwebportal.helper.ResponseMessage;
import com.ttpl.asd.drukairagentwebportal.helper.SystemDataInt;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserDataService {

    @Autowired
    private UserDao userDao;

    public ResponseMessage getCustomerDetails(String agentCode, Date startDate, Date endDate) {
        ResponseMessage responseMessage = new ResponseMessage();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String stringStartDate = dateFormat.format(startDate);
        final String stringEndDate = dateFormat.format(endDate);
        if (agentCode != null) {
            User user = userDao.getUser(agentCode);
            if (user == null) {
                responseMessage.setText("Agent code not found.");
                responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                return responseMessage;
            }
        }
//        String wsURL = "http://192.168.124.118:8000/sap/bc/srt/wsdl/flv_10002A111AD1/bndg_url/sap/bc/srt/rfc/sap/zfi_outstanding_api/910/zfi_outstanding_api/zfi_outstanding_api?sap-client=910";
//        String wsURL = "http://dhieccdev.dhi.bt:8000/sap/bc/srt/rfc/sap/zfi_outstanding_api/910/zfi_outstanding_api/zfi_outstanding_api";
//        String wsURL = "http://192.168.124.118:8000/sap/bc/srt/rfc/sap/zfi_outstanding_api/910/zfi_outstanding_api/zfi_outstanding_api";
//        String wsURL = "http://DECCPRDCI.dhi.bt:8000/sap/bc/srt/wsdl/flv_10002A111AD1/bndg_url/sap/bc/srt/rfc/sap/zfi_outstanding_api/960/zfi_outstanding_api/zfi_outstanding_api?sap-client=960";
//        String wsURL = "http://192.168.124.113:8000/sap/bc/srt/wsdl/flv_10002A111AD1/bndg_url/sap/bc/srt/rfc/sap/zfi_outstanding_api/960/zfi_outstanding_api/zfi_outstanding_api?sap-client=960";
        String wsURL = "http://192.168.124.113:8000/sap/bc/srt/rfc/sap/zfi_outstanding_api/960/zfi_outstanding_api/zfi_outstanding_api";

        String name = "ABAP4";
//        String password = "Abap@12345";
        String password = "AgentDACL@21";
        String authString = name + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);

        URL url = null;
        URLConnection connection = null;
        HttpURLConnection httpConn = null;
        String responseString = null;
        String outputString = "";
        ByteArrayOutputStream bout = null;
        OutputStream out = null;
        InputStreamReader isr = null;
        BufferedReader in = null;
//        String headQuater = "HQ01";
        String thimphu = "QJC1";
        String xmlInput =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:sap-com:document:sap:soap:functions:mc-style\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<urn:ZfiCustomerOutstanding>" +
                        "<ImCustomer>" + agentCode + "</ImCustomer>" +
                        "<ImDateFrom>" + stringStartDate + "</ImDateFrom>" +
                        "<ImDateTo>" + stringEndDate + "</ImDateTo>" +
                        "<ImProfitCenter>" + thimphu + "</ImProfitCenter>" +
                        "</urn:ZfiCustomerOutstanding>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        try {
            url = new URL(wsURL);
            connection = url.openConnection();
            connection.setRequestProperty("Authorization", "Basic " + authStringEnc);

            httpConn = (HttpURLConnection) connection;

            byte[] buffer = new byte[xmlInput.length()];
            buffer = xmlInput.getBytes();

            //set the appropriate HTTP parameters.
            String SOAPAction = "";
            httpConn.setRequestProperty("Content-Length", String.valueOf(buffer.length));
//            httpConn.setRequestProperty("Content-Length", String.valueOf("10691"));
            httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

            httpConn.setRequestProperty("SOAPAction", SOAPAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            out = httpConn.getOutputStream();
            out.write(buffer);
            out.close();

            // read the response and write to standard out.
            isr = new InputStreamReader(httpConn.getInputStream());

            in = new BufferedReader(isr);
            while ((responseString = in.readLine()) != null) {
                outputString = outputString + responseString;
            }
            Document document = parseXmlFile(outputString);
            NodeList nodeList = document.getElementsByTagName("n0:ZfiCustomerOutstandingResponse");
            String webServiceResponse = nodeList.item(0).getTextContent();
            System.out.println("The response from the web service is : " + webServiceResponse);
            String userData = webServiceResponse.substring(1);

            UserDataDTO userDataDTO = new UserDataDTO();
            userDataDTO.setUserData(userData);
            responseMessage.setDTO(userDataDTO);
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            return responseMessage;

        } catch (Exception e) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
//            responseMessage.setText("System encounter problem please contact Drukair Administrator.");
            responseMessage.setText(e.getMessage());
            return responseMessage;
        }
    }


    private Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
