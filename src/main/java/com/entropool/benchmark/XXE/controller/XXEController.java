package com.entropool.benchmark.XXE.controller;
import com.entropool.benchmark.XXE.dto.RootDTO;
import com.google.protobuf.Internal;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.tomcat.util.digester.Digester;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@SuppressWarnings("unchecked")
@Controller
public class XXEController {
    @RequestMapping(value = "/DocumentBuilderFactoryXXE")
    public String DocumentBuilderFactoryXXE(@RequestBody String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        String FEATURE = null;
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        dbf.setXIncludeAware(false);
        dbf.setExpandEntityReferences(false);
        StringReader sr = new StringReader(xml);
        InputSource is = new InputSource(sr);
        builder.parse(is);
        sr.close();
        return "success";
    }

    @RequestMapping(value = "/SAXReaderXXE")
    public String SAXReaderXXE(@RequestBody String xml) throws ParserConfigurationException, IOException, SAXException {
        try {
            org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
            reader.read(new StringReader(xml));
        } catch (Exception e) {
            System.out.println(e);
            return "except";
        }
        return "success";
    }

    @RequestMapping(value = "/SAXReaderXXE2")
    public String SAXReaderXXE2(@RequestBody String xml) throws ParserConfigurationException, IOException, SAXException, DocumentException {
        SAXReader sax=new SAXReader();
        Document document=sax.read(new ByteArrayInputStream(xml.getBytes()));
        Element root=document.getRootElement();
        List rowList = root.selectNodes("//msg");
        Iterator<?> iter1 = rowList.iterator();
        if (iter1.hasNext()) {
            Element beanNode = (Element) iter1.next();
            Internal.MapAdapter modelMap = null;
            modelMap.put("success",true);
            modelMap.put("resp",beanNode.getTextTrim());
        }
        return "success";

    }

    @RequestMapping(value = "/DigesterXXE")
    public String DigesterXXE(@RequestBody String xml) throws ParserConfigurationException, IOException, SAXException {
        try {
            Digester digester = new Digester();
            digester.parse(new ByteArrayInputStream(xml.getBytes()));
        } catch (Exception e) {
            System.out.println(e);
            return "except";

        }
        return "success";
    }

    @RequestMapping(value = "/SAXParserFactoryXXE")
    public String SAXParserFactoryXXE(@RequestBody String xml) throws ParserConfigurationException, IOException, SAXException {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(new ByteArrayInputStream(xml.getBytes()), new DefaultHandler());
            return "success";
        } catch (Exception e) {
            return "EXCEPT";
        }
    }

    @RequestMapping(value = "/SAXTransformerFactoryXXE")
    public String SAXTransformerFactoryXXE(HttpServletRequest request) throws ParserConfigurationException, IOException, SAXException, TransformerConfigurationException {
        StreamSource source = null;
        try {
            source = new StreamSource(request.getInputStream());
            SAXTransformerFactory sf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
//        sf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
//        sf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            sf.newTransformerHandler(source);
        } catch (IOException | TransformerConfigurationException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping(value = "/SchemaFactoryXXE")
    public String SchemaFactoryXXE(HttpServletRequest request) throws ParserConfigurationException, IOException, SAXException
    {
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        try {
            StreamSource source = new StreamSource(request.getInputStream());
            Schema schema = factory.newSchema(source);
            return "success";
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("/SchemaFactoryXXE2")
    public  String SchemaFactoryXXE2(HttpServletRequest request)
    {
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = null;
        try {
            schema = factory.newSchema();
            Validator validator = schema.newValidator();
            StreamSource source = new StreamSource(request.getInputStream());
            validator.validate(source);
            return "success";
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/TransformerFactoryXXE")
    public String TransformerFactoryXXE(HttpServletRequest request) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource source = new StreamSource(request.getInputStream());
        tf.newTransformer().transform(source, new DOMResult());
        return "success";
    }

    @PostMapping(value = "/UnmarshallerXXE")
    public String UnmarshallerXXE(HttpServletRequest request) throws IOException, JAXBException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RootDTO.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            RootDTO rootDTO = (RootDTO) unmarshaller.unmarshal(request.getInputStream());
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail" ;
        }
    }

    @RequestMapping(value = "/XMLReaderFactoryXXE")
    public String XMLReaderFactoryXXE(@RequestBody String xml) throws ParserConfigurationException, IOException, SAXException, DocumentException {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.parse(new InputSource(new StringReader(xml)));
        return "xmlReader XXE vuln code";
    }

    @RequestMapping(value = "/XMLInputFactoryXXE")
    public String XMLInputFactoryXXE(HttpServletRequest request) throws XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader reader = null;
        try {
            reader = xmlInputFactory.createXMLStreamReader(request.getInputStream());
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
        try {
            assert reader != null;
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    System.out.print(reader.getName());
                } else if (type == XMLStreamConstants.CHARACTERS) {
                    System.out.println("type" + type);
                } else if (type == XMLStreamConstants.END_ELEMENT) {
                    System.out.println(reader.getName());
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @PostMapping("/SAXBuilderXXE")
    public String SAXBuilderXXE(HttpServletRequest request) {
        try {
            InputStream inputStream = request.getInputStream();
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }
            String xmlContent = stringBuilder.toString();
            SAXBuilder builder = new SAXBuilder();
            builder.build(new InputSource(new StringReader(xmlContent)));

            return "SAXBuilder xxe vuln code";
        } catch (Exception e) {
            return "EXCEPT: " + e.getMessage();
        }
    }

}


