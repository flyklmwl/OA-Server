

import java.util.*; 
import java.sql.*;

public class MultipleTree {
	public static String ss = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		
		//root.sortChildren();
		//System.out.println(root.toString());		
		//ConnectSQL.connectSQL();
	}
	
	public String getString() {
		List dataList = VirtualDataGenerator.getVirtualResult();
		HashMap nodeList = new HashMap();
		Node root = null;
		
		for (Iterator it = dataList.iterator(); it.hasNext();) {
			Map dataRecord = (Map) it.next();  
			Node node = new Node();  
			node.id = (String) dataRecord.get("id");  
			node.text = (String) dataRecord.get("text");  
			node.parentId = (String) dataRecord.get("parentId");  
			nodeList.put(node.id, node);  
		}
		
		Set entrySet = nodeList.entrySet();
		
		for (Iterator it = entrySet.iterator(); it.hasNext();) {
			Node node = (Node) ((Map.Entry) it.next()).getValue();  
			if (node.parentId == null || node.parentId.equals("")) {  
				root = node; 
			}
		
		else {
			((Node) nodeList.get(node.parentId)).addChild(node);
			
			}
		}
		
		return root.toString();
	}
}

class Node{
	public String id;
	public String text;
	public String parentId;
	private Children children = new Children();
	
	public String toString() { 
		String result = "{"  + "\"name\" : '" + id + "'"   + ", \"title\" : '" + text + "'";
		if (children != null && children.getSize() != 0) {
			result += ", children : " + children.toString();
		}
		else {
			result += ", leaf : true";
		}
		return result + "}";
	}
	
	public void sortChildren() {
		if (children != null && children.getSize() != 0) {
			children.sortChildren();
		}
	}
	
	public void addChild(Node node) {
		this.children.addChild(node);
	}
}

class Children {
	private List list = new ArrayList();
	public int getSize() {
		return list.size();
	}
	
	public void addChild(Node node) { 
		list.add(node);
	}
	
	public String toString() {
		String result = "[";
		for (Iterator it = list.iterator(); it.hasNext();) {
			result += ((Node) it.next()).toString();
			result += ",";
		}
		result = result.substring(0, result.length() - 1);
		result += "]"; 
		return result;
	}
	
	public void sortChildren() { 
		Collections.sort(list, new NodeIDComparator());
		for (Iterator it = list.iterator(); it.hasNext();) {
			((Node) it.next()).sortChildren();
		}
	}
}

class NodeIDComparator implements Comparator {  
	 // ���սڵ��űȽ�  
	 public int compare(Object o1, Object o2) {  
	  int j1 = Integer.parseInt(((Node)o1).id);  
	     int j2 = Integer.parseInt(((Node)o2).id);  
	     return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));  
	 }   
}

class VirtualDataGenerator {
	public static List getVirtualResult() {
		ResultSet rs = ConnectSQL.getRs();
		List dataList = new ArrayList();
		
		try{ 
			int i = 1;
	        while (rs.next()) {  
	            	HashMap ai = new HashMap();
	            	ai.put("id", rs.getString(1));
	            	ai.put("text", rs.getString(2));
	            	if(rs.getString(3) == null) {
	            		ai.put("parentId", "");
	            	}
	            	else {
	            		ai.put("parentId", rs.getString(3));
	            	}            		        
	            	i++;
	            	dataList.add(ai);
	        }  
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return dataList;		
	}
}