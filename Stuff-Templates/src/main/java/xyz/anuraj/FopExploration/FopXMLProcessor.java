package xyz.anuraj.FopExploration;

import org.apache.fop.apps.*;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FopXMLProcessor {
    static PropertiesReader propertiesReader;

    public static void main(String[] args) {
        FopXMLProcessor fopXMLProcessor = new FopXMLProcessor();
        propertiesReader = new PropertiesReader();
        try {
            fopXMLProcessor.convertToPDF();
        } catch (FOPException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private void convertToPDF() throws IOException, FOPException, TransformerException {
        String basePath = "Stuff-Templates\\src\\main\\resources";
        String outputPath= "Stuff-Templates\\target";
        String xsltFilePathAndName = propertiesReader.getProperty("test.template.xslt.location");//String.join("\\",basePath,"fop-docs","name2fo.xsl");
        String xmlFilePathAndName = propertiesReader.getProperty("test.data.xml.location");//String.join("\\",basePath,"data-documents","test.xml");
        String pdfFilePathAndName= String.join("\\",outputPath,"testOutput.pdf");
        File xsltFile=new File(xsltFilePathAndName);
        StreamSource xmlStreamSource = new StreamSource(new File(xmlFilePathAndName));
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        try (OutputStream out = new FileOutputStream(pdfFilePathAndName)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
            Result result = new SAXResult(fop.getDefaultHandler());

            transformer.transform(xmlStreamSource, result);
        }

    }
}
