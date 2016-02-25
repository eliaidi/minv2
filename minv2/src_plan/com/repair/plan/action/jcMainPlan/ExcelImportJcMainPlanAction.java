package com.repair.plan.action.jcMainPlan;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.opensymphony.xwork2.Action;
import com.repair.entity.DictJcFixMileage;
import com.repair.entity.JcMainPlan;
import com.repair.entity.JcMainPlanRecorder;
import com.repair.plan.service.IDictJcFixMileageService;
import com.repair.plan.service.IJcMainPlanService;
import com.repair.util.ExcelWorkSheet;
import com.repair.util.action.BaseAction;

/**
 * 
 * @see 通过excel的方式导入机车检修计划
 * @author 周云韬
 * @date 2015-11-15
 * @version 1.0
 */
public class ExcelImportJcMainPlanAction extends BaseAction{
	private File excelFile;//与jsp页面的file标签的name属性一样
	private String excelFileFileName;//File对象的名称+FileName,一定要这样写，不然名称获取不到
	private ExcelWorkSheet<JcMainPlanRecorder> excelWorkSheet;//将数据记录封装为我们需要的对象
	
	private IJcMainPlanService jcMainPlanService;
	
	private IDictJcFixMileageService dictJCFixMileageService;
	
	private Date startTime;
	
	private Date endTime;
	
	private String title;
	
	
	private Long mainPlanId;
	
	@Override
	public String execute() throws Exception {
		Workbook workBook=createWorkbook(new FileInputStream(excelFile));
		
		
		JcMainPlan mainPlan=new JcMainPlan();
		mainPlan.setStartTime(startTime);
		mainPlan.setEndTime(endTime);
		mainPlan.setTitle(title);
		mainPlan.setMaker(getLoginUsers().getUserName());
		mainPlan.setMakeTime(new Date(System.currentTimeMillis()));
		mainPlan.setStatus(0);
		
		Set<JcMainPlanRecorder> mainPlanRecorders=getMainPlanRecorders(workBook,mainPlan);
		mainPlan.setPlanRecorderSet(mainPlanRecorders);
		String message="计划信息导入失败!";
		try {
			jcMainPlanService.save(mainPlan);
			mainPlanId=mainPlan.getId();
			message="计划信息导入成功!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		return Action.SUCCESS;
		
	}
	
	
	private Set<JcMainPlanRecorder> getMainPlanRecorders(Workbook workBook,JcMainPlan plan) throws Exception{
		Sheet sheet=workBook.getSheetAt(0);//得到第一个sheet
		excelWorkSheet=new ExcelWorkSheet<JcMainPlanRecorder>();
		Row firstRow=sheet.getRow(0);//得到第一行，也就是列名
		Iterator<Cell> iterator=firstRow.cellIterator();//得到第一行的一个迭代器
		List<String> cellNames=new ArrayList<String>();
		//将列名取出来
		while(iterator.hasNext()){
			cellNames.add(iterator.next().getStringCellValue());
		}
		excelWorkSheet.setColumns(cellNames);
		JcMainPlanRecorder mainPlanDetail=null;
		//遍历各列数据，并将其取出来放到excelWorkSheet中
		for(int i=1;i<sheet.getLastRowNum();i++){
			Row row=sheet.getRow(i);
			mainPlanDetail=new JcMainPlanRecorder();
			mainPlanDetail.setJcMainPlan(plan);
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			mainPlanDetail.setPlanDate(format.parse(getCellValue(row.getCell(0))));
			mainPlanDetail.setPlanWeek(getCellValue(row.getCell(1)));
			mainPlanDetail.setMainPlanNum(i+1);
			mainPlanDetail.setJcType(getCellValue(row.getCell(2)));
			mainPlanDetail.setJcNumber(getCellValue(row.getCell(3)));
			DictJcFixMileage fixMileage=dictJCFixMileageService.findByFixMileageValue(getCellValue(row.getCell(4)));
			mainPlanDetail.setDictJcFixMileage(fixMileage);
			
			if("".equals(getCellValue(row.getCell(5)))){
				mainPlanDetail.setPlanKilometre(null);
			}else{
				mainPlanDetail.setPlanKilometre(Integer.parseInt(getCellValue(row.getCell(5))));
			}
			
			if("".equals(getCellValue(row.getCell(6)))){
				mainPlanDetail.setRealityKilometre(null);
			}else{
				mainPlanDetail.setRealityKilometre(Integer.parseInt(getCellValue(row.getCell(6))));
			}
			mainPlanDetail.setRemark(getCellValue(row.getCell(8)));
			mainPlanDetail.setCash(0);
			excelWorkSheet.getData().add(mainPlanDetail);
		}
		Set<JcMainPlanRecorder> recorders=new HashSet<JcMainPlanRecorder>();
		recorders.addAll(excelWorkSheet.getData());
		return recorders;
    }
	
	//判断文件类型创建Workbook对象
    private Workbook createWorkbook(InputStream is) throws IOException{
    	if(excelFileFileName.toLowerCase().endsWith("xls")){
    		return new HSSFWorkbook(is);
    	}
    	if(excelFileFileName.toLowerCase().endsWith("xlsx")){
    		return new XSSFWorkbook(is);
    	}
    	return null;
    }

    /**
     * 将相应数据转换为字符串类型
     * @param cell
     * @return
     */
    private String getCellValue(Cell cell){
    	String temp="";
    	if(cell==null){
    		return temp;
    	}else if(cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
    		temp=cell.getNumericCellValue()+"";
    		temp=temp.substring(0,temp.lastIndexOf("."));
    	}else if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
    		temp=cell.getStringCellValue();
    	}
    	return temp;
    }



	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}


	public void setExcelFileFileName(String excelFileFileName) {
		this.excelFileFileName = excelFileFileName;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Long getMainPlanId() {
		return mainPlanId;
	}


	public void setJcMainPlanService(IJcMainPlanService jcMainPlanService) {
		this.jcMainPlanService = jcMainPlanService;
	}


	public void setDictJCFixMileageService(
			IDictJcFixMileageService dictJCFixMileageService) {
		this.dictJCFixMileageService = dictJCFixMileageService;
	}
    
    
    
}
