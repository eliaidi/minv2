package com.repair.constant;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
* @ClassName: Constants
* @Description: TODO(存放常量)
* @author 周云韬
* @version V1.0  
* @date 2015-8-10 下午1:55:44
 */
public interface Constants {
	
	/** 卡控状态：不需要卡控  */
	Integer CHECK_STATUS_NOT_CHECK=0;
	
	/** 卡控状态：需要卡控  */
	Integer CHECK_STATUS_NEED_CHECK=1;
	
	
	/** 机车中修检修项目记录表（相当于JC_ZX_FIX_ITEM_RECORD），F代表Fix，I代表Item，R代表Record ：检修人待签*/
	Integer JC_ZX_F_I_R_RECORD_STATUS_FIXEMP_STAY_SIGN=0;

	/** 机车中修检修项目记录表（相当于JC_ZX_FIX_ITEM_RECORD），F代表Fix，I代表Item，R代表Record ：工长待签字*/
	Integer JC_ZX_F_I_R_RECORD_STATUS_LEAD_STAY_SIGN=1;
	
	/** 机车中修检修项目记录表（相当于JC_ZX_FIX_ITEM_RECORD），F代表Fix，I代表Item，R代表Record ：技术员待签字*/
	Integer JC_ZX_F_I_R_RECORD_STATUS_TECH_STAY_SIGN=2;
	
	/** 机车中修检修项目记录表（相当于JC_ZX_FIX_ITEM_RECORD），F代表Fix，I代表Item，R代表Record ：质检员待签字*/
	Integer JC_ZX_F_I_R_RECORD_STATUS_QC_STAY_SIGN=3;
	
	/** 机车中修检修项目记录表（相当于JC_ZX_FIX_ITEM_RECORD），F代表Fix，I代表Item，R代表Record ：交车工长待签字*/
	Integer JC_ZX_F_I_R_RECORD_STATUS_COMMIT_LEAD_STAY_SIGN=4;
	
	/** 机车中修检修项目记录表（相当于JC_ZX_FIX_ITEM_RECORD），F代表Fix，I代表Item，R代表Record ：验收员待签字*/
	Integer JC_ZX_F_I_R_RECORD_STATUS_ACCEPTANCE_STAY_SIGN=5;
	
	/** 机车中修检修项目记录表（相当于JC_ZX_FIX_ITEM_RECORD），F代表Fix，I代表Item，R代表Record ：完成*/
	Integer JC_ZX_F_I_R_RECORD_STATUS_FINISH=6;
	
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）报活状态：作废  */
	Integer JT_REPORT_RECORD_STATUS_INVALID=0;
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）报活状态：接收  */
	Integer JT_REPORT_RECORD_STATUS_RECEIVE=2;
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）报活状态：工人检修完成 */
	Integer JT_REPORT_RECORD_STATUS_FIX_USERS_FINISH=3;
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）报活状态：工长核验 */
	Integer JT_REPORT_RECORD_STATUS_LEAD_CHECK=4;
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）报活状态：交车工厂卡控 */
	Integer JT_REPORT_RECORD_STATUS_COMMIT_LEAD_CHECK=5;
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）报活状态：质检或技术卡控 */
	Integer JT_REPORT_RECORD_STATUS_QC_OR_TECH_CHECK=6;
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）报活状态：验收员卡控 */
	Integer JT_REPORT_RECORD_STATUS_ACCEPTANCE_OR_TECH_CHECK=7;
	
	
	
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）报活状态 */
	Map<Integer, String> JT_REPORT_RECORD_STATUS=new HashMap<Integer, String>(){{
		put(JT_REPORT_RECORD_STATUS_INVALID, "作废");
		put(JT_REPORT_RECORD_STATUS_RECEIVE, "接收");
		put(JT_REPORT_RECORD_STATUS_FIX_USERS_FINISH, "工人检修完成");
		put(JT_REPORT_RECORD_STATUS_LEAD_CHECK, "工长核验");
		put(JT_REPORT_RECORD_STATUS_COMMIT_LEAD_CHECK, "交车工厂卡控");
		put(JT_REPORT_RECORD_STATUS_QC_OR_TECH_CHECK, "质检或技术卡控");
		put(JT_REPORT_RECORD_STATUS_ACCEPTANCE_OR_TECH_CHECK, "验收员卡控 ");
	}};
	
	
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）  报活类型：机统28报活*/
	Integer JT_REPORT_TYPE_JT28_REPORT=0;
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）  报活类型：复检报活*/
	Integer JT_REPORT_TYPE_FUJIAN_REPORT=1;
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）  报活类型：检修过程报活*/
	Integer JT_REPORT_TYPE_FIX_PROCESS_REPORT=2;
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）  报活类型：临修加改报活*/
	Integer JT_REPORT_TYPE_LXJG_REPORT=3;
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）  报活类型：零公里报活*/
	Integer JT_REPORT_TYPE_ZERO_REPORT=6;
	
	/** 机车中修\小辅修\临修，报活表（所有修程报活）  报活类型map集合*/
	Map<Integer, String>  JT_REPORT_TYPE = new HashMap<Integer, String>(){{
		put(JT_REPORT_TYPE_JT28_REPORT, "机统28报活");
		put(JT_REPORT_TYPE_FUJIAN_REPORT, "复检报活");
		put(JT_REPORT_TYPE_FIX_PROCESS_REPORT, "检修过程报活");
		put(JT_REPORT_TYPE_LXJG_REPORT, "临修加改报活");
		put(JT_REPORT_TYPE_ZERO_REPORT, "零公里报活");
	}};
	
	
	/** 油水化验子记录   油水化验情况：不合格*/
	Integer OIL_ACI_REC_ASSAY_STATUS_UNQUALIFIED=0;
	
	/** 油水化验子记录   油水化验情况：合格*/
	Integer OIL_ACI_REC_ASSAY_STATUS_QUALIFIED=1;
	
	/** 油水化验子记录   油水化验情况 */
	Map<Integer, String>  OIL_ACI_REC_ASSAY_STATUS = new HashMap<Integer, String>(){{
		put(OIL_ACI_REC_ASSAY_STATUS_UNQUALIFIED, "不合格");
		put(OIL_ACI_REC_ASSAY_STATUS_QUALIFIED, "合格");
	}};
	
	/** 油水化验主记录   油水化验状态：作废*/
	Integer OIL_AMI_REC_ASSAY_STATUS_INVALID=0;
	
	/** 油水化验主记录   油水化验状态：待化验*/
	Integer OIL_AMI_REC_ASSAY_STATUS_STAY_ASSAY=1;
	
	/** 油水化验主记录   油水化验状态：完成*/
	Integer OIL_AMI_REC_ASSAY_STATUS_FINISH =2;
	
	/** 油水化验主记录   油水化验状态map集合*/
	Map<Integer, String>  OIL_ANI_REC_ASSAY_STATUS = new HashMap<Integer, String>(){{
		put(OIL_AMI_REC_ASSAY_STATUS_INVALID, "作废");
		put(OIL_AMI_REC_ASSAY_STATUS_STAY_ASSAY, "待化验");
		put(OIL_AMI_REC_ASSAY_STATUS_FINISH,"完成");
	}};
	
	/** 油水化验主项目状态：禁用*/
	Integer OIL_AM_ITEM_STATUS_DISABLE=0;
	
	/** 油水化验主项目状态：启用*/
	Integer OIL_AM_ITEM_STATUS_ENABLE=1;
	

	
	
	
	/** JcFixFlowRecorder   status字段：未完成 */
	Integer JC_FF_RECORDER_STATUS_UNFINISH=0;
	
	/** JcFixFlowRecorder   status字段：完成 */
	Integer JC_FF_RECORDER_STATUS_FINISH=1;
	
	Map<Integer, String> JC_FF_RECORDER_STATUS=new HashMap<Integer, String>(){{
		put(JC_FF_RECORDER_STATUS_UNFINISH, "未完成");
		put(JC_FF_RECORDER_STATUS_FINISH, "完成");
	}};
	
	
	/** JcMainPlanRecorder cash:未兑现 */
	Integer JC_MP_RECORDER_CASH_NO=0;
	
	/** JcMainPlanRecorder cash:已兑现 */
	Integer JC_MP_RECORDER_CASH_YES=1;
	
	/** JcPlanDate projectType:小辅修 */
	Integer JC_PLAN_DATE_PROJECT_TYPE_XIAOFU_FIX=1;
	
	/** JcPlanDate projectType:中修 */
	Integer JC_PLAN_DATE_PROJECT_TYPE_ZHONG_FIX=2;
	
	/** JcPlanDate projectType:检修类型 集合*/
	Map<Integer, String> JC_PLAN_DATE_PROJECT_TYPE=new HashMap<Integer, String>(){{
		put(JC_PLAN_DATE_PROJECT_TYPE_XIAOFU_FIX, "小辅修");
		put(JC_PLAN_DATE_PROJECT_TYPE_ZHONG_FIX, "中修");
	}};
	
	/** DictJcFixMileage  MILEAGE_TYPE：小修*/
	Integer JC_FIX_MILEAGE_TYPE_SMALL_FIX=0;
	
	/** DictJcFixMileage  MILEAGE_TYPE：辅修*/
	Integer JC_FIX_MILEAGE_TYPE_FU_FIX=1;
	
	/** DictJcFixMileage  MILEAGE_TYPE：中修*/
	Integer JC_FIX_MILEAGE_TYPE_ZHONG_FIX=2;
	
	/** DictJcFixMileage  MILEAGE_TYPE：和谐修程*/
	Integer JC_FIX_MILEAGE_TYPE_HEXIE_FIX=3;
	
	/** DictJcFixMileage  MILEAGE_TYPE：整治*/
	Integer JC_FIX_MILEAGE_TYPE_ZHENGZHI_FIX=4;
	
	/** DictJcFixMileage  MILEAGE_TYPE：额外修程*/
	Integer JC_FIX_MILEAGE_TYPE_OTHER_FIX=5;
	
	/** DictJcFixMileage  MILEAGE_TYPE：Map集合*/
	Map<Integer, String> JC_FIX_MILEAGE_TYPE=new HashMap<Integer, String>(){{
		put(JC_FIX_MILEAGE_TYPE_SMALL_FIX, "小修");
		put(JC_FIX_MILEAGE_TYPE_FU_FIX, "辅修");
		put(JC_FIX_MILEAGE_TYPE_ZHONG_FIX, "中修");
		put(JC_FIX_MILEAGE_TYPE_HEXIE_FIX, "和谐修程");
		put(JC_FIX_MILEAGE_TYPE_ZHENGZHI_FIX, "整治");
		put(JC_FIX_MILEAGE_TYPE_OTHER_FIX, "额外修程");
	}};
	
	
	/** JC_ZX_FIX_ITEM  STATUS：禁用（删除）*/
	Integer JC_ZX_FIX_ITEM_STATUS_DISABLED=0;
	
	/** JC_ZX_FIX_ITEM  STATUS：启用（没删除）*/
	Integer JC_ZX_FIX_ITEM_STATUS_ENABLED=1;
	
	/** JC_ZX_FIX_ITEM  itemType：检查项目*/
	Integer JC_ZX_FIX_ITEM_TYPE_JIANCHA=0;
	
	/** JC_ZX_FIX_ITEM  itemType：检测项目*/
	Integer JC_ZX_FIX_ITEM_TYPE_JIANCE=1;
	
	
	/** JC_PLAN_DATE  JC_PLAN_STATUS：新建*/
	Integer JC_PLAN_STATUS_NEW=1;
	
	/** JC_PLAN_DATE  JC_PLAN_STATUS：在修*/
	Integer JC_PLAN_STATUS_IN_REPAIR=2;
	
	/** JC_PLAN_DATE  JC_PLAN_STATUS：待验*/
	Integer JC_PLAN_STATUS_GUARANTINE=3;
	
	/** JC_PLAN_DATE  JC_PLAN_STATUS：已交*/
	Integer JC_PLAN_STATUS_YET_DEAL=4;
	
	/** JC_PLAN_DATE  JC_PLAN_STATUS：转出*/
	Integer JC_PLAN_STATUS_OUT=5;
	
	Map<Integer, String> JC_PLAN_STATUS=new HashMap<Integer, String>(){{
		put(JC_PLAN_STATUS_NEW, "新建");
		put(JC_PLAN_STATUS_IN_REPAIR, "在修");
		put(JC_PLAN_STATUS_GUARANTINE, "待验");
		put(JC_PLAN_STATUS_YET_DEAL, "已交");
		put(JC_PLAN_STATUS_OUT, "转出");
	}};
	
	/** PjStoreDynamicInfoSearchDto中itemQueryFlag字段：  0代表未完全签认  */
	Integer PJ_SDIS_DTO_FIX_ITEM_QUERY_FALG_UN_SIGNALL=0;
	
	/** 配件检修记录(PjSDInfoRecordFix)  fixItemStatus字段：  0禁用  */
	Integer PJ_SDI_RECORD_FIX_FIX_ITEM_STATUS_DISABLE=0;
	
	/** 配件检修记录(PjSDInfoRecordFix)  fixItemStatus字段：  1启用  */
	Integer PJ_SDI_RECORD_FIX_FIX_ITEM_STATUS_ENABLE=1;
	
	/** 探伤班组  */
	String INSPECTION_PROTEAM_NAME="探伤班组";
	 
	/** 提示信息name-message*/
	String PROMPT_MESSAGE_ATTRIBUTE_NAME="message";
	
	/** 角色类型：0工人  */
	Integer ROLE_TYPE_FIX_USERS=0;
	
	/** 角色类型：1工长  */
	Integer ROLE_TYPE_LEAD=1;
	
	/** 角色类型：2交车工长  */
	Integer ROLE_TYPE_COMMIT_LEAD=2;
	
	/** 角色类型：3质检员  */
	Integer ROLE_TYPE_QC=3;
	
	/** 角色类型：4验收员  */
	Integer ROLE_TYPE_ACCEPTANCE=4;
	
	/** 角色类型：5技术员  */
	Integer ROLE_TYPE_TECHNICIAN=5;
	
	/** 配件检修记录卡控（PjSDIRecordFixCheck）卡控状态 0:不卡控；1卡控*/
	Map<Integer, String> PJ_SDIRF_CHECK_CHECK_STATU=new HashMap<Integer, String>(){{
		put(0, "不卡控");
		put(1, "卡控");
	}};
	
	/** 配件检修记录卡控（PjSDIRecordFixCheck）    卡控状态   0不卡控 */
	Integer PJ_SDIRF_CHECK_CHECK_STATU_ZERO=0;
	
	/** 配件检修记录卡控（PjSDIRecordFixCheck）    卡控状态   1卡控 */
	Integer PJ_SDIRF_CHECK_CHECK_STATU_ONE=1;
	
	/** 操作成功常量-操作成功 */
	 String COMMON_MESSAGE_OPERATE_SUC="操作成功";
	 
	 /** 操作失败常量-操作失败 */
	 String COMMON_MESSAGE_OPERATE_ERROR="操作失败";
	 
	 /**数据异常*/
	 String COMMON_MESSAGE_DATA_ERROR="数据异常";
	
	/** 响应文本默认编码-UTF-8  */
	String RESPONSE_DEFAULT_ENCODING="UTF-8";
	
	/**  返回json的时候的响应头-application/json;charset=utf-8  */
	String RESPONSE_HEADER_CONTENT_TYPE_JSON="application/json;charset=utf-8";
	
	/**  返回json的时候的相应头-application/json*/
	String RESPONSE_HEADER_CONTENT_TYPE_JSON_NOT_UTF8="application/json";
	
	/**  返回json的时候的响应头-text/html;charset=utf-8  */
	String RESPONSE_HEADER_CONTENT_TYPE_TEXT="text/html;charset=utf-8";
	
	
	/**  配件检修记录（PjSDInfoRecordFix）   fixCheckNode 字段的值:0新建；1已派工；2检修人签认；3工长验收；4交车工长验收；5技术员验收；6质检员验收；7验收员验收（完工）*/
	Map<Integer, String> PJ_SDI_RECORD_FIX_FIX_CHECK_NODE=new HashMap<Integer, String>(){{
		put(0, "新建");
		put(1, "已派工");
		put(2, "检修人签认");
		put(3, "工长验收");
		put(4, "交车工长验收");
		put(5, "技术员验收");
		put(6, "质检员验收");
		put(7, "验收员验收（完工）");
	}};
	
	/** 配件检修记录（PjSDInfoRecordFix）   fixCheckNode 字段的值：0代表新建状态   */
	Integer PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_ZERO=0;
	
	/** 配件检修记录（PjSDInfoRecordFix）   fixCheckNode 字段的值：1代表已派工状态   */
	Integer PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_FIRST=1;
	
	/** 配件检修记录（PjSDInfoRecordFix）   fixCheckNode 字段的值：2代表检修人签认状态   */
	Integer PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_SECOND=2;
	
	/** 配件检修记录（PjSDInfoRecordFix）   fixCheckNode 字段的值：3代表工长验收   */
	Integer PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_THREE=3;
	
	/** 配件检修记录（PjSDInfoRecordFix）   fixCheckNode 字段的值：4代表交车工长验收状态   */
	Integer PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_FOUR=4;
	
	/** 配件检修记录（PjSDInfoRecordFix）   fixCheckNode 字段的值：5代表技术员验收状态   */
	Integer PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_FIVE=5;
	
	/** 配件检修记录（PjSDInfoRecordFix）   fixCheckNode 字段的值：6代表质检员验收状态   */
	Integer PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_SIX=6;
	
	/** 配件检修记录（PjSDInfoRecordFix）   fixCheckNode 字段的值：7代表验收员状态   */
	Integer PJ_SDI_RECORD_FIX_FIX_CHECK_NODE_SEVEN=7;
	
	/**  机车信息（履历） jcStatus 字段值，0在修；1合格*/
	Map<Integer, String> JC_INFORMATION_JC_STATUS=new HashMap<Integer, String>(){{
		put(0, "在修");
		put(1, "合格");
	}};
	
	/**  机车信息（履历） jcStatus 字段值  0代表再修*/
	Integer JC_INFORMATION_JC_STATUS_ZERO=0;
	
	/**  机车信息（履历） jcStatus 字段值  1代表合格*/
	Integer JC_INFORMATION_JC_STATUS_FIRST=1;
	
	/**  联想输入组件显示个数 10*/
	Integer SMART_TIPS_SHOW_COUNT=10;
	
	/**  配件仓库动态信息/库存(所在位置) PjStoreDynamicInfo pjdStatus字段，0新件合格；1修浚合格；2待修；3报废；4检修中；5委外检修；6组装上车
	Map<Integer, String> PJ_STORE_DYNAMIC_INFO_PJD_STATUS=new HashMap<Integer, String>(){{
		put(0, "新件合格");
		put(1, "修浚合格");
		put(2, "待修");
		put(3, "报废");
		put(4, "检修中");
		put(5, "委外检修");
		put(6, "组装上车");
	}};
	*/
	
	/** 分页组件最多显示标签数 5*/
	int SPLIT_PAGE_SHOW_TAG=5;
	
	/** 分页组件默认每页10条数据 10*/
	int SPLIT_PAGE_DEFALT_SIZE=10;

	/** QueryPjStoreDynamicInfoAction查询时需要用到的参数-->代表专业分类 unit*/
	String QUERY_PJ_SD_INFO_PARAM_UNIT="unit";
	
	/** QueryPjStoreDynamicInfoAction查询时需要用到的参数-->代表车型分类 jctype*/
	String QUERY_PJ_SD_INFO_PARAM_JCTYPE="jctype";
	
	/** 用户字符串，当前登录的用户对象存放于session中，session().setAttribute(Constants.LOGIN_USER, user);UsersPrivs user=session().getAttribute(Constants.LOGIN_USER);获得当前登录用户*/ 
	String LOGIN_USER="loginUser";
	
	/** 根 root*/
	String ROOT="root";
	
	/** 静态配件启用状态：1L启用 */
	Long PJ_ACTIVATE_ENABLE=1L;
	
	/** 用户表(usersprivs) depart_proteam_status字段的三个值*/
	/** 0表示属于部门*/
	int DEPART_STATU=0;
	/** 1表属于示班组*/
	int PROTEAM_STATU=1;
	/** 2属于部门又属于班组*/
	int DEPART_AND_PROTEAM=2;
	
	/**  0属于班组中不修*/
    String PROTEAM_BX_BZ="0";
    /**  3属于班组中小辅修和中修*/
    String PROTEAM_XFX_ZX_BZ="3";
      
    /**  查询此班组用户个数 findUsersCount*/
    String find_Users_Count="findUsersCount";
    /**  FindUsersByDictDepartIdAction中判断的list常量 list*/
    String list="list";
	
	/**  3小辅修、中修班组标识*/
	int XFX_ZX_BZ_STATU=3;
	
	/**  查询用户时判别的标识-->全部班组用户 bz_root*/
	String BZ_ROOT="bz_root";
	
	/**  查询用户时判别的标识-->每个班组的用户 bz_*/
	String BZ_="bz_";
	
	/**  查询用户时判别的标识-->班组（小辅修、中修班组、小辅修和中修班组）用户 bzType_*/
	String BZTYPE_="bzType_";
	
	/**  班组用户跳转路径名称定义 proteamProteamManageChildIframe*/
    String PROTEAM_PROTEAM_MANAGE_CHILD_IFRAME="proteamProteamManageChildIframe";
    /**  班组添加用户对话跳转-proteamAddUsersDialog*/
    String PROTEAM_ADD_USERS_DIALOG="proteamAddUsersDialog";
    /** 部门用户跳转路径名称定义-departProteamManageChildIframe*/
    String DEPART_PROTEAM_MANAGE_CHILD_IFRAME="departProteamManageChildIframe";
    /** 部门添加用对话跳转-departAddUsersDialog*/
    String DEPART_ADD_USERS_DIALOG="departAddUsersDialog";
    /** 部门修改用户对话跳转-updateUsersDepartDialog*/
    String DEPART_UPDATE_USERS_PROTEAM_DIALOG="updateUsersDepartDialog";
    
    /**  添加跳转信息*/
    /**  添加跳转信息-添加成功！*/
    String COMMON_MESSAGE_ADD_SUC="添加成功！";
    /**  添加跳转信息-添加失败，请联系管理员！*/
    String COMMON_MESSAGE_ADD_ERROR="添加失败，请联系管理员！";
    
    /**  修改跳转信息*/
    /**  修改跳转信息-修改成功！*/
    String COMMON_MESSAGE_UPDATE_SUC="修改成功！";
    /**  修改跳转信息-修改失败，请联系管理员！*/
    String COMMON_MESSAGE_UPDATE_ERROR="修改失败，请联系管理员！";
   
    /**  删除跳转信息*/
    /**  删除跳转信息-删除成功！*/
    String COMMON_MESSAGE_DELETE_SUC="删除成功！";
    /**  删除跳转信息-删除失败，请联系管理员！*/
    String COMMON_MESSAGE_DELETE_ERROR="删除失败，请联系管理员！";
    /**  删除跳转信息-此专业存在动态配件,无法删除！*/
    String COMMON_MESSAGE_DELETE_RELE_ERROR_PJFIRSTUNIT="此专业存在动态配件,无法删除！";
    
	/**  配件动态信息移库跳转信息*/
    /**配件动态信息移库跳转信息-移库成功*/
	String MOVE_STORE_POSITION_DIALOG_SUC="移库成功!";
	/**配件动态信息移库跳转信息-移库失败，请联系管理员!*/
	String MOVE_STORE_POSITION_DIALOG_ERROR="移库失败，请联系管理员!";
	
	/**  通过仓库ID判断该仓库下是否存在配件*/
    String DICT_STORE_POSITION_ERROR="该仓库下存在配件,不能删除!";
	
    /**  配件仓库类型*/
    /**  配件仓库类型-平库*/
    String PK_TYPE="平库";
    /**  配件仓库类型-立库*/
    String LK_TYPE="立库";
    /**  配件仓库类型-班组库*/
    String BZ_TYPE="班组库";
    /**  配件仓库类型-外地*/
    String WD_TYPE="外地";
    
    /**  配件信息管理、组装状态，0L车上组装；1L配件组装 */
    Map<Long, String> PJ_ASSEMBLY_TYPE=new HashMap<Long, String>(){{
    	put(0L,"车上组装");
    	put(1L,"配件组装");
    }};
    
    /**  仓库类型 0平库；1立库；2班组库；3外地*/
    Map<Integer, String> DICT_STORE_POSITION_TYPE=new HashMap<Integer, String>(){{
    	put(0,"平库");
    	put(1,"立库");
    	put(2,"班组库");
    	put(3,"外地");
    }};	
    
    /**  配件信息管理/删除跳转路径*/
    /**  配件信息管理/删除跳转路径-delPjStoreStaticInfo*/
    String  COMMON_MESSAGE_DELETE_PJ_STORE_STATIC_INFO="delPjStoreStaticInfo";
    /**  配件信息管理/删除跳转路径-selectRolesInUsersDialogProteam*/
	String SELECT_ROLES_IN_USERS_DIALOG_PROTEAM = "selectRolesInUsersDialogProteam";
	/**  配件信息管理/删除跳转路径-selectRolesInUsersDialogDepart*/
	String SELECT_ROLES_IN_USERS_DIALOG_DEPART = "selectRolesInUsersDialogDepart";
	
	/**  出库入库*/
	/**入库（0）*/
	int RECEIVING_DELIVER_STATUS_ZERO = 0;
	/**出库（1）*/
	int RECEIVING_DELIVER_STATUS_ONE = 1;
	
	/**  配件动态信息*/
	/**0主仓库和班组仓库 0*/
	int STORE_UNIT_PROTEAM_STATUS_ZERO = 0;
	/**1班组仓库和班组仓库*/
	int STORE_UNIT_PROTEAM_STATUS_ONE = 1;
	/**2主仓库和相关单位*/
	int STORE_UNIT_PROTEAM_STATUS_TWO = 2;
	
	/**  3动态配件记录（PjSDInfoRecord）字段StoreUnitProteamStatus，代表下车入库 */
	int STORE_UNIT_PROTEAM_STATUS_THREE=3;
	/**  配件动态信息存储位置 0主仓库和班组仓库；1班组仓库和班组仓库；2班组仓库和班组仓库*/
	Map<Integer, String> STORE_UNIT_PROTEAM_STATUS = new HashMap<Integer, String>(){{
		put(0,"主仓库和班组仓库");
		put(1,"班组仓库和班组仓库");
		put(2,"班组仓库和班组仓库");
	}};
	/** 获取当前时间*/
	Timestamp TIME_STAMP_SYSTEM_DATE=new Timestamp(System.currentTimeMillis());
	
	/** 动态配件（PjStoreDynamicInfo）  pjdStatus字段  ：  新建合格 */
	Integer PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ZERO=0;

	/** 动态配件（PjStoreDynamicInfo）  pjdStatus字段  ：修竣合格 */
	Integer PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ONE=1;

	/** 动态配件（PjStoreDynamicInfo）  pjdStatus字段  ：  待修 */
	Integer PJ_STORE_DYNAMIC_INFO_PJD_STATUS_TWO=2;

	/** 动态配件（PjStoreDynamicInfo）  pjdStatus字段  ： 报废 */
	Integer PJ_STORE_DYNAMIC_INFO_PJD_STATUS_THREE=3;

	/** 动态配件（PjStoreDynamicInfo）  pjdStatus字段  ： 检修中 */
	Integer PJ_STORE_DYNAMIC_INFO_PJD_STATUS_FOUR=4;
	//委外检修
	/** 动态配件（PjStoreDynamicInfo）  pjdStatus字段  ：  委外检修 */
	Integer PJ_STORE_DYNAMIC_INFO_PJD_STATUS_FIVE=5;

	//组装上车
	/** 动态配件（PjStoreDynamicInfo）  pjdStatus字段  ：  组装上车*/
	Integer PJ_STORE_DYNAMIC_INFO_PJD_STATUS_SIX=6;
	
	/**  配件动态信息存储位置 0主仓库和班组仓库；1班组仓库和班组仓库；2班组仓库和班组仓库*/
	Map<Integer, String> PJ_STORE_DYNAMIC_INFO_PJD_STATUS = new HashMap<Integer, String>(){{
		put(PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ZERO,"新建合格");
		put(PJ_STORE_DYNAMIC_INFO_PJD_STATUS_ONE,"修竣合格");
		put(PJ_STORE_DYNAMIC_INFO_PJD_STATUS_TWO,"待修");
		put(PJ_STORE_DYNAMIC_INFO_PJD_STATUS_THREE,"报废");
		put(PJ_STORE_DYNAMIC_INFO_PJD_STATUS_FOUR,"检修中");
		put(PJ_STORE_DYNAMIC_INFO_PJD_STATUS_FIVE,"委外检修");
		put(PJ_STORE_DYNAMIC_INFO_PJD_STATUS_SIX,"组装上车");
	}};
	
	
	
	/** FindUsersByCardNumAction,用户卡号，信息提示-卡号不能为空!*/
	String USERS_CARD_NUM_NOT_NULL="卡号不能为空!";
	/** FindUsersByCardNumAction,用户卡号，信息提示-卡号存在！*/
	String USERS_CARD_NUM_IN="卡号存在！";
	
	/** FindUsersByJobNumAction,用户工号，信息提示*/
	String USERS_JOB_NUM_IN="工号存在！";
	
	/** FindUsersByNameAction 用户名-不能为空-提示信息*/
	String USERS_NAME_NOT_NULL="用户名不能为空！";
	/** FindUsersByNameAction 用户名-存在-提示信息*/
	String USERS_NAME_IN="用户名存在！";
	
	/** FindPjStoreDynamicInfoByPjdCodeAction 配件编码已存在，请重新填写配件编码！*/
	String PJ_CODE_IN="配件编码已存在，请重新填写配件编码！";
	/** AddPjStoreDynamicInfoAction 不存在此静态配件*/
	String PJ_STATIC_NOT_IN="不存在此静态配件!";
	
	/** AddOutsourcingMaintenanceAction 委外检修成功（O（Outsourcing）代表委外，M（Maintenance）代表检修）*/
	String PJ_O_M_FIX_SUC="委外检修成功!";
	/** AddOutsourcingMaintenanceAction 委外检修失败（O（Outsourcing）代表委外，M（Maintenance）代表检修）*/
	String PJ_O_M_FIX_ERROR="委外检修成功!";
	
}
