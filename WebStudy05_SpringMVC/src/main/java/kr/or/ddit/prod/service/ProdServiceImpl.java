package kr.or.ddit.prod.service;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProdServiceImpl implements ProdService {
	@Inject
	private ProdDAO prodDAO ;
	
	@Value("#{appInfo.prodSavePath}")
	private String prodSavePath;
	@Value("#{appInfo.prodSavePath}")
	private Resource prodSaveRes;
	
	@PostConstruct
	private void init() {
		log.info("상품 이미지 저장 경로 : {}" , prodSaveRes);
	}
	 

	@Override
	public ServiceResult createProd(ProdVO prod) {
		ServiceResult result = null;
		
		int cnt = prodDAO.insertProd(prod); 
		if(cnt>0) {
			try {
			File saveFile = new File(prodSaveRes.getFile(), prod.getProdImg());
			prod.getProdImage().transferTo(saveFile);
			result = ServiceResult.OK;
			}catch(IOException e){
				throw new RuntimeException(e);
			}
		}else {
			result = ServiceResult.FAIL;
		}
		return result;
	}

	@Override
	public ProdVO retrieveProd(String prodId) throws PKNotFoundException {
		ProdVO prod = prodDAO.selectProd(prodId);
		if(prod==null)
			throw new PKNotFoundException(MessageFormat.format("{0} 해당 상품 없음", prodId));
		return prod;
	}

	@Override
	public List<ProdVO> retrieveProdList() {
		return prodDAO.selectProdList();
	}

	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		return prodDAO.updateProd(prod) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

}
