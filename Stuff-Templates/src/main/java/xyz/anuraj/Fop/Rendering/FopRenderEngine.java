package xyz.anuraj.Fop.Rendering;

import org.apache.fop.apps.*;
import xyz.anuraj.common.Utils.PropertiesReader;

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

public class FopRenderEngine {

    private final PropertiesReader propertiesReader;


    private static FopFactory fopFactory;
    private final FOUserAgent foUserAgent;

    public FopRenderEngine(PropertiesReader propertiesReader) {
        this.propertiesReader = propertiesReader;
        fopFactory = FopFactory.newInstance(new File(".").toURI());
        foUserAgent = fopFactory.newFOUserAgent();
    }

    public FopRenderEngine() {
        propertiesReader = new PropertiesReader(this.getClass());
        fopFactory = FopFactory.newInstance(new File(".").toURI());
        foUserAgent = fopFactory.newFOUserAgent();
    }

    public FopRenderEngine(Class<?> initClass) {
        propertiesReader = new PropertiesReader(initClass);
        fopFactory = FopFactory.newInstance(new File(".").toURI());
        foUserAgent = fopFactory.newFOUserAgent();
    }

    public void renderDocuments(String xsltFileName, String xmldataFileName, String outputFileName){
        File xsltFile = new File(xsltFileName);
        StreamSource xmlStreamSource = new StreamSource(new File(xmldataFileName));
        try (OutputStream out = new FileOutputStream(outputFileName)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
            Result result = new SAXResult(fop.getDefaultHandler());

            transformer.transform(xmlStreamSource, result);
        } catch (FOPException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }




}
