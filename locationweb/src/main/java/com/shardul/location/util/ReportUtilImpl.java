package com.shardul.location.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ReportUtilImpl implements ReportUtil {

	@Override
	public void generatePieChart(String path, List<Object[]> data) {

		DefaultPieDataset dataset = new DefaultPieDataset();

		for (Object[] objects : data) {
			if(objects[0] != null)
			{
			System.out.println(objects[0].toString()+" - "+new Double(objects[1].toString()));
			dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
			}
		}

		JFreeChart createPieChart3D = ChartFactory.createPieChart3D("Location Type Report", dataset);

		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/pieChart.jpeg"), createPieChart3D, 500, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
