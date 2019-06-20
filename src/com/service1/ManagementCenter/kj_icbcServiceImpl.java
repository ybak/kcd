package com.service1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.ManagementCenter.assess_fsMapper;
import com.model1.ManagementCenter.assess_fs;


@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class kj_icbcServiceImpl implements kj_icbcService{

	@Resource
	private assess_fsMapper assess_fsmapper;
	
	//��ѯʡ��
	@Override
	public List<HashMap> SelectCity(){
		return assess_fsmapper.selectcity();
	} 	
	//��ѯ������
	@Override
	public String SelectGemsId(assess_fs ass_fs){
		return assess_fsmapper.selectgemsid(ass_fs);
	}	            
	//ÿ�±�������
	@Override
	public List<HashMap> SelectBill(assess_fs ass_fs){
		return assess_fsmapper.selectbill(ass_fs);
	}
	//ÿ�·ſ��,�ܽ��
	@Override
	public List<HashMap> SelectLoan(assess_fs ass_fs){
		return assess_fsmapper.selectloan(ass_fs);
	}
	//ÿ���ѷſ�δ��Ѻ����,�ܽ��
	@Override
	public List<HashMap> SelectFk(assess_fs ass_fs){
		return assess_fsmapper.selectfk(ass_fs);
	}
	//ÿ���ܶ�����ʡ����
	@Override
	public List<HashMap> SelectStates(assess_fs ass_fs){
		return assess_fsmapper.selectstates(ass_fs);
	}
	//ÿ���ܶ���������������
	@Override
	public List<HashMap> SelectGems(assess_fs ass_fs){
		return assess_fsmapper.selectgems(ass_fs);
	}
	//ÿ�·ſ����ʡ����
	@Override
	public List<HashMap> SelectLoanStates(assess_fs ass_fs){
		return assess_fsmapper.selectloanstates(ass_fs);
	}
	//ÿ�·ſ��������������
	@Override
	public List<HashMap> SelectLoanGems(assess_fs ass_fs){
		return assess_fsmapper.selectloangems(ass_fs);
	}	
	//����ͼ����
	@Override
	public List<HashMap> SelectChart(assess_fs ass_fs) {
		return assess_fsmapper.selectchart(ass_fs);
	}
	//��������������ͼ
	@Override
	public List<HashMap> SelectMoneyDistribute(assess_fs ass_fs){
		return assess_fsmapper.selectmoneydistribute(ass_fs);
	}
	//����ͨ���ʲ�ѯ
	@Override
	public List<HashMap> SelectCredit(assess_fs ass_fs){
		return assess_fsmapper.selectcredit(ass_fs);	
	}
	//�ͻ������ѯͳ��
	@Override
	public List<HashMap> SelectClientAge(assess_fs ass_fs) {
		return assess_fsmapper.selectclientage(ass_fs);
	}
	//�³������ѯͳ��
	@Override
	public List<HashMap> SelectCarsAge(assess_fs ass_fs){
		return assess_fsmapper.selectcarsage(ass_fs);
	}
	//���������ֲ�ͼ
	@Override
	public List<HashMap> SelectAdvanceFund(assess_fs ass_fs){
		return assess_fsmapper.selectadvancefund(ass_fs);
	}
	//��Ѻ���ϻ������
	@Override
	public List<HashMap> SelectRecycle(assess_fs ass_fs){
		return assess_fsmapper.selectrecycle(ass_fs);
	}
	//���ֳ�ÿ�·ſ�����ܽ��
	public List<HashMap> SelectOldCars(assess_fs ass_fs){
		return assess_fsmapper.selectoldcars(ass_fs);
	}
	//�³�ÿ�·ſ�����ܽ��
	public List<HashMap> SelectNewCars(assess_fs ass_fs){
		return assess_fsmapper.selectnewcars(ass_fs);
	}
	// ��ѯ��Ѻ��������������0-15�죬15-30�죬30-45�죬45-60�죬60�����ϵĽ��з����ѯ
	@Override
	public List<HashMap> SelectResult(assess_fs ass_fs) {	
		return assess_fsmapper.selectresult(ass_fs);
	}	
	 //ÿ�����������ܶ�����
	@Override
	public int CountSelect(assess_fs ass_fs){
		return assess_fsmapper.countselect(ass_fs);
	}
	 //ÿ�����������������
	@Override
	public int CountPass(assess_fs ass_fs){
		return assess_fsmapper.countpass(ass_fs);
	}
	//ÿ�����������ʡ�й�����
	@Override
	public List<HashMap> SelectCarPassComm(assess_fs ass_fs){
		return assess_fsmapper.selectcarpasscomm(ass_fs);
	}
	//������������ͼ
	@Override
	public List<HashMap> SelectCarChart(assess_fs ass_fs){
		return assess_fsmapper.selectcarchart(ass_fs);
	}
	//�����ſ�ֲ�����ͼ
	@Override
	public List<HashMap> SelectCarFk(assess_fs ass_fs){
		return assess_fsmapper.selectcarfk(ass_fs);
	}

	//ÿ����������������̹�����
	@Override
	public List<HashMap> SelectCarPassGems(assess_fs ass_fs) {
		return assess_fsmapper.selectcarpassgems(ass_fs);
	}
	
	
	
	
	//�����ʴ���������
	@Override
	public List<HashMap> SelectYuqilv(assess_fs ass_fs){
		return assess_fsmapper.selectyuqilv(ass_fs);
	}
	
	//������M1��M2��M3��ѯ 
	@Override
	public List<HashMap> SelectOverdue(assess_fs ass_fs){
		return assess_fsmapper.selectoverdue(ass_fs);
	}
	
	//����ǰ������ʡ�� 
	@Override
	public List<HashMap> SelectStateFive(assess_fs ass_fs){
		return assess_fsmapper.selectstatefive(ass_fs);
	}
	//��������ʡ��
	@Override
	public List<HashMap> SelectStateOther(assess_fs ass_fs){
		return assess_fsmapper.selectstateother(ass_fs);
	}
	//ҵ������
	@Override
	public List<HashMap> SelectYwnl(assess_fs ass_fs){
		return assess_fsmapper.selectywnl(ass_fs);
	}
	//����Ч��
	@Override
	public List<HashMap> SelectJjxl(assess_fs ass_fs){
		return assess_fsmapper.selectjjxl(ass_fs);
	}
	
	//�������
	@Override
	public List<HashMap> SelectFknl(assess_fs ass_fs){
		return assess_fsmapper.selectfknl(ass_fs);
	}
	
	//��Ӫ���� 
	@Override
	public List<HashMap> SelectYynl(assess_fs ass_fs){
		return assess_fsmapper.selectyynl(ass_fs);
	}
	
	//��������
	@Override
	public List<HashMap> SelectDhnl(assess_fs ass_fs){
		return assess_fsmapper.selectdhnl(ass_fs);
	}
}
