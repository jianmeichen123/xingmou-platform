package com.gi.ctdn.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class ProjectListInfo extends ProjectList {

    /**
	 * 直接竞争对手
	 */
    @ApiModelProperty(value="直接竞争对手")
	private List<ProjectList> directCompetationlist;

	/**
	 * 间接竞争对手
	 */
	@ApiModelProperty(value="间接竞争对手")
	private List<ProjectList> indirectCompetationlist;

	public List<ProjectList> getDirectCompetationlist() {
		return directCompetationlist;
	}

	public void setDirectCompetationlist(List<ProjectList> directCompetationlist) {
		this.directCompetationlist = directCompetationlist;
	}

	public List<ProjectList> getIndirectCompetationlist() {
		return indirectCompetationlist;
	}

	public void setIndirectCompetationlist(List<ProjectList> indirectCompetationlist) {
		this.indirectCompetationlist = indirectCompetationlist;
	}
}