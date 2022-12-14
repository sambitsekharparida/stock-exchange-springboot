package com.iiht.fse2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Stock {
	
	private Integer id;
	
	private String code;
	
	private String price;

}
