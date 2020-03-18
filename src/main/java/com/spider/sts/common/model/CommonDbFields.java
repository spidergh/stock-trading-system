/*
 * Copyright (c) 2018, Magnum Research Ltd. All rights reserved.
 *
 * This program and the accompanying materials (“Program”)
 * whether on any media or in any form,
 * are exclusive property of Magnum Research Limited (“Magnum”).
 * Without prior written authorization from Magnum,
 * any person shall not reproduce, modify, summarize,
 * reverse-engineer, decompile or disassemble the Program,
 * or disclose any part of this Program to any other person.
 *
 * Magnum reserves all rights not expressly stated herein.
 *  
 *
 */

package com.spider.sts.common.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class CommonDbFields {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "create_time", nullable = false)
	private Long createTime;

	@Column(name = "update_time", nullable = false)
	private Long updateTime;

	@Column(name = "internal_query_time")
	private Date timestamp = new Date();

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	@PrePersist
	public void onCreate() {
		this.setCreateTime(System.currentTimeMillis());
		this.setUpdateTime(System.currentTimeMillis());
		this.setTimestamp(new Date());
	}

	@PreUpdate
	public void onUpdate() {
		this.setUpdateTime(System.currentTimeMillis());
		this.setTimestamp(new Date());
	}
}
