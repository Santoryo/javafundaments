package com.lr.app;

public class DataTypeIdentifier {
    public static String determineDataType(Object value) {
        if (value == null) {
            return "null";
        }
        
        if (value instanceof Boolean) {
            return DataTypes.BOOLEAN.toString();
        } else if (value instanceof Integer) {
            return DataTypes.INTEGER.toString();
        } else if (value instanceof Double) {
            return DataTypes.DOUBLE.toString();
        } else if (value instanceof Float) {
            return DataTypes.DOUBLE.toString();
        } else if (value instanceof String) {
            return DataTypes.STRING.toString();
        }
        return DataTypes.UNKNOWN.toString();
    }
}
