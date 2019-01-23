package com.service.newAdd;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.newAdd.BmsUserMapper;
import com.mapper.newAdd.PDFdownloadMapper;
import com.model.newAdd.BmsUser;
import com.model.newAdd.pdfdownload;
@Service
public class BmsUserServiceImpl implements BmsUserService{
	@Resource
	private BmsUserMapper bmsUserMapper;

	@Override
	public Map checkUser(String username, String password) {
		return bmsUserMapper.checkUser(username, password);
	}

	@Override
	public ArrayList selectAllUser() {
		return bmsUserMapper.selectAllUser();
	}

	@Override
	public int addBMSUser(BmsUser bu) {
		return bmsUserMapper.addBMSUser(bu);
	}

	@Override
	public int updateUserStatus(int status, int uid) {
		bmsUserMapper.updateUserStatus(status, uid);
		return uid;
	}
	@Override
	public void deleteUserByUid(int uid) {
		bmsUserMapper.deleteUserByUid(uid);
	}

	@Override
	public ArrayList selectUserLike(String uname) {
		return bmsUserMapper.selectUserLike(uname);
	}

	@Override
	public void updateUserDeptno(int deptno, int uid) {
		bmsUserMapper.updateUserDeptno(deptno, uid);
	}

	@Override
	public ArrayList selectOtherUser(int deptno) {
		return bmsUserMapper.selectOtherUser(deptno);
	}

	@Override
	public BmsUser addUserBySelect(String username) {
		return bmsUserMapper.addUserBySelect(username);
	}

	@Override
	public ArrayList selectLoginUserTeam(int upid) {
		return bmsUserMapper.selectLoginUserTeam(upid);
	}

}
