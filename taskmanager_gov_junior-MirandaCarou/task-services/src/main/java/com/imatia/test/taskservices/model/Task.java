package com.imatia.test.taskservices.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

	private static final long serialVersionUID = 3224578592868604637L;

	@Id
	@GeneratedValue
	@Column(name = "idtask" ,columnDefinition = "uuid NOT NULL DEFAULT random_uuid()")
	private UUID idTask;
	@Column(name = "nametask" ,columnDefinition = "varchar(50) NOT NULL")
	private String name;
	@Column(name = "creationdate" ,columnDefinition = "Timestamp NOT NULL default current_date()")
	private Timestamp creationDate;
	@Column(name = "deadline" ,columnDefinition = "Date")
	private Date deadLine;
	@Column(name = "descriptiontask" ,columnDefinition = "varchar(500)")
	private String descriptionTask;
	@Column(name = "favorite" ,columnDefinition = "varchar(1) DEFAULT 'N'")
	private String favorite;


	public Task() {

	}

	public Task(UUID idTask, String name, Timestamp creationDate, Date deadLine, String descriptionTask, String favorite ) {
		super();
		this.idTask = idTask;
		this.name = name;
		this.creationDate = creationDate;
		this.deadLine = deadLine;
		this.descriptionTask = descriptionTask;
		this.favorite = favorite;
	}

	public UUID getIdTask() {
		return idTask;
	}

	public void setIdTask(UUID idTask) {
		this.idTask = idTask;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	
	public String getDescription() {
		return descriptionTask;
	}

	public void setDescription(String descriptionTask) {
		this.descriptionTask = descriptionTask;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}




}
