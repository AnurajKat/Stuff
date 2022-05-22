package xyz.anuraj.openHtmlToPdf;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xyz.anuraj.common.CustomExceptions.HtmlToPdfRenderFailureException;
import xyz.anuraj.common.CustomExceptions.PropertyNotFoundException;
import xyz.anuraj.common.Utils.PropertiesReader;

import java.io.File;

public class openHtmlToPdfRenderTest {

    private static PropertiesReader propertiesReader;

    @BeforeAll
    public static void init () {
        propertiesReader = new PropertiesReader(openHtmlToPdfRenderTest.class);
    }

    @Test
    public void HtmlToPdfRenderertest() throws PropertyNotFoundException {

        String inputHtml = String.join("/",propertiesReader.getProperty("test.htmlToPdf.html.location"),"test.html");
        String outputPdf = String.join("/",propertiesReader.getProperty("test.output.location"),"H2P.pdf");
        HtmlToPdfRenderer htmlToPdfRenderer = new HtmlToPdfRenderer(propertiesReader);
        try {
           htmlToPdfRenderer.htmlToPdf(inputHtml,outputPdf);
        } catch (HtmlToPdfRenderFailureException e) {
            e.printStackTrace();
        }

        File checkFile = new File(outputPdf);
        Assertions.assertTrue(checkFile.exists());
    }

}
