package com.repair.report.action.jtReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.opensymphony.xwork2.ModelDriven;
import com.repair.constant.Constants;
import com.repair.entity.DictProteam;
import com.repair.entity.JcPlanDate;
import com.repair.entity.JtReport;
import com.repair.entity.ReportImgUrl;
import com.repair.report.service.IDictProteamService;
import com.repair.report.service.IJcPlanDateService;
import com.repair.report.service.IJtReportService;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 保存报活记录
 * @author 周云韬
 * @date 2015-12-24
 * @version 1.0
 */
public class SaveJtReportAction extends BaseAction implements ModelDriven<JtReport>{
	
	private IJcPlanDateService jcPlanDateService;
	private IDictProteamService dictProteamService;
	private IJtReportService jtReportService;
	
	private JtReport report=new JtReport();
	
	private List<File> reportImg;
	private List<String> reportImgFileName;
	
	private Long planDateId;
	//是否报活给jcz
	private boolean jcz;
	
	@Override
	public String execute() throws Exception {
		try{
			JcPlanDate planDate=jcPlanDateService.findById(report.getPlanDate().getId());
			report.setPlanDate(planDate);
			report.setReportTime(new Date(System.currentTimeMillis()));
			report.setReportUsers(getLoginUsers());
			
			
			Integer check=Constants.CHECK_STATUS_NOT_CHECK;
			//如果不是交车组，则此报活都需要卡控
			if(!jcz){
				check=Constants.CHECK_STATUS_NEED_CHECK;
				DictProteam proteam=dictProteamService.findById(report.getProteam().getId());
				report.setProteam(proteam);
			}
			report.setLeadCheck(Constants.CHECK_STATUS_NEED_CHECK);
			report.setCommitLeadCheck(check);
			report.setQcCheck(check);
			report.setAcceptanceCheck(check);
			report.setTechnicianCheck(check);
			report.setRecordStatus(Constants.JT_REPORT_RECORD_STATUS_RECEIVE);
			
			if(report.getId() != null){
				Set<ReportImgUrl> imgSet=report.getReportImgUrlSet();
				if(imgSet != null){
					Iterator<ReportImgUrl> it=imgSet.iterator();
					String path=request.getRealPath("/upload/reportImages");
					while(it.hasNext()){
						File f=new File(path+"/"+it.next().getImgUrl());
						f.delete();
					}
					report.getReportImgUrlSet().clear();
				}
				
			}
			
			Set<ReportImgUrl> set=new HashSet<ReportImgUrl>();
			List<File> fileList=fileUpload();
			
			for (File file : fileList) {
				ReportImgUrl img=new ReportImgUrl();
				img.setImgUrl(file.getName());
				img.setReport(report);
				set.add(img);
			}
			
			report.setReportImgUrlSet(set);
			if(report.getId() == null){
				Serializable id=jtReportService.save(report);
			}else{
				jtReportService.update(report);
			}
			writeJson(0, Constants.COMMON_MESSAGE_OPERATE_SUC);
		}catch(Exception e){
			e.printStackTrace();
			writeJson(-1, Constants.COMMON_MESSAGE_OPERATE_ERROR);
		}
		
		return null;
	}

	public List<File> fileUpload() throws IOException{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		List<File> fileList=new ArrayList<File>();
		if(reportImg == null || reportImgFileName == null){
			return fileList;
		}
		try{
			String uploadPath="/upload/reportImages";
			int i=0;
			for (File file : reportImg) {
				String path=request.getRealPath(uploadPath);
				
				String fileName=reportImgFileName.get(i++);
				String fileSuffix=fileName.substring(fileName.lastIndexOf("."));
				
				File writeFile=new File(path+"/"+System.currentTimeMillis()+fileSuffix);
				fos=new FileOutputStream(writeFile);
				fis=new FileInputStream(file);
				
				int count=-1;
				byte[] content=new byte[1024];
			    while((count=fis.read(content,0,1024))!=-1)
			    {
				   //输出流,保存服务器端的文件输出流
				   fos.write(content, 0,count);
				   
			    }
			    fileList.add(writeFile);
			}
		}catch(Exception e){
			if(fis != null) fis.close();
		    if(fos != null) fos.close();
			e.printStackTrace();
			return fileList;
		}
		
		
		return fileList;
	}
	
	
	public void setJcPlanDateService(IJcPlanDateService jcPlanDateService) {
		this.jcPlanDateService = jcPlanDateService;
	}


	public JtReport getModel() {
		return this.report;
	}


	public void setDictProteamService(IDictProteamService dictProteamService) {
		this.dictProteamService = dictProteamService;
	}


	public void setJtReportService(IJtReportService jtReportService) {
		this.jtReportService = jtReportService;
	}


	public void setJcz(boolean jcz) {
		this.jcz = jcz;
	}

	public void setReportImg(List<File> reportImg) {
		this.reportImg = reportImg;
	}

	public void setReportImgFileName(List<String> reportImgFileName) {
		this.reportImgFileName = reportImgFileName;
	}

	
	

}
