package edu.upc.dsa.util;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);

        sb.append("ID");
        for (String field: fields) {
            sb.append(", ").append(field);
        }

        sb.append(") VALUES (?");

        for (String field: fields) {
            sb.append(", ?");
        }

        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE ID = ?");

        return sb.toString();
    }

    public static String createQuerySELECTall(Class theClass) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());

        System.out.println(sb);

        return sb.toString();
    }

    public static String createQueryUPDATE(Object object){

        String [] fields = ObjectHelper.getFields(object);
        StringBuffer sb = new StringBuffer("UPDATE ");
        sb.append(object.getClass().getSimpleName()).append(" ");
        sb.append("SET ");
        String field;

        int i = 1;
        while (i<fields.length){
            field = fields[i];
            if (i>1) sb.append(" = ?, ");
            sb.append(field);
            i++;
        }
        sb.append(" = ?");
        sb.append(" WHERE id = ?");

        System.out.println(sb);

        return sb.toString();
    }

    public static String createQueryUPDATEbyParameter(Object object, String parameter){

        String [] fields = ObjectHelper.getFields(object);
        StringBuffer sb = new StringBuffer("UPDATE ");
        sb.append(object.getClass().getSimpleName()).append(" ");
        sb.append("SET ");
        String field;

        int i = 1;
        while (i<fields.length){
            field = fields[i];
            if (i>1) sb.append(" = ?, ");
            sb.append(field);
            i++;
        }
        sb.append(" = ?");
        sb.append(" WHERE " + parameter + " = ?");

        System.out.println(sb);

        return sb.toString();
    }

    public static String createQueryUPDATEparameterByParameter(Class theClass, String parameter, String byParameter) {
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE " + theClass.getSimpleName() + " SET " + parameter + " = ?");
        sb.append(" WHERE " + byParameter + " = ? ");

        System.out.println(sb);

        return sb.toString();
    }


    public static String createQueryDELETE(Object entity){

        StringBuffer sb = new StringBuffer("DELETE FROM ");
        sb.append(entity.getClass().getSimpleName());
        sb.append(" WHERE id = ?");

        System.out.println(sb);

        return sb.toString();

    }


    public static String createQuerySELECTbyParameter(Class theClass, String byParameter) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());
        sb.append(" WHERE " + byParameter + " = ?");

        System.out.println(sb);

        return sb.toString();
    }

    public static String createQuerySELECTparameterByParameter(Class theClass, String parameter, String byParameter) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT " + parameter + " FROM ");
        sb.append(theClass.getSimpleName());
        sb.append(" WHERE " + byParameter + " = ?");

        System.out.println(sb);

        return sb.toString();
    }

    public static String createQueryDELETEbyParameter(Class theClass, String parameter){

        StringBuffer sb = new StringBuffer("DELETE FROM ");
        sb.append(theClass.getSimpleName());
        sb.append(" WHERE " + parameter + " = ?");

        System.out.println(sb);

        return sb.toString();
    }

}