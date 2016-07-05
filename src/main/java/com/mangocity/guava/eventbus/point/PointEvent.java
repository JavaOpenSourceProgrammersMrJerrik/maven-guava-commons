package com.mangocity.guava.eventbus.point;

public class PointEvent {

	private Long mbrId;

	private Double points;

	private String desc;
	

	public PointEvent(Long mbrId, Double points, String desc) {
		super();
		this.mbrId = mbrId;
		this.points = points;
		this.desc = desc;
	}

	public Long getMbrId() {
		return mbrId;
	}

	public void setMbrId(Long mbrId) {
		this.mbrId = mbrId;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "PointEvent [mbrId=" + mbrId + ", points=" + points + ", desc=" + desc + "]";
	}

}
