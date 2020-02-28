import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String args[]) throws JsonMappingException, JsonProcessingException
	{

	ObjectMapper mapper = new ObjectMapper();
//    String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
//    
//    //map json to student
//    
//       Student student = mapper.readValue(jsonString, Student.class);
//       
//       System.out.println(student);
//       
//       jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
//       
//       System.out.println(jsonString);
		
		 String jsonString = "{\"name\":\"Sanjay\", \"phone\":8667702382, \"email\":\"sanjay@gmail.com\", \"address\":\"72 raj street chennai\"}";
		    
     Contact contact = mapper.readValue(jsonString, Contact.class);
	       
       System.out.println("contact:"+contact);
        contact = new Contact("Sanjay","9878987898","sanjay@gmail.com","98 LGB nagar karur");
	     jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(contact);
	     System.out.println("Json:"+jsonString);
	     Map<String, String> map = mapper.readValue(jsonString, new TypeReference<Map<String, String>>() {});
	     System.out.println("Map:"+map);
	     jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
	     System.out.println("Map to Json"+jsonString);
	     
	     
	     
    
   
 }
}

//class Student {
// private String name;
// private int age;
// public String getName() {
//    return name;
// }
// public void setName(String name) {
//    this.name = name;
// }
// public int getAge() {
//    return age;
// }
// public void setAge(int age) {
//    this.age = age;
// }
// public String toString(){
//    return " name: "+name+", age: "+ age;
// }
//}
