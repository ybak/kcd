package com.service.newAdd;
import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.newAdd.PDFdownloadMapper;
import com.model.newAdd.pdfdownload;
@Service
public class PDFdownloadServiceImpl implements PDFdownloadService{
	@Resource
	private PDFdownloadMapper PDFdownloadMapper;

	@Override
	public void addPDFdownload(pdfdownload PDFdl) {
		PDFdownloadMapper.addPDFdownload(PDFdl);
	}
	@Override
	public List<pdfdownload> NoPDFdownload(int status, int start, int num) {
		return PDFdownloadMapper.NoPDFdownload(status, start, num);
	}
	@Override
	public void updatePDFdownload(pdfdownload PDFdl) {
		PDFdownloadMapper.updatePDFdownload(PDFdl);
	}
	@Override
	public List<pdfdownload> selectByCompanyOrCode(int status, String downloadCompany) {
		return PDFdownloadMapper.selectByCompanyOrCode(status, downloadCompany);
	}
	@Override
	public int PDFCounts(int status) {
		return PDFdownloadMapper.PDFCounts(status);
	}
	@Override
	public String[] getFileName(int aid, int pdf_fenlei, int page, int size) {
		return PDFdownloadMapper.getFileName(aid, pdf_fenlei, page, size);
	}
	@Override
	public List getFileCode(int aid, int pdf_fenlei, int page, int size) {
		return PDFdownloadMapper.getFileCode(aid, pdf_fenlei, page, size);
	}
}
