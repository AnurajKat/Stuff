package xyz.anuraj.common.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.StringUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvReader {

    private static final Logger logger = LoggerFactory.getLogger(CsvReader.class);

    public CSVReader loadCsvFile(String fileName) {

        if (isFilePresent(fileName)) {
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(fileName);
            } catch (FileNotFoundException e) {
            }
            CSVReader csvReader = new CSVReader(fileReader);
            return csvReader;

        }
        logger.error("File %s is not present", fileName);
        return null;
    }


    private boolean isFilePresent(String filename){
        File f = new File(filename);
        return f.exists() && f.isFile();
    }

    public List<String[]> getCsvData(CSVReader csvFile) {
        try {
            return csvFile.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public List<String[]> getCsvData(String fileName) {
        return getCsvData(loadCsvFile(fileName));
    }

    public JSONArray readCsvToJson(String filename) {
        if(isFilePresent(filename)) {
            File file = new File(filename);
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                logger.error(e.toString());
            }
            List<String> csv= new ArrayList<>();
            while(scanner.hasNextLine()) {
                csv.add(scanner.nextLine());
            }
            scanner.close();
            JSONArray jsonArray = new JSONArray();
            List.of(StringUtils.split(csv.remove(0), ','))
                    .forEach(key -> jsonArray.put(key));
//            logger.debug("File read: {}", StringUtils.join(csv,"\n"));
            return CDL.toJSONArray(jsonArray,StringUtils.join(csv,"\n"));
        }
        else {
            logger.error("File {} Not found.",filename);
            return null;
        }
    }

}
