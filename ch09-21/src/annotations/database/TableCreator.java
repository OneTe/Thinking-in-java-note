package annotations.database;
//Reflecting-based annotation processor.

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangcheng  on 2017/12/25.
 */
public class TableCreator {
    public static void main(String[] args) throws Exception{
        String className = "annotations.database.Member";
        Class<?> cl = Class.forName(className);
        DBTable dbTable = cl.getAnnotation(DBTable.class);
        if(dbTable == null){
            System.out.println("No DBTable annotations in class " + className);
        }
        String tableName = dbTable.name();
        System.out.println("========" + tableName + "========");
        //If the name is empty,use the Class name.
        if(tableName.length() < 1)
            tableName = cl.getName().toUpperCase();
        List<String> columnDefs = new ArrayList<>();
        for(Field field : cl.getDeclaredFields()){
            String columnName = null;
            Annotation[] anns = field.getDeclaredAnnotations();
            if(anns.length < 1)
                continue;//Not a db table column
            if(anns[0] instanceof SQLInteger){
                SQLInteger sInt = (SQLInteger) anns[0];
                //Use field name if name not specified
                if(sInt.name().length() < 1)
                    columnName = field.getName().toUpperCase();
                else
                    columnName = sInt.name();
                columnDefs.add(columnName + " INT" + getConstrains(sInt.constraints()));
            }
            if(anns[0] instanceof SQLString){
                SQLString sString = (SQLString) anns[0];
                //Use field name if name not specified
                if(sString.name().length() < 1)
                    columnName = field.getName().toUpperCase();
                else
                    columnName = sString.name();
                columnDefs.add(columnName + " VARCHAR(" +
                sString.value() + ")" + getConstrains(sString.constraints()));
            }
            StringBuilder createCommand = new StringBuilder(
                    "CREATE TABLE " + tableName + "("
            );
            for(String columnDef : columnDefs)
                createCommand.append("\n    " + columnDef + ",");
            //Remove trailing comma
            String tableCreate = createCommand.substring(0,createCommand.length() - 1) + ");";
            System.out.println("Table Creation SQL for " + className + " is : \n" + tableCreate);
        }
    }
    private static String getConstrains(Constraints con){
        String constraints = "";
        if(!con.allowNull())
            constraints += " NOT NULL";
        if(!con.primaryKey())
            constraints += " PRIMARY KEY";
        if(con.unique())
            constraints += " UNIQUE";
        return constraints;
    }
}
