package com.bridgelabz;

import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICVBuilder<E>
{


    public List getCSVFileList(Reader reader, Class csvClass) throws CSVBuilderException;
    public Iterator getCSVFileIterator(Reader reader, Class csvClass) throws CSVBuilderException;

}
