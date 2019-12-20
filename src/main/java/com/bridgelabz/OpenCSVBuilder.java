package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCSVBuilder<E> implements ICVBuilder
{

    public  Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CSVBuilderException
    {
        return this.getCSVBean(reader,csvClass).iterator();
    }


    public List getCSVFileList(Reader reader, Class csvClass) throws CSVBuilderException
    {
        return (List<E>)this.getCSVBean(reader,csvClass).parse();

    }

    private CsvToBean getCSVBean(Reader reader, Class csvClass) throws CSVBuilderException
    {
        try
        {
            CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(csvClass);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            return csvToBeanBuilder.build();
        }
        catch (IllegalStateException e)
        {
            throw new CSVBuilderException(e.getMessage(),CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
    }


}
