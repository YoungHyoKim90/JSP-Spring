package kr.or.ddit.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import lombok.extern.slf4j.Slf4j;

/**
 * 메소드 호출 jointpoint 지원 시스템에서 위빙의 종류
 * 
 * before advice : 메소드 호출 전 위빙. after adivice : 메소드 호출 이후 위빙.
 * 
 * 상품을 등록하고, 수정하고, 조회할 때 실행에 사용되는 모든 조건을 시스템 로그에 기록하자
 * 관심사 분리
 * C.C: 상품을 등록하고, 수정하고 조회 target: createProd,retrieveProd, modifyProd C.C.C: 시스템
 * 로그에 기록 Advice: 구현
 * advice + target => weaving -> pointcut 으로 필터링 된 타켓을 대상으로 위빙. --> 위빙되는 시점과 지점에
 * 대한 정보: JoinPoint
 *
 */
@Slf4j
public class LoggingAdvice {
	public void before(JoinPoint point) {
		long start = System.currentTimeMillis();
		Object target = point.getTarget();
		Signature signature = point.getSignature();
		String targetMethodName = signature.getName();
		Class<?> returnType = signature.getDeclaringType();
		Object[] args = point.getArgs();
		log.info("before weaving on : {}.{}({})", target.getClass().getSimpleName(),targetMethodName,args);
		
	}
	public void afterReturning(JoinPoint point, Object retValue) {
		long end = System.currentTimeMillis();
		Object target = point.getTarget();
		Signature signature = point.getSignature();
		String targetMethodName = signature.getName();
		Class<?> returnType = signature.getDeclaringType();
		Object[] args = point.getArgs();
		log.info("after weaving on : {}.{}({}) \n 실행 후 반환값 : {}"
				, target.getClass().getSimpleName(),targetMethodName,args,retValue);
		
	}
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Object target = point.getTarget();
		Signature signature = point.getSignature();
		String targetMethodName = signature.getName();
		Class<?> returnType = signature.getDeclaringType();
		Object[] args = point.getArgs();
		log.info("before weaving on : {}.{}({})", target.getClass().getSimpleName(),targetMethodName,args);
		long start = System.currentTimeMillis();
		//target직접 실행
		Object retValue = point.proceed(args);
		long end = System.currentTimeMillis();
		
		log.info("after weaving on : {}.{}({}) \n 실행 후 반환값 : {}, 소요시간 : {}ms"
				, target.getClass().getSimpleName(),targetMethodName,args,retValue,(end-start));
		return retValue;
	}
}
