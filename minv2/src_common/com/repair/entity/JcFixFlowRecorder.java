package com.repair.entity;

import java.util.Date;
/**
 * @ClassName: 机车检修流程记录表
 * @Description: TODO(实体类)
 * @author 周云涛
 * @version V1.0
 * @date 2015-12-10 下午1:26:16
 */

public class JcFixFlowRecorder  implements java.io.Serializable{
		/* @Field id : 主键 */
		private Long id;
		
		/* @Field id : 机车检修流程节点 */
		private JcFixFlow jcFixFlow;
		
		/* @Field id : 班组 */
		private DictProteam dictProteam;
		
		/* @Field id : 机车日计划 */
		private JcPlanDate jcPlanDate;
		
		/* @Field id : 完成状态 */
		private Integer status;
		
		/* @Field id : 完成时间 */
		private Date endTime;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		

		public JcFixFlow getJcFixFlow() {
			return jcFixFlow;
		}

		public void setJcFixFlow(JcFixFlow jcFixFlow) {
			this.jcFixFlow = jcFixFlow;
		}

		public DictProteam getDictProteam() {
			return dictProteam;
		}

		public void setDictProteam(DictProteam dictProteam) {
			this.dictProteam = dictProteam;
		}

		

		public JcPlanDate getJcPlanDate() {
			return jcPlanDate;
		}

		public void setJcPlanDate(JcPlanDate jcPlanDate) {
			this.jcPlanDate = jcPlanDate;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Date getEndTime() {
			return endTime;
		}

		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}
		
		
}
