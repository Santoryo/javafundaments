package com.lr.app;

public class Filter {
    private Records records;

    public Filter(Records records, String columnName, String operator, Object value) throws DatabaseException
    {
        this.records = records;

        if(value == null)
        {
            throw new DatabaseException("The syntax of the query is incorrect during the WHERE process");
        }


        filter(columnName, operator, value.toString());
    }

    public Records getResults()
    {
        return this.records;
    }

    public void setRecords(Records records)
    {
        this.records = records;
    }

    public Records filter(String columnName, String operator, String value) throws DatabaseException
    {
        Records filteredRecords = new Records();
        for (Record record : records.getData())
        {
            if (record.get(columnName) == null)
            {
                continue;
            }
            if (operator.equals("=") && record.matches(columnName, value))
            {
                filteredRecords.add(record);
            }
            else if (operator.equals("!=") && !record.matches(columnName, value))
            {
                filteredRecords.add(record);
            }
            else if (operator.equals(">") && Double.parseDouble(record.get(columnName).toString()) > Double.parseDouble(value))
            {
                filteredRecords.add(record);
            }
            else if (operator.equals("<") && Double.parseDouble(record.get(columnName).toString()) < Double.parseDouble(value))
            {
                filteredRecords.add(record);
            }
            else if (operator.equals(">=") && Double.parseDouble(record.get(columnName).toString()) >= Double.parseDouble(value))
            {
                filteredRecords.add(record);
            }
            else if (operator.equals("<=") && Double.parseDouble(record.get(columnName).toString()) <= Double.parseDouble(value))
            {
                filteredRecords.add(record);
            }
        }
        records = filteredRecords;
        return filteredRecords;
    }




    
}
