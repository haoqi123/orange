package com.mr.utils;

import lombok.Data;

@Data
public class Page {
	private Integer page = 1;
	private Integer limit = 10;

	private String sort;
	private String order;
}
