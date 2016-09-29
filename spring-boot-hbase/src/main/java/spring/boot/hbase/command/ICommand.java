package spring.boot.hbase.command;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import spring.boot.hbase.model.Family;

public interface ICommand {

	boolean createTable(String tableName, String[] family);
	/**
	 * 根据表名添加每个列族的数据
	 * @param tableName
	 * @param map
	 * @return
	 */
	boolean addFamilyData(String tableName,String rowKey,ConcurrentHashMap<String,List<String>> map) throws IOException;
	List<Family> getFamilies(String tableName,String rowKey )  throws IOException;
	List<Family> getFamilies(String tableName )  throws IOException;
	List<Family> getFamilies(String tableName , String start_rowkey,
            String stop_rowkey) throws IOException;
	List<Family> getFamilies(String tableName , String rowKey,
            String familyName, String columnName) throws IOException;
	List<Family> getFamilies(String tableName , String rowKey,
            String familyName, String columnName,int maxVersion) throws IOException;
	boolean deleteColumn(String tableName, String rowKey,
            String falilyName, String columnName) throws IOException;
	boolean deleteColumn(String tableName, String rowKey) throws IOException;
	boolean deleteTable(String tableName) throws IOException;
	
}
