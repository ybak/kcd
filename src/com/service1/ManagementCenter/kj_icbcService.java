package com.service1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

import com.model1.ManagementCenter.assess_fs;
import com.model1.ManagementCenter.kj_icbc;

public interface kj_icbcService {
	
	//��ѯʡ��
	public List<HashMap> SelectCity(); 
	
	//��ѯ������
	public String SelectGemsId(assess_fs ass_fs); 
	
	//ÿ�±�������
	public List<HashMap> SelectBill(assess_fs ass_fs);
	
	//ÿ�·ſ��,�ܽ��
	public List<HashMap> SelectLoan(assess_fs ass_fs);
	
	//ÿ���ѷſ�δ��Ѻ����,�ܽ��
	public List<HashMap> SelectFk(assess_fs ass_fs);
	
	//ÿ���ܶ�����ʡ����
	public List<HashMap> SelectStates(assess_fs ass_fs);
	
	//ÿ���ܶ���������������
	public List<HashMap> SelectGems(assess_fs ass_fs);
	
	//ÿ�·ſ����ʡ����
	public List<HashMap> SelectLoanStates(assess_fs ass_fs);
	
	//ÿ�·ſ��������������
	public List<HashMap> SelectLoanGems(assess_fs ass_fs);
	
	//����ͼ����
	public List<HashMap> SelectChart(assess_fs ass_fs);
	
	//��������������ͼ
	public List<HashMap> SelectMoneyDistribute(assess_fs ass_fs);
	
	//����ͨ���ʲ�ѯ
	public List<HashMap> SelectCredit(assess_fs ass_fs);
	
	//�ͻ������ѯͳ��
	public List<HashMap> SelectClientAge(assess_fs ass_fs);
	
	//�³������ѯͳ��
	public List<HashMap> SelectCarsAge(assess_fs ass_fs);
	
	//���������ֲ�ͼ
	public List<HashMap> SelectAdvanceFund(assess_fs ass_fs);
	
	//��Ѻ���ϻ������
	public List<HashMap> SelectRecycle(assess_fs ass_fs);
	
	//���ֳ�ÿ�·ſ�����ܽ��
	public List<HashMap> SelectOldCars(assess_fs ass_fs);
	
	//�³�ÿ�·ſ�����ܽ��
	public List<HashMap> SelectNewCars(assess_fs ass_fs);
	
	// ��ѯ��Ѻ��������������0-15�죬15-30�죬30-45�죬45-60�죬60�����ϵĽ��з����ѯ
	public List<HashMap> SelectResult(assess_fs ass_fs);	
	
	//ÿ�����������ܶ�����
	public int CountSelect(assess_fs ass_fs);
	
	//ÿ�����������������
	public int CountPass(assess_fs ass_fs);
	
	//ÿ�����������ʡ�й�����
	public List<HashMap> SelectCarPassComm(assess_fs ass_fs);
	
	//ÿ����������������̹�����
	public List<HashMap> SelectCarPassGems(assess_fs ass_fs);
	
	//������������ͼ
	public List<HashMap> SelectCarChart(assess_fs ass_fs);
	
	//�����ſ�ֲ�����ͼ
	public List<HashMap> SelectCarFk(assess_fs ass_fs);
	
	
	
	//�����ʴ���������
	public List<HashMap> SelectYuqilv(assess_fs ass_fs);
	
	//������M1��M2��M3��ѯ 
	public List<HashMap> SelectOverdue(assess_fs ass_fs);
	
	//����ǰ������ʡ�� 
	public List<HashMap> SelectStateFive(assess_fs ass_fs);
	
	//��������ʡ��
	public List<HashMap> SelectStateOther(assess_fs ass_fs);
	
	//ҵ������
	public List<HashMap> SelectYwnl(assess_fs ass_fs);
	
	//����Ч��
	public List<HashMap> SelectJjxl(assess_fs ass_fs);
	
	//�������
	public List<HashMap> SelectFknl(assess_fs ass_fs);
	
	//��Ӫ���� 
	public List<HashMap> SelectYynl(assess_fs ass_fs);
	
	//��������
	public List<HashMap> SelectDhnl(assess_fs ass_fs);
}
