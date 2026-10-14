package task;

public class user {
	 private int  id ;
	 private String name;
	 public user(int id ,String name){
		 setId(id);
		 setName(name);
		 print(getId(),getName());
		 
	  }
	 public int getId() {
		return id;
	}
	 public String getName() {
		return name;
	}
	 private void setId(int id) {
		this.id = id;
	}
	 private void setName(String name) {
		this.name = name;
	}
	 
	 public String print(int id, String name) {
		    return " Id : " + id + " Name is : " + name;
		}
	}

