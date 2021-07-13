package com.shardul.location.util;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface ReportUtil {

	void generatePieChart(String path, List<Object[]> data);
}
