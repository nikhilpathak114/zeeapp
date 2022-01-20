package com.zee.zee5app.service;

import com.zee.zee5app.dto.Series;

public interface SeriesServ2 {

	public String addSeries(Series series);
	public String updateSeries(String id, Series series);
	public Series getSeriesById(String id);
	public Series[] getSeries();
	public String deleteSeriesById(String id);
}
