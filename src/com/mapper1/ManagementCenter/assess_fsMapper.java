package com.mapper1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

import com.model1.ManagementCenter.assess_fs;

public interface assess_fsMapper {
	
	//��ѯʡ��
	public List<HashMap> selectcity(); 
	
	//��ѯ������
	public String selectgemsid(assess_fs ass_fs); 
	
	//ÿ���ܶ���������������
	public List<HashMap> selectgems(assess_fs ass_fs); 
	
	//ÿ�·ſ��������������
	public List<HashMap> selectloangems(assess_fs ass_fs); 
	
	//ÿ�����������������ȫ��������������
	public List<HashMap> selectcarpassgems(assess_fs ass_fs);
	
	//ÿ�±�������
	public List<HashMap> selectbill(assess_fs ass_fs);
	
	//ÿ�·ſ��,�ܽ��
	public List<HashMap> selectloan(assess_fs ass_fs);
	
	//ÿ���ѷſ�δ��Ѻ����,�ܽ��
	public List<HashMap> selectfk(assess_fs ass_fs);
	
	//ÿ���ܶ�����ʡ����
	public List<HashMap> selectstates(assess_fs ass_fs); 
	
	//ÿ�·ſ����ʡ����
	public List<HashMap> selectloanstates(assess_fs ass_fs); 
	
	//����ͼ����
	public List<HashMap> selectchart(assess_fs ass_fs);
	
	//��������������ͼ
	public List<HashMap> selectmoneydistribute(assess_fs ass_fs);
	
	//����ͨ���ʲ�ѯ
	public List<HashMap> selectcredit(assess_fs ass_fs);
	
	//�ͻ������ѯͳ��
	public List<HashMap> selectclientage(assess_fs ass_fs);
	
	//�³������ѯͳ��
	public List<HashMap> selectcarsage(assess_fs ass_fs);
	
	//���������ֲ�ͼ
	public List<HashMap> selectadvancefund(assess_fs ass_fs);
	
	//��Ѻ���ϻ������
	public List<HashMap> selectrecycle(assess_fs ass_fs);
	
	//���ֳ�ÿ�·ſ�����ܽ��
	public List<HashMap> selectoldcars(assess_fs ass_fs);
	
	//�³�ÿ�·ſ�����ܽ��
	public List<HashMap> selectnewcars(assess_fs ass_fs);	
	
	// ��ѯ��Ѻ��������������0-15�죬15-30�죬30-45�죬45-60�죬60�����ϵĽ��з����ѯ
	public List<HashMap> selectresult(assess_fs ass_fs);	
	
	//ÿ�����������ܶ�����
	public int countselect(assess_fs ass_fs);
	
	//ÿ�����������������
	public int countpass(assess_fs ass_fs);
	
	//ÿ�����������ʡ��ȫ��������������
	public List<HashMap> selectcarpasscomm(assess_fs ass_fs);
	
	//������������ͼ
	public List<HashMap> selectcarchart(assess_fs ass_fs);
	
	//�����ſ�ֲ�����ͼ
	public List<HashMap> selectcarfk(assess_fs ass_fs);
	
	
	//�����ʴ���������
	public List<HashMap> selectyuqilv(assess_fs ass_fs);
	
	//������M1��M2��M3��ѯ 
	public List<HashMap> selectoverdue(assess_fs ass_fs);
	
	//����ǰ������ʡ�� 
	public List<HashMap> selectstatefive(assess_fs ass_fs);
	
	//��������ʡ��
	public List<HashMap> selectstateother(assess_fs ass_fs);
	
	//ҵ������
	public List<HashMap> selectywnl(assess_fs ass_fs);
	
	//����Ч��
	public List<HashMap> selectjjxl(assess_fs ass_fs);
	
	//�������
	public List<HashMap> selectfknl(assess_fs ass_fs);
	
	//��Ӫ���� 
	public List<HashMap> selectyynl(assess_fs ass_fs);
	
	//��������
	public List<HashMap> selectdhnl(assess_fs ass_fs);
}
