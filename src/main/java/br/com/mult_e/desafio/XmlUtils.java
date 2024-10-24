package br.com.mult_e.desafio;

import br.com.mult_e.desafio.model.Livro;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class XmlUtils {

    public static String getXmlLivro(Livro livro) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Livro.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(livro, writer);
        return writer.toString();
    }

    public static byte[] getPdfFromXml(String xml) throws Exception {
        InputStream xslInputStream = XmlUtils.class.getResourceAsStream("/livro.xsl");
        StreamSource xsltFile = new StreamSource(xslInputStream);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(xsltFile);
        StreamSource xmlSource = new StreamSource(new StringReader(xml));
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, outStream);
        Result res = new SAXResult(fop.getDefaultHandler());
        transformer.transform(xmlSource, res);
        return outStream.toByteArray();
    }


}
