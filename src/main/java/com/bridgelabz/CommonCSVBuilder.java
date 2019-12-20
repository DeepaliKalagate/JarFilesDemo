package com.bridgelabz;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CommonCSVBuilder
{

    public Iterator getCSVFileIterator(Reader reader) throws CSVBuilderException, IOException
    {
        return commonCSV(reader).iterator();
    }


    public List getCSVFileList(Reader reader) throws CSVBuilderException, IOException
    {
        return Collections.singletonList(this.commonCSV(reader).parse(reader,CSVFormat.DEFAULT));
    }


    public CSVParser commonCSV(Reader reader) throws IOException, CSVBuilderException
    {
        int counter=0;
        try
        {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withHeader("State", "Population", "AreaInSqKm", "DensityPerSqKm")
                    .withIgnoreHeaderCase()
                    .withTrim());
            for (CSVRecord csvRecord:csvParser)
            {
                counter++;
                String state=csvRecord.get(0);
                String population=csvRecord.get(1);
                String areaInSqKm=csvRecord.get(2);
                String densityPerSqKm=csvRecord.get(3);

                System.out.println("State:"+state);
                System.out.println("population:"+population);
                System.out.println("AreaInSqKm:"+areaInSqKm);
                System.out.println("DensityPerSqKm:"+densityPerSqKm);
            }
            return csvParser;
        }
        catch (IllegalStateException e)
        {
            throw new CSVBuilderException(e.getMessage(),CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
    }


}
