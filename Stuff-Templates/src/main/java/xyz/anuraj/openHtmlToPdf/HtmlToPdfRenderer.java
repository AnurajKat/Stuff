package xyz.anuraj.openHtmlToPdf;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.w3c.dom.Document;
import xyz.anuraj.common.CustomExceptions.PropertyNotFoundException;
import xyz.anuraj.common.CustomExceptions.HtmlToPdfRenderFailureException;
import xyz.anuraj.common.Utils.PropertiesReader;

import java.io.*;
import java.nio.file.FileSystems;

public class HtmlToPdfRenderer {

    private final PropertiesReader propertiesReader;
    private String baseUri;

    public HtmlToPdfRenderer(PropertiesReader propertiesReader) {
        this.propertiesReader = propertiesReader;
        setBaseUri();
    }

    public HtmlToPdfRenderer() {
        propertiesReader = new PropertiesReader(HtmlToPdfRenderer.class);
        setBaseUri();
    }

    public HtmlToPdfRenderer(PropertiesReader propertiesReader, String baseUri) {
        this.propertiesReader = propertiesReader;
        setBaseUri(baseUri);
    }

    public void setBaseUri(String newBaseUri) {
        String res;
        res= FileSystems.getDefault().getPath(newBaseUri).toUri().toString();
        baseUri = res;
    }

    private void setBaseUri() {
       try {
           setBaseUri(propertiesReader.getProperty("xyz.anuraj.html.template.resources"));
       } catch (PropertyNotFoundException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
       }
    }

    private static Document parseHtml5Doc(String htmlFile, String charSetName) throws IOException {
        org.jsoup.nodes.Document doc;
        doc = Jsoup.parse(new File(htmlFile), charSetName);
        return new W3CDom().fromJsoup(doc);
    }

    public void htmlToPdf(String htmlDocName, String pdfFileName) throws HtmlToPdfRenderFailureException {

        try(OutputStream outputStream = new FileOutputStream(pdfFileName)) {

            Document htmlDocument = parseHtml5Doc(htmlDocName, propertiesReader.getProperty("xyz.anuraj.html.charset"));
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withUri(pdfFileName);
            builder.toStream(outputStream);
            builder.withW3cDocument(htmlDocument, baseUri);
            builder.run();
        } catch (PropertyNotFoundException | IOException e) {
            e.printStackTrace();
            throw new HtmlToPdfRenderFailureException(htmlDocName,e.getCause());
        }
    }
}
