package com.service.newAdd;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.newAdd.BmsClientMapper;
import com.mapper.newAdd.BmsUserMapper;
import com.mapper.newAdd.PDFdownloadMapper;
import com.model.newAdd.BmsCpyclient;
import com.model.newAdd.BmsUser;
import com.model.newAdd.pdfdownload;
@Service
public class BmsClientServiceImpl implements BmsClientService{
	@Resource
	private BmsClientMapper bmsClientMapper;

	@Override
	public ArrayList selectAllClient() {
		return bmsClientMapper.selectAllClient();
	}

	@Override
	public void deleteClientByTid(int tid) {
		bmsClientMapper.deleteClientByTid(tid);
	}

	@Override
	public void updateClientStatus(int status, int tid) {
		bmsClientMapper.updateClientStatus(status, tid);
	}

	@Override
	public int addBMSClient(BmsCpyclient bc) {
		return bmsClientMapper.addBMSClient(bc);
	}

	@Override
	public BmsCpyclient selectOneClientByTid(int tid) {
		return bmsClientMapper.selectOneClientByTid(tid);
	}

	@Override
	public void updateClientInfo(String ta, String tb, String tc, String td, int tid) {
		bmsClientMapper.updateClientInfo(ta, tb, tc, td, tid);
	}

	@Override
	public ArrayList selectClientLike(String tname) {
		return bmsClientMapper.selectClientLike(tname);
	}

	@Override
	public ArrayList selectLoginUserClient(String ucid) {
		return bmsClientMapper.selectLoginUserClient(ucid);
	}

	@Override
	public ArrayList selectClientLikeManager(String ucid, String tname) {
		return bmsClientMapper.selectClientLikeManager(ucid,tname);
	}

	@Override
	public int updateClientToUserUp(String ucid, int tid) {
		return bmsClientMapper.updateClientToUserUp(ucid, tid);
	}
}
