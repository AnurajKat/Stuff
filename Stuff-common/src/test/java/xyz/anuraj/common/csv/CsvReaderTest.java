package xyz.anuraj.common.csv;

import com.opencsv.CSVReader;
import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class CsvReaderTest {

    String fileName = "src/test/resources/testData-1.csv";

    static List<String> columnNames;

    static CsvReader csvReader;
    static List<List<String>> data;

    @BeforeAll
    public static void setUp() {
        csvReader = new CsvReader();
        data= Arrays.asList(
                Arrays.asList("1","sensation","vaski"),
                Arrays.asList("2","nails","noga erez"),
                Arrays.asList("3","remember","friction"),
                Arrays.asList("4","hide and seek","tayo sound"));
        columnNames = Arrays.asList("serial no", "title", "author");
    }

    @Test
    public void testLoadCsvFile() {
        CSVReader loadedCsv = csvReader.loadCsvFile(fileName);
        Assertions.assertNotNull(loadedCsv);
    }

    @Test
    public void readCsvFile() {

        List<String[]> csvData = csvReader.getCsvData(csvReader.loadCsvFile(fileName));
        Arrays.stream(csvData.get(0))
                .forEach(columnName ->
                        Assertions.assertTrue(columnNames.contains(columnName)));
    }
    @Test
    public void readCsvFileFromFileName() {
        List<String[]> csvData = csvReader.getCsvData(fileName);
        Arrays.stream(csvData.get(0))
                .forEach(columnName ->
                        Assertions.assertTrue(columnNames.contains(columnName)));
    }

    @Test
    public void readCsvToJson() {
        JSONArray jsonArray = csvReader.readCsvToJson(fileName);
        Assertions.assertNotNull(jsonArray);
        Assertions.assertEquals(data.get(2).get(2),jsonArray.getJSONObject(2).get("author"));
        Assertions.assertEquals(data.get(3).get(1),jsonArray.getJSONObject(3).get("title"));
    }

}