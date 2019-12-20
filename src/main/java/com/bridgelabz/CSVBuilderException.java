package com.bridgelabz;

public class CSVBuilderException extends Exception
{
    public enum ExceptionType
    {
        CENSUS_FILE_PROBLEM,UNABLE_TO_PARSE,NO_CENSUS_DATA,STATE_CODE_FILE_PROBLEM,NO_STATE_CODE_DATA,
        NO_IPL_DATA,IPL_FILE_PROBLEM,
    }

     public ExceptionType type;

    public CSVBuilderException(String message, ExceptionType type)
    {
        super(message);
        this.type=type;
    }
}
