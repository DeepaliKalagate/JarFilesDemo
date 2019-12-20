package com.bridgelabz;

public class CSVBuilderFactory
{

    public static ICVBuilder createCSVBuilder()
    {
       return new OpenCSVBuilder();
    }
}
