package com.repair.users.service.impl;

import java.util.List;
import com.repair.entity.UsersPrivs;
import com.repair.users.dao.UsersPrivsDao;
import com.repair.users.service.UsersPrivsService;
import com.repair.util.page.PageModel;


/**
 * 
* @ClassName: UsersPrivsServiceImpl
* @Description: TODO	�û��ࣨUsersPrivs����service��ʵ��
* @author �����
* @version V1.0  
* @date 2015-8-4 ����10:41:57
 */
public class UsersPrivsServiceImpl implements UsersPrivsService {
	private UsersPrivsDao usersPrivsDao;
	
	public void setUsersPrivsDao(UsersPrivsDao usersPrivsDao) {
		this.usersPrivsDao = usersPrivsDao;
	}

	/**����û�
	 * ������usersPrivs[�û�����]*/
	public void addUsers(UsersPrivs usersPrivs){
		usersPrivsDao.addUsers(usersPrivs);
	}
	/**����id��ɾ��
	 * ������id[�û�id]*/
	public void delUsersById(long id){
		usersPrivsDao.delUsersById(id);
	}
	/**�����û�����ɾ��
	 * ������userName[�û���]*/
	public void delUsersByUserName(String userName){
		usersPrivsDao.delUsersByUserName(userName);
	}
	/**�����û�id���޸�
	 * ������usersPrivs[�û�����]*/
	public void updateUsersById(UsersPrivs usersPrivs){
		usersPrivsDao.updateUsersById(usersPrivs);
	}
	/**��ѯ�����û�
	 * �������ͣ�List<UsersPrivs>[�û����󼯺�]*/
	public List<UsersPrivs> findAllUsers(){
		return usersPrivsDao.findAllUsers();
	}
	/**�����û�id������
	 * �������ͣ�UsersPrivs[�û�����]
	 * ������id[�û�id]*/
	public UsersPrivs findUsersById(long id){
		return usersPrivsDao.findUsersById(id);
	}
	/**�����û�������ѯ
	 * �������ͣ�UsersPrivs[�û�����]
	 * ������userName[�û���]*/
	public UsersPrivs findUsersByName(String userName){
		return usersPrivsDao.findUsersByName(userName);
	}
	/**���ݵ���/�����id����ѯ
	 * �������ͣ�List<UsersPrivs>[�û����󼯺�]
	 * ������dictAreaId[������/���id]*/
	public List<UsersPrivs> findUsersByDictAreaId(String dictAreaId){
		return usersPrivsDao.findUsersByDictAreaId(dictAreaId);
	}
	/**���ݼ���״̬����ѯ
	 * �������ͣ�List<UsersPrivs>[�û����󼯺�]
	 * ������status[����״̬]*/
	public List<UsersPrivs> findUsersByStatus(int status){
		return usersPrivsDao.findUsersByStatus(status);
	}
	/**���ݲ���id����ѯ
	 * �������ͣ�List<UsersPrivs>[�û����󼯺�]
	 * ������dictDepartId[����id]*/
	public PageModel<UsersPrivs> findUsersByDictDepartId(long dictDepartId){
		return usersPrivsDao.findUsersByDictDepartId(dictDepartId);
	}
	/**���ݰ���id����ѯ
	 * �������ͣ�List<UsersPrivs>[�û�����]
	 * ������dictProteamId[����id]*/
	public PageModel<UsersPrivs> findUsersByDictProteamId(long dictProteamId){
		return usersPrivsDao.findUsersByDictProteamId(dictProteamId);
	}
	/**���ݹ��ţ���ѯ
	 * �������ͣ�UsersPrivs[�û���]
	 * ������jobNum[����]*/
	public UsersPrivs findUsersByJobNum(String jobNum){
		return usersPrivsDao.findUsersByJobNum(jobNum);
	}
	/**���ݿ��ţ���ѯ
	 * �������ͣ�UsersPrivs[�û�����]
	 * ������cardNum[����]*/
	public UsersPrivs findUsersByCardNum(String cardNum){
		return usersPrivsDao.findUsersByCardNum(cardNum);
	}
	/**���ݽ�ɫid����ѯ��(��ɫ����ʵ����ְ���-�ֶ�ID)
	 * �������ͣ�List<UsersPrivs>[�û�����]
	 * ������rolePrivsId[��ɫid]*/
	public List<UsersPrivs> findUsersByRolePrivsId(int rolePrivsId){
		return usersPrivsDao.findUsersByRolePrivsId(rolePrivsId);
	}
	/**�����Ա𣬲�ѯ�����Ա�0���У�1��Ů��
	 * �������ͣ�List<UsersPrivs>[�û����󼯺�]
	 * ������gender[�Ա�]*/
	public List<UsersPrivs> findUsersByGender(int gender){
		return usersPrivsDao.findUsersByGender(gender);
	}
	
	/**���ݹ��ź������ѯ
	 * �������ͣ�UsersPrivs[�û�����]
	 * ������jobNum[�û���]
	 * ������password[����]*/
	public UsersPrivs findUsersByJobNumAndPassword(String jobNum,String password){
		return usersPrivsDao.findUsersByJobNumAndPassword(jobNum,password);
	}
	/**�����û������в�Ϊ�յ�ֵ��ѯ�û��б�
	 * �������ͣ�List<UsersPrivs>
	 * ������userPrivs
	 */
	public PageModel<UsersPrivs> findUsersList(UsersPrivs userPrivs){
		return usersPrivsDao.findUsersList(userPrivs);
	}
	
	/**���ݲ��Ż�����б��ֶβ�ѯ
	 * �������ͣ�List<UsersPrivs>[�û����󼯺�]
	 * ������DepartOrProteamStatus
	 * */
	public PageModel<UsersPrivs> findUsersByDepartOrProteamStatus(int status){
		return usersPrivsDao.findUsersByDepartOrProteamStatus(status);
	}
	
	/**���ݰ����ʶ�ֶβ�ѯ
	 * �������ͣ�PageModel<UsersPrivs>[�û����󼯺�]
	 * ������DepartOrProteamStatus*/
	public PageModel<UsersPrivs> findUsersByProteamWorkFlag(int workFlag){
		return usersPrivsDao.findUsersByProteamWorkFlag(workFlag);
	}
	
	
	/**
	 * 	 ͨ���û�����ƴ����ѯ�û��б�(�����ִ�Сд)
	 */
	public List<UsersPrivs> findUsersListByPjNameOrPy(String nameOrPy){
		return usersPrivsDao.findUsersListByPjNameOrPy(nameOrPy);
	}
	
	
	/**
	 * ͨ������ID������д˰����û�
	 * @param proteamId������ID
	 * @return �û�����
	 */
	public List<UsersPrivs> findUsersListByProteamId(long proteamId){
		return usersPrivsDao.findUsersListByProteamId(proteamId);
	}
}
