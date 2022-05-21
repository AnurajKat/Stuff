package xyz.anuraj.Fop.Rendering;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import xyz.anuraj.common.CustomExceptions.PropertyNotFoundException;
import xyz.anuraj.common.Utils.PropertiesReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class FopRenderEngineTest {
    private static PropertiesReader propertiesReader;

    @BeforeAll
    public static void init() {
        propertiesReader = new PropertiesReader("application.properties",FopRenderEngineTest.class);
    }

    @Test
    public void renderDocumentTest() throws PropertyNotFoundException {
        assertNull(convertToPDF());
    }

    private Executable convertToPDF() throws PropertyNotFoundException {
        String xsltFilePathAndName = propertiesReader.getProperty("test.template.xslt.location");//String.join("\\",basePath,"fop-docs","name2fo.xsl");
        String xmlFilePathAndName = propertiesReader.getProperty("test.data.xml.location");//String.join("\\",basePath,"data-documents","test.xml");
        String pdfFilePathAndName= propertiesReader.getProperty("test.output.file.name");//String.join("/",propertiesReader.getProperty("test.output.path"),"testOutput.pdf");
        FopRenderEngine fopRenderEngine = new FopRenderEngine(propertiesReader);
        fopRenderEngine.renderDocuments(xsltFilePathAndName,xmlFilePathAndName,pdfFilePathAndName);
        return null;
    }
}
