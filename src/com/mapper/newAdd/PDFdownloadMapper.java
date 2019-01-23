package com.mapper.newAdd;
import java.util.List;
import com.model.newAdd.pdfdownload;
public interface PDFdownloadMapper {
	//添加
	public void addPDFdownload(pdfdownload PDFdl);	
	//查询未回收件
	public List<pdfdownload> NoPDFdownload(int status,int start,int num);
	//修改文件的状态
	public void updatePDFdownload(pdfdownload PDFdl);
	//条件查询
	public List<pdfdownload> selectByCompanyOrCode(int status,String downloadCompany);
	//查询 未收回件 、已收回件 总数
	public int PDFCounts(int status);
	// 获取文件名字
	public String[] getFileName(int aid,int pdf_fenlei,int page,int size);
	// 获取文件编码
	public List getFileCode(int aid,int pdf_fenlei,int page,int size);
}
