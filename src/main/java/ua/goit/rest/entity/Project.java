package ua.goit.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "history")
	private String history;

	@Column(name = "goal")
	private Double goal;

	@Column(name = "pledged")
	private Double pledged;

	@Column(name = "theEndDay")
	private Integer theEndDay;

	@Column(name = "link")
	private String link;

	@Column(name = "status")
	private Integer status;

	public Long getCategoryId() {
		return category.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public Double getGoal() {
		return goal;
	}

	public void setGoal(Double goal) {
		this.goal = goal;
	}

	public Double getPledged() {
		return pledged;
	}

	public void setPledged(Double pledged) {
		this.pledged = pledged;
	}

	public Integer getTheEndDay() {
		return theEndDay;
	}

	public void setTheEndDay(Integer theEndDay) {
		this.theEndDay = theEndDay;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
