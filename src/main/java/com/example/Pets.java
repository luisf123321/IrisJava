package com.example;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="especies")
public class Pets {
	@Id
	public ObjectId _id;
	public int id;
	public String sl;
	public String sw;
	public String pl;
	public String pw;
	public String clase;

	// Constructors
	public Pets() {
	}

	

	public Pets(ObjectId _id,int id, String sl, String sw, String pl, String pw, String clase) {
		this._id = _id;
		this.id = id;
		this.sl = sl;
		this.sw = sw;
		this.pl = pl;
		this.pw = pw;
		this.clase = clase;
	}



	// ObjectId needs to be converted to string
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getSl() {
		return sl;
	}



	public void setSl(String sl) {
		this.sl = sl;
	}



	public String getSw() {
		return sw;
	}



	public void setSw(String sw) {
		this.sw = sw;
	}



	public String getPl() {
		return pl;
	}



	public void setPl(String pl) {
		this.pl = pl;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getClase() {
		return clase;
	}



	public void setClase(String clase) {
		this.clase = clase;
	}

	
}
