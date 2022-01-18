package com.lcode.commonutils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonProcess {
	private Logger logger = LoggerFactory.getLogger(CommonProcess.class);


	public String arrListToJsonString(ArrayList<String> al) {
		Date d1 = new Date();
		logger.info(d1.getHours() + "--" + d1.getMinutes() + "--" + d1.getSeconds());
		String resp = null;
		logger.info("Array List Size---" + al.size());
		for (String data : al) {
			resp = (resp == null) ? data : resp.concat(System.lineSeparator()).concat(data);
		}
		logger.info(resp);
		return resp;
	}
}
